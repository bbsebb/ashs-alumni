package fr.hoenheimsports.domain.models;


import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import fr.hoenheimsports.domain.services.validations.FieldValidationService;

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
        ContactStatus status,
        String code
) {

    private static final FieldValidationService validationService = new FieldValidationService();

    /**
     * Compact constructor that validates all required fields and ensures data integrity.
     * Performs null checks and business rule validations.
     * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
     * @throws MissingRequiredFieldException if any required field is null or empty
     */
    public FormerTeammate {
        validationService.validateRequiredField(id, "id");
        validationService.validateRequiredStringField(firstName, "firstName");
        validationService.validateRequiredStringField(lastName, "lastName");
        validationService.validateRequiredField(gender, "gender");
        validationService.validateRequiredField(phone, "phone");
        validationService.validateRequiredField(email, "email");
        validationService.validateRequiredField(birthDate, "birthDate");
        validationService.validateRequiredField(status, "status");
        validationService.validateRequiredStringField(code, "code");

        // Ensure that the roles list is never null
        roles = List.copyOf(validationService.validateListField(roles));
    }

    /**
     * Creates a new FormerTeammate instance with a changed contact status.
     * All other fields remain the same.
     *
     * @param newStatus the new contact status
     * @return a new FormerTeammate instance with the updated status
     * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
     * @throws MissingRequiredFieldException if any required field is null or empty
     */
    public FormerTeammate withContactStatus(ContactStatus newStatus) {
        validationService.validateRequiredField(newStatus, "newStatus");
        return new FormerTeammate(id, firstName, lastName, gender, phone, email, birthDate, roles, newStatus, code);
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
        private String code;

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
         * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
         */
        public Builder phone(String phone) {
            if(phone == null || phone.isBlank()) {
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
            if(email == null || email.isBlank()) {
                return this;
            }
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
         * Sets the code of the former teammate.
         *
         * @param code the code
         * @return this builder instance for method chaining
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }

        /**
         * Builds a new FormerTeammate instance with validation.
         * Validates that all required fields are set before creating the instance.
         *
         * @return a new FormerTeammate instance
         * @throws IllegalStateException if any required field is missing or invalid
         * @throws InvalidPhoneNumberException if the phone number format is invalid (propagated from Phone creation)
         */
        public FormerTeammate build() {
            validationService.validateRequiredField(id, "id");
            validationService.validateRequiredStringField(firstName, "firstName");
            validationService.validateRequiredStringField(lastName, "lastName");
            validationService.validateRequiredField(gender, "gender");
            validationService.validateRequiredField(status, "status");
            validationService.validateRequiredStringField(code, "code");

            return new FormerTeammate(id, firstName, lastName, gender, 
                    Optional.ofNullable(phone), Optional.ofNullable(email), Optional.ofNullable(birthDate),
                    List.copyOf(roles), status,code);
        }

    }

}