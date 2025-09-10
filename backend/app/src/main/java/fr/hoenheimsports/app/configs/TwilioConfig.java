package fr.hoenheimsports.app.configs;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
@Validated
public class TwilioConfig {

    @NotBlank
    private String accountSid;

    @NotBlank
    private String authToken;

    @NotBlank
    private String phoneNumber;

    @URL
    private String webhookUrl;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }
}

