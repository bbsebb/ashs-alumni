package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.models.FormerTeammate;

public interface HandleSMSValidation {
    FormerTeammate handleSMSValidation(FormerTeammate formerTeammate,String updatedBy );
}
