package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import fr.hoenheimsports.domain.models.HistoryAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FormerTeammateEntityRepository extends JpaRepository<FormerTeammateEntity, UUID> {
    @NonNull
    Optional<FormerTeammateEntity> findByFirstNameAndLastName(@NonNull String firstName, @NonNull String lastName);

    Optional<FormerTeammateEntity> findByPhone(@NonNull String phone);

    /**
     * Trouve tous les FormerTeammateEntity qui n'ont aucun FormerTeammateHistoryEntity
     * avec un HistoryAction.DELETED
     */
    @Query("SELECT DISTINCT f FROM FormerTeammateEntity f " +
            "WHERE f.id NOT IN (" +
            "    SELECT h.formerTeammateId FROM FormerTeammateHistoryEntity h " +
            "    WHERE h.historyAction = :historyAction" +
            ")")
    List<FormerTeammateEntity> findAllWithoutHistoryAction(@NonNull HistoryAction historyAction);

    /**
     * Méthode de convenance pour trouver tous les FormerTeammateEntity
     * qui n'ont pas été supprimés (pas d'action DELETE dans l'historique)
     */
    default List<FormerTeammateEntity> findAllNotDeleted() {
        return findAllWithoutHistoryAction(HistoryAction.DELETED);
    }


}