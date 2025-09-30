package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.FormerTeammateHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FormerTeammateHistoryEntityRepository extends JpaRepository<FormerTeammateHistoryEntity, UUID> {
    List<FormerTeammateHistoryEntity> findByFormerTeammateId(UUID formerTeammateId);
}