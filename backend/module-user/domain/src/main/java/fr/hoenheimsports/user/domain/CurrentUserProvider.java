package fr.hoenheimsports.user.domain;

import fr.hoenheimsports.user.domain.annotations.DomainService;
import fr.hoenheimsports.user.domain.api.GetCurrentUser;
import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.spi.FetchCurrentUser;

import java.util.Optional;

@DomainService
public class CurrentUserProvider implements GetCurrentUser {
    private final FetchCurrentUser fetchCurrentUser;

    public CurrentUserProvider(FetchCurrentUser fetchCurrentUser) {
        this.fetchCurrentUser = fetchCurrentUser;
    }

    @Override
    public Optional<CurrentUser> execute() {
        return fetchCurrentUser.fetch();
    }
}
