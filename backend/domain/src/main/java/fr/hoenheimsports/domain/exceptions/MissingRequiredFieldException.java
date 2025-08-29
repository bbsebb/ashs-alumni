package fr.hoenheimsports.domain.exceptions;

public class MissingRequiredFieldException extends FormerTeammateValidationException {
    public MissingRequiredFieldException(String fieldName) {
        super(fieldName);
    }
}
