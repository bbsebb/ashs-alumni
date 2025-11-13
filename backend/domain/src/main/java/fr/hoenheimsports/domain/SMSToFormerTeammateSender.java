package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.ResendSMSToFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.exceptions.CurrentUserMissingException;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.services.HandleSMSValidation;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.UUID;
@UseCase
public class SMSToFormerTeammateSender implements ResendSMSToFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final HandleSMSValidation handleSMSValidation;


    public SMSToFormerTeammateSender(FormerTeammateRepository formerTeammateRepository, HandleSMSValidation handleSMSValidation) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.handleSMSValidation = handleSMSValidation;
    }

    @Override
    public FormerTeammate resendSMS(UUID formerTeammateId, ContextDetails context) {
        if(!context.hasRole("ADMIN")) {
            throw new CurrentUserMissingException("Vous n'avez pas les autorisations requises");
        }
        //TODO il faudrait normalement pouvoir renvoyer un sms que sur des FormerTeammate actif. Pour l'instant j'utilise des requetes SQL
        // Il faudrait mieux faire un service pour cela
        var formerTeammate = formerTeammateRepository.findById(formerTeammateId).orElseThrow(() -> new FormerTeammateNotFoundException("L'entité Contact n'a pas été trouvé pour renvoyer un SMS"));
        if(formerTeammate.phone().isPresent()) {
            formerTeammate = handleSMSValidation.handleValidationBySMS(formerTeammate, context.currentUser().orElseThrow().username());
        }
        return formerTeammate;
    }
}
