package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.Optional;

public interface SMSHistoryRepository {
    void save(SMSHistory smsHistory);
    Optional<SMSHistory> findByExternalID(String externalId);

}
