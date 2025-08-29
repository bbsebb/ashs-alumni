package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;

public interface GetAllFormerTeammates {
    List<FormerTeammate> execute();
}