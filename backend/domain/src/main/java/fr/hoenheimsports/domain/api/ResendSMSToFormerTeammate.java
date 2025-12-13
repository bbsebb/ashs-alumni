package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.UUID;

public interface ResendSMSToFormerTeammate {
    FormerTeammate resendSMS(UUID formerTeammateId, ContextDetails context);

    List<FormerTeammate> resendSMSForAllWaitingFormerTeammates(ContextDetails currentContext);
}
