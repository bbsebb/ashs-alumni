package fr.hoenheimsports.domain.exceptions;

public class SMSWaitPeriodException extends RuntimeException {
    public SMSWaitPeriodException(String message) {
        super(message);
    }
}
