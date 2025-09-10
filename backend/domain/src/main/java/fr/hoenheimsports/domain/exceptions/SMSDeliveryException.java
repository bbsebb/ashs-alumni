package fr.hoenheimsports.domain.exceptions;

public class SMSDeliveryException extends InfrastructureException {
    public SMSDeliveryException(String message) {
        super(message);
    }
    
    public SMSDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }
}