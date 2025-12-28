package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GetFormerTeammates {
    List<FormerTeammate> findAllFormerTeammates();
    List<FormerTeammate> findAllActiveFormerTeammates();
    FormerTeammate findByCode(String code);

    Optional<FormerTeammate> findByPhone(String phone);

    FormerTeammate findById(UUID id);
}