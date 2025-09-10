package fr.hoenheimsports.domain.exceptions;

public class SMSHistoryRepositoryException extends InfrastructureException {
    public SMSHistoryRepositoryException(String message) {
        super(message);
    }
    
    public SMSHistoryRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
}