package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.UUID;

public interface FormerTeammateEntityRepository extends JpaRepository<FormerTeammateEntity, UUID> {
    @NonNull
    Optional<FormerTeammateEntity> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAllIgnoreCase(@NonNull String firstName, @NonNull String lastName);

    Optional<FormerTeammateEntity> findByPhone(@NonNull String phone);
}