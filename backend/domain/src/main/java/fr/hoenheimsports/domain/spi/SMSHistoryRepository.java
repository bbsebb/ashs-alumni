package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SMSHistoryRepository {
    void save(SMSHistory smsHistory);
    Optional<SMSHistory> findByExternalID(String externalId);
    List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId);

}
