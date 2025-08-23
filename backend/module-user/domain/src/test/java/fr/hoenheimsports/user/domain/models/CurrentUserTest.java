package fr.hoenheimsports.user.domain.models;

import fr.hoenheimsports.user.domain.exceptions.CurrentUserValidationException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CurrentUserTest {

    @Test
    void shouldCreateValidCurrentUser() {
        // Given
        UserId userId = new UserId("valid-id");
        String username = "validuser";
        Set<Role> roles = Set.of(Role.USER);

        // When
        CurrentUser currentUser = new CurrentUser(userId, username, roles);

        // Then
        assertThat(currentUser.id()).isEqualTo(userId);
        assertThat(currentUser.username()).isEqualTo(username);
        assertThat(currentUser.roles()).containsExactly(Role.USER);
    }

    @Test
    void shouldCreateValidCurrentUserWithMultipleRoles() {
        // Given
        UserId userId = new UserId("admin-id");
        String username = "adminuser";
        Set<Role> roles = Set.of(Role.USER, Role.ADMIN);

        // When
        CurrentUser currentUser = new CurrentUser(userId, username, roles);

        // Then
        assertThat(currentUser.id()).isEqualTo(userId);
        assertThat(currentUser.username()).isEqualTo(username);
        assertThat(currentUser.roles()).containsExactlyInAnyOrder(Role.USER, Role.ADMIN);
    }

    @Test
    void shouldThrowExceptionWhenIdIsNull() {
        // Given
        String username = "validuser";
        Set<Role> roles = Set.of(Role.USER);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(null, username, roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("id must not be null");
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsNull() {
        // Given
        UserId userId = new UserId("valid-id");
        Set<Role> roles = Set.of(Role.USER);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, null, roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("username must not be null or blank");
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsBlank() {
        // Given
        UserId userId = new UserId("valid-id");
        Set<Role> roles = Set.of(Role.USER);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, "   ", roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("username must not be null or blank");
    }

    @Test
    void shouldThrowExceptionWhenUsernameIsEmpty() {
        // Given
        UserId userId = new UserId("valid-id");
        Set<Role> roles = Set.of(Role.USER);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, "", roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("username must not be null or blank");
    }

    @Test
    void shouldThrowExceptionWhenRolesIsNull() {
        // Given
        UserId userId = new UserId("valid-id");
        String username = "validuser";

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, username, null))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("roles must not be null or empty and must contain at least ROLE.USER");
    }

    @Test
    void shouldThrowExceptionWhenRolesIsEmpty() {
        // Given
        UserId userId = new UserId("valid-id");
        String username = "validuser";
        Set<Role> roles = Collections.emptySet();

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, username, roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("roles must not be null or empty and must contain at least ROLE.USER");
    }

    @Test
    void shouldThrowExceptionWhenRolesDoesNotContainUserRole() {
        // Given
        UserId userId = new UserId("valid-id");
        String username = "validuser";
        Set<Role> roles = Set.of(Role.ADMIN);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, username, roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("roles must not be null or empty and must contain at least ROLE.USER");
    }

    @Test
    void shouldThrowExceptionWhenRolesDoesNotContainUserRoleWithMultipleOtherRoles() {
        // Given
        UserId userId = new UserId("valid-id");
        String username = "validuser";
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMIN);

        // When & Then
        assertThatThrownBy(() -> new CurrentUser(userId, username, roles))
                .isInstanceOf(CurrentUserValidationException.class)
                .hasMessage("roles must not be null or empty and must contain at least ROLE.USER");
    }
}