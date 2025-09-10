package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.mappers.FormerTeammateHistoryMapper;
import fr.hoenheimsports.app.repositories.FormerTeammateHistoryEntityRepository;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.spi.FormerTeammateHistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class FormerTeammateHistoryRepositoryImpl implements FormerTeammateHistoryRepository {
    private final FormerTeammateHistoryEntityRepository formerTeammateHistoryEntityRepository;
    private final FormerTeammateHistoryMapper formerTeammateHistoryMapper;

    public FormerTeammateHistoryRepositoryImpl(FormerTeammateHistoryEntityRepository formerTeammateHistoryEntityRepository, FormerTeammateHistoryMapper formerTeammateHistoryMapper) {
        this.formerTeammateHistoryEntityRepository = formerTeammateHistoryEntityRepository;
        this.formerTeammateHistoryMapper = formerTeammateHistoryMapper;
    }

    @Override
    public FormerTeammateHistory save(FormerTeammateHistory formerTeammateHistory) {
        return formerTeammateHistoryMapper.toModel(formerTeammateHistoryEntityRepository.save(formerTeammateHistoryMapper.toEntity(formerTeammateHistory)));
    }
}
