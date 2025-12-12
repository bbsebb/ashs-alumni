package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammate;

public interface BindUserId {
    FormerTeammate bind(String userId, String formerTeammateId);
}
