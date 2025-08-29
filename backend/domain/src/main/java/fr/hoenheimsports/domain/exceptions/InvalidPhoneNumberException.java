package fr.hoenheimsports.domain.exceptions;

public class InvalidPhoneNumberException extends FormerTeammateValidationException {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
