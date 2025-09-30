package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.UUID;

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
