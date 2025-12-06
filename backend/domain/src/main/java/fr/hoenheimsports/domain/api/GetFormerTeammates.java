package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.Optional;

public interface GetFormerTeammates {
    List<FormerTeammate> findAllFormerTeammates();
    List<FormerTeammate> findAllActiveFormerTeammates();
    FormerTeammate findByCode(String code);

    Optional<FormerTeammate> findByPhone(String phone);
}