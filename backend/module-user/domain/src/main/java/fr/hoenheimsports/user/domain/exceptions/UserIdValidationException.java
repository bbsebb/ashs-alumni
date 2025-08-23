package fr.hoenheimsports.user.domain.exceptions;

public class UserIdValidationException extends ModelValidationException {
    public UserIdValidationException(String message) {
        super(message);
    }
}
