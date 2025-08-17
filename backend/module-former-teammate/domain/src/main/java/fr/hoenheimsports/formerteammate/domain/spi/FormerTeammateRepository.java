package fr.hoenheimsports.formerteammate.domain.spi;

import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;

import java.util.List;

public interface FormerTeammateRepository {
    void save(FormerTeammate formerTeammate);

    List<FormerTeammate> findAll();
}
