package fr.hoenheimsports.user.domain.exceptions;

public class ModelValidationException extends RuntimeException {
    public ModelValidationException(String message) {
        super(message);
    }
}
