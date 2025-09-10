package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.UUID;

/**
 * API pour la mise à jour des anciens coéquipiers.
 * 
 * <p>Cette API est responsable de la mise à jour des FormerTeammate,
 * notamment la modification du statut de contact suite à des actions
 * comme la validation par SMS ou d'autres événements du cycle de vie.</p>
 * 
 * <p>Types de mises à jour supportées :</p>
 * <ul>
 *   <li><strong>Mise à jour de statut :</strong> Modification du ContactStatus (SUBMITTED → PENDING → VALIDATED/UNREACHABLE)</li>
 *   <li><strong>Mise à jour complète :</strong> Modification de l'entité complète avec nouveau statut</li>
 * </ul>
 * 
 * <p>Cette API se concentre sur les aspects transactionnels de la mise à jour,
 * laissant la gestion de l'historique à l'API dédiée {@link CreateFormerTeammateHistory}.</p>
 * 
 * @author ASHS Alumni System
 * @since 1.0
 * @see FormerTeammate
 * @see ContactStatus
 */
public interface UpdateFormerTeammate {
    
    /**
     * Met à jour le statut de contact d'un ancien coéquipier.
     * 
     * <p>Cette méthode permet de modifier uniquement le statut de contact
     * d'un FormerTeammate existant, typiquement suite à une validation
     * par SMS ou un changement d'état dans le processus de validation.</p>
     * 
     * @param formerTeammateId l'identifiant de l'ancien coéquipier à mettre à jour
     * @param newStatus le nouveau statut de contact à appliquer
     * @return l'ancien coéquipier avec le statut mis à jour, ou null si non trouvé
     */
    FormerTeammate updateContactStatus(UUID formerTeammateId, ContactStatus newStatus);
    
    /**
     * Met à jour un ancien coéquipier avec un nouveau statut de contact.
     * 
     * <p>Cette méthode permet de mettre à jour une entité FormerTeammate complète
     * en modifiant son statut de contact. Elle est utilisée quand on dispose déjà
     * de l'entité à modifier et qu'on souhaite uniquement changer son statut.</p>
     * 
     * @param formerTeammate l'ancien coéquipier à mettre à jour
     * @param newStatus le nouveau statut de contact à appliquer
     * @return l'ancien coéquipier avec le statut mis à jour et sauvegardé
     */
    FormerTeammate updateContactStatus(FormerTeammate formerTeammate, ContactStatus newStatus);
}