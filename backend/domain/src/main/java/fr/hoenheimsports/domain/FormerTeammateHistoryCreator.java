package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.CreateFormerTeammateHistory;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.spi.FormerTeammateHistoryRepository;
import fr.hoenheimsports.domain.spi.IdGenerator;

import java.time.LocalDate;

/**
 * Service de domaine responsable de la création des entrées d'historique des anciens coéquipiers.
 * 
 * <p>Ce service implémente l'API {@link CreateFormerTeammateHistory} et se concentre
 * uniquement sur la création d'entrées dans l'historique des FormerTeammate.
 * Il capture l'état des entités au moment des modifications pour assurer
 * la traçabilité complète des changements.</p>
 * 
 * <p>Fonctionnalités principales :</p>
 * <ul>
 *   <li><strong>Création d'historique :</strong> Enregistre l'état initial lors de la création</li>
 *   <li><strong>Mise à jour d'historique :</strong> Enregistre l'état après modification</li>
 *   <li><strong>Génération d'ID :</strong> Génère un identifiant unique pour chaque entrée</li>
 *   <li><strong>Horodatage :</strong> Utilise la date courante pour chaque entrée</li>
 * </ul>
 * 
 * <p>Chaque entrée d'historique capture une photographie complète de l'état
 * du FormerTeammate au moment de l'action, permettant une reconstruction
 * précise de l'évolution des données dans le temps.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see CreateFormerTeammateHistory
 * @see FormerTeammateHistory
 * @see HistoryAction
 */
@DomainService
public class FormerTeammateHistoryCreator implements CreateFormerTeammateHistory {
    
    private final IdGenerator idGenerator;
    private final FormerTeammateHistoryRepository formerTeammateHistoryRepository;

    /**
     * Constructeur du service de création d'historique des anciens coéquipiers.
     * 
     * @param idGenerator générateur d'identifiants uniques pour les nouvelles entrées d'historique
     * @param formerTeammateHistoryRepository dépôt pour la persistance des entrées d'historique
     * @throws IllegalArgumentException si l'un des paramètres est null
     */
    public FormerTeammateHistoryCreator(IdGenerator idGenerator, FormerTeammateHistoryRepository formerTeammateHistoryRepository) {
        this.idGenerator = idGenerator;
        this.formerTeammateHistoryRepository = formerTeammateHistoryRepository;
    }

    /**
     * Crée une entrée d'historique pour une action de création d'un ancien coéquipier.
     * 
     * <p>Cette méthode capture l'état initial du FormerTeammate au moment de sa création
     * et l'enregistre avec l'action CREATED. L'horodatage utilisé est la date courante.</p>
     * 
     * @param formerTeammate l'ancien coéquipier créé
     * @param updatedBy l'identifiant de l'utilisateur ayant effectué l'action
     * @param description la description de l'action de création
     * @return l'entrée d'historique créée et sauvegardée
     */
    @Override
    public FormerTeammateHistory createHistoryForCreation(FormerTeammate formerTeammate, String updatedBy, String description) {
        return createHistoryEntry(formerTeammate, updatedBy, description, HistoryAction.CREATED);
    }

    /**
     * Crée une entrée d'historique pour une action de mise à jour d'un ancien coéquipier.
     * 
     * <p>Cette méthode capture l'état actuel du FormerTeammate après sa modification
     * et l'enregistre avec l'action UPDATED. L'horodatage utilisé est la date courante.</p>
     * 
     * @param formerTeammate l'ancien coéquipier mis à jour
     * @param updatedBy l'identifiant de l'utilisateur ayant effectué l'action
     * @param description la description de l'action de mise à jour
     * @return l'entrée d'historique créée et sauvegardée
     */
    @Override
    public FormerTeammateHistory createHistoryForUpdate(FormerTeammate formerTeammate, String updatedBy, String description) {
        return createHistoryEntry(formerTeammate, updatedBy, description, HistoryAction.UPDATED);
    }

    /**
     * Méthode privée pour créer une entrée d'historique avec l'action spécifiée.
     * 
     * <p>Cette méthode factorise la logique commune de création d'historique en
     * capturant une photographie complète de l'état du FormerTeammate :</p>
     * <ul>
     *   <li>Téléphone au moment T</li>
     *   <li>Email au moment T</li>
     *   <li>Date de naissance au moment T</li>
     *   <li>Rôles au moment T</li>
     *   <li>Statut au moment T</li>
     * </ul>
     * 
     * @param formerTeammate l'ancien coéquipier dont capturer l'état
     * @param updatedBy l'identifiant de l'utilisateur ayant effectué l'action
     * @param description la description de l'action effectuée
     * @param historyAction l'action effectuée (CREATED ou UPDATED)
     * @return l'entrée d'historique créée et sauvegardée
     */
    private FormerTeammateHistory createHistoryEntry(FormerTeammate formerTeammate, String updatedBy, String description, HistoryAction historyAction) {
        var formerTeammateHistory = FormerTeammateHistory.builder()
                .id(idGenerator.generateId())
                .formerTeammateId(formerTeammate.id())
                .phoneAtTime(formerTeammate.phone().orElse(null))
                .emailAtTime(formerTeammate.email().orElse(null))
                .birthDateAtTime(formerTeammate.birthDate().orElse(null))
                .rolesAtTime(formerTeammate.roles())
                .statusAtTime(formerTeammate.status())
                .updatedAt(LocalDate.now())
                .historyAction(historyAction)
                .updatedBy(updatedBy)
                .description(description)
                .build();

        formerTeammateHistoryRepository.save(formerTeammateHistory);
        return formerTeammateHistory;
    }
}