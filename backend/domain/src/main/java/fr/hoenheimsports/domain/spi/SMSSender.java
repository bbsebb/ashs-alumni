package fr.hoenheimsports.domain.spi;

import fr.hoenheimsports.domain.models.SMSHistory;

import java.util.UUID;

public interface SMSSender {
    SMSHistory sendSMS(String message, String phoneNumber, UUID formerTeammateId);
}
