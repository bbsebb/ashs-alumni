package fr.hoenheimsports.domain.exceptions;

public class SMSHistoryNotFoundException extends SMSHistoryRepositoryException {
    public SMSHistoryNotFoundException(String message) {
        super(message);
    }
}
