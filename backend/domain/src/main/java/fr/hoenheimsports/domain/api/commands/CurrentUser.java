package fr.hoenheimsports.domain.api.commands;

import java.util.Set;

public record CurrentUser(String id,
                          String username,
                          Set<String> roles) {
}
