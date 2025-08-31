package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.mappers.SMSHistoryMapper;
import fr.hoenheimsports.app.repositories.SMSHistoryEntityRepository;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SMSHistoryRepositoryImpl implements SMSHistoryRepository {
    private final SMSHistoryEntityRepository smsHistoryEntityRepository;
    private final SMSHistoryMapper smsHistoryMapper;

    public SMSHistoryRepositoryImpl(SMSHistoryEntityRepository smsHistoryEntityRepository, SMSHistoryMapper smsHistoryMapper) {
        this.smsHistoryEntityRepository = smsHistoryEntityRepository;
        this.smsHistoryMapper = smsHistoryMapper;
    }

    @Override
    public void save(SMSHistory smsHistory) {
        smsHistoryEntityRepository.save(smsHistoryMapper.toEntity(smsHistory));
    }
}
