package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.HistoryAction;

import java.util.List;

public interface GetFormerTeammates {
    List<FormerTeammate> findAllFormerTeammates();
    List<FormerTeammate> findAllActiveFormerTeammates();

}