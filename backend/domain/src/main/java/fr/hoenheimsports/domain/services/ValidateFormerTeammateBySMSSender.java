package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.exceptions.SMSHistoryRepositoryException;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;
import fr.hoenheimsports.domain.spi.SMSSender;

import java.util.UUID;

@DomainService
public class ValidateFormerTeammateBySMSSender implements SendSMSToValidateFormerTeammate {
    private final SMSSender smsSender;
    private final SMSHistoryRepository smsHistoryRepository;
    private final PhoneValidationService phoneValidationService;

    public ValidateFormerTeammateBySMSSender(SMSSender smsSender, SMSHistoryRepository smsHistoryRepository, PhoneValidationService phoneValidationService) {
        this.smsSender = smsSender;
        this.smsHistoryRepository = smsHistoryRepository;
        this.phoneValidationService = phoneValidationService;
    }

    @Override
    public SMSHistory sendSMS(String phoneNumber, String message, UUID formerTeammateId) {
        // Validate and normalize phone number before sending SMS
        var validatedPhone = phoneValidationService.validateAndNormalize(phoneNumber);
        var smsHistory = smsSender.sendSMS(message, validatedPhone, formerTeammateId);
        try {
            smsHistoryRepository.save(smsHistory);
        } catch (Exception e) {
            throw new SMSHistoryRepositoryException("erreur de l'enregistrement de l'historique du SMS", e);
        }
        return smsHistory;
    }
}
