package fr.hoenheimsports.formerteammate.domain.exceptions;

public class ModelValidationException extends RuntimeException {
    public ModelValidationException(String message) {
        super(message);
    }
}
