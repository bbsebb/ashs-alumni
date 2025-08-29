package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.models.FormerTeammate;

public interface FormerTeammateRegistrar {
    FormerTeammate registerFormerTeammate(FormerTeammateRegistrationCommand formerTeammateRegistrationCommand, ContextCommand contextCommand);
}
