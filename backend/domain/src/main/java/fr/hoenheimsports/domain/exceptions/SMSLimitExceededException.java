package fr.hoenheimsports.domain.exceptions;

public class SMSLimitExceededException extends RuntimeException {
    public SMSLimitExceededException(String message) {
        super(message);
    }
}
