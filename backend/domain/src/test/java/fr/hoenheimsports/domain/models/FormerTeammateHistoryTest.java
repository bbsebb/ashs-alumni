package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FormerTeammateHistoryTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("validBuilderScenariosData")
    void testBuilderWithValidData(String testCase, UUID id, UUID formerTeammateId, String phoneAtTime, 
                                 String emailAtTime, LocalDate birthDateAtTime, List<Role> rolesAtTime,
                                 ContactStatus statusAtTime, LocalDate updatedAt, HistoryAction historyAction,
                                 String updatedBy, String description) {
        // Given
        FormerTeammateHistory.Builder builder = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .phoneAtTime(phoneAtTime)
                .emailAtTime(emailAtTime)
                .birthDateAtTime(birthDateAtTime)
                .rolesAtTime(rolesAtTime)
                .statusAtTime(statusAtTime)
                .updatedAt(updatedAt)
                .historyAction(historyAction)
                .updatedBy(updatedBy)
                .description(description);

        // When
        FormerTeammateHistory history = builder.build();

        // Then
        assertNotNull(history);
        assertEquals(id, history.id());
        assertEquals(formerTeammateId, history.formerTeammateId());
        assertEquals(Optional.ofNullable(phoneAtTime != null ? Phone.of(phoneAtTime) : null), history.phoneAtTime());
        assertEquals(Optional.ofNullable(emailAtTime), history.emailAtTime());
        assertEquals(Optional.ofNullable(birthDateAtTime), history.birthDateAtTime());
        assertEquals(rolesAtTime != null ? rolesAtTime : List.of(), history.rolesAtTime());
        assertEquals(statusAtTime, history.statusAtTime());
        assertEquals(updatedAt, history.updatedAt());
        assertEquals(historyAction, history.historyAction());
        assertEquals(updatedBy, history.updatedBy());
        assertEquals(description, history.description());
    }

    static Stream<Arguments> validBuilderScenariosData() {
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        
        return Stream.of(
                arguments("Complete data with all optionals", id, formerTeammateId, "+33123456789", 
                         "test@example.com", birthDate, List.of(Role.PLAYER, Role.COACH), 
                         ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user123", "Initial creation"),
                arguments("Only required fields", id, formerTeammateId, null, null, null, 
                         List.of(), ContactStatus.PENDING, now, HistoryAction.UPDATED, "admin", "Status update"),
                arguments("With empty roles list", id, formerTeammateId, null, null, null,
                         List.of(), ContactStatus.SUBMITTED, now, HistoryAction.REMOVE, "system", "Cleanup operation")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("builderMissingRequiredFieldsData")
    void testBuilderMissingRequiredFields(String testCase, UUID id, UUID formerTeammateId, 
                                         ContactStatus statusAtTime, LocalDate updatedAt, 
                                         HistoryAction historyAction, String updatedBy, 
                                         String description, String expectedField) {
        // Given
        FormerTeammateHistory.Builder builder = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .statusAtTime(statusAtTime)
                .updatedAt(updatedAt)
                .historyAction(historyAction)
                .updatedBy(updatedBy)
                .description(description);

        // When & Then
        MissingRequiredFieldException exception = assertThrows(MissingRequiredFieldException.class, builder::build);
        assertTrue(exception.getMessage().contains(expectedField));
    }

    static Stream<Arguments> builderMissingRequiredFieldsData() {
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        
        return Stream.of(
                arguments("Missing id", null, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "desc", "id"),
                arguments("Missing formerTeammateId", id, null, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "desc", "formerTeammateId"),
                arguments("Missing statusAtTime", id, formerTeammateId, null, now, HistoryAction.CREATED, "user", "desc", "statusAtTime"),
                arguments("Missing updatedAt", id, formerTeammateId, ContactStatus.VALIDATED, null, HistoryAction.CREATED, "user", "desc", "updatedAt"),
                arguments("Missing historyAction", id, formerTeammateId, ContactStatus.VALIDATED, now, null, "user", "desc", "historyAction"),
                arguments("Missing updatedBy", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, null, "desc", "updatedBy"),
                arguments("Empty updatedBy", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "", "desc", "updatedBy"),
                arguments("Missing description", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", null, "description"),
                arguments("Empty description", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "", "description")
        );
    }

    @Test
    void testBuilderRolesDefaultsToEmptyList() {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        
        FormerTeammateHistory.Builder builder = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .statusAtTime(ContactStatus.VALIDATED)
                .updatedAt(now)
                .historyAction(HistoryAction.CREATED)
                .updatedBy("user")
                .description("test description");

        // When
        FormerTeammateHistory history = builder.build();

        // Then
        assertNotNull(history.rolesAtTime());
        assertTrue(history.rolesAtTime().isEmpty());
    }

    @Test
    void testConstructorValidatesRequiredFields() {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();

        // When & Then - Should not throw exception
        assertDoesNotThrow(() -> new FormerTeammateHistory(
                id, formerTeammateId, Optional.empty(), Optional.empty(), Optional.empty(),
                List.of(), ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "description"
        ));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("constructorNullValidationData")
    void testConstructorThrowsWhenRequiredFieldIsNull(String testCase, UUID id, UUID formerTeammateId, 
                                                     ContactStatus statusAtTime, LocalDate updatedAt, 
                                                     HistoryAction historyAction, String updatedBy, 
                                                     String description, String expectedField) {
        // When & Then
        MissingRequiredFieldException exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammateHistory(id, formerTeammateId, Optional.empty(), Optional.empty(), 
                                        Optional.empty(), List.of(), statusAtTime, updatedAt, 
                                        historyAction, updatedBy, description)
        );
        assertTrue(exception.getMessage().contains(expectedField));
    }

    static Stream<Arguments> constructorNullValidationData() {
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        
        return Stream.of(
                arguments("null id", null, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "desc", "id"),
                arguments("null formerTeammateId", id, null, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "desc", "formerTeammateId"),
                arguments("null statusAtTime", id, formerTeammateId, null, now, HistoryAction.CREATED, "user", "desc", "statusAtTime"),
                arguments("null updatedAt", id, formerTeammateId, ContactStatus.VALIDATED, null, HistoryAction.CREATED, "user", "desc", "updatedAt"),
                arguments("null historyAction", id, formerTeammateId, ContactStatus.VALIDATED, now, null, "user", "desc", "historyAction"),
                arguments("null updatedBy", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, null, "desc", "updatedBy"),
                arguments("null description", id, formerTeammateId, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", null, "description")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("constructorNullOptionalValidationData")
    void testConstructorThrowsWhenOptionalFieldIsNull(String testCase, Optional<Phone> phoneAtTime, 
                                                     Optional<String> emailAtTime, Optional<LocalDate> birthDateAtTime, 
                                                     String expectedField) {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();

        // When & Then
        MissingRequiredFieldException exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammateHistory(id, formerTeammateId, phoneAtTime, emailAtTime, 
                                        birthDateAtTime, List.of(), ContactStatus.VALIDATED, 
                                        now, HistoryAction.CREATED, "user", "description")
        );
        assertTrue(exception.getMessage().contains(expectedField));
    }

    static Stream<Arguments> constructorNullOptionalValidationData() {
        return Stream.of(
                arguments("null phoneAtTime Optional", null, Optional.empty(), Optional.empty(), "phoneAtTime"),
                arguments("null emailAtTime Optional", Optional.empty(), null, Optional.empty(), "emailAtTime"),
                arguments("null birthDateAtTime Optional", Optional.empty(), Optional.empty(), null, "birthDateAtTime")
        );
    }

    @Test
    void testConstructorSetsDefaultRolesIfNull() {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();

        // When
        FormerTeammateHistory history = new FormerTeammateHistory(
                id, formerTeammateId, Optional.empty(), Optional.empty(), Optional.empty(),
                null, ContactStatus.VALIDATED, now, HistoryAction.CREATED, "user", "description"
        );

        // Then
        assertNotNull(history.rolesAtTime());
        assertTrue(history.rolesAtTime().isEmpty());
    }

    @Test
    void testBuilderCanHandleNullPhone() {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();

        // When
        FormerTeammateHistory history = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .phoneAtTime((Phone) null)
                .statusAtTime(ContactStatus.VALIDATED)
                .updatedAt(now)
                .historyAction(HistoryAction.CREATED)
                .updatedBy("user")
                .description("test")
                .build();

        // Then
        assertTrue(history.phoneAtTime().isEmpty());
    }

    @Test
    void testBuilderCreatesImmutableRolesList() {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        List<Role> originalRoles = List.of(Role.PLAYER);

        // When
        FormerTeammateHistory history = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .rolesAtTime(originalRoles)
                .statusAtTime(ContactStatus.VALIDATED)
                .updatedAt(now)
                .historyAction(HistoryAction.CREATED)
                .updatedBy("user")
                .description("test")
                .build();

        // Then
        assertNotSame(originalRoles, history.rolesAtTime());
        assertEquals(originalRoles, history.rolesAtTime());
    }

    @ParameterizedTest(name = "Testing with {0}")
    @MethodSource("allHistoryActionData")
    void testBuilderWorksForAllHistoryActions(String testCase, HistoryAction historyAction) {
        // Given
        UUID id = UUID.randomUUID();
        UUID formerTeammateId = UUID.randomUUID();
        LocalDate now = LocalDate.now();

        // When
        FormerTeammateHistory history = FormerTeammateHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .statusAtTime(ContactStatus.VALIDATED)
                .updatedAt(now)
                .historyAction(historyAction)
                .updatedBy("user")
                .description("test")
                .build();

        // Then
        assertEquals(historyAction, history.historyAction());
    }

    static Stream<Arguments> allHistoryActionData() {
        return Stream.of(
                arguments("CREATED", HistoryAction.CREATED),
                arguments("UPDATED", HistoryAction.UPDATED),
                arguments("DELETED", HistoryAction.REMOVE)
        );
    }
}