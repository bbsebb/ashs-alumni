package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.List;
import java.util.UUID;

public interface GetSMSHistory {
    List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId);
    List<SMSHistory> findAllSMSHistoryByPhoneNumber(Phone phoneNumber);
}
