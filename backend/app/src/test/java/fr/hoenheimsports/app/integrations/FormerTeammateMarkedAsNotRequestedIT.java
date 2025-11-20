package fr.hoenheimsports.app.integrations;

import com.c4_soft.springaddons.security.oauth2.test.annotations.OpenIdClaims;
import com.c4_soft.springaddons.security.oauth2.test.annotations.WithMockJwtAuth;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.domain.models.ContactStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@Transactional
@Testcontainers
public class FormerTeammateMarkedAsNotRequestedIT {
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
    @DisplayName("Valid scenarios with authentication")
    @WithMockJwtAuth(authorities = {"ROLE_ADMIN"}, claims = @OpenIdClaims(name = "nameTest"))
    void markAsNotRequestedFormerTeammate_withAuthentication_shouldReturn200_andPersistEntity() {

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
        assertThat(responseContext.status()).isNotEqualTo(ContactStatus.NOT_REQUESTED);


        FormerTeammateResponse formerTeammateResponse =this.webTestClient
                .post()
                .uri("/api/former-teammates/{id}/not_requested", responseContext.id())
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();

        assertThat(formerTeammateResponse).isNotNull();
        assertThat(formerTeammateResponse.id()).isEqualTo(responseContext.id());
        assertThat(formerTeammateResponse.status()).isEqualTo(ContactStatus.NOT_REQUESTED);
    }

    @Test
    @DisplayName("Valid scenarios without admin role")
    void markAsNotRequestedFormerTeammate_withoutRoleAdmin_shouldReturn401() {

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
        assertThat(responseContext.status()).isNotEqualTo(ContactStatus.NOT_REQUESTED);


        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates/{id}/not_requested", responseContext.id())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.UNAUTHORIZED.value());
        assertThat(response.getTitle()).isEqualTo("Permission utilisateur manquante");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/unauthorized");
        assertThat(response.getDetail()).isEqualTo("Vous n'avez pas les autorisations requises");
    }

    @Test
    @DisplayName("Send sms with NOT REQUESTED status")
    @WithMockJwtAuth(authorities = {"ROLE_ADMIN"}, claims = @OpenIdClaims(name = "nameTest"))
    void markAsNotRequestedFormerTeammate_AndSendSMS_withAuthentication_shouldReturn409() {

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
        assertThat(responseContext.status()).isNotEqualTo(ContactStatus.NOT_REQUESTED);


        FormerTeammateResponse formerTeammateResponse =this.webTestClient
                .post()
                .uri("/api/former-teammates/{id}/not_requested", responseContext.id())
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();

        assertThat(formerTeammateResponse).isNotNull();
        assertThat(formerTeammateResponse.id()).isEqualTo(responseContext.id());
        assertThat(formerTeammateResponse.status()).isEqualTo(ContactStatus.NOT_REQUESTED);


        ProblemDetail response = this.webTestClient
                .post()
                .uri("/api/former-teammates/{id}/resend-sms", responseContext.id())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(response.getTitle()).isEqualTo("Le contact est marqué comme « NON SOLLICITÉ »");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/former-teammate-not-requested");
        assertThat(response.getDetail()).isEqualTo("Le contact ne souhaite plus être sollicité.");
    }
}
