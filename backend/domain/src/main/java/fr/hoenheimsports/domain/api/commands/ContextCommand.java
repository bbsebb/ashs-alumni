package fr.hoenheimsports.domain.api.commands;

import fr.hoenheimsports.domain.models.Role;

import java.util.Optional;
import java.util.Set;

public record ContextCommand(Optional<CurrentUser> currentUser) {
}
