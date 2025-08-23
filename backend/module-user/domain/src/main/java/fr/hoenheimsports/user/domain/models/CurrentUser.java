package fr.hoenheimsports.user.domain.models;

import fr.hoenheimsports.user.domain.exceptions.CurrentUserValidationException;

import java.util.HashSet;
import java.util.Set;

public record CurrentUser(
        UserId id,
        String username,
        Set<Role> roles
) {
    public CurrentUser {
        if (id == null) {
            throw new CurrentUserValidationException("id must not be null");
        }
        if (username == null || username.isBlank()) {
            throw new CurrentUserValidationException("username must not be null or blank");
        }
        // Garantir au moins ROLE.USER
        if (roles == null || roles.isEmpty() || !roles.contains(Role.USER)) {
            throw new CurrentUserValidationException("roles must not be null or empty and must contain at least ROLE.USER");
        }
    }


    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private String username;
        private final Set<Role> roles = new HashSet<>();

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder roles(Set<Role> roles) {
            this.roles.clear();
            if (roles != null) {
                this.roles.addAll(roles);
            }
            return this;
        }


        public CurrentUser build() {
            return new CurrentUser(new UserId(id), username, Set.copyOf(roles));
        }
    }

}
