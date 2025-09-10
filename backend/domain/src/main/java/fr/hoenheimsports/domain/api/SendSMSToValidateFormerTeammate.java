package fr.hoenheimsports.domain.api;

import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.UUID;

public interface SendSMSToValidateFormerTeammate {

    SMSHistory sendSMS(String phoneNumber, String message, UUID formerTeammateId);
}
