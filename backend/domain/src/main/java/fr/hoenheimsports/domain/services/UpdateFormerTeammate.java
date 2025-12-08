package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;

public interface UpdateFormerTeammate {


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

    FormerTeammate updateFormerTeammate(FormerTeammate oldFormerTeammate, UpdateFormerTeammateRequest updateFormerTeammateRequest);

    FormerTeammate updateFormerTeammate(FormerTeammate oldFormerTeammate, ValidateFormerTeammateRequest updateFormerTeammateRequest);


}
