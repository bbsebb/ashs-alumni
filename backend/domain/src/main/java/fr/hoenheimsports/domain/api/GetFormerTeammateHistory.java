package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.FormerTeammateHistory;

import java.util.List;
import java.util.UUID;

public interface GetFormerTeammateHistory {

    List<FormerTeammateHistory> findAllFormerTeammateHistoryByFormerTeammateId(UUID formerTeammateId);
}
