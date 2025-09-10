package fr.hoenheimsports.domain.services.validations;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;

/**
 * Service de validation des champs requis.
 * Centralise la logique de validation commune à tous les modèles du domaine.
 */
@DomainService
public class FieldValidationService {

    /**
     * Valide qu'un champ requis n'est pas null.
     *
     * @param field     le champ à valider
     * @param fieldName le nom du champ pour le message d'erreur
     * @throws MissingRequiredFieldException si le champ est null
     */
    public void validateRequiredField(Object field, String fieldName) {
        if (field == null) {
            throw new MissingRequiredFieldException(fieldName);
        }
    }

    /**
     * Valide qu'un champ string requis n'est pas null ou vide.
     *
     * @param field     le champ string à valider
     * @param fieldName le nom du champ pour le message d'erreur
     * @throws MissingRequiredFieldException si le champ est null ou vide après trim
     */
    public void validateRequiredStringField(String field, String fieldName) {
        if (field == null || field.trim().isEmpty()) {
            throw new MissingRequiredFieldException(fieldName);
        }
    }

    /**
     * Valide qu'une liste n'est pas null et la transforme en liste vide si nécessaire.
     *
     * @param list la liste à valider
     * @param <T>  le type des éléments de la liste
     * @return la liste originale ou une liste vide si null
     */
    public <T> java.util.List<T> validateListField(java.util.List<T> list) {
        return list != null ? list : java.util.List.of();
    }
}