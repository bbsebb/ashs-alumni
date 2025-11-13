package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;

public interface ValidateFormerTeammate {
    FormerTeammate valideFormerTeammate(ValidateFormerTeammateRequest validateFormerTeammateRequest);
}
