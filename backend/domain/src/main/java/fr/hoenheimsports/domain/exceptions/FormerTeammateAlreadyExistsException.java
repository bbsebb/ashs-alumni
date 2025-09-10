package fr.hoenheimsports.domain.exceptions;

public class FormerTeammateAlreadyExistsException extends RuntimeException {
    public FormerTeammateAlreadyExistsException(String message) {
        super(message);
    }
}
