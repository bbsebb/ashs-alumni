package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FormerTeammateEntityRepository extends JpaRepository<FormerTeammateEntity, UUID> {
}