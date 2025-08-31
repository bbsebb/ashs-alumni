package fr.hoenheimsports.domain.models;


import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a former teammate in the sports organization.
 * This record encapsulates all the information about a person who was previously part of the team,
 * including their personal details, contact information, and role history.
 *
 * @param id        The unique identifier of the former teammate
 * @param firstName The first name of the former teammate
 * @param lastName  The last name of the former teammate
 * @param gender    The gender of the former teammate
 * @param phone     The phone number for contact (optional)
 * @param email     The email address for contact (optional)
 * @param birthDate The birthdate of the former teammate (optional)
 * @param roles     The list of roles this person had in the organization
 * @param status    The current contact status
 */
public record FormerTeammate(
        UUID id,
        String firstName,
        String lastName,
        Gender gender,
        Optional<Phone> phone,
        Optional<String> email,
        Optional<LocalDate> birthDate,
        List<Role> roles,
        ContactStatus status
) {

    /**
     * Compact constructor that validates all required fields and ensures data integrity.
     * Performs null checks and business rule validations.
     *
     * @throws MissingRequiredFieldException if any required field is null or empty
     */
    public FormerTeammate {
        validateRequiredField(id, "id");
        validateRequiredStringField(firstName, "firstName");
        validateRequiredStringField(lastName, "lastName");
        validateRequiredField(gender, "gender");
        validateRequiredField(phone, "phone");
        validateRequiredField(email, "email");
        validateRequiredField(birthDate, "birthDate");
        validateRequiredField(status, "status");

        // Ensure that the roles list is never null
        if (roles == null) {
            roles = List.of();
        }

    }

    /**
     * Validates that a required field is not null.
     *
     * @param field     the field to validate
     * @param fieldName the name of the field for error messaging
     * @throws MissingRequiredFieldException if the field is null
     */
    private static void validateRequiredField(Object field, String fieldName) {
        if (field == null) {
            throw new MissingRequiredFieldException(fieldName);
        }
    }

    /**
     * Validates that a required string field is not null or empty.
     *
     * @param field     the string field to validate
     * @param fieldName the name of the field for error messaging
     * @throws MissingRequiredFieldException if the field is null or empty after trimming
     */
    private static void validateRequiredStringField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new MissingRequiredFieldException(fieldName);
        }
    }


    /**
     * Creates a new builder instance for constructing FormerTeammate objects.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating FormerTeammate instances with fluent API.
     * Provides validation to ensure all required fields are set before building.
     */
    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private Gender gender;
        private Phone phone;
        private String email;
        private LocalDate birthDate;
        private List<Role> roles = new ArrayList<>();
        private ContactStatus status;

        private Builder() {
        }

        /**
         * Sets the unique identifier for the former teammate.
         *
         * @param id the UUID identifier
         * @return this builder instance for method chaining
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the first name of the former teammate.
         *
         * @param firstName the first name
         * @return this builder instance for method chaining
         */
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Sets the last name of the former teammate.
         *
         * @param lastName the last name
         * @return this builder instance for method chaining
         */
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Sets the gender of the former teammate.
         *
         * @param gender the gender
         * @return this builder instance for method chaining
         */
        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        /**
         * Sets the phone number of the former teammate.
         *
         * @param phone the phone number (optional)
         * @return this builder instance for method chaining
         */
        public Builder phone(String phone) {
            if(phone == null) {
                return this;
            }
            this.phone = Phone.of(phone);
            return this;
        }

        /**
         * Sets the email address of the former teammate.
         *
         * @param email the email address (optional)
         * @return this builder instance for method chaining
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Sets the birth date of the former teammate.
         *
         * @param birthDate the birth date (optional)
         * @return this builder instance for method chaining
         */
        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Sets the list of roles for the former teammate.
         *
         * @param roles the list of roles
         * @return this builder instance for method chaining
         */
        public Builder roles(List<Role> roles) {
            this.roles = new ArrayList<>(roles);
            return this;
        }

/*        public Builder addRole(Role role) {
            this.roles.add(role);
            return this;
        }*/

        /**
         * Sets the contact status of the former teammate.
         *
         * @param status the contact status
         * @return this builder instance for method chaining
         */
        public Builder status(ContactStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Builds a new FormerTeammate instance with validation.
         * Validates that all required fields are set before creating the instance.
         *
         * @return a new FormerTeammate instance
         * @throws IllegalStateException if any required field is missing or invalid
         */
        public FormerTeammate build() {
            validateRequiredField(id, "id");
            validateRequiredStringField(firstName, "firstName");
            validateRequiredStringField(lastName, "lastName");
            validateRequiredField(gender, "gender");
            validateRequiredField(status, "status");

            return new FormerTeammate(id, firstName, lastName, gender, 
                    Optional.ofNullable(phone), Optional.ofNullable(email), Optional.ofNullable(birthDate),
                    List.copyOf(roles), status);
        }

    }

}