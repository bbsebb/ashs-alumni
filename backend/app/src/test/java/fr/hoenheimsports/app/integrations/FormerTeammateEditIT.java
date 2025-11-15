package fr.hoenheimsports.app.integrations;

import com.c4_soft.springaddons.security.oauth2.test.annotations.OpenIdClaims;
import com.c4_soft.springaddons.security.oauth2.test.annotations.WithMockJwtAuth;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateHistoryResponse;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.controllers.dtos.SMSHistoryResponse;
import fr.hoenheimsports.domain.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.client.MockMvcWebTestClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
@SpringBootTest
@Transactional
@Testcontainers
public class FormerTeammateEditIT extends FormerTeammateIT {
    @Autowired
    Environment env;
    @Test
    void checkOrigin() {
        System.out.println("myapp.origin = " + env.getProperty("myapp.origin"));
    }
    @Autowired
    private WebApplicationContext context;


    protected WebTestClient webTestClient;


    @BeforeEach
    public void setup() {
        // C'est la partie la plus importante :
        // 1. On crée un WebTestClient qui utilise MockMvc
        // 2. On lui applique la configuration de sécurité de Spring
        this.webTestClient = MockMvcWebTestClient
                .bindToApplicationContext(this.context)
                .apply(springSecurity())
                .configureClient()
                .build();
    }


    @Container
    @ServiceConnection
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("local.server.port", () -> "8080");
        // Ensure Docker Compose support doesn't interfere during tests
        registry.add("spring.docker.compose.enabled", () -> "false");

        // Configuration HikariCP optimisée pour Testcontainers
        registry.add("spring.datasource.hikari.maximum-pool-size", () -> "2");
        registry.add("spring.datasource.hikari.minimum-idle", () -> "1");
        registry.add("spring.datasource.hikari.connection-timeout", () -> "10000");
        registry.add("spring.datasource.hikari.validation-timeout", () -> "3000");
        registry.add("spring.datasource.hikari.max-lifetime", () -> "60000"); // 1 minute (court pour les tests)
        registry.add("spring.datasource.hikari.keepalive-time", () -> "30000"); // 30 secondes
        registry.add("spring.datasource.hikari.initialization-fail-timeout", () -> "1");
        // Provide dummy Twilio configuration to satisfy validated properties
    }
    @Test
    @DisplayName("Valid scenarios without authentication")
    void editFormerTeammate_withoutAuthentication_shouldReturn401_andProblemDetailResponse() {

        String jsonPayloadContext = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33638937416",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        FormerTeammateResponse responseContext = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayloadContext)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertNotNull(responseContext);

        String jsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33638937416",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        ProblemDetail response = this.webTestClient
                .put()
                .uri("/api/former-teammates/{id}", responseContext.id())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isUnauthorized()
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
        assertThat(response.getTitle()).isEqualTo("Permission utilisateur manquante");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/unauthorisation");
        assertThat(response.getDetail()).isEqualTo("Vous n'avez pas les autorisations requises");
    }

    @Test
    @WithMockJwtAuth(authorities = {"ROLE_ADMIN"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Valid scenarios with authentication and role admin")
    void editFormerTeammate_shouldReturn200_andPersistEntity_WithRoleAdmin(){
        String jsonPayloadContext = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33638937416",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        FormerTeammateResponse responseContext = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayloadContext)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertNotNull(responseContext);
        String jsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33612555678",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        this.webTestClient
                .put()
                .uri("/api/former-teammates/{id}",responseContext.id())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk();
    }



    @ParameterizedTest(name = "{displayName} : {0}")
    @WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Valid scenarios with authentication")
    @MethodSource("provideValidScenariosWithAuthentication")
    void editFormerTeammate_shouldReturn200_andPersistEntity(
            String scenarioName,
            String jsonPayloadContext,
            String jsonPayload,
            FormerTeammateResponse expectedResponse,
            List<FormerTeammateHistoryResponse> expectedNewFormerTeammateHistoryResponse,
            List<SMSHistoryResponse> expectedNewSMSHistoryResponse
    ) {
        //Arrange

        FormerTeammateResponse contextResponse = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayloadContext)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertNotNull(contextResponse);
        Assertions.assertNotNull(contextResponse.id());
        //Act
        LocalDateTime testStartTime = LocalDateTime.now();
        FormerTeammateResponse response = this.webTestClient
                .put()
                .uri("/api/former-teammates/{id}",contextResponse.id())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        LocalDateTime testEndTime = LocalDateTime.now();

        //Assert
        assertThat(response).isNotNull();
        assertThat(response).usingRecursiveComparison().ignoringFields(
                "id",
                "formerTeammateHistories",           // Ignore id de chaque élément
                "SMSHistories"
        ).isEqualTo(expectedResponse);


        List<FormerTeammateHistoryResponse> oldFormerTeammateHistoriesResponse = filterOldFormerTeammateHistoryResponses(response, contextResponse);
        List<FormerTeammateHistoryResponse> newFormerTeammateHistoriesResponse = filterNewTeammateHistoryResponses(response, contextResponse);
        assertThat(oldFormerTeammateHistoriesResponse).isEqualTo(contextResponse.formerTeammateHistories());
        System.out.println("Response");
        System.out.println(response);
        System.out.println("newFormerTeammateHistoriesResponse");
        newFormerTeammateHistoriesResponse.forEach(System.out::println);
        System.out.println("oldFormerTeammateHistoriesResponse");
        oldFormerTeammateHistoriesResponse.forEach(System.out::println);
        if (!expectedNewFormerTeammateHistoryResponse.isEmpty()) {
            assertThat(newFormerTeammateHistoriesResponse).hasSize(expectedNewFormerTeammateHistoryResponse.size());
            assertThat(newFormerTeammateHistoriesResponse)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "formerTeammateId", "updatedAt")
                    .isEqualTo(expectedNewFormerTeammateHistoryResponse);
        } else {
            assertThat(newFormerTeammateHistoriesResponse).isEmpty();
        }

        List<SMSHistoryResponse> oldSMSHistoriesResponse = filterOldSMSHistories(response, contextResponse);
        List<SMSHistoryResponse> newSMSHistoriesResponse = filterNewSMSHistory(response, contextResponse);
        assertThat(oldSMSHistoriesResponse).isEqualTo(contextResponse.SMSHistories());
        Assertions.assertNotNull(expectedNewFormerTeammateHistoryResponse);
        if (!expectedNewFormerTeammateHistoryResponse.isEmpty()) {
            assertThat(newSMSHistoriesResponse).hasSize(expectedNewSMSHistoryResponse.size());
            assertThat(newSMSHistoriesResponse)
                    .usingRecursiveComparison()
                    .ignoringFields("id", "formerTeammateId", "updatedAt", "sentAt", "externalId")
                    .isEqualTo(expectedNewSMSHistoryResponse);
        } else {
            assertThat(newSMSHistoriesResponse).isEmpty();
        }

        assertThat(newFormerTeammateHistoriesResponse).allMatch(
                isParentFormerTeammateIdEqualForFormerTeammateHistoryResponse(response),
                "tous les formerTeammateId de l'historique doivent correspondre au formerTeammate parent"
        );
        assertThat(newFormerTeammateHistoriesResponse)
                .allMatch(
                        isUpdatedWithinTimeRange(testStartTime, testEndTime),
                        "updatedAt devrait être entre le début et la fin du test");

        assertThat(newSMSHistoriesResponse).allMatch(
                isParentFormerTeammateIdEqualForSMSHistoryResponse(response),
                "tous les formerTeammateId de l'historique des sms doivent correspondre au formerTeammate parent"
        );
        assertThat(newSMSHistoriesResponse)
                .allMatch(
                        isFailedOrHasExternalId(),
                        "L'id externe fournit par twilio doit être renseigné pour chaque SMS correctement envoyé"
                );

    }




    public static Stream<Arguments> provideValidScenariosWithAuthentication() {
        return Stream.of(
                Arguments.of(
                        "Valid edit if no modification",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612222678",
                                    "email": "john.doe@example.com",
                                    "birthDate": "1990-01-01",
                                    "roles": ["PLAYER"]
                                }
                                """,
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612***678",
                                    "email": "john.doe@example.com",
                                    "birthDate": "1990-01-01",
                                    "roles": ["PLAYER"]
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John",
                                "Doe",
                                Gender.M,
                                "+33612***678",
                                "john.doe@example.com",
                                LocalDate.of(1990, 1, 1),
                                List.of(Role.PLAYER),
                                ContactStatus.PENDING,
                                null,
                                null
                        ),
                        List.of(),
                        List.of()

                ),
                Arguments.of(
                        "Valid edit if all modification expect phone number",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612222678",
                                    "email": "john.doe@example.com",
                                    "birthDate": "1990-01-01",
                                    "roles": ["PLAYER"]
                                }
                                """,
                        """
                                {
                                    "firstName": "John1",
                                    "lastName": "Doe1",
                                    "gender": "F",
                                    "phone": "+33612***678",
                                    "email": "john1.doe1@example.com",
                                    "birthDate": "1999-09-09",
                                    "roles": ["COACH","ASSISTANT"]
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John1",
                                "Doe1",
                                Gender.F,
                                "+33612***678",
                                "john1.doe1@example.com",
                                LocalDate.of(1999, 9, 9),
                                List.of(Role.COACH, Role.ASSISTANT),
                                ContactStatus.PENDING,
                                null,
                                null
                        ),
                        List.of(
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33612***678",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.PENDING,
                                        null,
                                        HistoryAction.UPDATED,
                                        "nameTest",
                                        "Mise à jour des informations du contact")
                        ),
                        List.of()

                ),
                Arguments.of(
                        "Valid edit if all modification and phone number",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612222678",
                                    "email": "john.doe@example.com",
                                    "birthDate": "1990-01-01",
                                    "roles": ["PLAYER"]
                                }
                                """,
                        """
                                {
                                    "firstName": "John1",
                                    "lastName": "Doe1",
                                    "gender": "F",
                                    "phone": "+33638937416",
                                    "email": "john1.doe1@example.com",
                                    "birthDate": "1999-09-09",
                                    "roles": ["COACH","ASSISTANT"]
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John1",
                                "Doe1",
                                Gender.F,
                                "+33638***416",
                                "john1.doe1@example.com",
                                LocalDate.of(1999, 9, 9),
                                List.of(Role.COACH, Role.ASSISTANT),
                                ContactStatus.PENDING,
                                null,
                                null
                        ),
                        List.of(
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.PENDING,
                                        null,
                                        HistoryAction.UPDATED,
                                        "nameTest",
                                        "Mise à jour des informations du contact")
                        ),
                        List.of(
                                new SMSHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "message test du sms",
                                        SMSStatus.QUEUED,
                                        null,
                                        null,
                                        null,
                                        null
                                )
                        )

                ),
                Arguments.of(
                        "Valid edit if all modification and phone number with UNREACHABLE status context",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "",
                                    "email": "john.doe@example.com",
                                    "birthDate": "1990-01-01",
                                    "roles": ["PLAYER"]
                                }
                                """,
                        """
                                {
                                    "firstName": "John1",
                                    "lastName": "Doe1",
                                    "gender": "F",
                                    "phone": "+33638937416",
                                    "email": "john1.doe1@example.com",
                                    "birthDate": "1999-09-09",
                                    "roles": ["COACH","ASSISTANT"]
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John1",
                                "Doe1",
                                Gender.F,
                                "+33638***416",
                                "john1.doe1@example.com",
                                LocalDate.of(1999, 9, 9),
                                List.of(Role.COACH, Role.ASSISTANT),
                                ContactStatus.PENDING,
                                null,
                                null
                        ),
                        List.of(
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.UNREACHABLE,
                                        null,
                                        HistoryAction.UPDATED,
                                        "nameTest",
                                        "Mise à jour des informations du contact"),
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.PENDING,
                                        null,
                                        HistoryAction.UPDATED,
                                        "nameTest",
                                        "Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. En attente de la confirmation du contact.")
                        ),
                        List.of(
                                new SMSHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "message test du sms",
                                        SMSStatus.QUEUED,
                                        null,
                                        null,
                                        null,
                                        null
                                )
                        )

                )

        );
    }
}
