package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;

import java.util.List;

/**
 * Represents a phone number phoneNumber object.
 * This record encapsulates phone number information with validation for international format.
 * The phone number must follow the E.164 international format (+[country code][national number]).
 *
 * @param phoneNumber The phone number as a string in international format
 */
public record Phone(String phoneNumber, boolean isBlackListed, List<SMSHistory> smsHistory) {

    private static final PhoneValidationService validationService = new PhoneValidationService();

    /**
     * Compact constructor that validates and normalizes the phone number.
     *
     * @throws InvalidPhoneNumberException if the phone number is null, empty, or doesn't match international format
     */
    public Phone {
        phoneNumber = validationService.validateAndNormalize(phoneNumber);
    }

    /**
     * Returns the phone number phoneNumber a masked format for privacy protection.
     *
     * @return the phone number as a string without spaces or dashes
     */
    @Override
    public String toString() {
        return toMaskedFormat();

    }


    /**
     * Returns the phone number in a masked format for privacy protection.
     * Shows the country code, first digits, and last 3 digits while hiding middle digits with asterisks.
     * Example: +33638123456 becomes +33638***456
     *
     * @return the masked phone number
     */
    public String toMaskedFormat() {
        if (phoneNumber.length() < 7) {
            // Si le numéro est trop court, masquer tout sauf l'indicatif pays
            return phoneNumber.substring(0, Math.min(3, phoneNumber.length())) + "***";
        }

        // Extraire les 3 derniers chiffres
        String lastThree = phoneNumber.substring(phoneNumber.length() - 3);

        // Garder tout le début sauf les 3 derniers chiffres (moins les 3 étoiles)
        String visiblePrefix = phoneNumber.substring(0, phoneNumber.length() - 6);

        return visiblePrefix + "***" + lastThree;
    }

    /**
     * Returns the raw phone number phoneNumber for internal system use.
     * This method should only be used when the complete phone number is required
     * for operations like SMS sending or database storage.
     *
     * @return the complete phone number phoneNumber
     */
    public String getRawValue() {
        return phoneNumber;
    }


    /**
     * Creates a Phone instance from a string phoneNumber.
     * This method provides a more explicit way to create a Phone object.
     *
     * @param phoneNumber the phone number string in international format
     * @return a new Phone instance
     * @throws InvalidPhoneNumberException if the phone number is null, empty, or invalid format
     */
    public static Phone of(String phoneNumber) {
        return new Phone(phoneNumber, true, List.of() );
    }

    /**
     * Checks if a string is a valid international phone number format.
     * This method can be used for validation without creating a Phone object.
     *
     * @param phoneNumber the phone number string to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValid(String phoneNumber) {
        return validationService.isValid(phoneNumber);
    }
}