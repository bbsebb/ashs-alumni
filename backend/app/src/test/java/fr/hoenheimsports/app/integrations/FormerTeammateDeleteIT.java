package fr.hoenheimsports.app.integrations;

import com.c4_soft.springaddons.security.oauth2.test.annotations.OpenIdClaims;
import com.c4_soft.springaddons.security.oauth2.test.annotations.WithMockJwtAuth;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.domain.models.HistoryAction;
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

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
@SpringBootTest
@Transactional
@Testcontainers
public class FormerTeammateDeleteIT extends FormerTeammateIT{
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

    }
    @Test
    @DisplayName("No authentication")
    void deleteFormerTeammate_shouldReturn401_whenNoAuthentication() {

        ProblemDetail response = this.webTestClient
                .delete()
                .uri("/api/former-teammates/{id}", UUID.randomUUID())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED)
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
    @WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("wrong UUID")
    void deleteFormerTeammate_shouldReturn404_whenEntityNotFound() {

        ProblemDetail response = this.webTestClient
                .delete()
                .uri("/api/former-teammates/{id}", UUID.randomUUID())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND)
                .expectBody(ProblemDetail.class)
                .returnResult()
                .getResponseBody();
        assertThat(response).isNotNull();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getTitle()).isEqualTo("Le contact n'existe pas ou n'a pas été trouvé");
        assertThat(response.getType().toString()).isEqualTo("https://api.hoenheimsports.fr/errors/former-teammate-not-found");
        assertThat(response.getDetail()).isEqualTo("Le contact à supprimer n'existe pas ou plus.");
    }

    @Test
    @WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Valid scenarios with authentication with role admin")
    void deleteFormerTeammate_shouldReturn204_andDeleteEntity_WhenRoleAdmin() {
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

        Assertions.assertNotNull(response);
        this.webTestClient
                .delete()
                .uri("/api/former-teammates/{id}", response.id())
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @WithMockJwtAuth(authorities = {"ROLE_USER"}, claims = @OpenIdClaims(name = "nameTest"))
    @DisplayName("Valid scenarios with authentication")
    void deleteFormerTeammate_shouldReturn204_andDeleteEntity() {
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

        Assertions.assertNotNull(response);
        this.webTestClient
                .delete()
                .uri("/api/former-teammates/{id}", response.id())
                .exchange()
                .expectStatus().isNoContent();

        List<FormerTeammateResponse> activeFormerTeammateResponses = this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api/former-teammates").queryParam("isActive",true).build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        assertThat(activeFormerTeammateResponses).doesNotContain(response);

        List<FormerTeammateResponse> allFormerTeammateResponses = this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api/former-teammates").queryParam("isActive",false).build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FormerTeammateResponse.class)
                .returnResult()
                .getResponseBody();
        assertThat(allFormerTeammateResponses).isNotNull();
        assertThat(allFormerTeammateResponses.getFirst()).isNotNull();

        allFormerTeammateResponses.forEach(System.out::println);


        assertThat(allFormerTeammateResponses.getFirst().id()).isEqualTo(response.id());
        assertThat(allFormerTeammateResponses.getFirst().formerTeammateHistories()).anyMatch(formerTeammateHistoryResponse -> formerTeammateHistoryResponse.historyAction().equals(HistoryAction.REMOVED));
    }
}
