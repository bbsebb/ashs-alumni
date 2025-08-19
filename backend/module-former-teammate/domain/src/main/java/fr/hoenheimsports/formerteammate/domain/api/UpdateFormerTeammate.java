package fr.hoenheimsports.formerteammate.domain.api;

import fr.hoenheimsports.formerteammate.domain.commands.UpdateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;

public interface UpdateFormerTeammate {
    FormerTeammate execute(UpdateFormerTeammateCommand updateFOrmerTeammateCommand);
}
