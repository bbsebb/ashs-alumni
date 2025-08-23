package fr.hoenheimsports.user.domain.models;

import fr.hoenheimsports.user.domain.exceptions.UserIdValidationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserIdTest {

    @Test
    void shouldCreateValidUserId() {
        // Given
        String id = "valid-user-id";

        // When
        UserId userId = new UserId(id);

        // Then
        assertThat(userId.id()).isEqualTo(id);
    }
    

    @Test
    void shouldCreateValidUserIdWithSpecialCharacters() {
        // Given
        String id = "user-123@domain.com";

        // When
        UserId userId = new UserId(id);

        // Then
        assertThat(userId.id()).isEqualTo(id);
    }

    @ParameterizedTest(name = "[{index}] entrée invalide: `{0}`")
    @NullAndEmptySource
    @ValueSource(strings = {"", "     ", "\t"})
    void shouldThrowExceptionWhenIdIsNull(String wrongId) {
        // When & Then
        assertThatThrownBy(() -> new UserId(wrongId))
                .isInstanceOf(UserIdValidationException.class)
                .hasMessage("id cannot be null or blank");
    }
}