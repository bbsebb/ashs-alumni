package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.commands.CreateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CRUDFormerTeammateCommandFactoryTest {

    /**
     * Tests for CRUDFormerTeammateCommandFactory class.
     * Class Responsibility: Create command objects (CreateFormerTeammateCommand, UpdateFormerTeammateCommand)
     * from respective request DTOs.
     * <p>
     * This test focuses on the createFrom method for CreateFormerTeammateRequest -> CreateFormerTeammateCommand mapping.
     */

    @Test
    void testCreateFrom_ValidRequest_ShouldMapFieldsCorrectly() {
        // Arrange
        CRUDFormerTeammateCommandFactory factory = new CRUDFormerTeammateCommandFactory();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M,
                " John ",
                " Doe ",
                "0123456789",
                LocalDate.of(1990, 1, 1),
                List.of(Role.PLAYER, Role.COACH)
        );

        // Act
        CreateFormerTeammateCommand command = factory.createFrom(request);

        // Assert
        assertEquals(Gender.M, command.gender());
        assertEquals("John", command.firstName());
        assertEquals("Doe", command.lastName());
        assertEquals("0123456789", command.phone());
        assertEquals(LocalDate.of(1990, 1, 1), command.birthDate());
        assertEquals(List.of(Role.PLAYER, Role.COACH), command.roles());
    }

    @Test
    void testCreateFrom_RequestWithEmptyRoles_ShouldAllowEmptyRoles() {
        // Arrange
        CRUDFormerTeammateCommandFactory factory = new CRUDFormerTeammateCommandFactory();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.F,
                "Jane",
                "Smith",
                "9876543210",
                LocalDate.of(1995, 5, 15),
                List.of()
        );

        // Act
        CreateFormerTeammateCommand command = factory.createFrom(request);

        // Assert
        assertEquals(Gender.F, command.gender());
        assertEquals("Jane", command.firstName());
        assertEquals("Smith", command.lastName());
        assertEquals("9876543210", command.phone());
        assertEquals(LocalDate.of(1995, 5, 15), command.birthDate());
        assertEquals(List.of(), command.roles());
    }

    @Test
    void testCreateFrom_RequestWithNullPhone_ShouldAllowNullPhone() {
        // Arrange
        CRUDFormerTeammateCommandFactory factory = new CRUDFormerTeammateCommandFactory();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.M,
                "Tom",
                "Brown",
                null,
                LocalDate.of(2000, 3, 20),
                List.of(Role.COACH)
        );

        // Act
        CreateFormerTeammateCommand command = factory.createFrom(request);

        // Assert
        assertEquals(Gender.M, command.gender());
        assertEquals("Tom", command.firstName());
        assertEquals("Brown", command.lastName());
        assertNull(command.phone());
        assertEquals(LocalDate.of(2000, 3, 20), command.birthDate());
        assertEquals(List.of(Role.COACH), command.roles());
    }

    @Test
    void testCreateFrom_TrimsWhitespaceInNames_ShouldTrimValuesCorrectly() {
        // Arrange
        CRUDFormerTeammateCommandFactory factory = new CRUDFormerTeammateCommandFactory();
        CreateFormerTeammateRequest request = new CreateFormerTeammateRequest(
                Gender.F,
                "  Emily  ",
                "   Kyler  ",
                "1234567890",
                LocalDate.of(1985, 8, 25),
                List.of(Role.ASSISTANT)
        );

        // Act
        CreateFormerTeammateCommand command = factory.createFrom(request);

        // Assert
        assertEquals(Gender.F, command.gender());
        assertEquals("Emily", command.firstName());
        assertEquals("Kyler", command.lastName());
        assertEquals("1234567890", command.phone());
        assertEquals(LocalDate.of(1985, 8, 25), command.birthDate());
        assertEquals(List.of(Role.ASSISTANT), command.roles());
    }
}