package fr.hoenheimsports.formerteammate.infrastructure.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.hoenheimsports.formerteammate.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.api.DeleteFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.api.GetAllFormerTeammates;
import fr.hoenheimsports.formerteammate.domain.api.UpdateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.commands.CreateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.commands.UpdateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.UpdateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.CRUDFormerTeammateCommandFactory;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import fr.hoenheimsports.user.domain.api.GetCurrentUser;
import fr.hoenheimsports.user.domain.models.CurrentUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = FormerTeammateController.class, excludeAutoConfiguration = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
class FormerTeammateControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CreateFormerTeammate createFormerTeammateService;
    @MockitoBean
    private UpdateFormerTeammate updateFormerTeammateService;
    @MockitoBean
    private DeleteFormerTeammate deleteFormerTeammateService;
    @MockitoBean
    private GetAllFormerTeammates getAllFormerTeammatesService;
    @MockitoBean
    private CRUDFormerTeammateCommandFactory crudFormerTeammateCommandFactory;
    @MockitoBean
    private FormerTeammateMapper formerTeammateMapper;
    @MockitoBean
    private FormerTeammateRepository formerTeammateRepository;
    @MockitoBean
    private GetCurrentUser getCurrentUser;

    @Test
    void getFormerTeammates_shouldReturnListOfFormerTeammates() throws Exception {
        // Given
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        List<FormerTeammate> formerTeammates = List.of(
                FormerTeammate.builder()
                        .id(id1)
                        .firstName("John")
                        .lastName("Doe")
                        .gender(Gender.M)
                        .phone("0123456789")
                        .birthDate(LocalDate.of(1990, 1, 15))
                        .roles(List.of(Role.PLAYER))
                        .status(ContactStatus.PENDING)
                        .build(),
                FormerTeammate.builder()
                        .id(id2)
                        .firstName("Jane")
                        .lastName("Smith")
                        .gender(Gender.F)
                        .phone("0987654321")
                        .birthDate(LocalDate.of(1985, 5, 20))
                        .roles(List.of(Role.COACH))
                        .status(ContactStatus.VALIDATED)
                        .build()
        );

        List<FormerTeammateResponse> responses = List.of(
                new FormerTeammateResponse(id1, "John", "Doe", Gender.M, "0123456789",
                        LocalDate.of(1990, 1, 15), List.of(Role.PLAYER), ContactStatus.PENDING),
                new FormerTeammateResponse(id2, "Jane", "Smith", Gender.F, "0987654321",
                        LocalDate.of(1985, 5, 20), List.of(Role.COACH), ContactStatus.VALIDATED)
        );

        when(getAllFormerTeammatesService.execute()).thenReturn(formerTeammates);
        when(formerTeammateMapper.toResponseList(formerTeammates)).thenReturn(responses);

        // When & Then
        String responseContent = mockMvc.perform(get("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(id1.toString()))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].gender").value("M"))
                .andExpect(jsonPath("$[1].id").value(id2.toString()))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Smith"))
                .andExpect(jsonPath("$[1].gender").value("F"))
                .andReturn().getResponse().getContentAsString();

        // Additional AssertJ assertions
        List<FormerTeammateResponse> actualResponses = objectMapper.readValue(responseContent,
                objectMapper.getTypeFactory().constructCollectionType(List.class, FormerTeammateResponse.class));

        assertThat(actualResponses).hasSize(2);
        assertThat(actualResponses.get(0).firstName()).isEqualTo("John");
        assertThat(actualResponses.get(1).firstName()).isEqualTo("Jane");
    }

    @Test
    void getFormerTeammates_withEmptyList_shouldReturnEmptyList() throws Exception {
        // Given
        List<FormerTeammate> emptyFormerTeammates = Collections.emptyList();
        List<FormerTeammateResponse> emptyResponses = Collections.emptyList();

        when(getAllFormerTeammatesService.execute()).thenReturn(emptyFormerTeammates);
        when(formerTeammateMapper.toResponseList(emptyFormerTeammates)).thenReturn(emptyResponses);

        // When & Then
        String responseContent = mockMvc.perform(get("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(0))
                .andReturn().getResponse().getContentAsString();

        // Additional AssertJ assertions
        List<FormerTeammateResponse> actualResponses = objectMapper.readValue(responseContent,
                objectMapper.getTypeFactory().constructCollectionType(List.class, FormerTeammateResponse.class));

        assertThat(actualResponses).isEmpty();
    }

    @Test
    void createFormerTeammate_shouldCreateAndReturnFormerTeammate() throws Exception {
        // Given
        UUID createdId = UUID.randomUUID();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER)
        );

        Optional<CurrentUser> currentUser = Optional.empty();

        CreateFormerTeammateCommand command = new CreateFormerTeammateCommand(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER),
                false, false
        );

        FormerTeammate createdTeammate = FormerTeammate.builder()
                .id(createdId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.PENDING)
                .build();

        FormerTeammateResponse response = new FormerTeammateResponse(
                createdId, "John", "Doe", Gender.M, "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER), ContactStatus.PENDING
        );

        when(getCurrentUser.execute()).thenReturn(currentUser);
        when(crudFormerTeammateCommandFactory.createFrom(any(CreateFormerTeammateRequest.class), any(Optional.class))).thenReturn(command);
        when(createFormerTeammateService.execute(command)).thenReturn(createdTeammate);
        when(formerTeammateMapper.toResponse(createdTeammate)).thenReturn(response);

        // When & Then
        String responseContent = mockMvc.perform(post("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", "/api/former-teammates/" + createdId))
                .andExpect(jsonPath("$.id").value(createdId.toString()))
                .andExpect(jsonPath("$.firstName").value("John"))
                .andExpect(jsonPath("$.lastName").value("Doe"))
                .andExpect(jsonPath("$.gender").value("M"))
                .andExpect(jsonPath("$.phone").value("0123456789"))
                .andExpect(jsonPath("$.roles[0]").value("PLAYER"))
                .andExpect(jsonPath("$.status").value("PENDING"))
                .andReturn().getResponse().getContentAsString();

        // Additional AssertJ assertions
        FormerTeammateResponse actualResponse = objectMapper.readValue(responseContent, FormerTeammateResponse.class);

        assertThat(actualResponse.id()).isEqualTo(createdId);
        assertThat(actualResponse.firstName()).isEqualTo("John");
        assertThat(actualResponse.lastName()).isEqualTo("Doe");
        assertThat(actualResponse.gender()).isEqualTo(Gender.M);
        assertThat(actualResponse.roles()).containsExactly(Role.PLAYER);
        assertThat(actualResponse.status()).isEqualTo(ContactStatus.PENDING);
    }

    @Test
    void createFormerTeammate_withInvalidData_shouldReturnBadRequest() throws Exception {
        // Given - invalid request with null required fields
        CreateFormerTeammateRequest invalidRequest = new CreateFormerTeammateRequest(
                null, "", "", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER)
        );

        Optional<CurrentUser> currentUser = Optional.empty();
        when(getCurrentUser.execute()).thenReturn(currentUser);

        // When & Then
        mockMvc.perform(post("/api/former-teammmates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void updateFormerTeammate_shouldUpdateAndReturnFormerTeammate() throws Exception {
        // Given
        UUID existingId = UUID.randomUUID();
        UpdateFormerTeammateRequest request = new UpdateFormerTeammateRequest(
                Gender.F, "Jane", "Smith", "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH)
        );

        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                existingId, Gender.F, "Jane", "Smith", "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH)
        );

        FormerTeammate updatedTeammate = FormerTeammate.builder()
                .id(existingId)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0987654321")
                .birthDate(LocalDate.of(1985, 5, 20))
                .roles(List.of(Role.COACH))
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammateResponse response = new FormerTeammateResponse(
                existingId, "Jane", "Smith", Gender.F, "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH), ContactStatus.VALIDATED
        );

        when(crudFormerTeammateCommandFactory.createFrom(any(UpdateFormerTeammateRequest.class), any(UUID.class))).thenReturn(command);
        when(updateFormerTeammateService.execute(command)).thenReturn(updatedTeammate);
        when(formerTeammateMapper.toResponse(updatedTeammate)).thenReturn(response);

        // When & Then
        String responseContent = mockMvc.perform(put("/api/former-teammmates/" + existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(existingId.toString()))
                .andExpect(jsonPath("$.firstName").value("Jane"))
                .andExpect(jsonPath("$.lastName").value("Smith"))
                .andExpect(jsonPath("$.gender").value("F"))
                .andExpect(jsonPath("$.phone").value("0987654321"))
                .andExpect(jsonPath("$.roles[0]").value("COACH"))
                .andExpect(jsonPath("$.status").value("VALIDATED"))
                .andReturn().getResponse().getContentAsString();

        // Additional AssertJ assertions
        FormerTeammateResponse actualResponse = objectMapper.readValue(responseContent, FormerTeammateResponse.class);

        assertThat(actualResponse.id()).isEqualTo(existingId);
        assertThat(actualResponse.firstName()).isEqualTo("Jane");
        assertThat(actualResponse.lastName()).isEqualTo("Smith");
        assertThat(actualResponse.gender()).isEqualTo(Gender.F);
        assertThat(actualResponse.roles()).containsExactly(Role.COACH);
        assertThat(actualResponse.status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void updateFormerTeammate_withInvalidData_shouldReturnBadRequest() throws Exception {
        // Given
        UUID existingId = UUID.randomUUID();
        UpdateFormerTeammateRequest invalidRequest = new UpdateFormerTeammateRequest(
                null, "", "", "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH)
        );

        // When & Then
        mockMvc.perform(put("/api/former-teammmates/" + existingId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void deleteFormerTeammate_shouldDeleteAndReturnNoContent() throws Exception {
        // Given
        UUID existingId = UUID.randomUUID();

        // When & Then
        mockMvc.perform(delete("/api/former-teammmates/" + existingId))
                .andExpect(status().isNoContent());

        // Verify service was called
        verify(deleteFormerTeammateService).execute(existingId);
    }

    @Test
    void deleteFormerTeammate_withInvalidUUID_shouldReturnBadRequest() throws Exception {
        // Given
        String invalidId = "invalid-uuid";

        // When & Then
        mockMvc.perform(delete("/api/former-teammmates/" + invalidId))
                .andExpect(status().isBadRequest());
    }
}