package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusCommand;

public interface HandleSMSUpdatedStatus {
    void execute(SMSUpdatedStatusCommand command);
}
