package fr.hoenheimsports.app.controllers.validators;

import fr.hoenheimsports.domain.services.validations.PhoneValidationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private final PhoneValidationService phoneValidationService;
    private boolean optional;

    public PhoneValidator(PhoneValidationService phoneValidationService) {
        this.phoneValidationService = phoneValidationService;
    }

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
        this.optional = constraintAnnotation.optional();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // Si le champ est optionnel et vide/null, c'est valide
        if (optional && (phoneNumber == null || phoneNumber.trim().isEmpty())) {
            return true;
        }

        // Si le champ n'est pas optionnel et vide/null, c'est invalide
        if (!optional && (phoneNumber == null || phoneNumber.trim().isEmpty())) {
            return false;
        }

        // Valider le format du téléphone avec le service
        return phoneValidationService.isValid(phoneNumber);
    }
}
