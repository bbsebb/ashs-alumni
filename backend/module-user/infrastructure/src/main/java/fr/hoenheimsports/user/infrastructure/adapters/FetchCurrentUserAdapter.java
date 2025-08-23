package fr.hoenheimsports.user.infrastructure.adapters;

import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.models.Role;
import fr.hoenheimsports.user.domain.spi.FetchCurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FetchCurrentUserAdapter implements FetchCurrentUser {
    @Override
    public Optional<CurrentUser> fetch() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof JwtAuthenticationToken jwtAuth) || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Jwt jwt = jwtAuth.getToken();

        String id = jwt.getSubject();
        String username = jwt.getClaimAsString("preferred_username");
        Set<Role> roles = jwtAuth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> role.replace("ROLE_", ""))
                .map(Role::from)
                .collect(Collectors.toSet());


        return Optional.of(CurrentUser.builder().id(id).username(username).roles(roles).build());
    }
}
