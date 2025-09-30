package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SMSHistoryEntityRepository extends JpaRepository<SMSHistoryEntity, UUID> {
    Optional<SMSHistoryEntity> findByExternalId(@NonNull String externalId);

    List<SMSHistoryEntity> findByFormerTeammateId(UUID formerTeammateId);
}