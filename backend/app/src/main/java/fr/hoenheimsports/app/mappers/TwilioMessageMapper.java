package fr.hoenheimsports.app.mappers;

import com.twilio.rest.api.v2010.account.Message;
import fr.hoenheimsports.app.controllers.dtos.TwilioWebhookRequest;
import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusCommand;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import fr.hoenheimsports.domain.spi.IdGenerator;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class TwilioMessageMapper {
    
    private final IdGenerator idGenerator;
    
    public TwilioMessageMapper(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
    
    public SMSHistory toSMSHistory(Message twilioMessage, UUID formerTeammateId) {
        return SMSHistory.builder()
                .id(idGenerator.generateId())
                .formerTeammateId(formerTeammateId)
                .phoneNumber(twilioMessage.getTo())
                .message(twilioMessage.getBody())
                .status(mapTwilioStatusToSMSStatus(twilioMessage.getStatus()))
                .sentAt(twilioMessage.getDateCreated() != null ? twilioMessage.getDateCreated().toInstant() : Instant.now())
                .updatedAt(twilioMessage.getDateUpdated() != null ? twilioMessage.getDateUpdated().toInstant() : Instant.now())
                .externalId(twilioMessage.getSid())
                .errorMessage(twilioMessage.getErrorMessage())
                .build();
    }

    public SMSUpdatedStatusCommand toSMSUpdatedStatusCommand(TwilioWebhookRequest request, String formerTeammateId) {
        SMSUpdatedStatusCommand.SMSStatusUpdate smsStatusUpdate = new SMSUpdatedStatusCommand.SMSStatusUpdate(
                request.MessageSid(),
                mapTwilioStatusToSMSStatus(Message.Status.forValue(request.MessageStatus())),
                request.ErrorMessage(),
                request.ErrorCode()
        );
        SMSUpdatedStatusCommand.FormerTeammateReference formerTeammateReference =
                new SMSUpdatedStatusCommand.FormerTeammateReference(formerTeammateId);
        return new SMSUpdatedStatusCommand(smsStatusUpdate, formerTeammateReference);
    }

    private SMSStatus mapTwilioStatusToSMSStatus(Message.Status twilioStatus) {
        if (twilioStatus == null) {
            return SMSStatus.UNKNOWN;
        }
        
        return switch (twilioStatus) {
            case QUEUED -> SMSStatus.QUEUED;
            case ACCEPTED -> SMSStatus.ACCEPTED;
            case SCHEDULED -> SMSStatus.SCHEDULED;
            case CANCELED -> SMSStatus.CANCELED;
            case READ -> SMSStatus.READ;
            case SENT -> SMSStatus.SENT;
            case SENDING -> SMSStatus.SENDING;
            case DELIVERED -> SMSStatus.DELIVERED;
            case FAILED -> SMSStatus.FAILED;
            case UNDELIVERED -> SMSStatus.UNDELIVERED;
            default -> SMSStatus.UNKNOWN;
        };
    }
}
