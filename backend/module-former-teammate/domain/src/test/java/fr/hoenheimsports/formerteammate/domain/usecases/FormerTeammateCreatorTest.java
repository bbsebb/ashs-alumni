package fr.hoenheimsports.formerteammate.domain.usecases;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.GenerateId;
import fr.hoenheimsports.formerteammate.domain.spi.stub.FormerTeammateRepositoryStub;
import fr.hoenheimsports.formerteammate.domain.spi.stub.UUIDGeneratorStub;
import fr.hoenheimsports.formerteammate.domain.usecases.commands.CreateFormerTeammateCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormerTeammateCreatorTest {

    private FormerTeammateRepositoryStub repository;
    private FormerTeammateCreator formerTeammateCreator;


    @BeforeEach
    void setUp() {
        repository = new FormerTeammateRepositoryStub();
        repository.clear();
        GenerateId generateId = new UUIDGeneratorStub();
        formerTeammateCreator = new FormerTeammateCreator(repository, generateId);
    }

    @Test
    void execute() {
        // Given
        CreateFormerTeammateCommand command = new CreateFormerTeammateCommand(
                Gender.M,
                "John",
                "Doe",
                "0123456789",
                LocalDate.of(1990, 1, 15),
                List.of(Role.PLAYER, Role.COACH)
        );

        // When
        FormerTeammate result = formerTeammateCreator.execute(command);

        // Then
        // Verify that the result is not null
        assertNotNull(result, "Result should not be null");

        // Verify UUID is assigned (not null)
        assertNotNull(result.id(), "UUID should be assigned");

        // Verify entity construction with command data
        assertEquals("John", result.firstName(), "FirstName should match command");
        assertEquals("Doe", result.lastName(), "LastName should match command");
        assertEquals(Gender.M, result.gender(), "Gender should match command");
        assertEquals("0123456789", result.phone(), "Phone should match command");
        assertEquals(LocalDate.of(1990, 1, 15), result.birthDate(), "BirthDate should match command");
        assertEquals(List.of(Role.PLAYER, Role.COACH), result.roles(), "Roles should match command");

        // Verify default status is set to SUBMITTED
        assertEquals(ContactStatus.SUBMITTED, result.status(), "Status should be SUBMITTED by default");

        // Verify repository save was called (check saved entities)
        assertEquals(1, repository.getSavedEntities().size(), "Repository save should be called once");
        FormerTeammate savedEntity = repository.getSavedEntities().getFirst();
        assertEquals(result, savedEntity, "Saved entity should match returned entity");
    }

    @Test
    void execute_generatesUniqueUUIDs() {
        // Given
        CreateFormerTeammateCommand command1 = new CreateFormerTeammateCommand(
                Gender.F,
                "Jane",
                "Smith",
                "0987654321",
                LocalDate.of(1985, 5, 20),
                List.of(Role.PRESIDENT)
        );

        CreateFormerTeammateCommand command2 = new CreateFormerTeammateCommand(
                Gender.M,
                "Bob",
                "Johnson",
                "0555666777",
                LocalDate.of(1992, 12, 3),
                List.of(Role.ASSISTANT)
        );

        // When
        FormerTeammate result1 = formerTeammateCreator.execute(command1);
        FormerTeammate result2 = formerTeammateCreator.execute(command2);

        // Then
        // Verify UUIDs are unique
        assertNotEquals(result1.id(), result2.id(), "Generated UUIDs should be unique");

        // Verify both entities were saved
        assertEquals(2, repository.getSavedEntities().size(), "Both entities should be saved");
    }


}