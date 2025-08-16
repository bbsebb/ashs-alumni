package fr.hoenheimsports.formerteammate.domain.api;

import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.usecases.commands.CreateFormerTeammateCommand;

public interface CreateFormerTeammate {
    FormerTeammate execute(CreateFormerTeammateCommand createFormerTeammateCommand);
}
