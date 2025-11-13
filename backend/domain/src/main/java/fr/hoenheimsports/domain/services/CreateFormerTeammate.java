package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;

/**
 * API pour la création d'un ancien coéquipier.
 * 
 * <p>Cette API est responsable de la création initiale d'un FormerTeammate
 * avec le statut SUBMITTED. Elle effectue les validations nécessaires et
 * génère un identifiant unique pour la nouvelle entité.</p>
 * 
 * <p>Les validations incluent :</p>
 * <ul>
 *   <li>Vérification de l'unicité du nom et prénom</li>
 *   <li>Vérification de l'unicité du numéro de téléphone</li>
 *   <li>Validation des champs obligatoires</li>
 * </ul>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 */
public interface CreateFormerTeammate {
    
    /**
     * Crée un nouvel ancien coéquipier avec le statut initial SUBMITTED.
     * 
     * <p>Cette méthode génère un identifiant unique, construit l'entité FormerTeammate
     * avec les données fournies et la persiste avec le statut SUBMITTED.</p>
     * 
     * @param command les données de l'ancien coéquipier à créer
     * @return l'ancien coéquipier créé et sauvegardé
     * @throws fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException si des champs obligatoires sont manquants
     * @throws fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException si le format du téléphone est invalide
     * @throws fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyExistsException si le contact existe déjà
     */
    FormerTeammate createFormerTeammate(FormerTeammateRegistrationRequest command );
}