package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.HistoryAction;

/**
 * API pour la création d'entrées d'historique des anciens coéquipiers.
 * 
 * <p>Cette API est responsable de la création d'entrées dans l'historique
 * des FormerTeammate. Elle permet de tracer toutes les modifications
 * apportées aux entités au fil du temps.</p>
 * 
 * <p>L'historique capture :</p>
 * <ul>
 *   <li><strong>État au moment T :</strong> Téléphone, email, date de naissance, rôles, statut</li>
 *   <li><strong>Métadonnées :</strong> Date de modification, utilisateur, action effectuée</li>
 *   <li><strong>Description :</strong> Description textuelle de la modification</li>
 * </ul>
 * 
 * <p>Les actions supportées incluent la création (CREATED) et la mise à jour (UPDATED)
 * des anciens coéquipiers.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see FormerTeammateHistory
 * @see HistoryAction
 */
public interface CreateFormerTeammateHistory {
    
    /**
     * Crée une entrée d'historique pour une action de création d'un ancien coéquipier.
     * 
     * <p>Cette méthode enregistre la création initiale d'un FormerTeammate en
     * capturant son état au moment de la création avec l'action CREATED.</p>
     * 
     * @param formerTeammate l'ancien coéquipier créé
     * @param updatedBy l'identifiant de l'utilisateur ayant effectué l'action
     * @param description la description de l'action de création
     * @return l'entrée d'historique créée et sauvegardée
     */
    FormerTeammateHistory createHistoryForCreation(FormerTeammate formerTeammate, String updatedBy, String description);
    
    /**
     * Crée une entrée d'historique pour une action de mise à jour d'un ancien coéquipier.
     * 
     * <p>Cette méthode enregistre une modification apportée à un FormerTeammate en
     * capturant son nouvel état avec l'action UPDATED.</p>
     * 
     * @param formerTeammate l'ancien coéquipier mis à jour
     * @param updatedBy l'identifiant de l'utilisateur ayant effectué l'action
     * @param description la description de l'action de mise à jour
     * @return l'entrée d'historique créée et sauvegardée
     */
    FormerTeammateHistory createHistoryForUpdate(FormerTeammate formerTeammate, String updatedBy, String description);
}