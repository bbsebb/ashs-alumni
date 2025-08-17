package fr.hoenheimsports.formerteammate.domain.exceptions;

public class MissingRequiredFieldException extends FormerTeammateValidationException {

    public MissingRequiredFieldException(String fieldName) {
        super(String.format("Le champ '%s' est obligatoire et ne peut pas être null ou vide", fieldName));
    }


}
