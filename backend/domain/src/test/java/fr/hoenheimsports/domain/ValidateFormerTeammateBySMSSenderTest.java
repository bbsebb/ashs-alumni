package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;
import fr.hoenheimsports.domain.spi.stubs.SMSHistoryRepositoryStub;
import fr.hoenheimsports.domain.spi.stubs.SMSSenderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("ValidateFormerTeammateBySMSSender Tests")
class ValidateFormerTeammateBySMSSenderTest {

    private ValidateFormerTeammateBySMSSender smsValidator;
    private SMSSenderStub smsSender;

    @BeforeEach
    void setUp() {
        smsSender = new SMSSenderStub();
        SMSHistoryRepositoryStub smsHistoryRepository = new SMSHistoryRepositoryStub();
        PhoneValidationService phoneValidationService = new PhoneValidationService();
        smsValidator = new ValidateFormerTeammateBySMSSender(smsSender, smsHistoryRepository, phoneValidationService);
    }

    @Test
    @DisplayName("Should validate and normalize phone number before sending SMS")
    void shouldValidateAndNormalizePhoneBeforeSendingSMS() {
        // Given
        String rawPhone = "+33 1 23-45-67-89"; // Phone with spaces and dashes
        String message = "Test SMS";
        UUID formerTeammateId = UUID.randomUUID();
        smsSender.simulateFailure(false);

        // When
        SMSHistory result = smsValidator.sendSMS(rawPhone, message, formerTeammateId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(SMSStatus.SENT);
        
        // Verify that the phone was normalized (spaces and dashes removed)
        var sentSMS = smsSender.getSentSMSHistory();
        assertThat(sentSMS).hasSize(1);
        assertThat(sentSMS.getFirst().phoneNumber().value()).isEqualTo("+33123456789"); // Normalized
    }

    @Test
    @DisplayName("Should throw InvalidPhoneNumberException for invalid phone number")
    void shouldThrowExceptionForInvalidPhoneNumber() {
        // Given
        String invalidPhone = "invalid-phone";
        String message = "Test SMS";
        UUID formerTeammateId = UUID.randomUUID();

        // When/Then
        assertThatThrownBy(() -> smsValidator.sendSMS(invalidPhone, message, formerTeammateId))
            .isInstanceOf(InvalidPhoneNumberException.class);

        // Verify no SMS was sent
        assertThat(smsSender.getSentSMSCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle valid phone number and successful SMS sending")
    void shouldHandleValidPhoneAndSuccessfulSMS() {
        // Given
        String validPhone = "+33987654321";
        String message = "Test SMS";
        UUID formerTeammateId = UUID.randomUUID();
        smsSender.simulateFailure(false);

        // When
        SMSHistory result = smsValidator.sendSMS(validPhone, message, formerTeammateId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(SMSStatus.SENT);
        assertThat(result.phoneNumber().value()).isEqualTo("+33987654321");
        assertThat(result.formerTeammateId()).isEqualTo(formerTeammateId);

        // Verify SMS was sent with validated phone
        var sentSMS = smsSender.getSentSMSHistory();
        assertThat(sentSMS).hasSize(1);
        assertThat(sentSMS.getFirst().phoneNumber().value()).isEqualTo("+33987654321");
    }

    @Test
    @DisplayName("Should handle valid phone number but failed SMS sending")
    void shouldHandleValidPhoneButFailedSMS() {
        // Given
        String validPhone = "+33987654321";
        String message = "Test SMS";
        UUID formerTeammateId = UUID.randomUUID();
        smsSender.simulateFailure(true); // Simulate SMS sending failure

        // When
        SMSHistory result = smsValidator.sendSMS(validPhone, message, formerTeammateId);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(SMSStatus.FAILED);
        assertThat(result.phoneNumber().value()).isEqualTo("+33987654321");
        assertThat(result.formerTeammateId()).isEqualTo(formerTeammateId);

        // Verify SMS attempt was recorded
        var sentSMS = smsSender.getSentSMSHistory();
        assertThat(sentSMS).hasSize(1);
        assertThat(sentSMS.getFirst().status()).isEqualTo(SMSStatus.FAILED);
    }
}