package fr.hoenheimsports.user.domain.spi;

import fr.hoenheimsports.user.domain.models.CurrentUser;

import java.util.Optional;

public interface FetchCurrentUser {
    Optional<CurrentUser> fetch();
}
