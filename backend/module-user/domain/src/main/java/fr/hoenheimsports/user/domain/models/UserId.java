package fr.hoenheimsports.user.domain.models;

import fr.hoenheimsports.user.domain.exceptions.UserIdValidationException;

public record UserId(String id) {
    public UserId {
        if (id == null || id.isBlank()) {
            throw new UserIdValidationException("id cannot be null or blank");
        }
    }
}
