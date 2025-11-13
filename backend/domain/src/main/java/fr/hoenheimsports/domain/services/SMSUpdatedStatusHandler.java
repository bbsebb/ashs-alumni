package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusDetails;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateRepositoryException;
import fr.hoenheimsports.domain.exceptions.SMSHistoryRepositoryException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;

import java.util.UUID;

/**
 * Service de gestion des mises à jour de statut des SMS.
 * 
 * <p>Ce service traite les notifications de changement de statut des SMS envoyés
 * et met à jour en conséquence l'historique des SMS ainsi que le statut de contact
 * des anciens coéquipiers.</p>
 * 
 * <p>Le processus de traitement inclut :</p>
 * <ul>
 *   <li>Vérification que le statut a réellement changé</li>
 *   <li>Mise à jour de l'historique SMS avec le nouveau statut</li>
 *   <li>Mise à jour du statut de contact de l'ancien coéquipier selon le résultat du SMS</li>
 *   <li>Sauvegarde des modifications dans les repositories</li>
 * </ul>
 * 
 * @since 1.0
 */
@DomainService
public class SMSUpdatedStatusHandler implements HandleSMSUpdatedStatus {
    private final FormerTeammateRepository formerTeammateRepository;
    private final SMSHistoryRepository smsHistoryRepository;

    /**
     * Constructeur du gestionnaire de mise à jour de statut SMS.
     * 
     * @param formerTeammateRepository le repository pour gérer les anciens coéquipiers
     * @param smsHistoryRepository le repository pour gérer l'historique des SMS
     * @throws NullPointerException si l'un des repositories est null
     */
    public SMSUpdatedStatusHandler(FormerTeammateRepository formerTeammateRepository, SMSHistoryRepository smsHistoryRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.smsHistoryRepository = smsHistoryRepository;
    }

    /**
     * Exécute la mise à jour du statut SMS.
     * 
     * <p>Cette méthode traite une commande de mise à jour de statut SMS en effectuant les opérations suivantes :</p>
     * <ol>
     *   <li>Récupération de l'historique SMS concerné</li>
     *   <li>Vérification que le statut a réellement changé (sortie anticipée si identique)</li>
     *   <li>Récupération de l'ancien coéquipier associé</li>
     *   <li>Mise à jour de l'historique SMS avec le nouveau statut</li>
     *   <li>Mise à jour du statut de contact de l'ancien coéquipier</li>
     *   <li>Sauvegarde des modifications</li>
     * </ol>
     * 
     * @param smsUpdatedStatusDetails la commande contenant les informations de mise à jour du statut SMS
     * @throws SMSHistoryRepositoryException si l'historique SMS n'est pas trouvé
     * @throws FormerTeammateRepositoryException si l'ancien coéquipier n'est pas trouvé
     * @throws NullPointerException si la commande est null
     */
    @Override
    public void handleSMSStatusUpdated(SMSUpdatedStatusDetails smsUpdatedStatusDetails) {
        var smsHistory = retrieveSMSHistory(smsUpdatedStatusDetails);

        if (smsHistory.status() == smsUpdatedStatusDetails.smsStatusUpdate().smsStatus()) {
            return;
        }

        var formerTeammate = retrieveFormerTeammate(smsUpdatedStatusDetails);
        var updatedSmsHistory = updateSMSHistoryWithStatus(smsHistory, smsUpdatedStatusDetails);
        var updatedFormerTeammate = updateFormerTeammateContactStatus(formerTeammate, updatedSmsHistory);

        formerTeammateRepository.save(updatedFormerTeammate);
        smsHistoryRepository.save(updatedSmsHistory);
    }

    /**
     * Récupère l'historique SMS à partir de son identifiant externe.
     * 
     * @param smsUpdatedStatusDetails la commande contenant l'identifiant externe du SMS
     * @return l'historique SMS correspondant
     * @throws SMSHistoryRepositoryException si aucun historique SMS n'est trouvé avec cet identifiant
     */
    private SMSHistory retrieveSMSHistory(SMSUpdatedStatusDetails smsUpdatedStatusDetails) {
        return smsHistoryRepository.findByExternalID(smsUpdatedStatusDetails.smsStatusUpdate().externalSmsId())
                .orElseThrow(() -> new SMSHistoryRepositoryException(
                        "L'historique des sms n'a pas été trouvé avec l'id : %s".formatted(smsUpdatedStatusDetails.smsStatusUpdate().externalSmsId())));
    }

    /**
     * Récupère l'ancien coéquipier à partir de son identifiant.
     * 
     * @param smsUpdatedStatusDetails la commande contenant l'identifiant de l'ancien coéquipier
     * @return l'ancien coéquipier correspondant
     * @throws FormerTeammateRepositoryException si aucun ancien coéquipier n'est trouvé avec cet identifiant
     * @throws IllegalArgumentException si l'identifiant n'est pas un UUID valide
     */
    private FormerTeammate retrieveFormerTeammate(SMSUpdatedStatusDetails smsUpdatedStatusDetails) {
        return formerTeammateRepository.findById(UUID.fromString(smsUpdatedStatusDetails.formerTeammateReference().formerTeammateId()))
                .orElseThrow(() -> new FormerTeammateNotFoundException(
                        "Le contact n'a pas été trouvé avec l'id %s".formatted(smsUpdatedStatusDetails.formerTeammateReference().formerTeammateId())));
    }

    /**
     * Met à jour l'historique SMS avec le nouveau statut et les informations d'erreur si nécessaire.
     * 
     * <p>Si le SMS a échoué, cette méthode ajoute également un message d'erreur formaté
     * contenant le code d'erreur et le message d'erreur provenant de la commande.</p>
     * 
     * @param originalSmsHistory l'historique SMS original à mettre à jour
     * @param smsUpdatedStatusDetails la commande contenant le nouveau statut et les informations d'erreur
     * @return l'historique SMS mis à jour avec le nouveau statut et éventuellement un message d'erreur
     */
    private SMSHistory updateSMSHistoryWithStatus(SMSHistory originalSmsHistory, SMSUpdatedStatusDetails smsUpdatedStatusDetails) {
        var updatedSmsHistory = originalSmsHistory.withStatus(smsUpdatedStatusDetails.smsStatusUpdate().smsStatus());

        if (updatedSmsHistory.hasFailed()) {
            updatedSmsHistory = updatedSmsHistory.withErrorMessage(
                    "Erreur de type %s : %s".formatted(smsUpdatedStatusDetails.smsStatusUpdate().errorCode(), smsUpdatedStatusDetails.smsStatusUpdate().errorMessage()));
        }

        return updatedSmsHistory;
    }

    /**
     * Met à jour le statut de contact de l'ancien coéquipier en fonction du statut du SMS.
     * 
     * <p>Les règles de mise à jour sont les suivantes :</p>
     * <ul>
     *   <li>Si le SMS est {@link SMSStatus#DELIVERED} → {@link ContactStatus#PENDING}</li>
     *   <li>Si le SMS a échoué → {@link ContactStatus#UNREACHABLE}</li>
     *   <li>Dans tous les autres cas → {@link ContactStatus#SUBMITTED}</li>
     * </ul>
     * 
     * @param formerTeammate l'ancien coéquipier à mettre à jour
     * @param updatedSmsHistory l'historique SMS mis à jour contenant le nouveau statut
     * @return l'ancien coéquipier avec le statut de contact mis à jour
     */
    private FormerTeammate updateFormerTeammateContactStatus(FormerTeammate formerTeammate, SMSHistory updatedSmsHistory) {
        if (updatedSmsHistory.status() == SMSStatus.DELIVERED) {
            return formerTeammate.withContactStatus(ContactStatus.PENDING);
        } else if (updatedSmsHistory.hasFailed()) {
            return formerTeammate.withContactStatus(ContactStatus.UNREACHABLE);
        } else {
            return formerTeammate.withContactStatus(ContactStatus.SUBMITTED);
        }
    }
}
