package fr.hoenheimsports.domain.exceptions;

public class MissingRequiredFieldException extends FormerTeammateValidationException {
    public MissingRequiredFieldException(String fieldName) {
        super("Ce champ est requis :  %s".formatted( fieldName ) );
    }
}
