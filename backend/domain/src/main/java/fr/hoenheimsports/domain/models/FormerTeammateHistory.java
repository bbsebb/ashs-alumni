package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import fr.hoenheimsports.domain.services.validations.FieldValidationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the historical state of a former teammate at a specific point in time.
 * This record captures all the information about a former teammate's data changes,
 * including their personal details, contact information, and metadata about the change.
 *
 * @param id                The unique identifier of this history entry
 * @param formerTeammateId  The unique identifier of the former teammate
 * @param phoneAtTime       The phone number at the time of this history entry (optional)
 * @param emailAtTime       The email address at the time of this history entry (optional)
 * @param birthDateAtTime   The birthdate at the time of this history entry (optional)
 * @param rolesAtTime       The list of roles at the time of this history entry
 * @param statusAtTime      The contact status at the time of this history entry
 * @param updatedAt         The date when this history entry was created
 * @param historyAction     The action that triggered this history entry
 * @param updatedBy         The user who made the change
 * @param description       A description of the change made
 */
public record FormerTeammateHistory(
        UUID id,
        UUID formerTeammateId,
        Optional<Phone> phoneAtTime,
        Optional<String> emailAtTime,
        Optional<LocalDate> birthDateAtTime,
        List<Role> rolesAtTime,
        ContactStatus statusAtTime,
        LocalDateTime updatedAt,
        HistoryAction historyAction,
        String updatedBy,
        String description
) {

    private static final FieldValidationService validationService = new FieldValidationService();

    /**
     * Compact constructor that validates all required fields and ensures data integrity.
     * Performs null checks and business rule validations.
     * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
     * @throws MissingRequiredFieldException if any required field is null or empty
     */
    public FormerTeammateHistory {
        validationService.validateRequiredField(id, "id");
        validationService.validateRequiredField(formerTeammateId, "formerTeammateId");
        validationService.validateRequiredField(phoneAtTime, "phoneAtTime");
        validationService.validateRequiredField(emailAtTime, "emailAtTime");
        validationService.validateRequiredField(birthDateAtTime, "birthDateAtTime");
        validationService.validateRequiredField(statusAtTime, "statusAtTime");
        validationService.validateRequiredField(updatedAt, "updatedAt");
        validationService.validateRequiredField(historyAction, "historyAction");
        validationService.validateRequiredStringField(updatedBy, "updatedBy");
        validationService.validateRequiredStringField(description, "description");

        // Ensure that the roles list is never null
        rolesAtTime = validationService.validateListField(rolesAtTime);
    }

    /**
     * Creates a new builder instance for constructing FormerTeammateHistory objects.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating FormerTeammateHistory instances with fluent API.
     * Provides validation to ensure all required fields are set before building.
     */
    public static class Builder {
        private UUID id;
        private UUID formerTeammateId;
        private Phone phoneAtTime;
        private String emailAtTime;
        private LocalDate birthDateAtTime;
        private List<Role> rolesAtTime = new ArrayList<>();
        private ContactStatus statusAtTime;
        private LocalDateTime updatedAt;
        private HistoryAction historyAction;
        private String updatedBy;
        private String description;

        private Builder() {
        }

        /**
         * Sets the unique identifier for the history entry.
         *
         * @param id the UUID identifier
         * @return this builder instance for method chaining
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the former teammate identifier.
         *
         * @param formerTeammateId the former teammate UUID identifier
         * @return this builder instance for method chaining
         */
        public Builder formerTeammateId(UUID formerTeammateId) {
            this.formerTeammateId = formerTeammateId;
            return this;
        }

        /**
         * Sets the phone number at the time of this history entry.
         *
         * @param phoneAtTime the phone number (optional)
         * @return this builder instance for method chaining
         * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
         */
        public Builder phoneAtTime(String phoneAtTime) {
            if(phoneAtTime == null) {
                return this;
            }
            this.phoneAtTime = Phone.of(phoneAtTime);
            return this;
        }

        /**
         * Sets the phone number at the time of this history entry.
         *
         * @param phoneAtTime the Phone object (optional)
         * @return this builder instance for method chaining
         */
        public Builder phoneAtTime(Phone phoneAtTime) {
            this.phoneAtTime = phoneAtTime;
            return this;
        }




        /**
         * Sets the email address at the time of this history entry.
         *
         * @param emailAtTime the email address (optional)
         * @return this builder instance for method chaining
         */
        public Builder emailAtTime(String emailAtTime) {
            this.emailAtTime = emailAtTime;
            return this;
        }

        /**
         * Sets the birth date at the time of this history entry.
         *
         * @param birthDateAtTime the birth date (optional)
         * @return this builder instance for method chaining
         */
        public Builder birthDateAtTime(LocalDate birthDateAtTime) {
            this.birthDateAtTime = birthDateAtTime;
            return this;
        }

        /**
         * Sets the list of roles at the time of this history entry.
         *
         * @param rolesAtTime the list of roles
         * @return this builder instance for method chaining
         */
        public Builder rolesAtTime(List<Role> rolesAtTime) {
            this.rolesAtTime = new ArrayList<>(rolesAtTime);
            return this;
        }

        /**
         * Sets the contact status at the time of this history entry.
         *
         * @param statusAtTime the contact status
         * @return this builder instance for method chaining
         */
        public Builder statusAtTime(ContactStatus statusAtTime) {
            this.statusAtTime = statusAtTime;
            return this;
        }

        /**
         * Sets the date when this history entry was created.
         *
         * @param updatedAt the update date
         * @return this builder instance for method chaining
         */
        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Sets the action that triggered this history entry.
         *
         * @param historyAction the history action
         * @return this builder instance for method chaining
         */
        public Builder historyAction(HistoryAction historyAction) {
            this.historyAction = historyAction;
            return this;
        }

        /**
         * Sets the user who made the change.
         *
         * @param updatedBy the user identifier
         * @return this builder instance for method chaining
         */
        public Builder updatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        /**
         * Sets the description of the change made.
         *
         * @param description the change description
         * @return this builder instance for method chaining
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Builds a new FormerTeammateHistory instance with validation.
         * Validates that all required fields are set before creating the instance.
         *
         * @return a new FormerTeammateHistory instance
         * @throws IllegalStateException if any required field is missing or invalid
         * @throws InvalidPhoneNumberException if the phone number format is invalid (propagated from Phone creation)
         */
        public FormerTeammateHistory build() {
            validationService.validateRequiredField(id, "id");
            validationService.validateRequiredField(formerTeammateId, "formerTeammateId");
            validationService.validateRequiredField(statusAtTime, "statusAtTime");
            validationService.validateRequiredField(updatedAt, "updatedAt");
            validationService.validateRequiredField(historyAction, "historyAction");
            validationService.validateRequiredStringField(updatedBy, "updatedBy");
            validationService.validateRequiredStringField(description, "description");

            return new FormerTeammateHistory(id, formerTeammateId,
                    Optional.ofNullable(phoneAtTime), Optional.ofNullable(emailAtTime), Optional.ofNullable(birthDateAtTime),
                    List.copyOf(rolesAtTime), statusAtTime, updatedAt, historyAction, updatedBy, description);
        }
    }
}
