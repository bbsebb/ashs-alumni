package fr.hoenheimsports.user.domain.api;

import fr.hoenheimsports.user.domain.models.CurrentUser;

import java.util.Optional;

public interface GetCurrentUser {
    Optional<CurrentUser> execute();
}
