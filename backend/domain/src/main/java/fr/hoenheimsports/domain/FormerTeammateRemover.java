package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.RemoveFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.exceptions.CurrentUserMissingException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateAlreadyRemoved;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.UUID;

@UseCase
public class FormerTeammateRemover implements RemoveFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final FormerTeammateHistoryRetriever formerTeammateHistoryRetriever;
    private final FormerTeammateHistoryCreator formerTeammateHistoryCreator;


    public FormerTeammateRemover(FormerTeammateRepository formerTeammateRepository, FormerTeammateHistoryRetriever formerTeammateHistoryRetriever, FormerTeammateHistoryCreator formerTeammateHistoryCreator) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.formerTeammateHistoryRetriever = formerTeammateHistoryRetriever;
        this.formerTeammateHistoryCreator = formerTeammateHistoryCreator;
    }

    @Override
    public void removeFormerTeammate(UUID formerTeammateId, ContextDetails context) {
        //Cela vérifie aussi la présence d'un currentUser dans le contexte.
        if (!context.hasRole("USER")) {
            throw new CurrentUserMissingException("Vous n'avez pas les autorisations requises");
        }

        var formerTeammateToRemove = formerTeammateRepository.findById(formerTeammateId).orElseThrow(() -> new IllegalStateException("ERREUR CRITIQUE : currentUser absent malgré la vérification hasRole. Vérifiez que la validation de sécurité n'a pas été supprimée."));
        boolean isAlreadyRemoved = formerTeammateHistoryRetriever.findAllFormerTeammateHistoryByFormerTeammateId(formerTeammateToRemove.id()).stream().anyMatch(formerTeammateHistory -> formerTeammateHistory.historyAction() == HistoryAction.REMOVED);
        if (isAlreadyRemoved) {
            throw new FormerTeammateAlreadyRemoved("Ce contact a déjà été supprimé.");
        }
        var updatedBy = context.currentUser().map(CurrentUser::username).orElseThrow();
        formerTeammateHistoryCreator.createHistoryForRemove(formerTeammateToRemove, updatedBy, "Mise à jour des informations du contact");

    }
}
