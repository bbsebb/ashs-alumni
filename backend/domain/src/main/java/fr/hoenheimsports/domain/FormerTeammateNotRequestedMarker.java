package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.MarkAsNotRequestedFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.exceptions.CurrentUserMissingException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.services.UpdateFormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.UUID;

@UseCase
public class FormerTeammateNotRequestedMarker implements MarkAsNotRequestedFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final FormerTeammateHistoryCreator formerTeammateHistoryCreator;
    private final UpdateFormerTeammate updateFormerTeammate;

    public FormerTeammateNotRequestedMarker(FormerTeammateRepository formerTeammateRepository, FormerTeammateHistoryCreator formerTeammateHistoryCreator, UpdateFormerTeammate updateFormerTeammate) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.formerTeammateHistoryCreator = formerTeammateHistoryCreator;
        this.updateFormerTeammate = updateFormerTeammate;
    }

    @Override
    public FormerTeammate markAsNotRequestedFormerTeammate(UUID formerTeammateId, ContextDetails context) {
        if(!context.hasRole("ADMIN")) {
            throw new CurrentUserMissingException("Vous n'avez pas les autorisations requises");
        }
        //TODO il faudrait normalement pouvoir renvoyer un sms que sur des FormerTeammate actif. Pour l'instant j'utilise des requetes SQL
        // Il faudrait mieux faire un service pour cela
        var formerTeammate = formerTeammateRepository.findById(formerTeammateId).orElseThrow(() -> new FormerTeammateNotFoundException("L'entité Contact n'a pas été trouvé pour renvoyer un SMS"));
        var updatedBy = context.currentUser().map(CurrentUser::username).orElseThrow(() -> new IllegalStateException("ERREUR CRITIQUE : currentUser absent malgré la vérification hasRole. Vérifiez que la validation de sécurité n'a pas été supprimée."));;
        formerTeammate = updateFormerTeammate.updateContactStatus(formerTeammate, ContactStatus.NOT_REQUESTED);
        formerTeammateHistoryCreator.createHistoryForUpdate(formerTeammate,updatedBy,"Transition du status vers → NON SOLLICITÉ : Cette personne ne souhaite plus être contactée. ");
        return formerTeammate;
    }
}
