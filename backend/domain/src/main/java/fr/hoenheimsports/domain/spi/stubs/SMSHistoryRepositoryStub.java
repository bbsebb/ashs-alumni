package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class SMSHistoryRepositoryStub implements SMSHistoryRepository {
    
    private final Map<UUID, SMSHistory> storage = new HashMap<>();
    
    @Override
    public void save(SMSHistory smsHistory) {
        storage.put(smsHistory.id(), smsHistory);
    }

    @Override
    public Optional<SMSHistory> findByExternalID(String externalId) {
        return storage.values().stream().filter(smsHistory -> smsHistory.externalId().equals(externalId)).findFirst();
    }
}