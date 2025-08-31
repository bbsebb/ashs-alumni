package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface SMSHistoryEntityRepository extends JpaRepository<SMSHistoryEntity, UUID> {
}