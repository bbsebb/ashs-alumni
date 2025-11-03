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

    /**
     * Trouve un FormerTeammateEntity actif par son numéro de téléphone
     * (excluant ceux avec un HistoryAction.REMOVED)
     */
    @Query("SELECT DISTINCT f FROM FormerTeammateEntity f " +
            "WHERE f.phone = :phone " +
            "AND NOT EXISTS (" +
            "    SELECT 1 FROM FormerTeammateHistoryEntity h " +
            "    WHERE h.formerTeammateId = f.id " +
            "    AND h.historyAction = fr.hoenheimsports.domain.models.HistoryAction.REMOVED" +
            ")")
    Optional<FormerTeammateEntity> findByPhone(@NonNull String phone);

    /**
     * Trouve tous les FormerTeammateEntity qui n'ont aucun FormerTeammateHistoryEntity
     * avec un HistoryAction.DELETED
     */
    @Query("SELECT DISTINCT f FROM FormerTeammateEntity f " +
            "WHERE NOT EXISTS (" +
            "    SELECT 1 FROM FormerTeammateHistoryEntity h " +
            "    WHERE h.formerTeammateId = f.id " +
            "    AND h.historyAction = :historyAction" +
            ")")
    List<FormerTeammateEntity> findAllWithoutHistoryAction(@NonNull HistoryAction historyAction);

    /**
     * Méthode de convenance pour trouver tous les FormerTeammateEntity
     * qui n'ont pas été supprimés (pas d'action DELETE dans l'historique)
     */
    default List<FormerTeammateEntity> findAllActiveFormerTeammate() {
        return findAllWithoutHistoryAction(HistoryAction.REMOVED);
    }

    /**
     * Trouve un FormerTeammateEntity actif par prénom et nom (insensible à la casse)
     * (excluant ceux avec un HistoryAction.REMOVED)
     */
    @Query("SELECT DISTINCT f FROM FormerTeammateEntity f " +
            "WHERE LOWER(f.firstName) = LOWER(:firstName) " +
            "AND LOWER(f.lastName) = LOWER(:lastName) " +
            "AND NOT EXISTS (" +
            "    SELECT 1 FROM FormerTeammateHistoryEntity h " +
            "    WHERE h.formerTeammateId = f.id " +
            "    AND h.historyAction = fr.hoenheimsports.domain.models.HistoryAction.REMOVED" +
            ")")
    Optional<FormerTeammateEntity> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(@NonNull String firstName, @NonNull String lastName);



}