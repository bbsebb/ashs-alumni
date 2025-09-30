package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusDetails;

public interface HandleSMSUpdatedStatus {
    void handleSMSStatusUpdated(SMSUpdatedStatusDetails command);
}
