package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.UUID;

public interface ResendSMSToFormerTeammate {
    FormerTeammate resendSMS(UUID formerTeammateId, ContextDetails context);
}
