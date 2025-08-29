package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class FormerTeammateTest {

    @Test
    void testBuilderWithAllRequiredFields() {
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

    @Test
    void testBuilderWithOptionalFields() {
        UUID id = UUID.randomUUID();
        String firstName = "Jane";
        String lastName = "Smith";
        Gender gender = Gender.FEMALE;
        String phone = "123-456-7890";
        String email = "jane.smith@example.com";
        LocalDate birthDate = LocalDate.of(1990, 1, 1);
        List<Role> roles = List.of(Role.ASSISTANT);
        ContactStatus status = ContactStatus.PENDING;

        FormerTeammate teammate = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .phone(phone)
                .email(email)
                .birthDate(birthDate)
                .roles(roles)
                .status(status)
                .build();

        assertEquals(id, teammate.id());
        assertEquals(firstName, teammate.firstName());
        assertEquals(lastName, teammate.lastName());
        assertEquals(gender, teammate.gender());
        assertEquals(Optional.of(phone), teammate.phone());
        assertEquals(Optional.of(email), teammate.email());
        assertEquals(Optional.of(birthDate), teammate.birthDate());
        assertEquals(roles, teammate.roles());
        assertEquals(status, teammate.status());
    }

    @Test
    void testBuilderMissingRequiredFieldId() {
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .gender(gender)
                        .status(status)
                        .build()
        );

        assertEquals("id", exception.getMessage());
    }

    @Test
    void testBuilderMissingRequiredFieldFirstName() {
        UUID id = UUID.randomUUID();
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .id(id)
                        .lastName(lastName)
                        .gender(gender)
                        .status(status)
                        .build()
        );

        assertEquals("firstName", exception.getMessage());
    }

    @Test
    void testBuilderWithEmptyFirstNameField() {
        UUID id = UUID.randomUUID();
        String firstName = "   ";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .id(id)
                        .firstName(firstName)
                        .lastName(lastName)
                        .gender(gender)
                        .status(status)
                        .build()
        );

        assertEquals("firstName", exception.getMessage());
    }

    @Test
    void testBuilderMissingRequiredFieldLastName() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .id(id)
                        .firstName(firstName)
                        .gender(gender)
                        .status(status)
                        .build()
        );

        assertEquals("lastName", exception.getMessage());
    }

    @Test
    void testBuilderMissingRequiredFieldGender() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .id(id)
                        .firstName(firstName)
                        .lastName(lastName)
                        .status(status)
                        .build()
        );

        assertEquals("gender", exception.getMessage());
    }

    @Test
    void testBuilderMissingRequiredFieldStatus() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                FormerTeammate.builder()
                        .id(id)
                        .firstName(firstName)
                        .lastName(lastName)
                        .gender(gender)
                        .build()
        );

        assertEquals("status", exception.getMessage());
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
                id, firstName, lastName, gender, null, null, null, null, status
        );

        assertEquals(id, teammate.id());
        assertEquals(firstName, teammate.firstName());
        assertEquals(lastName, teammate.lastName());
        assertEquals(gender, teammate.gender());
        assertEquals(status, teammate.status());
        assertTrue(teammate.roles().isEmpty());
        assertNull(teammate.phone());
        assertNull(teammate.email());
        assertNull(teammate.birthDate());
    }

    @Test
    void testConstructorThrowsWhenIdIsNull() {
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(null, firstName, lastName, gender, null, null, null, null, status)
        );

        assertEquals("id", exception.getMessage());
    }

    @Test
    void testConstructorThrowsWhenFirstNameIsNull() {
        UUID id = UUID.randomUUID();
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(id, null, lastName, gender, null, null, null, null, status)
        );

        assertEquals("firstName", exception.getMessage());
    }

    @Test
    void testConstructorThrowsWhenLastNameIsNull() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(id, firstName, null, gender, null, null, null, null, status)
        );

        assertEquals("lastName", exception.getMessage());
    }

    @Test
    void testConstructorThrowsWhenGenderIsNull() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        ContactStatus status = ContactStatus.PENDING;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(id, firstName, lastName, null, null, null, null, null, status)
        );

        assertEquals("gender", exception.getMessage());
    }

    @Test
    void testConstructorThrowsWhenStatusIsNull() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;

        Exception exception = assertThrows(MissingRequiredFieldException.class, () ->
                new FormerTeammate(id, firstName, lastName, gender, null, null, null, null, null)
        );

        assertEquals("status", exception.getMessage());
    }

    @Test
    void testConstructorSetsDefaultRolesIfNull() {
        UUID id = UUID.randomUUID();
        String firstName = "John";
        String lastName = "Doe";
        Gender gender = Gender.MALE;
        ContactStatus status = ContactStatus.PENDING;

        FormerTeammate teammate = new FormerTeammate(
                id, firstName, lastName, gender, null, null, null, null, status
        );

        assertNotNull(teammate.roles());
        assertTrue(teammate.roles().isEmpty());
    }
}