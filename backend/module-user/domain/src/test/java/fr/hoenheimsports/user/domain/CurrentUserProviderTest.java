package fr.hoenheimsports.user.domain;

import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.models.Role;
import fr.hoenheimsports.user.domain.models.UserId;
import fr.hoenheimsports.user.domain.spi.stubs.FetchCurrentUserStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CurrentUserProviderTest {

    private FetchCurrentUserStub fetchCurrentUserStub;
    private CurrentUserProvider currentUserProvider;

    @BeforeEach
    void setUp() {
        fetchCurrentUserStub = new FetchCurrentUserStub();
        currentUserProvider = new CurrentUserProvider(fetchCurrentUserStub);
    }

    @Test
    void execute_shouldReturnDefaultUser() {
        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isPresent();
        CurrentUser currentUser = result.get();
        assertThat(currentUser.id()).isEqualTo(new UserId("id"));
        assertThat(currentUser.username()).isEqualTo("current_user");
        assertThat(currentUser.roles()).containsExactly(Role.USER);
    }

    @Test
    void execute_shouldReturnUserWithCustomId() {
        // Given
        fetchCurrentUserStub.setCurrentUserId("custom-id");

        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isPresent();
        CurrentUser currentUser = result.get();
        assertThat(currentUser.id()).isEqualTo(new UserId("custom-id"));
        assertThat(currentUser.username()).isEqualTo("current_user");
        assertThat(currentUser.roles()).containsExactly(Role.USER);
    }

    @Test
    void execute_shouldReturnUserWithCustomUsername() {
        // Given
        fetchCurrentUserStub.setCurrentUserUsername("john.doe");

        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isPresent();
        CurrentUser currentUser = result.get();
        assertThat(currentUser.id()).isEqualTo(new UserId("id"));
        assertThat(currentUser.username()).isEqualTo("john.doe");
        assertThat(currentUser.roles()).containsExactly(Role.USER);
    }

    @Test
    void execute_shouldReturnUserWithCustomRoles() {
        // Given
        HashSet<Role> customRoles = new HashSet<>();
        customRoles.add(Role.ADMIN);
        customRoles.add(Role.USER);
        fetchCurrentUserStub.setCurrentUserRoles(customRoles);

        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isPresent();
        CurrentUser currentUser = result.get();
        assertThat(currentUser.id()).isEqualTo(new UserId("id"));
        assertThat(currentUser.username()).isEqualTo("current_user");
        assertThat(currentUser.roles()).containsExactlyInAnyOrder(Role.ADMIN, Role.USER);
    }

    @Test
    void execute_shouldReturnUserWithAllCustomValues() {
        // Given
        HashSet<Role> customRoles = new HashSet<>();
        customRoles.add(Role.USER);
        customRoles.add(Role.ADMIN);
        fetchCurrentUserStub.setCurrentUserId("admin-123");
        fetchCurrentUserStub.setCurrentUserUsername("admin.user");
        fetchCurrentUserStub.setCurrentUserRoles(customRoles);

        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isPresent();
        CurrentUser currentUser = result.get();
        assertThat(currentUser.id()).isEqualTo(new UserId("admin-123"));
        assertThat(currentUser.username()).isEqualTo("admin.user");
        assertThat(currentUser.roles()).containsExactly(Role.ADMIN, Role.USER);
    }

    @Test
    void execute_shouldReturnEmptyOptionalWhenNoCurrentUser() {
        // Given
        fetchCurrentUserStub.setNoCurrentUser();

        // When
        Optional<CurrentUser> result = currentUserProvider.execute();

        // Then
        assertThat(result).isEmpty();
    }
}