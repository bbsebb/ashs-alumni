package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;

public interface RegisterFormerTeammate {
    FormerTeammate registerFormerTeammate(FormerTeammateRegistrationRequest formerTeammateRegistrationRequest, ContextDetails contextDetails);
}
