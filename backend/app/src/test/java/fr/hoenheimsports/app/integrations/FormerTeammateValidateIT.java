package fr.hoenheimsports.app.integrations;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateHistoryResponse;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.controllers.dtos.SMSHistoryResponse;
import fr.hoenheimsports.app.repositories.FormerTeammateEntityRepository;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.models.Role;
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
public class FormerTeammateValidateIT extends FormerTeammateIT{
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
    @Autowired
    private FormerTeammateEntityRepository formerTeammateEntityRepository;

    //@Test
    void editFormerTeammate_template() {
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

        FormerTeammateResponse contextResponse = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        Assertions.assertNotNull(contextResponse);
        String code = formerTeammateEntityRepository.findById(contextResponse.id()).orElseThrow().getCode();
        FormerTeammateResponse response = this.webTestClient
                .put()
                .uri("/api/former-teammates/validate/{code}", "AAAAA")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        System.out.println(response);
    }

    @Test
    @DisplayName("Should return 404 BAD_REQUEST for invalid code")
    void editFormerTeammate_shouldReturn404_whenFormerTeammateNotFound() {
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
                .uri("/api/former-teammates/validate/{code}", "AAAAA")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getTitle()).isEqualTo("Le contact n'existe pas ou n'a pas été trouvé");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/former-teammate-not-found");
        assertThat(response.getDetail()).isEqualTo("Votre code est erroné ou obsolète.");
    }


    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("Valid scenarios")
    @MethodSource("provideValidScenarios")
    void validateFormerTeammate_shouldReturn200_andPersistEntity(
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
        String code = formerTeammateEntityRepository.findById(contextResponse.id()).orElseThrow().getCode();
        Assertions.assertNotNull(code);
        //Act
        LocalDateTime testStartTime = LocalDateTime.now();
        FormerTeammateResponse response = this.webTestClient
                .put()
                .uri("/api/former-teammates/validate/{code}",code)
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

    public static Stream<Arguments> provideValidScenarios() {
        return Stream.of(
                Arguments.of(
                        "Validation with no modification",
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
                                ContactStatus.VALIDATED,
                                null,
                                null
                        ),
                        List.of(
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33612***678",
                                        "john.doe@example.com",
                                        LocalDate.of(1990, 1, 1),
                                        List.of(Role.PLAYER),
                                        ContactStatus.VALIDATED,
                                        null,
                                        HistoryAction.UPDATED,
                                        "John Doe",
                                        "Transition du status vers → VALIDÉ : le contact a validé ses informations")
                        ),
                        List.of()

                ),
                Arguments.of(
                        "Validation with modifications",
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
                                ContactStatus.VALIDATED,
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
                                        ContactStatus.SUBMITTED,
                                        null,
                                        HistoryAction.UPDATED,
                                        "John1 Doe1",
                                        "Mise à jour des informations du contact"),
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33612***678",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.VALIDATED,
                                        null,
                                        HistoryAction.UPDATED,
                                        "John1 Doe1",
                                        "Transition du status vers → VALIDÉ : le contact a validé ses informations")
                        ),
                        List.of()

                ),
                Arguments.of(
                        "Validation with phone number modification",
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
                                ContactStatus.VALIDATED,
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
                                        ContactStatus.SUBMITTED,
                                        null,
                                        HistoryAction.UPDATED,
                                        "John1 Doe1",
                                        "Mise à jour des informations du contact"),
                                new FormerTeammateHistoryResponse(
                                        null,
                                        null,
                                        "+33638***416",
                                        "john1.doe1@example.com",
                                        LocalDate.of(1999, 9, 9),
                                        List.of(Role.COACH, Role.ASSISTANT),
                                        ContactStatus.VALIDATED,
                                        null,
                                        HistoryAction.UPDATED,
                                        "John1 Doe1",
                                        "Transition du status vers → VALIDÉ : le contact a validé ses informations")
                        ),
                        List.of()

                )
        );
    }
}
