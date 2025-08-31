package fr.hoenheimsports.domain.api;

import java.util.UUID;

public interface SendSMSToValidateFormerTeammate {

    void sendSMS(String phoneNumber, String message, UUID formerTeammateId);
}
