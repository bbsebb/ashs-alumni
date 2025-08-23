package fr.hoenheimsports.user.domain.exceptions;

public class CurrentUserValidationException extends ModelValidationException {
    public CurrentUserValidationException(String message) {
        super(message);
    }
}
