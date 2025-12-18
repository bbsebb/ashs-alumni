package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.ValidateFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.services.UpdateFormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

@UseCase
public class FormerTeammateValidator implements ValidateFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final UpdateFormerTeammate updateFormerTeammate;
    private final FormerTeammateHistoryCreator formerTeammateHistoryCreator;


    public FormerTeammateValidator(FormerTeammateRepository formerTeammateRepository, UpdateFormerTeammate updateFormerTeammate, FormerTeammateHistoryCreator formerTeammateHistoryCreator) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.updateFormerTeammate = updateFormerTeammate;

        this.formerTeammateHistoryCreator = formerTeammateHistoryCreator;
    }

    @Override
    public FormerTeammate valideFormerTeammate(ValidateFormerTeammateRequest validateFormerTeammateRequest) {
        var formerTeammateToValidate = formerTeammateRepository.findByCode(validateFormerTeammateRequest.formerTeammateCode()).orElseThrow(() -> new FormerTeammateNotFoundException("Votre code est erroné ou obsolète."));
        var updatedFormerTeammateToValidate = updateFormerTeammate.updateFormerTeammate(formerTeammateToValidate, validateFormerTeammateRequest);
        String updatedBy = updatedFormerTeammateToValidate.firstName() + " " + updatedFormerTeammateToValidate.lastName();
        if(!updatedFormerTeammateToValidate.equals(formerTeammateToValidate)) {
            formerTeammateHistoryCreator.createHistoryForUpdate(updatedFormerTeammateToValidate,updatedBy,"Mise à jour des informations du contact");
        }
        updatedFormerTeammateToValidate =  updateFormerTeammate.updateContactStatus(updatedFormerTeammateToValidate, ContactStatus.VALIDATED);
        formerTeammateHistoryCreator.createHistoryForUpdate(updatedFormerTeammateToValidate,updatedBy,"Transition du status vers → VALIDÉ : le contact a validé ses informations");
        return updatedFormerTeammateToValidate;
    }
}
