package fr.hoenheimsports.formerteammate;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
final class FormerTeammateIntegrationTest {

    // Démarre un container PostgreSQL avant les tests
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17-alpine");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FormerTeammateRepository formerTeammateRepository;

    @BeforeEach
    void setUp() {
        formerTeammateRepository.deleteAll();
    }

    @Test
    void getFormerTeammates_shouldReturnListOfFormerTeammates() throws Exception {
        // Given
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        FormerTeammate teammate1 = FormerTeammate.builder()
                .id(id1)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammate teammate2 = FormerTeammate.builder()
                .id(id2)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0987654321")
                .birthDate(LocalDate.of(1985, 5, 20))
                .roles(List.of(Role.COACH))
                .status(ContactStatus.PENDING)
                .build();

        formerTeammateRepository.save(teammate1);
        formerTeammateRepository.save(teammate2);


        // When & Then
        mockMvc.perform(get("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(id1.toString()))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].gender").value("M"))
                .andExpect(jsonPath("$[0].phone").value("0123456789"))
                .andExpect(jsonPath("$[0].birthDate").value("1990-01-15"))
                .andExpect(jsonPath("$[0].roles[0]").value("PLAYER"))
                .andExpect(jsonPath("$[0].status").value("VALIDATED"))
                .andExpect(jsonPath("$[1].id").value(id2.toString()))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"))
                .andExpect(jsonPath("$[1].gender").value("F"))
                .andExpect(jsonPath("$[1].phone").value("0987654321"))
                .andExpect(jsonPath("$[1].birthDate").value("1985-05-20"))
                .andExpect(jsonPath("$[1].roles[0]").value("COACH"))
                .andExpect(jsonPath("$[1].status").value("PENDING"));
    }

    @Test
    void getFormerTeammates_withEmptyList_shouldReturnEmptyList() throws Exception {
        // Given

        // When & Then
        mockMvc.perform(get("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    void createFormerTeammate_shouldCreateAndReturnFormerTeammate() throws Exception {
        // Given
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER)
        );

        // When & Then
        mockMvc.perform(post("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.gender").value("M"))
                .andExpect(jsonPath("$.phone").value("0123456789"))
                .andExpect(jsonPath("$.birthDate").value("1990-01-15"))
                .andExpect(jsonPath("$.roles[0]").value("PLAYER"))
                .andExpect(jsonPath("$.status").value("SUBMITTED"));
    }

    @Test
    void createFormerTeammate_withMultipleRoles_shouldCreateSuccessfully() throws Exception {
        // Given

        List<Role> multipleRoles = Arrays.asList(Role.PLAYER, Role.COACH);

        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.F, "Jane", "Smith", "0987654321",
                LocalDate.of(1985, 5, 20), multipleRoles
        );


        // When & Then
        mockMvc.perform(post("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.gender").value("F"))
                .andExpect(jsonPath("$.phone").value("0987654321"))
                .andExpect(jsonPath("$.birthDate").value("1985-05-20"))
                .andExpect(jsonPath("$.roles").isArray())
                .andExpect(jsonPath("$.roles.length()").value(2))
                .andExpect(jsonPath("$.status").value("SUBMITTED"));
    }

    @Test
    void createFormerTeammate_withInvalidData_shouldReturnBadRequest() throws Exception {
        // Given - Invalid request with null firstName
        String invalidJson = """
                {
                    "gender": "M",
                    "firstName": null,
                    "lastName": "Doe",
                    "phone": "0123456789",
                    "birthDate": "1990-01-15",
                    "roles": ["PLAYER"]
                }
                """;

        // When & Then
        mockMvc.perform(post("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}