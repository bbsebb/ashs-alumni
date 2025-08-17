package fr.hoenheimsports.formerteammate.domain.models;

import fr.hoenheimsports.formerteammate.domain.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormerTeammateTest {

    private static final UUID VALID_ID = UUID.randomUUID();
    private static final String VALID_FIRST_NAME = "John";
    private static final String VALID_LAST_NAME = "Doe";
    private static final Gender VALID_GENDER = Gender.M;
    private static final ContactStatus VALID_STATUS = ContactStatus.SUBMITTED;

    /**
     * Provides test cases for null field validation.
     * Each argument contains: field description, id, firstName, lastName, gender, status, expected field name in exception
     */
    static Stream<Arguments> nullFieldTestCases() {
        return Stream.of(
                Arguments.of("null id", null, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_GENDER, VALID_STATUS, "id"),
                Arguments.of("null firstName", VALID_ID, null, VALID_LAST_NAME, VALID_GENDER, VALID_STATUS, "firstName"),
                Arguments.of("null lastName", VALID_ID, VALID_FIRST_NAME, null, VALID_GENDER, VALID_STATUS, "lastName"),
                Arguments.of("null gender", VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, null, VALID_STATUS, "gender"),
                Arguments.of("null status", VALID_ID, VALID_FIRST_NAME, VALID_LAST_NAME, VALID_GENDER, null, "status")
        );
    }

    /**
     * Provides test cases for empty string field validation.
     * Each argument contains: field description, firstName, lastName, expected field name in exception
     */
    static Stream<Arguments> emptyStringTestCases() {
        return Stream.of(
                Arguments.of("empty firstName", "", VALID_LAST_NAME, "firstName"),
                Arguments.of("whitespace firstName", "   ", VALID_LAST_NAME, "firstName"),
                Arguments.of("empty lastName", VALID_FIRST_NAME, "", "lastName"),
                Arguments.of("whitespace lastName", VALID_FIRST_NAME, "   ", "lastName")
        );
    }

    @ParameterizedTest(name = "Should throw MissingRequiredFieldException when {0}")
    @MethodSource("nullFieldTestCases")
    void shouldThrowExceptionForNullFields(String description, UUID id, String firstName, String lastName,
                                           Gender gender, ContactStatus status, String expectedFieldName) {
        // When & Then
        assertThatThrownBy(() -> new FormerTeammate(id, firstName, lastName, gender, null, null, List.of(), status))
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining(expectedFieldName);
    }

    @ParameterizedTest(name = "Should throw MissingRequiredFieldException when {0}")
    @MethodSource("emptyStringTestCases")
    void shouldThrowExceptionForEmptyStringFields(String description, String firstName, String lastName,
                                                  String expectedFieldName) {
        // When & Then
        assertThatThrownBy(() -> new FormerTeammate(VALID_ID, firstName, lastName, VALID_GENDER, null, null, List.of(), VALID_STATUS))
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining(expectedFieldName);
    }

    @Test
    void shouldCreateValidFormerTeammateWithAllRequiredFields() {
        // When
        FormerTeammate teammate = new FormerTeammate(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_GENDER,
                null,
                null,
                List.of(),
                VALID_STATUS
        );

        // Then
        assertThat(teammate).isNotNull();
        assertThat(teammate.id()).isEqualTo(VALID_ID);
        assertThat(teammate.firstName()).isEqualTo(VALID_FIRST_NAME);
        assertThat(teammate.lastName()).isEqualTo(VALID_LAST_NAME);
        assertThat(teammate.gender()).isEqualTo(VALID_GENDER);
        assertThat(teammate.status()).isEqualTo(VALID_STATUS);
        assertThat(teammate.roles()).isNotNull().isEmpty();
    }

    @Test
    void shouldCreateValidFormerTeammateWithAllFields() {
        // Given
        String phone = "123-456-7890";
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        List<Role> roles = List.of(); // Assuming Role enum exists, using empty list for now

        // When
        FormerTeammate teammate = new FormerTeammate(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_GENDER,
                phone,
                birthDate,
                roles,
                VALID_STATUS
        );

        // Then
        assertThat(teammate).isNotNull();
        assertThat(teammate.id()).isEqualTo(VALID_ID);
        assertThat(teammate.firstName()).isEqualTo(VALID_FIRST_NAME);
        assertThat(teammate.lastName()).isEqualTo(VALID_LAST_NAME);
        assertThat(teammate.gender()).isEqualTo(VALID_GENDER);
        assertThat(teammate.phone()).isEqualTo(phone);
        assertThat(teammate.birthDate()).isEqualTo(birthDate);
        assertThat(teammate.roles()).isEqualTo(roles);
        assertThat(teammate.status()).isEqualTo(VALID_STATUS);
    }

    @Test
    void shouldHandleNullRolesList() {
        // When
        FormerTeammate teammate = new FormerTeammate(
                VALID_ID,
                VALID_FIRST_NAME,
                VALID_LAST_NAME,
                VALID_GENDER,
                null,
                null,
                null, // null roles list
                VALID_STATUS
        );

        // Then
        assertThat(teammate.roles()).isNotNull().isEmpty();
    }
}