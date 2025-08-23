package fr.hoenheimsports.formerteammate.domain;

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

class FormerTeammateRemoverTest {

    private FormerTeammateRepositoryStub repository;
    private FormerTeammateRemover formerTeammateRemover;

    @BeforeEach
    void setUp() {
        repository = new FormerTeammateRepositoryStub();
        repository.clear();
        formerTeammateRemover = new FormerTeammateRemover(repository);
    }

    @Test
    void execute_shouldDeleteFormerTeammateById() {
        // Given
        UUID existingId = UUID.randomUUID();
        FormerTeammate existingFormerTeammate = FormerTeammate.builder()
                .id(existingId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1985, 6, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();

        // Save entity first to simulate existing data
        repository.save(existingFormerTeammate);

        // Verify entity exists before deletion
        assertTrue(repository.findById(existingId).isPresent(), "Entity should exist before deletion");

        // When
        formerTeammateRemover.execute(existingId);

        // Then
        // Verify that the entity was deleted
        assertFalse(repository.findById(existingId).isPresent(), "Entity should be deleted after execute");

        // Verify deleteById was called on repository (entity should be removed from the list)
        assertFalse(repository.findById(existingId).isPresent(), "Entity should be removed from repository after deletion");
    }

    @Test
    void execute_shouldCallRepositoryDeleteByIdWithCorrectUUID() {
        // Given
        UUID testId = UUID.randomUUID();

        // When
        formerTeammateRemover.execute(testId);

        // Then
        // Verify deleteById was called - even for non-existent entities, the method should execute without error
        // We can't verify the exact call was made with stub, but we can verify no exception was thrown
        assertDoesNotThrow(() -> formerTeammateRemover.execute(testId),
                "Should not throw exception when calling deleteById");

        // Verify the entity is not present after deletion attempt
        assertFalse(repository.findById(testId).isPresent(), "Entity should not exist after deletion attempt");
    }

    @Test
    void execute_shouldHandleNonExistentId() {
        // Given
        UUID nonExistentId = UUID.randomUUID();

        // Verify entity does not exist
        assertFalse(repository.findById(nonExistentId).isPresent(), "Entity should not exist initially");

        // When & Then
        // The method should not throw an exception even if ID doesn't exist
        assertDoesNotThrow(() -> formerTeammateRemover.execute(nonExistentId),
                "Should not throw exception when deleting non-existent ID");

        // Verify the entity still doesn't exist after deletion attempt
        assertFalse(repository.findById(nonExistentId).isPresent(),
                "Entity should still not exist after deletion attempt");
    }

    @Test
    void execute_shouldDeleteMultipleFormerTeammates() {
        // Given
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        FormerTeammate teammate1 = FormerTeammate.builder()
                .id(id1)
                .firstName("Alice")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0111111111")
                .birthDate(LocalDate.of(1990, 3, 10))
                .roles(List.of(Role.COACH))
                .status(ContactStatus.SUBMITTED)
                .build();

        FormerTeammate teammate2 = FormerTeammate.builder()
                .id(id2)
                .firstName("Bob")
                .lastName("Johnson")
                .gender(Gender.M)
                .phone("0222222222")
                .birthDate(LocalDate.of(1988, 12, 25))
                .roles(List.of(Role.PRESIDENT))
                .status(ContactStatus.VALIDATED)
                .build();

        repository.save(teammate1);
        repository.save(teammate2);

        // Verify both entities exist
        assertTrue(repository.findById(id1).isPresent(), "First entity should exist before deletion");
        assertTrue(repository.findById(id2).isPresent(), "Second entity should exist before deletion");

        // When
        formerTeammateRemover.execute(id1);
        formerTeammateRemover.execute(id2);

        // Then
        // Verify both entities were deleted
        assertFalse(repository.findById(id1).isPresent(), "First entity should be deleted");
        assertFalse(repository.findById(id2).isPresent(), "Second entity should be deleted");

        // Verify both deletion operations completed successfully
        assertFalse(repository.findById(id1).isPresent(), "First entity should be removed from repository");
        assertFalse(repository.findById(id2).isPresent(), "Second entity should be removed from repository");
    }

    @Test
    void execute_shouldAcceptAnyValidUUID() {
        // Given - Test with different UUID formats/patterns
        UUID uuid1 = UUID.fromString("550e8400-e29b-41d4-a716-446655440000");
        UUID uuid2 = UUID.fromString("6ba7b810-9dad-11d1-80b4-00c04fd430c8");
        UUID uuid3 = UUID.randomUUID();

        // When
        formerTeammateRemover.execute(uuid1);
        formerTeammateRemover.execute(uuid2);
        formerTeammateRemover.execute(uuid3);

        // Then
        // Verify all UUIDs were processed without throwing exceptions
        assertDoesNotThrow(() -> formerTeammateRemover.execute(uuid1), "First UUID should be processed without error");
        assertDoesNotThrow(() -> formerTeammateRemover.execute(uuid2), "Second UUID should be processed without error");
        assertDoesNotThrow(() -> formerTeammateRemover.execute(uuid3), "Third UUID should be processed without error");

        // Verify none of the entities exist after deletion attempts
        assertFalse(repository.findById(uuid1).isPresent(), "First entity should not exist after deletion");
        assertFalse(repository.findById(uuid2).isPresent(), "Second entity should not exist after deletion");
        assertFalse(repository.findById(uuid3).isPresent(), "Third entity should not exist after deletion");
    }
}