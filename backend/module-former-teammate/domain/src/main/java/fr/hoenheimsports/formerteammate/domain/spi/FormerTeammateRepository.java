package fr.hoenheimsports.formerteammate.domain.spi;

import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;

public interface FormerTeammateRepository {
    FormerTeammate save(FormerTeammate formerTeammate);
}
