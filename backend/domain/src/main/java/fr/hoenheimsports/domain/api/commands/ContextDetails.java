package fr.hoenheimsports.domain.api.commands;

import java.util.Optional;

public record ContextDetails(Optional<CurrentUser> currentUser) {
}
