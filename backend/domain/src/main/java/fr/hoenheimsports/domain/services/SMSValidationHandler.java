package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.SMSHistoryRetriever;
import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.FormerTeammateForbiddenByStatusException;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.SMSDeliveryException;
import fr.hoenheimsports.domain.exceptions.SMSLimitExceededException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.SMSHistory;

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
    private static final String SMS_VALIDATION_MESSAGE = """
            Bonjour, c'est Sébastien Burckhardt. Un ancien de la SM1 de Hoenheim t'a ajouté à l'annuaire.
            Merci de valider ton contact ici : alumni.hoenheimsports.fr/former-teammates/validate/%s
            Tu es aussi invité à la soirée des anciens le samedi 10 décembre.
            Si erreur ou pour ne plus être contacté, réponds à ce SMS.
            """;
    private static final int SMS_SEND_LIMIT = 3;
    private final UpdateFormerTeammate updateFormerTeammate;
    private final SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate;
    private final CreateFormerTeammateHistory createFormerTeammateHistory;
    private final SMSHistoryRetriever smsHistoryRetriever;

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
    public SMSValidationHandler(UpdateFormerTeammate updateFormerTeammate, SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate, CreateFormerTeammateHistory createFormerTeammateHistory, SMSHistoryRetriever smsHistoryRetriever) {
        this.updateFormerTeammate = updateFormerTeammate;
        this.sendSMSToValidateFormerTeammate = sendSMSToValidateFormerTeammate;
        this.createFormerTeammateHistory = createFormerTeammateHistory;
        this.smsHistoryRetriever = smsHistoryRetriever;
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
    public FormerTeammate handleValidationBySMS(FormerTeammate formerTeammate, String updatedBy) {
        if(formerTeammate.status() == ContactStatus.NOT_REQUESTED) {
            throw new FormerTeammateForbiddenByStatusException("Le contact ne souhaite plus être sollicité.");
        }
        if(formerTeammate.code() == null) {
            throw new SMSDeliveryException("Le code d'envoi du SMS est indisponible.");
        }

        int SMSHistoriesCount = smsHistoryRetriever.findAllSMSHistoryByFormerTeammateId(formerTeammate.id()).size();

        if(SMSHistoriesCount > SMS_SEND_LIMIT -1) {
            throw new SMSLimitExceededException("Limite d'envoi de SMS dépassée : %d envois effectués sur un maximum de %d autorisés".formatted(SMSHistoriesCount, SMS_SEND_LIMIT));
        }

        var smsHistory = sendSMSToValidateFormerTeammate.sendSMS(
                formerTeammate.phone().orElseThrow().getRawValue(),
                SMS_VALIDATION_MESSAGE.formatted(formerTeammate.code()),
                formerTeammate.id()
        );

        var newStatus = determineNewStatus(smsHistory);
        var previousStatus = formerTeammate.status();
        var updatedFormerTeammate = updateFormerTeammate.updateContactStatus(formerTeammate, newStatus);

        recordStatusChangeHistory(updatedFormerTeammate, updatedBy, previousStatus, newStatus);

        return updatedFormerTeammate;
    }

    /**
     * Détermine le nouveau statut de contact basé sur le résultat de l'envoi du SMS.
     *
     * @param smsHistory l'historique du SMS envoyé
     * @return UNREACHABLE si l'envoi a échoué, PENDING sinon
     */
    private ContactStatus determineNewStatus(SMSHistory smsHistory) {
        return smsHistory.hasFailed() ? ContactStatus.UNREACHABLE : ContactStatus.PENDING;
    }

    /**
     * Enregistre l'historique du changement de statut si celui-ci a été modifié.
     *
     * @param formerTeammate l'ancien coéquipier mis à jour
     * @param updatedBy l'utilisateur ayant effectué la modification
     * @param previousStatus le statut précédent
     * @param newStatus le nouveau statut
     */
    private void recordStatusChangeHistory(FormerTeammate formerTeammate, String updatedBy,
                                           ContactStatus previousStatus, ContactStatus newStatus) {
        if (!previousStatus.equals(newStatus)) {
            String description = createHistoryDescription(newStatus);
            createFormerTeammateHistory.createHistoryForUpdate(formerTeammate, updatedBy, description);
        }
    }

    /**
     * Crée la description de l'historique en fonction du nouveau statut.
     *
     * @param newStatus le nouveau statut de contact
     * @return la description formatée pour l'historique
     */
    private String createHistoryDescription(ContactStatus newStatus) {
        return switch (newStatus) {
            case PENDING -> "Transition du status vers → EN ATTENTE : SMS de validation envoyé avec succès. " +
                    "En attente de la confirmation du contact.";
            case UNREACHABLE -> "Transition du status vers → INJOIGNABLE : Échec de l'envoi du SMS. " +
                    "Le numéro de téléphone fourni est invalide ou absent.";
            default -> "Changement de statut vers " + newStatus;
        };
    }
}
