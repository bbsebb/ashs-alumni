package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;

public interface ValidateFormerTeammate {
    FormerTeammate valideFormerTeammateByCode(ValidateFormerTeammateRequest validateFormerTeammateRequest);

    FormerTeammate valideFormerTeammateById(String formerTeammateId, ContextDetails context);
}
