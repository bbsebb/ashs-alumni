package fr.hoenheimsports.domain.exceptions;

public class ModelValidationException extends RuntimeException {
    public ModelValidationException(String message) {
        super(message);
    }
}
