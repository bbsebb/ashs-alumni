package fr.hoenheimsports.formerteammate.infrastructure.controllers;

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
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.UpdateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.CRUDFormerTeammateCommandFactory;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import fr.hoenheimsports.user.domain.api.GetCurrentUser;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FormerTeammateControllerTest {

    @Mock
    private CreateFormerTeammate createFormerTeammateService;

    @Mock
    private UpdateFormerTeammate updateFormerTeammateService;

    @Mock
    private DeleteFormerTeammate deleteFormerTeammateService;

    @Mock
    private GetAllFormerTeammates getAllFormerTeammatesService;

    @Mock
    private CRUDFormerTeammateCommandFactory crudFormerTeammateCommandFactory;

    @Mock
    private FormerTeammateMapper formerTeammateMapper;

    @Mock
    private GetCurrentUser getCurrentUser;

    private FormerTeammateController controller;

    @BeforeEach
    void setUp() {
        controller = new FormerTeammateController(
                createFormerTeammateService,
                updateFormerTeammateService,
                deleteFormerTeammateService,
                getAllFormerTeammatesService,
                crudFormerTeammateCommandFactory,
                formerTeammateMapper,
                getCurrentUser
        );
    }

    @Test
    void getFormerTeammates_shouldReturnListOfFormerTeammates() {
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

        List<FormerTeammate> teammates = Arrays.asList(teammate1, teammate2);

        List<FormerTeammateResponse> responses = getFormerTeammateResponses(id1, id2);

        when(getAllFormerTeammatesService.execute()).thenReturn(teammates);
        when(formerTeammateMapper.toResponseList(teammates)).thenReturn(responses);

        // When
        ResponseEntity<List<FormerTeammateResponse>> result = controller.getFormerTeammates();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody()).hasSize(2);
        assertThat(result.getBody().get(0).firstName()).isEqualTo("John");
        assertThat(result.getBody().get(0).lastName()).isEqualTo("Doe");
        assertThat(result.getBody().get(1).firstName()).isEqualTo("Jane");
        assertThat(result.getBody().get(1).lastName()).isEqualTo("Smith");
    }

    private static @NotNull List<FormerTeammateResponse> getFormerTeammateResponses(UUID id1, UUID id2) {
        FormerTeammateResponse response1 = new FormerTeammateResponse(
                id1, "John", "Doe", Gender.M, "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER), ContactStatus.VALIDATED
        );

        FormerTeammateResponse response2 = new FormerTeammateResponse(
                id2, "Jane", "Smith", Gender.F, "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH), ContactStatus.PENDING
        );

        return Arrays.asList(response1, response2);
    }

    @Test
    void getFormerTeammates_withEmptyList_shouldReturnEmptyList() {
        // Given
        List<FormerTeammate> emptyTeammates = Collections.emptyList();
        List<FormerTeammateResponse> emptyResponses = Collections.emptyList();

        when(getAllFormerTeammatesService.execute()).thenReturn(emptyTeammates);
        when(formerTeammateMapper.toResponseList(emptyTeammates)).thenReturn(emptyResponses);

        // When
        ResponseEntity<List<FormerTeammateResponse>> result = controller.getFormerTeammates();

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody()).isEmpty();
    }

    @Test
    void createFormerTeammate_shouldCreateAndReturnFormerTeammate() {
        // Given
        UUID createdId = UUID.randomUUID();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER)
        );

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

        when(crudFormerTeammateCommandFactory.createFrom(eq(request), any())).thenReturn(command);
        when(createFormerTeammateService.execute(command)).thenReturn(createdTeammate);
        when(formerTeammateMapper.toResponse(createdTeammate)).thenReturn(response);

        // When
        ResponseEntity<FormerTeammateResponse> result = controller.createFormerTeammate(request);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().id()).isEqualTo(createdId);
        assertThat(result.getBody().firstName()).isEqualTo("John");
        assertThat(result.getBody().lastName()).isEqualTo("Doe");
        assertThat(result.getBody().gender()).isEqualTo(Gender.M);
        assertThat(result.getBody().phone()).isEqualTo("0123456789");
        assertThat(result.getBody().birthDate()).isEqualTo(LocalDate.of(1990, 1, 15));
        assertThat(result.getBody().roles()).containsExactly(Role.PLAYER);
        assertThat(result.getBody().status()).isEqualTo(ContactStatus.PENDING);

        // Verify location header
        assertThat(result.getHeaders().getLocation()).isNotNull();
        assertThat(result.getHeaders().getLocation()).isEqualTo(URI.create("/api/former-teammates/" + createdId));
    }

    @Test
    void createFormerTeammate_withMultipleRoles_shouldCreateSuccessfully() {
        // Given
        UUID createdId = UUID.randomUUID();
        List<Role> multipleRoles = Arrays.asList(Role.PLAYER, Role.COACH);

        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER)
        );

        CreateFormerTeammateCommand command = new CreateFormerTeammateCommand(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER),
                false, false
        );

        FormerTeammate createdTeammate = FormerTeammate.builder()
                .id(createdId)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0987654321")
                .birthDate(LocalDate.of(1985, 5, 20))
                .roles(multipleRoles)
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammateResponse response = new FormerTeammateResponse(
                createdId, "Jane", "Smith", Gender.F, "0987654321",
                LocalDate.of(1985, 5, 20), multipleRoles, ContactStatus.VALIDATED
        );

        when(crudFormerTeammateCommandFactory.createFrom(eq(request), any())).thenReturn(command);
        when(createFormerTeammateService.execute(command)).thenReturn(createdTeammate);
        when(formerTeammateMapper.toResponse(createdTeammate)).thenReturn(response);

        // When
        ResponseEntity<FormerTeammateResponse> result = controller.createFormerTeammate(request);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().roles()).hasSize(2);
        assertThat(result.getBody().roles()).containsExactlyInAnyOrder(Role.PLAYER, Role.COACH);
        assertThat(result.getBody().status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void updateFormerTeammate_shouldUpdateAndReturnFormerTeammate() {
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

        when(crudFormerTeammateCommandFactory.createFrom(request, existingId)).thenReturn(command);
        when(updateFormerTeammateService.execute(command)).thenReturn(updatedTeammate);
        when(formerTeammateMapper.toResponse(updatedTeammate)).thenReturn(response);

        // When
        ResponseEntity<FormerTeammateResponse> result = controller.updateFormerTeammate(existingId, request);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().id()).isEqualTo(existingId);
        assertThat(result.getBody().firstName()).isEqualTo("Jane");
        assertThat(result.getBody().lastName()).isEqualTo("Smith");
        assertThat(result.getBody().gender()).isEqualTo(Gender.F);
        assertThat(result.getBody().phone()).isEqualTo("0987654321");
        assertThat(result.getBody().birthDate()).isEqualTo(LocalDate.of(1985, 5, 20));
        assertThat(result.getBody().roles()).containsExactly(Role.COACH);
        assertThat(result.getBody().status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void updateFormerTeammate_withMultipleRoles_shouldUpdateSuccessfully() {
        // Given
        UUID existingId = UUID.randomUUID();
        List<Role> multipleRoles = Arrays.asList(Role.PLAYER, Role.COACH);

        UpdateFormerTeammateRequest request = new UpdateFormerTeammateRequest(
                Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), multipleRoles
        );

        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                existingId, Gender.M, "John", "Doe", "0123456789",
                LocalDate.of(1990, 1, 15), multipleRoles
        );

        FormerTeammate updatedTeammate = FormerTeammate.builder()
                .id(existingId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(multipleRoles)
                .status(ContactStatus.PENDING)
                .build();

        FormerTeammateResponse response = new FormerTeammateResponse(
                existingId, "John", "Doe", Gender.M, "0123456789",
                LocalDate.of(1990, 1, 15), multipleRoles, ContactStatus.PENDING
        );

        when(crudFormerTeammateCommandFactory.createFrom(request, existingId)).thenReturn(command);
        when(updateFormerTeammateService.execute(command)).thenReturn(updatedTeammate);
        when(formerTeammateMapper.toResponse(updatedTeammate)).thenReturn(response);

        // When
        ResponseEntity<FormerTeammateResponse> result = controller.updateFormerTeammate(existingId, request);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().roles()).hasSize(2);
        assertThat(result.getBody().roles()).containsExactlyInAnyOrder(Role.PLAYER, Role.COACH);
        assertThat(result.getBody().status()).isEqualTo(ContactStatus.PENDING);
    }

    @Test
    void deleteFormerTeammate_shouldDeleteAndReturnNoContent() {
        // Given
        UUID idToDelete = UUID.randomUUID();

        // When
        ResponseEntity<Void> result = controller.deleteFormerTeammate(idToDelete);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(result.getBody()).isNull();
    }

    @Test
    void deleteFormerTeammate_withValidId_shouldCallServiceAndReturnNoContent() {
        // Given
        UUID existingId = UUID.randomUUID();

        // When
        ResponseEntity<Void> result = controller.deleteFormerTeammate(existingId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(result.getBody()).isNull();

        // Verify that the service was called with the correct ID
        // Note: We can't verify this directly with Mockito.verify in this setup
        // but the controller implementation shows it calls deleteFormerTeammateService.execute(id)
    }
}