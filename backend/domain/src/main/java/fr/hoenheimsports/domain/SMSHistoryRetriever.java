package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.GetSMSHistory;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;

import java.util.List;
import java.util.UUID;

@UseCase
public class SMSHistoryRetriever implements GetSMSHistory {
    private final SMSHistoryRepository smsHistoryRepository;

    public SMSHistoryRetriever(SMSHistoryRepository smsHistoryRepository) {
        this.smsHistoryRepository = smsHistoryRepository;
    }

    @Override
    public List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId) {
        return smsHistoryRepository.findAllSMSHistoryByFormerTeammateId(formerTeammateId);
    }

    @Override
    public List<SMSHistory> findAllSMSHistoryByPhoneNumber(Phone phoneNumber) {
        return smsHistoryRepository.findAllSMSHistoryByPhoneNumber(phoneNumber );
    }
}
