package fr.hoenheimsports.domain.exceptions;

public class CurrentUserMissingException extends RuntimeException {
    public CurrentUserMissingException(String message) {
        super(message);
    }
}
