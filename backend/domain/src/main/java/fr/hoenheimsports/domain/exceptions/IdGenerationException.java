package fr.hoenheimsports.domain.exceptions;

public class IdGenerationException extends InfrastructureException {
    public IdGenerationException(String message) {
        super(message);
    }
    
    public IdGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}