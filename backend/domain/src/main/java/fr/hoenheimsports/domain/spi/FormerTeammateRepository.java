package fr.hoenheimsports.domain.spi;
import fr.hoenheimsports.domain.models.FormerTeammate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormerTeammateRepository {
    FormerTeammate save(FormerTeammate formerTeammate);

    List<FormerTeammate> findAll();

    List<FormerTeammate> findAllActiveFormerTeammates();

    void deleteAll();

    Optional<FormerTeammate> findById(UUID id);
    Optional<FormerTeammate> findByCode(String id);

    void deleteById(UUID id);

    Optional<FormerTeammate> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    Optional<FormerTeammate> findByPhone(String phone);


}
