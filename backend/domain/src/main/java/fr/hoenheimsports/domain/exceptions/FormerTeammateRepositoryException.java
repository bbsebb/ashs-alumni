package fr.hoenheimsports.domain.exceptions;

public class FormerTeammateRepositoryException extends InfrastructureException {
    public FormerTeammateRepositoryException(String message) {
        super(message);
    }
    
    public FormerTeammateRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}