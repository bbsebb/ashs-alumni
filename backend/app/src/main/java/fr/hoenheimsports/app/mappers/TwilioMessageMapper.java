package fr.hoenheimsports.app.mappers;

import com.twilio.rest.api.v2010.account.Message;
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
        return new SMSHistory(
                idGenerator.generateId(),
                formerTeammateId,
                twilioMessage.getTo(),
                twilioMessage.getBody(),
                mapTwilioStatusToSMSStatus(twilioMessage.getStatus()),
                twilioMessage.getDateCreated() != null ? twilioMessage.getDateCreated().toInstant() : Instant.now(),
                twilioMessage.getDateUpdated() != null ? twilioMessage.getDateUpdated().toInstant() : Instant.now(),
                twilioMessage.getSid(),
                twilioMessage.getErrorMessage()
        );
    }
    
    private SMSStatus mapTwilioStatusToSMSStatus(Message.Status twilioStatus) {
        if (twilioStatus == null) {
            return SMSStatus.UNKNOWN;
        }
        
        return switch (twilioStatus) {
            case QUEUED -> SMSStatus.QUEUED;
            case SENDING -> SMSStatus.SENDING;
            case SENT -> SMSStatus.SENT;
            case DELIVERED -> SMSStatus.DELIVERED;
            case FAILED -> SMSStatus.FAILED;
            case UNDELIVERED -> SMSStatus.UNDELIVERED;
            default -> SMSStatus.UNKNOWN;
        };
    }
}
