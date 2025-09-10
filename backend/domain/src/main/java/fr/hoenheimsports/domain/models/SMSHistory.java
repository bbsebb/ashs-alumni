package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import fr.hoenheimsports.domain.services.validations.FieldValidationService;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents SMS history in the system.
 * This record encapsulates all information about SMS messages sent to former teammates,
 * including delivery status and tracking information.
 *
 * @param id               The unique identifier of the SMS history record
 * @param formerTeammateId The ID of the former teammate who received the SMS
 * @param phoneNumber      The phone number where the SMS was sent
 * @param message          The content of the SMS message
 * @param status           The current status of the SMS
 * @param sentAt           The timestamp when the SMS was sent
 * @param updatedAt        The timestamp when the record was last updated (optional)
 * @param externalId       The ID from the SMS provider (optional)
 * @param errorMessage     Error message if SMS failed (optional)
 */
public record SMSHistory(
        UUID id,
        UUID formerTeammateId,
        Phone phoneNumber,
        String message,
        SMSStatus status,
        Instant sentAt,
        Instant updatedAt,
        String externalId, // ID du fournisseur SMS
        String errorMessage
) {

    private static final FieldValidationService validationService = new FieldValidationService();

    /**
     * Compact constructor that validates all required fields and ensures data integrity.
     * Performs null checks and business rule validations.
     * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
     * @throws MissingRequiredFieldException if any required field is null or empty
     */
    public SMSHistory {
        validationService.validateRequiredField(id, "id");
        validationService.validateRequiredField(formerTeammateId, "formerTeammateId");
        validationService.validateRequiredField(phoneNumber, "phoneNumber");
        validationService.validateRequiredStringField(message, "message");
        validationService.validateRequiredField(status, "status");
        validationService.validateRequiredField(sentAt, "sentAt");
    }

    /**
     * Vérifie si le SMS à échouer lors de l'envoi
     * @return true si le SMS a échoué, false sinon
     */
    public boolean hasFailed() {
        return this.status == SMSStatus.FAILED ||this.status == SMSStatus.UNKNOWN || this.status == SMSStatus.UNDELIVERED || this.status == SMSStatus.CANCELED;
    }

    /**
     * Vérifie si le SMS a été envoyé avec succès.
     * Le SMS n'a peut-être pas été encore délivré
     * @return true si le SMS a été envoyé avec succès, false sinon
     */
    public boolean isSuccessful() {
        return this.status == SMSStatus.SENT ||
                this.status == SMSStatus.DELIVERED ||
                this.status == SMSStatus.QUEUED ||
                this.status == SMSStatus.SENDING ||
                this.status == SMSStatus.ACCEPTED ||
                this.status == SMSStatus.SCHEDULED ||
                this.status == SMSStatus.READ;
    }

    /**
     * Creates a new SMSHistory instance with a changed SMS status and updated timestamp.
     * All other fields remain the same.
     *
     * @param newStatus the new SMS status
     * @return a new SMSHistory instance with the updated status and updatedAt timestamp
     * @throws MissingRequiredFieldException if the new status is null
     */
    public SMSHistory withStatus(SMSStatus newStatus) {
        validationService.validateRequiredField(newStatus, "newStatus");
        return new SMSHistory(id, formerTeammateId, phoneNumber, message, newStatus, sentAt, 
                Instant.now(), externalId, errorMessage);
    }

    /**
     * Creates a new SMSHistory instance with a changed error message and updated timestamp.
     * All other fields remain the same.
     *
     * @param newErrorMessage the new error message (can be null)
     * @return a new SMSHistory instance with the updated error message and updatedAt timestamp
     */
    public SMSHistory withErrorMessage(String newErrorMessage) {
        return new SMSHistory(id, formerTeammateId, phoneNumber, message, status, sentAt, 
                Instant.now(), externalId, newErrorMessage);
    }


    /**
     * Creates a new builder instance for constructing SMSHistory objects.
     *
     * @return a new Builder instance
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder class for creating SMSHistory instances with fluent API.
     * Provides validation to ensure all required fields are set before building.
     */
    public static class Builder {
        private UUID id;
        private UUID formerTeammateId;
        private Phone phoneNumber;
        private String message;
        private SMSStatus status;
        private Instant sentAt;
        private Instant updatedAt;
        private String externalId;
        private String errorMessage;

        private Builder() {
        }

        /**
         * Sets the unique identifier for the SMS history record.
         *
         * @param id the UUID identifier
         * @return this builder instance for method chaining
         */
        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the former teammate ID.
         *
         * @param formerTeammateId the UUID of the former teammate
         * @return this builder instance for method chaining
         */
        public Builder formerTeammateId(UUID formerTeammateId) {
            this.formerTeammateId = formerTeammateId;
            return this;
        }

        /**
         * Sets the phone number where the SMS was sent.
         *
         * @param phoneNumber the phone number as string in international format
         * @return this builder instance for method chaining
         * @throws InvalidPhoneNumberException if the phone number format is invalid (not E.164 format)
         */
        public Builder phoneNumber(String phoneNumber) {
            if (phoneNumber != null) {
                this.phoneNumber = Phone.of(phoneNumber);
            }
            return this;
        }

        /**
         * Sets the phone number where the SMS was sent.
         *
         * @param phoneNumber the phone number as Phone object
         * @return this builder instance for method chaining
         */
        public Builder phoneNumber(Phone phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Sets the SMS message content.
         *
         * @param message the message content
         * @return this builder instance for method chaining
         */
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * Sets the SMS status.
         *
         * @param status the SMS status
         * @return this builder instance for method chaining
         */
        public Builder status(SMSStatus status) {
            this.status = status;
            return this;
        }

        /**
         * Sets the timestamp when the SMS was sent.
         *
         * @param sentAt the sent timestamp
         * @return this builder instance for method chaining
         */
        public Builder sentAt(Instant sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        /**
         * Sets the timestamp when the record was last updated.
         *
         * @param updatedAt the updated timestamp (optional)
         * @return this builder instance for method chaining
         */
        public Builder updatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * Sets the external SMS provider ID.
         *
         * @param externalId the external provider ID (optional)
         * @return this builder instance for method chaining
         */
        public Builder externalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        /**
         * Sets the error message if SMS failed.
         *
         * @param errorMessage the error message (optional)
         * @return this builder instance for method chaining
         */
        public Builder errorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }

        /**
         * Builds a new SMSHistory instance with validation.
         * Validates that all required fields are set before creating the instance.
         *
         * @return a new SMSHistory instance
         * @throws MissingRequiredFieldException if any required field is missing or invalid
         * @throws InvalidPhoneNumberException if the phone number format is invalid (propagated from Phone creation)
         */
        public SMSHistory build() {
            validationService.validateRequiredField(id, "id");
            validationService.validateRequiredField(formerTeammateId, "formerTeammateId");
            validationService.validateRequiredField(phoneNumber, "phoneNumber");
            validationService.validateRequiredStringField(message, "message");
            validationService.validateRequiredField(status, "status");
            validationService.validateRequiredField(sentAt, "sentAt");

            return new SMSHistory(id, formerTeammateId, phoneNumber, message, status, sentAt,
                    updatedAt, externalId, errorMessage);
        }
    }
}
