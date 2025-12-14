package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.api.commands.SMSStatusDetails;

public interface HandleSMSUpdatedStatus {
    void handleSMSStatusUpdated(SMSStatusDetails command);
}
