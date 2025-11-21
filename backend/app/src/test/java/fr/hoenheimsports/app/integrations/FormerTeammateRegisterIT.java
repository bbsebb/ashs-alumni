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
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@Transactional
@Testcontainers
class FormerTeammateRegisterIT extends FormerTeammateIT{
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
    @WithMockJwtAuth(authorities = {"ROLE_ADMIN"}, claims = @OpenIdClaims(name = "nameTest"))
    void registerFormerTeammate_template() {
        String jsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33638",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        System.out.println(response);
    }

    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("Should return 400 BAD_REQUEST for invalid phone format")
    @MethodSource("provideInvalidPhoneNumbers")
    void registerFormerTeammate_shouldReturn400_whenInvalidPhoneNumber(
            String scenarioName,
            String wrongPhoneNumber,
            String detail
    ) {
        String jsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "%s",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """.formatted(wrongPhoneNumber);
        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getTitle()).isEqualTo("Le numéro de téléphone est invalide");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/invalid-phone-number");
        assertThat(response.getDetail()).isEqualTo(detail);
    }

    @Test
    @DisplayName("Should return 409 CONFLICT for duplicate name and firstname")
    void registerFormerTeammate_shouldReturn409_whenDuplicateNameAndFirstname() {
        String firstJsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "",
                    "email": "",
                    "birthDate": "",
                    "roles": []
                }
                """;
        String secondJsonPayload = """
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
        this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(firstJsonPayload)
                .exchange()
                .expectStatus().isOk();
        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(secondJsonPayload)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();


        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(response.getTitle()).isEqualTo("Le contact existe déjà");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/contact-already-exists");
        assertThat(response.getDetail()).isEqualTo("Le contact existe déjà avec le nom et prénom suivant :  JOHN DOE");
    }

    @Test
    @DisplayName("Should return 409 CONFLICT for duplicate phone number")
    void registerFormerTeammate_shouldReturn409_whenDuplicatePhoneNumber() {
        String firstJsonPayload = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "gender": "M",
                    "phone": "+33638937416",
                    "email": "",
                    "birthDate": "",
                    "roles": []
                }
                """;
        String secondJsonPayload = """
                {
                    "firstName": "John1",
                    "lastName": "Doe1",
                    "gender": "M",
                    "phone": "+33638937416",
                    "email": "john.doe@example.com",
                    "birthDate": "1990-01-01",
                    "roles": ["PLAYER"]
                }
                """;
        this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(firstJsonPayload)
                .exchange()
                .expectStatus().isOk();
        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(secondJsonPayload)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();


        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(response.getTitle()).isEqualTo("Le contact existe déjà");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/contact-already-exists");
        assertThat(response.getDetail()).isEqualTo("Le contact existe déjà avec le numéro de téléphone : +33638***416");
    }

    @ParameterizedTest(name = "{displayName} : {0}")
    @MethodSource("provideInvalidScenarios")
    @DisplayName("Should return 400 BAD_REQUEST for invalid payloads")
    void registerFormerTeammate_shouldReturn400_whenValidationFails(
            String scenarioName,
            String jsonPayload,
            String expectedTitle,
            int expectedErrorCount,
            List<String> expectedFieldsInError
    ) {
        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();

        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
        assertThat(response.getTitle()).isEqualTo(expectedTitle);
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/validation");
        assertThat(response.getDetail()).isEqualTo("Erreur de validation des données");

        // Vérification des erreurs de champs
        Assertions.assertNotNull(response.getProperties());
        assertThat(response.getProperties().get("errors")).isNotNull();
        assertThat(response.getProperties().get("errors")).isInstanceOf(List.class);

        @SuppressWarnings("unchecked")
        List<Map<String, Object>> errors = (List<Map<String, Object>>) response.getProperties().get("errors");
        assertThat(errors).hasSize(expectedErrorCount);

        // Vérification que tous les champs attendus sont présents dans les erreurs
        List<String> actualFieldsInError = errors.stream()
                .filter(error -> "field".equals(error.get("type")))
                .map(error -> (String) error.get("field"))
                .toList();

        assertThat(actualFieldsInError).containsExactlyInAnyOrderElementsOf(expectedFieldsInError);

        // Vérification que chaque erreur contient les propriétés nécessaires
        errors.forEach(error -> {
            assertThat(error).containsKeys("type", "message", "code");
            if ("field".equals(error.get("type"))) {
                assertThat(error).containsKeys("field", "rejectedValue");
            }
        });
    }


    @ParameterizedTest(name = "{displayName} : {0}")
    @MethodSource("provideValidScenariosWithoutAuthentication")
    //@WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Valid scenarios without authentication")
    void registerFormerTeammate_shouldReturn200_andPersistEntity(
            String scenarioName,
            String jsonPayload,
            FormerTeammateResponse expectedResponse
    ) {
        LocalDateTime testStartTime = LocalDateTime.now();
        FormerTeammateResponse response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        LocalDateTime testEndTime = LocalDateTime.now();

        assertThat(response).isNotNull();
        assertThat(response.id()).as("id should be generated").isNotNull();
        assertThat(response).usingRecursiveComparison().ignoringFields(
                "id",
                "formerTeammateHistories.id",           // Ignore id de chaque élément
                "formerTeammateHistories.formerTeammateId",
                "formerTeammateHistories.rolesAtTime",
                "formerTeammateHistories.updatedAt").isEqualTo(expectedResponse);
        assertThat(response.formerTeammateHistories()).hasSize(1);
        assertThat(response.formerTeammateHistories()).allMatch(
                isParentFormerTeammateIdEqualForFormerTeammateHistoryResponse(response),
                "tous les formerTeammateId de l'historique doivent correspondre au formerTeammate parent");
        assertThat(response.formerTeammateHistories())
                .allMatch(
                        isUpdatedWithinTimeRange(testStartTime,testEndTime),
                        "updatedAt devrait être entre le début et la fin du test");

        assertThat(response.SMSHistories()).isEmpty();
    }

    @ParameterizedTest(name = "{displayName} : {0}")
    @MethodSource("provideValidScenariosWithAuthentication")
    @WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Should handle various registration scenarios")
    void registerFormerTeammate_shouldReturn200_andPersistEntity_WithRoleUser(
            String scenarioName,
            String jsonPayload,
            FormerTeammateResponse expectedResponse
    ) {
        LocalDateTime testStartTime = LocalDateTime.now();
        FormerTeammateResponse response = this.webTestClient
                .post()
                .uri("/api/former-teammates")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(jsonPayload)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        LocalDateTime testEndTime = LocalDateTime.now();
        System.out.println(response);
        assertThat(response).isNotNull();
        assertThat(response.id()).as("id should be generated").isNotNull();
        assertThat(response).usingRecursiveComparison().ignoringFields(
                "id",
                "formerTeammateHistories.id",           // Ignore id de chaque élément
                "formerTeammateHistories.formerTeammateId",
                "formerTeammateHistories.updatedAt",
                "SMSHistories.id",
                "SMSHistories.formerTeammateId",
                "SMSHistories.sentAt",
                "SMSHistories.updatedAt",
                "SMSHistories.externalId",
                "SMSHistories.message"
        ).isEqualTo(expectedResponse);
        assertThat(response.formerTeammateHistories()).allMatch(
                isParentFormerTeammateIdEqualForFormerTeammateHistoryResponse(response),
                "tous les formerTeammateId de l'historique doivent correspondre au formerTeammate parent"
        );
        assertThat(response.formerTeammateHistories())
                .allMatch(
                        isUpdatedWithinTimeRange(testStartTime,testEndTime),
                        "updatedAt devrait être entre le début et la fin du test");

        assertThat(response.SMSHistories()).allMatch(
                isParentFormerTeammateIdEqualForSMSHistoryResponse(response),
                "tous les formerTeammateId de l'historique des sms doivent correspondre au formerTeammate parent"
        );
        assertThat(response.SMSHistories()).allMatch(
                isFailedOrHasExternalId(),
                "L'id externe fournit par twilio doit être renseigné pour chaque SMS correctement envoyé"
        );
    }

    private static Stream<Arguments> provideValidScenariosWithoutAuthentication() {
        return Stream.of(
                Arguments.of(
                        "Valid player registration with all fields",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612345678",
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
                                ContactStatus.SUBMITTED,
                                List.of(
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                "+33612***678",
                                                "john.doe@example.com",
                                                LocalDate.of(1990, 1, 1),
                                                List.of(Role.PLAYER),
                                                ContactStatus.SUBMITTED,
                                                null,
                                                HistoryAction.CREATED,
                                                "Anonyme",
                                                "Enregistrement initial")
                                ),
                                List.of()
                        )
                ),
                Arguments.of(
                        "Valid player registration with minimum fields",
                        """
                                {
                                    "firstName": "John1",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "",
                                    "email": "",
                                    "birthDate": "",
                                    "roles": []
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John1",
                                "Doe",
                                Gender.M,
                                null,
                                null,
                                null,
                                List.of(),
                                ContactStatus.UNREACHABLE,
                                List.of(
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                null,
                                                null,
                                                null,
                                                List.of(),
                                                ContactStatus.UNREACHABLE,
                                                null,
                                                HistoryAction.CREATED,
                                                "Anonyme",
                                                "Enregistrement initial")
                                ),
                                List.of()
                        )
                )
        );
    }

    private static Stream<Arguments> provideValidScenariosWithAuthentication() {
        return Stream.of(
                Arguments.of(
                        "Valid player registration with valid phone number",
                        """
                                {
                                    "firstName": "John",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+33612345678",
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
                                List.of(
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                "+33612***678",
                                                "john.doe@example.com",
                                                LocalDate.of(1990, 1, 1),
                                                List.of(Role.PLAYER),
                                                ContactStatus.SUBMITTED,
                                                null,
                                                HistoryAction.CREATED,
                                                "nameTest",
                                                "Enregistrement initial"),
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                "+33612***678",
                                                "john.doe@example.com",
                                                LocalDate.of(1990, 1, 1),
                                                List.of(Role.PLAYER),
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
                                                "+33612***678",
                                                "message test du sms",
                                                SMSStatus.QUEUED,
                                                null,
                                                null,
                                                null,
                                                null
                                        )
                                )
                        )
                ),
                Arguments.of(
                        "Valid player registration without valid phone number",
                        """
                                {
                                    "firstName": "John1",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "",
                                    "email": "",
                                    "birthDate": "",
                                    "roles": []
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John1",
                                "Doe",
                                Gender.M,
                                null,
                                null,
                                null,
                                List.of(),
                                ContactStatus.UNREACHABLE,
                                List.of(
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                null,
                                                null,
                                                null,
                                                List.of(),
                                                ContactStatus.UNREACHABLE,
                                                null,
                                                HistoryAction.CREATED,
                                                "nameTest",
                                                "Enregistrement initial")
                                ),
                                List.of()
                        )
                ),
                Arguments.of(
                        "Valid player registration with invalid twilio-test phone number",
                        """
                                {
                                    "firstName": "John3",
                                    "lastName": "Doe",
                                    "gender": "M",
                                    "phone": "+15005550001",
                                    "email": "",
                                    "birthDate": "",
                                    "roles": []
                                }
                                """,
                        new FormerTeammateResponse(
                                null,
                                "John3",
                                "Doe",
                                Gender.M,
                                "+15005***001",
                                null,
                                null,
                                List.of(),
                                ContactStatus.UNREACHABLE,
                                List.of(
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                "+15005***001",
                                                null,
                                                null,
                                                List.of(),
                                                ContactStatus.SUBMITTED,
                                                null,
                                                HistoryAction.CREATED,
                                                "nameTest",
                                                "Enregistrement initial"),
                                        new FormerTeammateHistoryResponse(
                                                null,
                                                null,
                                                "+15005***001",
                                                null,
                                                null,
                                                List.of(),
                                                ContactStatus.UNREACHABLE,
                                                null,
                                                HistoryAction.UPDATED,
                                                "nameTest",
                                                "Transition du status vers → INJOIGNABLE : Échec de l'envoi du SMS. Le numéro de téléphone fourni est invalide ou absent.")
                                ),
                                List.of(
                                        new SMSHistoryResponse(
                                                null,
                                                null,
                                                "+15005***001",
                                                """
                                                        message test du sms
                                                        """,
                                                SMSStatus.FAILED,
                                                null,
                                                null,
                                                null,
                                                "Erreur lors de l'envoi du SMS: Invalid 'To' Phone Number: +1500555XXXX"
                                        )
                                )
                        )
                )
        );
    }

    private static Stream<Arguments> provideInvalidScenarios() {
        return Stream.of(
                Arguments.of(
                        "Prénom vide - contrainte @NotBlank non respectée",
                        """
                        {
                            "firstName": "",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33612345678",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("firstName")
                ),
                Arguments.of(
                        "Nom vide - contrainte @NotBlank non respectée",
                        """
                        {
                            "firstName": "John",
                            "lastName": "",
                            "gender": "M",
                            "phone": "+33612345678",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("lastName")
                ),
                Arguments.of(
                        "Email invalide - format incorrect",
                        """
                        {
                            "firstName": "John",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "john.doeexample.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("email")
                ),
                Arguments.of(
                        "Email invalide - sans arobase",
                        """
                        {
                            "firstName": "John",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "johnexample.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("email")
                ),
                Arguments.of(
                        "Date de naissance future - contrainte @Past non respectée",
                        """
                        {
                            "firstName": "John",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "2030-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("birthDate")
                ),
                Arguments.of(
                        "Genre null - contrainte @NotNull non respectée",
                        """
                        {
                            "firstName": "John",
                            "lastName": "Doe",
                            "gender": null,
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("gender")
                ),
                Arguments.of(
                        "Prénom null - contrainte @NotBlank non respectée",
                        """
                        {
                            "firstName": null,
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("firstName")
                ),
                Arguments.of(
                        "Nom null - contrainte @NotBlank non respectée",
                        """
                        {
                            "firstName": "John",
                            "lastName": null,
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("lastName")
                ),
                Arguments.of(
                        "Prénom contenant uniquement des espaces",
                        """
                        {
                            "firstName": "   ",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        1,
                        List.of("firstName")
                ),
                Arguments.of(
                        "Multiples erreurs - prénom vide et email invalide",
                        """
                        {
                            "firstName": "",
                            "lastName": "Doe",
                            "gender": "M",
                            "phone": "+33638937416",
                            "email": "invalid-email",
                            "birthDate": "1990-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        2,
                        List.of("firstName", "email")
                ),
                Arguments.of(
                        "Multiples erreurs - nom vide, genre null et date future",
                        """
                        {
                            "firstName": "John",
                            "lastName": "",
                            "gender": null,
                            "phone": "+33638937416",
                            "email": "john.doe@example.com",
                            "birthDate": "2030-12-31",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        3,
                        List.of("lastName", "gender", "birthDate")
                ),
                Arguments.of(
                        "Toutes les contraintes violées",
                        """
                        {
                            "firstName": "",
                            "lastName": null,
                            "gender": null,
                            "phone": "+33638937416",
                            "email": "not-an-email",
                            "birthDate": "2099-01-01",
                            "roles": ["PLAYER"]
                        }
                        """,
                        "Champs erronés",
                        5,
                        List.of("firstName", "lastName", "gender", "email", "birthDate")
                )
        );
    }
    private static Stream<Arguments> provideInvalidPhoneNumbers() {
        return Stream.of(
                Arguments.of("Numéro trop court", "123","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: 123"),
                Arguments.of("Numéro sans indicatif pays", "0612345678","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: 0612345678"),
                Arguments.of("Format français sans +", "33612345678","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: 33612345678"),
                //Arguments.of("Numéro avec espaces", "+33 6 12 34 56 78",""), Le numéro est normalisé s'il y a des espaces
                //Arguments.of("Numéro avec tirets", "+33-6-12-34-56-78",""), Le numéro est normalisé s'il y a des tirets
                //Arguments.of("Numéro avec points", "+33.6.12.34.56.78",""), Le numéro est normalisé s'il y a des points
                Arguments.of("Numéro avec parenthèses", "+33(6)12345678","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33(6)12345678"),
                Arguments.of("Numéro avec lettres", "+33ABCDEFGHI","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33ABCDEFGHI"),
                Arguments.of("Numéro trop long", "+336123456789012345","Le numéro de téléphone est trop long. Maximum 15 chiffres autorisés selon E.164. Longueur: 18 chiffres"),
                //Arguments.of("Indicatif invalide", "+99912345678",""), Ce n'est pas tester
                Arguments.of("Format local américain", "(555) 123-4567","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: (555)1234567"),
                Arguments.of("Numéro commençant par 00", "0033612345678","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: 0033612345678"),
                Arguments.of("Plus sans chiffres", "+","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +"),
                Arguments.of("Seulement des caractères spéciaux", "+--..","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +"),
                //Arguments.of("Numéro vide avec espaces", "   ",""), C'est considéré comme un numéro absent et géré tel quel avant la validation
                Arguments.of("Format international incomplet", "+33","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33"),
                Arguments.of("Caractères alphanumériques mélangés", "+33A12B34C56D78","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33A12B34C56D78"),
                Arguments.of("Double indicatif", "++33612345678","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: ++33612345678"),
                Arguments.of("Indicatif sans numéro", "+33","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33"),
                Arguments.of("Format avec extension", "+33612345678x123","Le numéro de téléphone ne respecte pas le format E.164. Format reçu après normalisation: +33612345678x123")
        );
    }
}
