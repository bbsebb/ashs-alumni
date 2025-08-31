package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.UUID;

public interface SMSHistoryRepository {
    void save(SMSHistory smsHistory);

}
