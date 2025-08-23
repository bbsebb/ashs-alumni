package fr.hoenheimsports.user.domain.spi.stubs;

import fr.hoenheimsports.user.domain.annotations.Stub;
import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.models.Role;
import fr.hoenheimsports.user.domain.models.UserId;
import fr.hoenheimsports.user.domain.spi.FetchCurrentUser;

import java.util.HashSet;
import java.util.Optional;

@Stub
public class FetchCurrentUserStub implements FetchCurrentUser {

    private CurrentUser currentUser;

    public FetchCurrentUserStub() {
        var roles = new HashSet<Role>();
        roles.add(Role.USER);
        currentUser = new CurrentUser(new UserId("id"), "current_user", roles);
    }

    @Override
    public Optional<CurrentUser> fetch() {
        return Optional.ofNullable(currentUser);
    }

    public void setCurrentUserId(String newId) {
        currentUser = new CurrentUser(new UserId(newId), currentUser.username(), currentUser.roles());
    }

    public void setCurrentUserUsername(String newUsername) {
        currentUser = new CurrentUser(currentUser.id(), newUsername, currentUser.roles());
    }

    public void setCurrentUserRoles(HashSet<Role> newRoles) {
        currentUser = new CurrentUser(currentUser.id(), currentUser.username(), newRoles);
    }

    public void setNoCurrentUser() {
        currentUser = null;
    }
}
