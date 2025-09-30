package fr.hoenheimsports.app.services;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityContextService {

    public ContextDetails getCurrentContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return buildContextFromAuthentication(authentication);
    }

    private ContextDetails buildContextFromAuthentication(Authentication authentication) {
        if (!(authentication instanceof JwtAuthenticationToken jwtAuth) || !authentication.isAuthenticated()) {
            return new ContextDetails(Optional.empty());
        }

        Jwt jwt = jwtAuth.getToken();

        String id = jwt.getSubject();
        String username = jwt.getClaimAsString("preferred_username");
        Set<String> roles = jwtAuth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> role.replace("ROLE_", ""))
                .collect(Collectors.toSet());


        return new ContextDetails(
                Optional.of(
                        new CurrentUser(id,username,roles)
                )
        );
    }
}


