package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.SMSHistory;

public interface SMSHistoryRepository {
    void save(SMSHistory smsHistory);

}
