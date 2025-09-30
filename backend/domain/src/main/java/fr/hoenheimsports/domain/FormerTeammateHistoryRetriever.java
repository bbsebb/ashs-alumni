package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.GetFormerTeammateHistory;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.spi.FormerTeammateHistoryRepository;

import java.util.List;
import java.util.UUID;
@UseCase
public class FormerTeammateHistoryRetriever implements GetFormerTeammateHistory {
    private final FormerTeammateHistoryRepository formerTeammateHistoryRepository;

    public FormerTeammateHistoryRetriever(FormerTeammateHistoryRepository formerTeammateHistoryRepository) {
        this.formerTeammateHistoryRepository = formerTeammateHistoryRepository;
    }

    @Override
    public List<FormerTeammateHistory> findAllFormerTeammateHistoryByFormerTeammateId(UUID formerTeammateId) {
        return formerTeammateHistoryRepository.findAllFormerTeammateHistoryByFormerTeammateId(formerTeammateId);
    }
}
