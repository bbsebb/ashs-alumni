package fr.hoenheimsports.formerteammate.infrastructure.repository;

import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface FormerTeammateEntityRepository extends JpaRepository<FormerTeammateEntity, UUID> {
}