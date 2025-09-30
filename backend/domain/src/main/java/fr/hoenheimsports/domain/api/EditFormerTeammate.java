package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;


public interface EditFormerTeammate {
    


    FormerTeammate editFormerTeammate(FormerTeammate oldFormerTeammate, UpdateFormerTeammateRequest updateFormerTeammateRequest,ContextDetails context);
}