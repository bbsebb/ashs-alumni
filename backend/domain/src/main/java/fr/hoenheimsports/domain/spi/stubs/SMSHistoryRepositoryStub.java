package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;

import java.util.*;

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

    @Override
    public List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId) {
        return storage.values().stream().filter(smsHistory -> smsHistory.formerTeammateId().equals(formerTeammateId)).toList();
    }
}