package fr.hoenheimsports.app.adapters;


import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import fr.hoenheimsports.app.mappers.TwilioMessageMapper;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class SendSMS implements SMSSender {
    private final TwilioMessageMapper twilioMessageMapper;

    public SendSMS(TwilioMessageMapper twilioMessageMapper) {
        this.twilioMessageMapper = twilioMessageMapper;
    }

    @Override
    public SMSHistory sendSMS(String message, String phoneNumber, UUID formerTeammateId) {
        var response = Message.creator(new PhoneNumber("to"),new PhoneNumber("twilio"),"message").create();
        return twilioMessageMapper.toSMSHistory(response, formerTeammateId);
    }
}
