package fr.hoenheimsports.formerteammate.domain.api;

import fr.hoenheimsports.formerteammate.domain.commands.CreateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;

public interface CreateFormerTeammate {
    FormerTeammate execute(CreateFormerTeammateCommand createFormerTeammateCommand);
}
