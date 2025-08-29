package fr.hoenheimsports.domain.spi;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormerTeammateRepository {
    void save(FormerTeammate formerTeammate);

    List<FormerTeammate> findAll();

    void deleteAll();

    Optional<FormerTeammate> findById(UUID id);

    void deleteById(UUID id);
}
