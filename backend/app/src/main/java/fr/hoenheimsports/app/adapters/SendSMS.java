package fr.hoenheimsports.app.adapters;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import fr.hoenheimsports.app.configs.TwilioConfig;
import fr.hoenheimsports.app.mappers.TwilioMessageMapper;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import fr.hoenheimsports.domain.spi.IdGenerator;
import fr.hoenheimsports.domain.spi.SMSSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.UUID;

@Component
@Slf4j
public class SendSMS implements SMSSender {
    private final TwilioMessageMapper twilioMessageMapper;
    private final IdGenerator idGenerator;
    private final TwilioConfig twilioConfig;

    public SendSMS(TwilioMessageMapper twilioMessageMapper, IdGenerator idGenerator, TwilioConfig twilioConfig) {
        this.twilioMessageMapper = twilioMessageMapper;
        this.idGenerator = idGenerator;
        this.twilioConfig = twilioConfig;
    }

    @Override
    public SMSHistory sendSMS(String message, String phoneNumber, UUID formerTeammateId) {
        try {
            var callbackUri = buildCallbackUri(formerTeammateId);
            log.debug("Creating callbackUri path: {}", callbackUri);
            var response = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(twilioConfig.getPhoneNumber()), message)
                    .setStatusCallback(callbackUri)
                    .create();
            log.debug("Creating message: {}", response);
            return twilioMessageMapper.toSMSHistory(response, formerTeammateId);
        } catch (Exception e) {
            return SMSHistory.builder()
                    .id(idGenerator.generateUUID())
                    .formerTeammateId(formerTeammateId)
                    .phoneNumber(phoneNumber)
                    .message(message)
                    .status(SMSStatus.FAILED)
                    .sentAt(Instant.now())
                    .errorMessage("Erreur lors de l'envoi du SMS: " + e.getMessage())
                    .build();

        }
    }

    private URI buildCallbackUri(UUID formerTeammateId) {
        return UriComponentsBuilder.fromUriString(twilioConfig.getWebhookUrl())
                .path("/api/webhooks/twilio/status")
                .queryParam("formerTeammateId", formerTeammateId.toString())
                .build()
                .toUri();
    }




}
