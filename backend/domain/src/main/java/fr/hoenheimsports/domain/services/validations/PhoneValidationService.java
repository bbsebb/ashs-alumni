package fr.hoenheimsports.domain.services.validations;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;

import java.util.regex.Pattern;

/**
 * Service de validation et normalisation des numéros de téléphone.
 * Assure la conformité au format E.164 international.
 */
@DomainService
public class PhoneValidationService {

    // Pattern pour valider le format international E.164
    private static final Pattern INTERNATIONAL_PHONE_PATTERN =
            Pattern.compile("^\\+[1-9]\\d{1,3}\\d{4,14}$");

    /**
     * Normalise un numéro de téléphone en supprimant les espaces et tirets.
     *
     * @param phoneNumber le numéro à normaliser
     * @return le numéro normalisé
     */
    public String normalize(String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return phoneNumber.replaceAll("[\\s\\-.]", "");
    }

    /**
     * Valide qu'un numéro de téléphone respecte le format E.164.
     *
     * @param phoneNumber le numéro à valider
     * @return true si valide, false sinon
     */
    public boolean isValid(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }

        try {
            String normalized = normalize(phoneNumber.trim());
            return INTERNATIONAL_PHONE_PATTERN.matcher(normalized).matches()
                    && normalized.length() <= 16;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Valide et normalise un numéro de téléphone.
     *
     * @param phoneNumber le numéro à traiter
     * @return le numéro normalisé et validé
     * @throws InvalidPhoneNumberException si le format est invalide
     */
    public String validateAndNormalize(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new InvalidPhoneNumberException("Le numéro de téléphone ne peut pas être null ou vide");
        }

        String normalized = normalize(phoneNumber.trim());

        if (!INTERNATIONAL_PHONE_PATTERN.matcher(normalized).matches()) {
            throw new InvalidPhoneNumberException(
                    "Le numéro de téléphone ne respecte pas le format E.164. "
                            + "Format reçu après normalisation: " + normalized
            );
        }

        if (normalized.length() > 16) {
            throw new InvalidPhoneNumberException(
                    "Le numéro de téléphone est trop long. Maximum 15 chiffres autorisés selon E.164. "
                            + "Longueur: " + (normalized.length() - 1) + " chiffres"
            );
        }

        return normalized;
    }
}

