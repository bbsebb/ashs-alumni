package fr.hoenheimsports.domain.spi;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormerTeammateRepository {
    FormerTeammate save(FormerTeammate formerTeammate);

    List<FormerTeammate> findAll();

    List<FormerTeammate> findAllNotDeleted();

    void deleteAll();

    Optional<FormerTeammate> findById(UUID id);

    void deleteById(UUID id);

    Optional<FormerTeammate> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<FormerTeammate> findByPhone(String phone);
}
