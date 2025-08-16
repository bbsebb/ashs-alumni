package fr.hoenheimsports.formerteammate.domain.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record FormerTeammate(
        UUID id,
        String firstName,
        String lastName,
        Gender gender,
        String phone,
        LocalDate birthDate,
        List<Role> roles,
        ContactStatus status
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private Gender gender;
        private String phone;
        private LocalDate birthDate;
        private List<Role> roles = new ArrayList<>();
        private ContactStatus status;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder roles(List<Role> roles) {
            this.roles = new ArrayList<>(roles);
            return this;
        }

/*        public Builder addRole(Role role) {
            this.roles.add(role);
            return this;
        }*/

        public Builder status(ContactStatus status) {
            this.status = status;
            return this;
        }

        public FormerTeammate build() {
            return new FormerTeammate(id, firstName, lastName, gender, phone, birthDate,
                    List.copyOf(roles), status);
        }
    }

}

