package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;

/**
 * Represents a phone number value object.
 * This record encapsulates phone number information with validation for international format.
 * The phone number must follow the E.164 international format (+[country code][national number]).
 *
 * @param value The phone number as a string in international format
 */
public record Phone(String value) {

    private static final PhoneValidationService validationService = new PhoneValidationService();

    /**
     * Compact constructor that validates and normalizes the phone number.
     *
     * @throws InvalidPhoneNumberException if the phone number is null, empty, or doesn't match international format
     */
    public Phone {
        value = validationService.validateAndNormalize(value);
    }

    /**
     * Returns the phone number value in normalized format.
     *
     * @return the phone number as a string without spaces or dashes
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns the phone number in a masked format for privacy protection.
     * Shows the country code, first digits, and last 3 digits while hiding middle digits with asterisks.
     * Example: +33638123456 becomes +33638***456
     *
     * @return the masked phone number
     */
    public String toMaskedFormat() {
        if (value.length() < 7) {
            // Si le numéro est trop court, masquer tout sauf l'indicatif pays
            return value.substring(0, Math.min(3, value.length())) + "***";
        }

        // Extraire les 3 derniers chiffres
        String lastThree = value.substring(value.length() - 3);

        // Calculer la partie à masquer (tout sauf les 3 derniers)
        String prefix = value.substring(0, value.length() - 3);

        // Déterminer combien de chiffres masquer (minimum 3 étoiles)
        int digitsToMask = Math.max(3, Math.min(6, prefix.length() - 3));

        // Garder le début (indicatif pays + premiers chiffres) et masquer le milieu
        String visiblePrefix = prefix.substring(0, prefix.length() - digitsToMask);
        String maskedPart = "*".repeat(digitsToMask);

        return visiblePrefix + maskedPart + lastThree;
    }


    /**
     * Returns the phone number in a formatted display version.
     * This method can be used to display the phone number in a more readable format.
     *
     * @return the formatted phone number for display
     */
    public String toDisplayFormat() {
        if (value.startsWith("+33")) {
            // Format français: +33 1 23 45 67 89
            return value.replaceFirst("^(\\+33)(\\d)(\\d{2})(\\d{2})(\\d{2})(\\d{2})$", "$1 $2 $3 $4 $5 $6");
        } else if (value.startsWith("+1")) {
            // Format américain/canadien: +1 234 567 8900
            return value.replaceFirst("^(\\+1)(\\d{3})(\\d{3})(\\d{4})$", "$1 $2 $3 $4");
        }
        // Format générique : +XX XXX XXX XXX
        return value.replaceFirst("^(\\+\\d{1,3})(\\d{3})(\\d{3})(\\d+)$", "$1 $2 $3 $4");
    }

    /**
     * Creates a Phone instance from a string value.
     * This method provides a more explicit way to create a Phone object.
     *
     * @param phoneNumber the phone number string in international format
     * @return a new Phone instance
     * @throws InvalidPhoneNumberException if the phone number is null, empty, or invalid format
     */
    public static Phone of(String phoneNumber) {
        return new Phone(phoneNumber);
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