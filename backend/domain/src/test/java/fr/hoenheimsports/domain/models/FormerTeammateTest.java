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

class FormerTeammateTest {

    @ParameterizedTest
    @MethodSource("validBuilderScenariosData")
    void testBuilderWithValidData(String testCase, UUID id, String firstName, String lastName, Gender gender, 
                                String phone, String email, LocalDate birthDate, List<Role> roles, ContactStatus status) {
        FormerTeammate.Builder builder = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .status(status);

        if (phone != null) builder.phone(phone);
        if (email != null) builder.email(email);
        if (birthDate != null) builder.birthDate(birthDate);
        if (roles != null) builder.roles(roles);

        FormerTeammate teammate = builder.build();

        assertEquals(id, teammate.id());
        assertEquals(firstName, teammate.firstName());
        assertEquals(lastName, teammate.lastName());
        assertEquals(gender, teammate.gender());
        assertEquals(status, teammate.status());

        if (phone != null) {
            assertEquals(Optional.of(Phone.of(phone)), teammate.phone());
        } else {
            assertTrue(teammate.phone().isEmpty());
        }

        if (email != null) {
            assertEquals(Optional.of(email), teammate.email());
        } else {
            assertTrue(teammate.email().isEmpty());
        }

        if (birthDate != null) {
            assertEquals(Optional.of(birthDate), teammate.birthDate());
        } else {
            assertTrue(teammate.birthDate().isEmpty());
        }

        if (roles != null) {
            assertEquals(roles, teammate.roles());
        } else {
            assertTrue(teammate.roles().isEmpty());
        }
    }

    static Stream<Arguments> validBuilderScenariosData() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        UUID id3 = UUID.randomUUID();

        return Stream.of(
                arguments("Required fields only", id1, "John", "Doe", Gender.MALE, 
                         null, null, null, null, ContactStatus.PENDING),
                arguments("With all optional fields", id2, "Jane", "Smith", Gender.FEMALE, 
                         "+33123456789", "jane.smith@example.com", LocalDate.of(1990, 1, 1), 
                         List.of(Role.ASSISTANT), ContactStatus.PENDING),
                arguments("Mixed optional fields", id3, "Bob", "Wilson", Gender.MALE, 
                         "+33987654321", null, LocalDate.of(1985, 5, 15), 
                         List.of(Role.PLAYER, Role.COACH), ContactStatus.VALIDATED)
        );
    }

    @ParameterizedTest
    @MethodSource("builderMissingRequiredFieldsData")
    void testBuilderMissingRequiredFields(String testCase, UUID id, String firstName, String lastName, 
                                        Gender gender, ContactStatus status, String expectedField) {
        Exception exception = assertThrows(MissingRequiredFieldException.class, () -> {
            FormerTeammate.Builder builder = FormerTeammate.builder();
            if (id != null) builder.id(id);
            if (firstName != null) builder.firstName(firstName);
            if (lastName != null) builder.lastName(lastName);
            if (gender != null) builder.gender(gender);
            if (status != null) builder.status(status);
            builder.build();
        });

        assertEquals(expectedField, exception.getMessage());
    }

    static Stream<Arguments> builderMissingRequiredFieldsData() {
        UUID validId = UUID.randomUUID();
        String validFirstName = "John";
        String validLastName = "Doe";
        Gender validGender = Gender.MALE;
        ContactStatus validStatus = ContactStatus.PENDING;

        return Stream.of(
                arguments("Missing ID", null, validFirstName, validLastName, validGender, validStatus, "id"),
                arguments("Missing firstName", validId, null, validLastName, validGender, validStatus, "firstName"),
                arguments("Empty firstName", validId, "   ", validLastName, validGender, validStatus, "firstName"),
                arguments("Missing lastName", validId, validFirstName, null, validGender, validStatus, "lastName"),
                arguments("Missing gender", validId, validFirstName, validLastName, null, validStatus, "gender"),
                arguments("Missing status", validId, validFirstName, validLastName, validGender, null, "status")
        );
    }

    @Test
    void testBuilderRolesDefaultsToEmptyList() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        FormerTeammate teammate = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .status(status)
                .build();

        assertNotNull(teammate.roles());
        assertTrue(teammate.roles().isEmpty());
    }

    @Test
    void testConstructorValidatesRequiredFields() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        FormerTeammate teammate = new FormerTeammate(
                id, firstName, lastName, gender, Optional.empty(), Optional.empty(), Optional.empty(), List.of(), status
        );

        assertEquals(id, teammate.id());
        assertEquals(firstName, teammate.firstName());
        assertEquals(lastName, teammate.lastName());
        assertEquals(gender, teammate.gender());
        assertEquals(status, teammate.status());
        assertTrue(teammate.roles().isEmpty());
        assertTrue(teammate.phone().isEmpty());
        assertTrue(teammate.email().isEmpty());
        assertTrue(teammate.birthDate().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("constructorNullValidationData")
    void testConstructorThrowsWhenRequiredFieldIsNull(String testCase, UUID id, String firstName, String lastName, 
                                                    Gender gender, ContactStatus status, String expectedField) {
        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(id, firstName, lastName, gender, Optional.empty(), Optional.empty(), Optional.empty(), List.of(), status)
        );

        assertEquals(expectedField, exception.getMessage());
    }

    static Stream<Arguments> constructorNullValidationData() {
        UUID validId = UUID.randomUUID();
        String validFirstName = "John";
        String validLastName = "Doe";
        Gender validGender = Gender.MALE;
        ContactStatus validStatus = ContactStatus.PENDING;

        return Stream.of(
                arguments("Null ID", null, validFirstName, validLastName, validGender, validStatus, "id"),
                arguments("Null firstName", validId, null, validLastName, validGender, validStatus, "firstName"),
                arguments("Null lastName", validId, validFirstName, null, validGender, validStatus, "lastName"),
                arguments("Null gender", validId, validFirstName, validLastName, null, validStatus, "gender"),
                arguments("Null status", validId, validFirstName, validLastName, validGender, null, "status")
        );
    }

    @ParameterizedTest
    @MethodSource("constructorNullOptionalValidationData")
    void testConstructorThrowsWhenOptionalFieldIsNull(String testCase, Optional<Phone> phone, Optional<String> email, 
                                                     Optional<LocalDate> birthDate, String expectedField) {
        UUID validId = UUID.randomUUID();
        String validFirstName = "John";
        String validLastName = "Doe";
        Gender validGender = Gender.MALE;
        ContactStatus validStatus = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(validId, validFirstName, validLastName, validGender, phone, email, birthDate, List.of(), validStatus)
        );

        assertEquals(expectedField, exception.getMessage());
    }

    static Stream<Arguments> constructorNullOptionalValidationData() {
        return Stream.of(
                arguments("Null phone Optional", null, Optional.empty(), Optional.empty(), "phone"),
                arguments("Null email Optional", Optional.empty(), null, Optional.empty(), "email"),
                arguments("Null birthDate Optional", Optional.empty(), Optional.empty(), null, "birthDate")
        );
    }

    @Test
    void testConstructorSetsDefaultRolesIfNull() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        FormerTeammate teammate = new FormerTeammate(
                id, firstName, lastName, gender, Optional.empty(), Optional.empty(), Optional.empty(), null, status
        );

        assertNotNull(teammate.roles());
        assertTrue(teammate.roles().isEmpty());
    }

    @Test
    void testWithContactStatusReturnsNewInstanceWithChangedStatus() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus originalStatus = ContactStatus.PENDING;
        ContactStatus newStatus = ContactStatus.VALIDATED;

        FormerTeammate originalTeammate = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .status(originalStatus)
                .build();

        FormerTeammate updatedTeammate = originalTeammate.withContactStatus(newStatus);

        // Verify the new instance has the updated status
        assertEquals(newStatus, updatedTeammate.status());
        
        // Verify all other fields remain the same
        assertEquals(originalTeammate.id(), updatedTeammate.id());
        assertEquals(originalTeammate.firstName(), updatedTeammate.firstName());
        assertEquals(originalTeammate.lastName(), updatedTeammate.lastName());
        assertEquals(originalTeammate.gender(), updatedTeammate.gender());
        assertEquals(originalTeammate.phone(), updatedTeammate.phone());
        assertEquals(originalTeammate.email(), updatedTeammate.email());
        assertEquals(originalTeammate.birthDate(), updatedTeammate.birthDate());
        assertEquals(originalTeammate.roles(), updatedTeammate.roles());
        
        // Verify original instance is unchanged (immutability)
        assertEquals(originalStatus, originalTeammate.status());
        
        // Verify they are different instances
        assertNotSame(originalTeammate, updatedTeammate);
    }

    @Test
    void testWithContactStatusThrowsExceptionForNullStatus() {
        UUID id = UUID.randomUUID();
        FormerTeammate teammate = FormerTeammate.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .status(ContactStatus.PENDING)
                .build();

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                teammate.withContactStatus(null)
        );

        assertEquals("newStatus", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("contactStatusTransitionData")
    void testWithContactStatusWorksForAllStatusValues(String testCase, ContactStatus fromStatus, ContactStatus toStatus) {
        UUID id = UUID.randomUUID();
        FormerTeammate teammate = FormerTeammate.builder()
                .id(id)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.FEMALE)
                .status(fromStatus)
                .build();

        FormerTeammate updatedTeammate = teammate.withContactStatus(toStatus);

        assertEquals(toStatus, updatedTeammate.status());
        assertEquals(fromStatus, teammate.status()); // Original unchanged
    }

    static Stream<Arguments> contactStatusTransitionData() {
        return Stream.of(
                arguments("SUBMITTED to PENDING", ContactStatus.SUBMITTED, ContactStatus.PENDING),
                arguments("PENDING to VALIDATED", ContactStatus.PENDING, ContactStatus.VALIDATED),
                arguments("PENDING to UNREACHABLE", ContactStatus.PENDING, ContactStatus.UNREACHABLE),
                arguments("VALIDATED to NOT_REQUESTED", ContactStatus.VALIDATED, ContactStatus.NOT_REQUESTED),
                arguments("NOT_REQUESTED to SUBMITTED", ContactStatus.NOT_REQUESTED, ContactStatus.SUBMITTED),
                arguments("Same status transition", ContactStatus.PENDING, ContactStatus.PENDING)
        );
    }
}