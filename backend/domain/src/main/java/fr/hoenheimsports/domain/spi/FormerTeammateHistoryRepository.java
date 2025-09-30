package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.FormerTeammateHistory;

import java.util.List;
import java.util.UUID;

public interface FormerTeammateHistoryRepository {
    FormerTeammateHistory save(FormerTeammateHistory formerTeammateHistory);
    List<FormerTeammateHistory> findAllFormerTeammateHistoryByFormerTeammateId(UUID formerTeammateId);
}
