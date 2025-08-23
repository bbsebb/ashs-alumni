package fr.hoenheimsports.user.infrastructure.adapters;

import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.models.Role;
import fr.hoenheimsports.user.domain.models.UserId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {FetchCurrentUserAdapter.class})
class FetchCurrentUserAdapterIntegrationTest {

    private final FetchCurrentUserAdapter adapter = new FetchCurrentUserAdapter();

    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void fetch_should_return_current_user_when_jwt_authentication_present() {
        // Arrange: construire un Jwt avec claims attendues
        Instant now = Instant.now();
        Map<String, Object> headers = Map.of("alg", "none");
        Map<String, Object> claims = new HashMap<>();
        claims.put("sub", "user-123");
        claims.put("preferred_username", "jdoe");

        Jwt jwt = new Jwt("test-token", now, now.plusSeconds(3600), headers, claims);

        // Autorités: le composant enlève "ROLE_" puis map vers Role.from(...)
        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER")
        );

        JwtAuthenticationToken authentication = new JwtAuthenticationToken(jwt, authorities);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        Optional<CurrentUser> result = adapter.fetch();

        // Assert
        assertThat(result).isPresent();
        CurrentUser user = result.get();
        assertThat(user.id()).isEqualTo(new UserId("user-123"));
        assertThat(user.username()).isEqualTo("jdoe");
        assertThat(user.roles()).contains(Role.ADMIN, Role.USER);
    }

    @Test
    void fetch_should_return_empty_when_no_authentication() {
        // Arrange
        SecurityContextHolder.clearContext();

        // Act
        Optional<CurrentUser> result = adapter.fetch();

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    void fetch_should_return_empty_when_authentication_is_not_jwt() {
        // Arrange: un autre type d’authentification
        TestingAuthenticationToken nonJwtAuth = new TestingAuthenticationToken("principal", "cred");
        nonJwtAuth.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(nonJwtAuth);

        // Act
        Optional<CurrentUser> result = adapter.fetch();

        // Assert
        assertThat(result).isEmpty();
    }
}
