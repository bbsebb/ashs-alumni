package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.domain.api.CreateFormerTeammateHistory;
import fr.hoenheimsports.domain.api.SendSMSToValidateFormerTeammate;
import fr.hoenheimsports.domain.api.UpdateFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.models.*;

/**
 * Service d'orchestration responsable de l'enregistrement des anciens coéquipiers.
 * 
 * <p>Ce service orchestre le cas d'usage d'enregistrement d'un ancien coéquipier
 * en coordonnant les APIs spécialisées. Il implémente un processus en deux phases :</p>
 * <ol>
 *   <li><strong>Création initiale :</strong> Délègue la création à {@link CreateFormerTeammate}
 *       et l'historique initial à {@link CreateFormerTeammateHistory}</li>
 *   <li><strong>Validation SMS :</strong> Si un utilisateur est authentifié, envoie un SMS
 *       puis délègue la mise à jour à {@link UpdateFormerTeammate} et l'historique
 *       à {@link CreateFormerTeammateHistory}</li>
 * </ol>
 * 
 * <h3>Gestion des statuts</h3>
 * <ul>
 *   <li><strong>SUBMITTED :</strong> Statut initial après création de l'entité</li>
 *   <li><strong>PENDING :</strong> SMS envoyé avec succès, en attente de validation</li>
 *   <li><strong>UNREACHABLE :</strong> Échec de l'envoi du SMS</li>
 * </ul>
 * 
 * <p>Cette classe suit le principe de responsabilité unique en se concentrant
 * sur l'orchestration, déléguant la logique métier aux APIs spécialisées.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see CreateFormerTeammate
 * @see CreateFormerTeammateHistory
 * @see UpdateFormerTeammate
 */
@DomainService
public class FormerTeammateRegistrar implements fr.hoenheimsports.domain.api.RegisterFormerTeammate {
    private final CreateFormerTeammate createFormerTeammate;
    private final CreateFormerTeammateHistory createFormerTeammateHistory;
    private final UpdateFormerTeammate updateFormerTeammate;
    private final SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate;


    /**
     * Constructeur du service d'enregistrement des anciens coéquipiers.
     * 
     * @param createFormerTeammate API pour la création des anciens coéquipiers
     * @param createFormerTeammateHistory API pour la création d'entrées d'historique
     * @param updateFormerTeammate API pour la mise à jour des anciens coéquipiers
     * @param sendSMSToValidateFormerTeammate service d'envoi de SMS de validation
     * @throws IllegalArgumentException si l'un des paramètres est null
     */
    public FormerTeammateRegistrar(CreateFormerTeammate createFormerTeammate, CreateFormerTeammateHistory createFormerTeammateHistory, UpdateFormerTeammate updateFormerTeammate, SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate) {
        this.createFormerTeammate = createFormerTeammate;
        this.createFormerTeammateHistory = createFormerTeammateHistory;
        this.updateFormerTeammate = updateFormerTeammate;
        this.sendSMSToValidateFormerTeammate = sendSMSToValidateFormerTeammate;
    }

    /**
     * Enregistre un nouvel ancien coéquipier dans le système.
     * 
     * <p>Cette méthode orchestre le processus complet d'enregistrement en deux phases
     * en délèguant aux APIs spécialisées :</p>
     * <ol>
     *   <li><strong>Phase 1 :</strong> Création via {@link CreateFormerTeammate} et historique
     *       via {@link CreateFormerTeammateHistory} avec le statut SUBMITTED</li>
     *   <li><strong>Phase 2 :</strong> Si un utilisateur est authentifié, tentative d'envoi de SMS
     *       puis mise à jour via {@link UpdateFormerTeammate} (PENDING si succès, UNREACHABLE si échec)</li>
     * </ol>
     * 
     * <p>Le contexte utilisateur détermine si la validation par SMS est nécessaire.
     * Sans utilisateur authentifié, l'ancien coéquipier reste au statut SUBMITTED.</p>
     * 
     * @param command les données de l'ancien coéquipier à enregistrer (nom, prénom, téléphone, etc.)
     * @param context le contexte d'exécution contenant l'utilisateur courant (peut être vide)
     * @return l'ancien coéquipier enregistré avec son statut final
     * @throws InvalidPhoneNumberException si le numéro de téléphone est invalide
     */
    @Override
    public FormerTeammate registerFormerTeammate(FormerTeammateRegistrationCommand command, ContextCommand context) {

        // Sauvegarde initiale
        var savedFormerTeammate = createInitialeFormerTeammate(command,context);

        // Gestion SMS et mise à jour du statut
        if (context.currentUser().isPresent()) {
            savedFormerTeammate = handleSMSValidation(savedFormerTeammate, command.phone());
        }

        return savedFormerTeammate;
    }

    /**
     * Orchestre la création d'un nouvel ancien coéquipier avec le statut initial SUBMITTED.
     *
     * <p>Cette méthode délègue la création d'un FormerTeammate aux APIs spécialisées.
     * Elle utilise {@link CreateFormerTeammate} pour la création de l'entité
     * et {@link CreateFormerTeammateHistory} pour l'enregistrement de l'historique initial.</p>
     *
     * @param command les données de l'ancien coéquipier à créer
     * @param context le contexte d'exécution contenant l'utilisateur courant
     * @return l'ancien coéquipier créé et sauvegardé
     */
    private FormerTeammate createInitialeFormerTeammate(FormerTeammateRegistrationCommand command, ContextCommand context) {
        // Création de l'ancien coéquipier via l'API dédiée
        var formerTeammate = createFormerTeammate.createFormerTeammate(command, context);
        
        // Création de l'entrée d'historique pour la création
        var updatedBy = context.currentUser().isPresent() ? context.currentUser().get().username() : "Anonyme";

        createFormerTeammateHistory.createHistoryForCreation(formerTeammate, updatedBy, "Enregistrement initial");
        
        return formerTeammate;
    }


    /**
     * Gère la validation par SMS et met à jour le statut de l'ancien coéquipier.
     *
     * <p>Cette méthode orchestre la seconde phase du processus d'enregistrement
     * en utilisant les APIs spécialisées. Elle normalise le numéro de téléphone,
     * envoie un SMS de validation, puis délègue la mise à jour du statut et
     * la création de l'historique aux APIs appropriées :</p>
     * <ul>
     *   <li><strong>PENDING :</strong> si l'envoi du SMS a réussi</li>
     *   <li><strong>UNREACHABLE :</strong> si l'envoi du SMS a échoué</li>
     * </ul>
     *
     * @param formerTeammate l'ancien coéquipier à mettre à jour
     * @param rawPhone       le numéro de téléphone brut à valider et normaliser
     * @return l'ancien coéquipier avec son statut mis à jour
     * @throws InvalidPhoneNumberException si le numéro de téléphone est invalide
     */
    private FormerTeammate handleSMSValidation(FormerTeammate formerTeammate, String rawPhone) {
        var smsHistory = sendSMSToValidateFormerTeammate.sendSMS(rawPhone, "message test du sms", formerTeammate.id());

        var newStatus = smsHistory.hasFailed() ? ContactStatus.UNREACHABLE : ContactStatus.PENDING;
        var oldFormerTeammateStatus = formerTeammate.status();
        
        // Mise à jour du statut via l'API dédiée
        var updatedFormerTeammate = updateFormerTeammate.updateContactStatus(formerTeammate, newStatus);
        
        // Création de l'entrée d'historique pour la mise à jour
        var description = "Modification du status de %s à %s".formatted(oldFormerTeammateStatus, newStatus);
        createFormerTeammateHistory.createHistoryForUpdate(updatedFormerTeammate, "système ASHS", description);


        return updatedFormerTeammate;
    }
}
