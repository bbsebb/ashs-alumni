package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.commands.SMSStatusDetails;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateRepositoryException;
import fr.hoenheimsports.domain.exceptions.SMSHistoryRepositoryException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;

import java.time.Instant;

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
    private final MapSMSStatusToContactStatus SMSStatusToContactStatusMapper;
    private final CreateFormerTeammateHistory createFormerTeammateHistory;

    /**
     * Constructeur du gestionnaire de mise à jour de statut SMS.
     * 
     * @param formerTeammateRepository le repository pour gérer les anciens coéquipiers
     * @param smsHistoryRepository le repository pour gérer l'historique des SMS
     * @throws NullPointerException si l'un des repositories est null
     */
    public SMSUpdatedStatusHandler(FormerTeammateRepository formerTeammateRepository, SMSHistoryRepository smsHistoryRepository, MapSMSStatusToContactStatus smsStatusToContactStatusMapper, CreateFormerTeammateHistory createFormerTeammateHistory) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.smsHistoryRepository = smsHistoryRepository;

        SMSStatusToContactStatusMapper = smsStatusToContactStatusMapper;
        this.createFormerTeammateHistory = createFormerTeammateHistory;
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
     * @param smsStatusDetails la commande contenant les informations de mise à jour du statut SMS
     * @throws SMSHistoryRepositoryException si l'historique SMS n'est pas trouvé
     * @throws FormerTeammateRepositoryException si l'ancien coéquipier n'est pas trouvé
     * @throws NullPointerException si la commande est null
     */
    @Override
    public void handleSMSStatusUpdated(SMSStatusDetails smsStatusDetails) {
        var smsHistory = retrieveSMSHistory(smsStatusDetails);

        if (smsHistory.status() == smsStatusDetails.smsStatus()) {
            return;
        }

        var formerTeammate = findFormerTeammate(smsHistory);
        var oldContactStatus = formerTeammate.status();
        var updatedSmsHistory = addSMSHistoryWithStatus(smsHistory, smsStatusDetails);
        var updatedFormerTeammate = updateFormerTeammateContactStatus(formerTeammate, updatedSmsHistory);
        var newContactStatus = updatedFormerTeammate.status();


        smsHistoryRepository.save(updatedSmsHistory);
        formerTeammate = formerTeammateRepository.save(updatedFormerTeammate);
        if(oldContactStatus != newContactStatus) {
            createFormerTeammateHistory.createHistoryForUpdate(formerTeammate, "ASHS BOT", "Mise à jour du status d'envoi du SMS. Transition du status du contact vers -> %s".formatted(newContactStatus.getLabel().toUpperCase()));
        }
    }

    private FormerTeammate findFormerTeammate(SMSHistory smsHistory) {
        return formerTeammateRepository.findById(smsHistory.formerTeammateId())
                .orElseThrow(() -> new FormerTeammateNotFoundException(
                        "Le contact n'a pas été trouvé avec l'id %s".formatted(smsHistory.formerTeammateId())));
    }

    /**
     * Récupère l'historique SMS à partir de son identifiant externe.
     * 
     * @param smsStatusDetails la commande contenant l'identifiant externe du SMS
     * @return l'historique SMS correspondant
     * @throws SMSHistoryRepositoryException si aucun historique SMS n'est trouvé avec cet identifiant
     */
    private SMSHistory retrieveSMSHistory(SMSStatusDetails smsStatusDetails) {
        return smsHistoryRepository.findByExternalID(smsStatusDetails.externalSmsId())
                .orElseThrow(() -> new SMSHistoryRepositoryException(
                        "L'historique des sms n'a pas été trouvé avec l'id : %s".formatted(smsStatusDetails.externalSmsId())));
    }



    /**
     * Met à jour l'historique SMS avec le nouveau statut et les informations d'erreur si nécessaire.
     * 
     * <p>Si le SMS a échoué, cette méthode ajoute également un message d'erreur formaté
     * contenant le code d'erreur et le message d'erreur provenant de la commande.</p>
     * 
     * @param originalSmsHistory l'historique SMS original à mettre à jour
     * @param smsStatusDetails la commande contenant le nouveau statut et les informations d'erreur
     * @return l'historique SMS mis à jour avec le nouveau statut et éventuellement un message d'erreur
     */
    private SMSHistory addSMSHistoryWithStatus(SMSHistory originalSmsHistory, SMSStatusDetails smsStatusDetails) {

        var newSmsHistory = SMSHistory.builder()
                .id(originalSmsHistory.id())
                .updatedAt(Instant.now())
                .formerTeammateId(originalSmsHistory.formerTeammateId())
                .externalId(originalSmsHistory.externalId())
                .status(smsStatusDetails.smsStatus())
                .message(originalSmsHistory.message())
                .sentAt(originalSmsHistory.sentAt())
                .phoneNumber(originalSmsHistory.phoneNumber())
                .errorMessage(originalSmsHistory.errorMessage())
                .build();

        if (newSmsHistory.hasFailed()) {
            newSmsHistory = newSmsHistory.withErrorMessage(
                    "Erreur de type %s : %s".formatted(smsStatusDetails.errorCode(), smsStatusDetails.errorMessage()));
        }

        return newSmsHistory;
    }

    /**
     * Met à jour le statut de contact de l'ancien coéquipier en fonction du statut du SMS.
     *
     * 
     * @param formerTeammate l'ancien coéquipier à mettre à jour
     * @param updatedSmsHistory l'historique SMS mis à jour contenant le nouveau statut
     * @return l'ancien coéquipier avec le statut de contact mis à jour
     */
    private FormerTeammate updateFormerTeammateContactStatus(FormerTeammate formerTeammate, SMSHistory updatedSmsHistory) {

        ContactStatus newContactStatus = this.SMSStatusToContactStatusMapper.map(updatedSmsHistory.status());
        if(formerTeammate.status() == ContactStatus.VALIDATED || formerTeammate.status() == ContactStatus.NOT_REQUESTED) {
            return formerTeammate;
        }
        if(formerTeammate.status() == ContactStatus.WAITING &&  newContactStatus == ContactStatus.SENDING) {
            return formerTeammate;
        }
        return formerTeammate.withContactStatus(newContactStatus);

    }


}
