package fr.hoenheimsports.formerteammate.domain;

import fr.hoenheimsports.formerteammate.domain.commands.UpdateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.stubs.FormerTeammateRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FormerTeammateUpdaterTest {

    private FormerTeammateRepositoryStub repository;
    private FormerTeammateUpdater formerTeammateUpdater;
    private UUID existingId;

    @BeforeEach
    void setUp() {
        repository = new FormerTeammateRepositoryStub();
        repository.clear();
        formerTeammateUpdater = new FormerTeammateUpdater(repository);

        // Setup existing former teammate for update tests
        existingId = UUID.randomUUID();
        FormerTeammate existingFormerTeammate = FormerTeammate.builder()
                .id(existingId)
                .firstName("Original")
                .lastName("Name")
                .gender(Gender.M)
                .phone("0111111111")
                .birthDate(LocalDate.of(1985, 1, 1))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();
        repository.save(existingFormerTeammate);
    }

    @Test
    void execute_shouldUpdateExistingFormerTeammate() {
        // Given
        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                existingId,
                Gender.F,
                "Updated",
                "LastName",
                "0222222222",
                LocalDate.of(1990, 5, 15),
                List.of(Role.COACH, Role.PRESIDENT)
        );

        // When
        FormerTeammate result = formerTeammateUpdater.execute(command);

        // Then
        // Verify that the result is not null
        assertNotNull(result, "Result should not be null");

        // Verify entity construction with updated command data
        assertEquals(existingId, result.id(), "ID should remain the same");
        assertEquals("Updated", result.firstName(), "FirstName should be updated");
        assertEquals("LastName", result.lastName(), "LastName should be updated");
        assertEquals(Gender.F, result.gender(), "Gender should be updated");
        assertEquals("0222222222", result.phone(), "Phone should be updated");
        assertEquals(LocalDate.of(1990, 5, 15), result.birthDate(), "BirthDate should be updated");
        assertEquals(List.of(Role.COACH, Role.PRESIDENT), result.roles(), "Roles should be updated");

        // Verify status is preserved from original entity
        assertEquals(ContactStatus.VALIDATED, result.status(), "Status should be preserved from original entity");

        // Verify repository save was called
        assertEquals(2, repository.getSavedEntities().size(), "Repository save should be called (original + updated)");
        assertTrue(repository.getSavedEntities().contains(result), "Updated entity should be saved");
    }

    @Test
    void execute_shouldPreserveStatusFromOriginalEntity() {
        // Given - Create another entity with different status
        UUID anotherId = UUID.randomUUID();
        FormerTeammate anotherFormerTeammate = FormerTeammate.builder()
                .id(anotherId)
                .firstName("Another")
                .lastName("Person")
                .gender(Gender.M)
                .phone("0333333333")
                .birthDate(LocalDate.of(1980, 12, 25))
                .roles(List.of(Role.ASSISTANT))
                .status(ContactStatus.SUBMITTED)
                .build();
        repository.save(anotherFormerTeammate);

        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                anotherId,
                Gender.F,
                "Updated Another",
                "Updated Person",
                "0444444444",
                LocalDate.of(1981, 6, 10),
                List.of(Role.PLAYER)
        );

        // When
        FormerTeammate result = formerTeammateUpdater.execute(command);

        // Then
        // Verify status is preserved as SUBMITTED (not VALIDATED)
        assertEquals(ContactStatus.SUBMITTED, result.status(), "Status should be preserved from original entity (SUBMITTED)");
    }

    @Test
    void execute_shouldThrowExceptionWhenFormerTeammateNotFound() {
        // Given
        UUID nonExistentId = UUID.randomUUID();
        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                nonExistentId,
                Gender.F,
                "New",
                "Person",
                "0555555555",
                LocalDate.of(1995, 3, 20),
                List.of(Role.PLAYER)
        );

        // When & Then
        FormerTeammateNotFoundException exception = assertThrows(
                FormerTeammateNotFoundException.class,
                () -> formerTeammateUpdater.execute(command),
                "Should throw FormerTeammateNotFoundException when ID not found"
        );

        // Verify exception message
        assertTrue(exception.getMessage().contains(nonExistentId.toString()),
                "Exception message should contain the ID that was not found");
        assertTrue(exception.getMessage().contains("does not exist"),
                "Exception message should indicate the entity does not exist");

        // Verify no additional save was called
        assertEquals(1, repository.getSavedEntities().size(), "No additional save should occur when entity not found");
    }

    @Test
    void execute_shouldCallRepositoryFindByIdAndSave() {
        // Given
        UpdateFormerTeammateCommand command = new UpdateFormerTeammateCommand(
                existingId,
                Gender.M,
                "Test",
                "User",
                "0666666666",
                LocalDate.of(1988, 8, 8),
                List.of(Role.ASSISTANT)
        );

        // When
        FormerTeammate result = formerTeammateUpdater.execute(command);

        // Then
        // Verify repository interactions
        assertTrue(repository.findById(existingId).isPresent(), "Repository should have been queried for existing ID");
        assertTrue(repository.getSavedEntities().contains(result), "Repository save should have been called with updated entity");

        // Verify the saved entity has correct data
        FormerTeammate savedEntity = repository.getSavedEntities().stream()
                .filter(entity -> entity.equals(result))
                .findFirst()
                .orElseThrow();
        assertEquals(result, savedEntity, "Saved entity should match returned entity");
    }
}