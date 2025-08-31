package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.SendSMSToValidateFormerTeammate;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;
import fr.hoenheimsports.domain.spi.SMSSender;

import java.util.UUID;

@DomainService
public class ValidateFormerTeammateBySMSSender implements SendSMSToValidateFormerTeammate {
    private final SMSSender smsSender;
    private final SMSHistoryRepository smsHistoryRepository;

    public ValidateFormerTeammateBySMSSender(SMSSender smsSender, SMSHistoryRepository smsHistoryRepository) {
        this.smsSender = smsSender;
        this.smsHistoryRepository = smsHistoryRepository;
    }

    @Override
    public void sendSMS(String phoneNumber, String message, UUID formerTeammateId) {
        var smsHistory = smsSender.sendSMS(message, phoneNumber, formerTeammateId);
        smsHistoryRepository.save(smsHistory);
    }
}
