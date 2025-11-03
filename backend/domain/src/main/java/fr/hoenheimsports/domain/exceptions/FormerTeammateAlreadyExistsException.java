package fr.hoenheimsports.domain.exceptions;

public class FormerTeammateAlreadyExistsException extends FormerTeammateRepositoryException {
    public FormerTeammateAlreadyExistsException(String message) {
        super(message);
    }
}
