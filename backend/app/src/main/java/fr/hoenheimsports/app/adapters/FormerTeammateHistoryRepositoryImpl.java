package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.mappers.FormerTeammateHistoryMapper;
import fr.hoenheimsports.app.repositories.FormerTeammateHistoryEntityRepository;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.spi.FormerTeammateHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class FormerTeammateHistoryRepositoryImpl implements FormerTeammateHistoryRepository {
    private final FormerTeammateHistoryEntityRepository formerTeammateHistoryEntityRepository;
    private final FormerTeammateHistoryMapper formerTeammateHistoryMapper;

    public FormerTeammateHistoryRepositoryImpl(FormerTeammateHistoryEntityRepository formerTeammateHistoryEntityRepository, FormerTeammateHistoryMapper formerTeammateHistoryMapper) {
        this.formerTeammateHistoryEntityRepository = formerTeammateHistoryEntityRepository;
        this.formerTeammateHistoryMapper = formerTeammateHistoryMapper;
    }

    @Override
    public FormerTeammateHistory save(FormerTeammateHistory formerTeammateHistory) {
        log.info("Saving former teammate history {}", formerTeammateHistory);
        return formerTeammateHistoryMapper.toModel(formerTeammateHistoryEntityRepository.save(formerTeammateHistoryMapper.toEntity(formerTeammateHistory)));
    }

    @Override
    public List<FormerTeammateHistory> findAllFormerTeammateHistoryByFormerTeammateId(UUID formerTeammateId) {
        log.info("Finding all former teammate history by former teammate id {}", formerTeammateId);
        return formerTeammateHistoryEntityRepository.findByFormerTeammateId(formerTeammateId).stream().map(formerTeammateHistoryMapper::toModel).toList();
    }
}
