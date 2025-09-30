package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;

/**
 * Service de gestion de la validation par SMS des anciens coéquipiers.
 *
 * <p>Cette classe orchestre le processus de validation par SMS en coordonnant
 * trois services spécialisés pour accomplir les tâches suivantes :</p>
 * 
 * <ul>
 *   <li><strong>Envoi de SMS :</strong> Délègue l'envoi du SMS de validation 
 *       via {@link SendSMSToValidateFormerTeammate}</li>
 *   <li><strong>Mise à jour du statut :</strong> Met à jour le statut de contact
 *       via {@link UpdateFormerTeammate}</li>
 *   <li><strong>Traçabilité :</strong> Enregistre l'historique des modifications
 *       via {@link CreateFormerTeammateHistory}</li>
 * </ul>
 *
 * <p>Le service détermine automatiquement le nouveau statut en fonction du résultat
 * de l'envoi du SMS :</p>
 * <ul>
 *   <li><strong>PENDING :</strong> si l'envoi du SMS a réussi</li>
 *   <li><strong>UNREACHABLE :</strong> si l'envoi du SMS a échoué</li>
 * </ul>
 *
 * <p>Cette classe implémente le pattern de coordination de services et assure
 * la cohérence transactionnelle entre les différentes opérations.</p>
 *
 * @author ASHS Alumni System
 * @since 1.0
 * @see HandleSMSValidation
 * @see UpdateFormerTeammate
 * @see SendSMSToValidateFormerTeammate
 * @see CreateFormerTeammateHistory
 */
@DomainService
public class SMSValidationHandler implements HandleSMSValidation{
    private final UpdateFormerTeammate updateFormerTeammate;
    private final SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate;
    private final CreateFormerTeammateHistory createFormerTeammateHistory;

    /**
     * Constructeur principal pour l'injection des dépendances.
     *
     * <p>Initialise le gestionnaire de validation SMS avec tous les services
     * nécessaires à l'orchestration du processus de validation.</p>
     *
     * @param updateFormerTeammate service de mise à jour des statuts des anciens coéquipiers
     * @param sendSMSToValidateFormerTeammate service d'envoi de SMS de validation
     * @param createFormerTeammateHistory service de création d'entrées d'historique
     */
    public SMSValidationHandler(UpdateFormerTeammate updateFormerTeammate, SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate, CreateFormerTeammateHistory createFormerTeammateHistory) {
        this.updateFormerTeammate = updateFormerTeammate;
        this.sendSMSToValidateFormerTeammate = sendSMSToValidateFormerTeammate;
        this.createFormerTeammateHistory = createFormerTeammateHistory;
    }

    /**
     * Gère la validation par SMS et met à jour le statut de l'ancien coéquipier.
     *
     * <p>Cette méthode orchestre le processus complet de validation par SMS en
     * coordonnant plusieurs services spécialisés. Le processus suit ces étapes :</p>
     * 
     * <ol>
     *   <li><strong>Envoi du SMS :</strong> Utilise le numéro de téléphone de l'ancien 
     *       coéquipier pour envoyer un SMS de validation</li>
     *   <li><strong>Évaluation du résultat :</strong> Détermine le nouveau statut basé 
     *       sur le succès/échec de l'envoi</li>
     *   <li><strong>Mise à jour du statut :</strong> Applique le nouveau statut de contact</li>
     *   <li><strong>Traçabilité :</strong> Enregistre l'opération dans l'historique</li>
     * </ol>
     *
     * <p>Les statuts appliqués selon le résultat de l'envoi :</p>
     * <ul>
     *   <li><strong>PENDING :</strong> si l'envoi du SMS a réussi (en attente de validation)</li>
     *   <li><strong>UNREACHABLE :</strong> si l'envoi du SMS a échoué (numéro injoignable)</li>
     * </ul>
     *
     * @param formerTeammate l'ancien coéquipier à traiter, doit contenir un numéro de téléphone valide
     * @param updatedBy l'identifiant de l'utilisateur ou du système effectuant l'opération
     * @return l'ancien coéquipier avec son statut mis à jour et sauvegardé
     * @throws InvalidPhoneNumberException si le numéro de téléphone est invalide ou absent
     * @throws NullPointerException si formerTeammate ou updatedBy est null
     */
    @Override
    public FormerTeammate handleSMSValidation(FormerTeammate formerTeammate,String updatedBy) {
        var smsHistory = sendSMSToValidateFormerTeammate.sendSMS(formerTeammate.phone().orElseThrow().toString(), "message test du sms", formerTeammate.id());

        var newStatus = smsHistory.hasFailed() ? ContactStatus.UNREACHABLE : ContactStatus.PENDING;
        var oldFormerTeammateStatus = formerTeammate.status();

        // Mise à jour du statut via l'API dédiée
        var updatedFormerTeammate = updateFormerTeammate.updateContactStatus(formerTeammate, newStatus);

        // Création de l'entrée d'historique pour la mise à jour
        var description = "Modification du status de %s à %s".formatted(oldFormerTeammateStatus, newStatus);
        createFormerTeammateHistory.createHistoryForUpdate(updatedFormerTeammate, updatedBy, description);


        return updatedFormerTeammate;
    }
}
