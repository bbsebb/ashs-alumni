package fr.hoenheimsports.domain.api.commands;

import java.util.Optional;

public record ContextDetails(Optional<CurrentUser> currentUser) {
    public boolean hasRole(String role) {
        if (currentUser.isEmpty()) {
            return false;
        }
        return currentUser.map(user -> user.roles().contains(role)).orElse(false);
    }
}
