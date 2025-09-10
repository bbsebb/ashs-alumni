package fr.hoenheimsports.domain.models;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SMSHistoryTest {

    private static final UUID VALID_ID = UUID.randomUUID();
    private static final UUID VALID_FORMER_TEAMMATE_ID = UUID.randomUUID();
    private static final Phone VALID_PHONE = Phone.of("+33638123456");
    private static final String VALID_MESSAGE = "Hello, this is a test SMS";
    private static final SMSStatus VALID_STATUS = SMSStatus.SENT;
    private static final Instant VALID_SENT_AT = Instant.now();
    private static final Instant VALID_UPDATED_AT = Instant.now();
    private static final String VALID_EXTERNAL_ID = "external-123";
    private static final String VALID_ERROR_MESSAGE = "Test error message";

    @Test
    void should_create_sms_history_with_all_valid_fields_using_builder() {
        // Given
        var builder = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .updatedAt(VALID_UPDATED_AT)
                .externalId(VALID_EXTERNAL_ID)
                .errorMessage(VALID_ERROR_MESSAGE);

        // When
        SMSHistory smsHistory = builder.build();

        // Then
        assertThat(smsHistory.id()).isEqualTo(VALID_ID);
        assertThat(smsHistory.formerTeammateId()).isEqualTo(VALID_FORMER_TEAMMATE_ID);
        assertThat(smsHistory.phoneNumber()).isEqualTo(VALID_PHONE);
        assertThat(smsHistory.message()).isEqualTo(VALID_MESSAGE);
        assertThat(smsHistory.status()).isEqualTo(VALID_STATUS);
        assertThat(smsHistory.sentAt()).isEqualTo(VALID_SENT_AT);
        assertThat(smsHistory.updatedAt()).isEqualTo(VALID_UPDATED_AT);
        assertThat(smsHistory.externalId()).isEqualTo(VALID_EXTERNAL_ID);
        assertThat(smsHistory.errorMessage()).isEqualTo(VALID_ERROR_MESSAGE);
    }

    @Test
    void should_create_sms_history_with_only_required_fields_using_builder() {
        // Given
        var builder = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT);

        // When
        SMSHistory smsHistory = builder.build();

        // Then
        assertThat(smsHistory.id()).isEqualTo(VALID_ID);
        assertThat(smsHistory.formerTeammateId()).isEqualTo(VALID_FORMER_TEAMMATE_ID);
        assertThat(smsHistory.phoneNumber()).isEqualTo(VALID_PHONE);
        assertThat(smsHistory.message()).isEqualTo(VALID_MESSAGE);
        assertThat(smsHistory.status()).isEqualTo(VALID_STATUS);
        assertThat(smsHistory.sentAt()).isEqualTo(VALID_SENT_AT);
        assertThat(smsHistory.updatedAt()).isNull();
        assertThat(smsHistory.externalId()).isNull();
        assertThat(smsHistory.errorMessage()).isNull();
    }

    @Test
    void should_create_phone_from_string_using_builder() {
        // Given
        String phoneString = "+33638123456";
        var builder = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(phoneString)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT);

        // When
        SMSHistory smsHistory = builder.build();

        // Then
        assertThat(smsHistory.phoneNumber()).isNotNull();
        assertThat(smsHistory.phoneNumber().value()).isEqualTo(phoneString);
    }

    @Test
    void should_handle_null_phone_string_in_builder() {
        // Given
        var builder = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber((String) null)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT);

        // When & Then
        assertThatThrownBy(builder::build)
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining("phoneNumber");
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("builderMissingRequiredFieldsData")
    void should_throw_exception_when_builder_missing_required_fields(
            String testCase, UUID id, UUID formerTeammateId, Phone phoneNumber, 
            String message, SMSStatus status, Instant sentAt, String expectedField) {
        
        // Given
        var builder = SMSHistory.builder()
                .id(id)
                .formerTeammateId(formerTeammateId)
                .phoneNumber(phoneNumber)
                .message(message)
                .status(status)
                .sentAt(sentAt);

        // When & Then
        assertThatThrownBy(builder::build)
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining(expectedField);
    }

    static Stream<Arguments> builderMissingRequiredFieldsData() {
        return Stream.of(
                arguments("Missing id", null, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "id"),
                arguments("Missing formerTeammateId", VALID_ID, null, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "formerTeammateId"),
                arguments("Missing phoneNumber", VALID_ID, VALID_FORMER_TEAMMATE_ID, null, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "phoneNumber"),
                arguments("Missing message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, null, VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Empty message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, "", VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Blank message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, "   ", VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Missing status", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, null, VALID_SENT_AT, "status"),
                arguments("Missing sentAt", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, null, "sentAt")
        );
    }

    @Test
    void should_create_sms_history_with_constructor_validation() {
        // When
        SMSHistory smsHistory = new SMSHistory(
                VALID_ID,
                VALID_FORMER_TEAMMATE_ID,
                VALID_PHONE,
                VALID_MESSAGE,
                VALID_STATUS,
                VALID_SENT_AT,
                VALID_UPDATED_AT,
                VALID_EXTERNAL_ID,
                VALID_ERROR_MESSAGE
        );

        // Then
        assertThat(smsHistory.id()).isEqualTo(VALID_ID);
        assertThat(smsHistory.formerTeammateId()).isEqualTo(VALID_FORMER_TEAMMATE_ID);
        assertThat(smsHistory.phoneNumber()).isEqualTo(VALID_PHONE);
        assertThat(smsHistory.message()).isEqualTo(VALID_MESSAGE);
        assertThat(smsHistory.status()).isEqualTo(VALID_STATUS);
        assertThat(smsHistory.sentAt()).isEqualTo(VALID_SENT_AT);
        assertThat(smsHistory.updatedAt()).isEqualTo(VALID_UPDATED_AT);
        assertThat(smsHistory.externalId()).isEqualTo(VALID_EXTERNAL_ID);
        assertThat(smsHistory.errorMessage()).isEqualTo(VALID_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("constructorMissingRequiredFieldsData")
    void should_throw_exception_when_constructor_missing_required_fields(
            String testCase, UUID id, UUID formerTeammateId, Phone phoneNumber,
            String message, SMSStatus status, Instant sentAt, String expectedField) {

        // When & Then
        assertThatThrownBy(() -> new SMSHistory(
                id, formerTeammateId, phoneNumber, message, status, sentAt,
                null, null, null))
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining(expectedField);
    }

    static Stream<Arguments> constructorMissingRequiredFieldsData() {
        return Stream.of(
                arguments("Missing id", null, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "id"),
                arguments("Missing formerTeammateId", VALID_ID, null, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "formerTeammateId"),
                arguments("Missing phoneNumber", VALID_ID, VALID_FORMER_TEAMMATE_ID, null, VALID_MESSAGE, VALID_STATUS, VALID_SENT_AT, "phoneNumber"),
                arguments("Missing message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, null, VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Empty message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, "", VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Blank message", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, "   ", VALID_STATUS, VALID_SENT_AT, "message"),
                arguments("Missing status", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, null, VALID_SENT_AT, "status"),
                arguments("Missing sentAt", VALID_ID, VALID_FORMER_TEAMMATE_ID, VALID_PHONE, VALID_MESSAGE, VALID_STATUS, null, "sentAt")
        );
    }

    @Test
    void should_throw_exception_when_invalid_phone_number_in_builder() {
        // Given & When & Then
        assertThatThrownBy(() -> SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber("invalid-phone")
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT))
                .isInstanceOf(InvalidPhoneNumberException.class);
    }

    @Test
    void should_throw_exception_when_invalid_phone_number_in_constructor() {
        // When & Then
        assertThatThrownBy(() -> new SMSHistory(
                VALID_ID,
                VALID_FORMER_TEAMMATE_ID,
                Phone.of("invalid-phone"),
                VALID_MESSAGE,
                VALID_STATUS,
                VALID_SENT_AT,
                null, null, null))
                .isInstanceOf(InvalidPhoneNumberException.class);
    }

    @Test
    void should_be_equal_when_same_values() {
        // Given
        SMSHistory smsHistory1 = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .build();

        SMSHistory smsHistory2 = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .build();

        // Then
        assertThat(smsHistory1).isEqualTo(smsHistory2);
        assertThat(smsHistory1.hashCode()).isEqualTo(smsHistory2.hashCode());
    }

    @Test
    void should_not_be_equal_when_different_values() {
        // Given
        SMSHistory smsHistory1 = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .build();

        SMSHistory smsHistory2 = SMSHistory.builder()
                .id(UUID.randomUUID())
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .build();

        // Then
        assertThat(smsHistory1).isNotEqualTo(smsHistory2);
    }

    @Test
    void should_have_meaningful_toString_representation() {
        // Given
        SMSHistory smsHistory = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .build();

        // When
        String toString = smsHistory.toString();

        // Then
        assertThat(toString).contains("SMSHistory");
        assertThat(toString).contains(VALID_ID.toString());
        assertThat(toString).contains(VALID_FORMER_TEAMMATE_ID.toString());
        assertThat(toString).contains(VALID_PHONE.value());
        assertThat(toString).contains(VALID_MESSAGE);
        assertThat(toString).contains(VALID_STATUS.toString());
    }

    @ParameterizedTest(name = "Status: {0}")
    @MethodSource("allSMSStatusValues")
    void should_accept_all_valid_sms_status_values(SMSStatus status) {
        // Given
        var builder = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(status)
                .sentAt(VALID_SENT_AT);

        // When
        SMSHistory smsHistory = builder.build();

        // Then
        assertThat(smsHistory.status()).isEqualTo(status);
    }

    static Stream<Arguments> allSMSStatusValues() {
        return Stream.of(SMSStatus.values())
                .map(Arguments::of);
    }

    @Test
    void should_allow_chaining_builder_methods() {
        // When
        SMSHistory smsHistory = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(VALID_STATUS)
                .sentAt(VALID_SENT_AT)
                .updatedAt(VALID_UPDATED_AT)
                .externalId(VALID_EXTERNAL_ID)
                .errorMessage(VALID_ERROR_MESSAGE)
                .build();

        // Then
        assertThat(smsHistory).isNotNull();
        assertThat(smsHistory.updatedAt()).isEqualTo(VALID_UPDATED_AT);
        assertThat(smsHistory.externalId()).isEqualTo(VALID_EXTERNAL_ID);
        assertThat(smsHistory.errorMessage()).isEqualTo(VALID_ERROR_MESSAGE);
    }

    @ParameterizedTest(name = "Status {0} should return hasFailed = {1}")
    @MethodSource("hasFailedTestData")
    void should_return_correct_hasFailed_result_for_each_status(SMSStatus status, boolean expectedResult) {
        // Given
        SMSHistory smsHistory = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(status)
                .sentAt(VALID_SENT_AT)
                .build();

        // When
        boolean hasFailed = smsHistory.hasFailed();

        // Then
        assertThat(hasFailed).isEqualTo(expectedResult);
    }

    static Stream<Arguments> hasFailedTestData() {
        return Stream.of(
                arguments(SMSStatus.FAILED, true),
                arguments(SMSStatus.QUEUED, false),
                arguments(SMSStatus.SENT, false),
                arguments(SMSStatus.DELIVERED, false),
                arguments(SMSStatus.UNDELIVERED, true),
                arguments(SMSStatus.SENDING, false),
                arguments(SMSStatus.UNKNOWN, true)
        );
    }

    @ParameterizedTest(name = "Status {0} should return isSuccessful = {1}")
    @MethodSource("isSuccessfulTestData")
    void should_return_correct_isSuccessful_result_for_each_status(SMSStatus status, boolean expectedResult) {
        // Given
        SMSHistory smsHistory = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(status)
                .sentAt(VALID_SENT_AT)
                .build();

        // When
        boolean isSuccessful = smsHistory.isSuccessful();

        // Then
        assertThat(isSuccessful).isEqualTo(expectedResult);
    }

    static Stream<Arguments> isSuccessfulTestData() {
        return Stream.of(
                arguments(SMSStatus.SENT, true),
                arguments(SMSStatus.DELIVERED, true),
                arguments(SMSStatus.QUEUED, true),
                arguments(SMSStatus.FAILED, false),
                arguments(SMSStatus.UNDELIVERED, false),
                arguments(SMSStatus.SENDING, true),
                arguments(SMSStatus.UNKNOWN, false)
        );
    }

    @Test
    void should_return_false_for_hasFailed_when_successful_status() {
        // Given
        SMSHistory successfulSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.DELIVERED)
                .sentAt(VALID_SENT_AT)
                .build();

        // When & Then
        assertThat(successfulSMS.hasFailed()).isFalse();
        assertThat(successfulSMS.isSuccessful()).isTrue();
    }

    @Test
    void should_return_true_for_hasFailed_when_failed_status() {
        // Given
        SMSHistory failedSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.FAILED)
                .sentAt(VALID_SENT_AT)
                .build();

        // When & Then
        assertThat(failedSMS.hasFailed()).isTrue();
        assertThat(failedSMS.isSuccessful()).isFalse();
    }

    @Test
    void should_handle_edge_case_status_correctly() {
        // Given
        SMSHistory unknownSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.UNKNOWN)
                .sentAt(VALID_SENT_AT)
                .build();

        // When & Then
        assertThat(unknownSMS.hasFailed()).isTrue();
        assertThat(unknownSMS.isSuccessful()).isFalse();
    }

    @Test
    void should_create_new_sms_history_with_updated_status_and_timestamp() {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.QUEUED)
                .sentAt(VALID_SENT_AT)
                .updatedAt(VALID_UPDATED_AT)
                .externalId(VALID_EXTERNAL_ID)
                .errorMessage(VALID_ERROR_MESSAGE)
                .build();

        // When
        SMSHistory updatedSMS = originalSMS.withStatus(SMSStatus.DELIVERED);

        // Then
        assertThat(updatedSMS).isNotNull();
        assertThat(updatedSMS.status()).isEqualTo(SMSStatus.DELIVERED);
        assertThat(updatedSMS.updatedAt()).isAfter(VALID_UPDATED_AT);
        assertThat(updatedSMS.updatedAt()).isBeforeOrEqualTo(Instant.now());
        
        // All other fields should remain the same
        assertThat(updatedSMS.id()).isEqualTo(originalSMS.id());
        assertThat(updatedSMS.formerTeammateId()).isEqualTo(originalSMS.formerTeammateId());
        assertThat(updatedSMS.phoneNumber()).isEqualTo(originalSMS.phoneNumber());
        assertThat(updatedSMS.message()).isEqualTo(originalSMS.message());
        assertThat(updatedSMS.sentAt()).isEqualTo(originalSMS.sentAt());
        assertThat(updatedSMS.externalId()).isEqualTo(originalSMS.externalId());
        assertThat(updatedSMS.errorMessage()).isEqualTo(originalSMS.errorMessage());
    }

    @Test
    void should_throw_exception_when_withStatus_receives_null_status() {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.QUEUED)
                .sentAt(VALID_SENT_AT)
                .build();

        // When & Then
        assertThatThrownBy(() -> originalSMS.withStatus(null))
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining("newStatus");
    }

    @Test
    void should_update_timestamp_each_time_withStatus_is_called() throws InterruptedException {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.QUEUED)
                .sentAt(VALID_SENT_AT)
                .build();

        // When
        SMSHistory firstUpdate = originalSMS.withStatus(SMSStatus.SENT);
        Thread.sleep(1); // Ensure different timestamps
        SMSHistory secondUpdate = firstUpdate.withStatus(SMSStatus.DELIVERED);

        // Then
        assertThat(secondUpdate.updatedAt()).isAfter(firstUpdate.updatedAt());
        assertThat(firstUpdate.updatedAt()).isAfter(originalSMS.updatedAt() != null ? originalSMS.updatedAt() : Instant.MIN);
    }

    @Test
    void should_create_new_sms_history_with_updated_error_message_and_timestamp() {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.FAILED)
                .sentAt(VALID_SENT_AT)
                .updatedAt(VALID_UPDATED_AT)
                .externalId(VALID_EXTERNAL_ID)
                .errorMessage("Original error")
                .build();

        // When
        String newErrorMessage = "New error message";
        SMSHistory updatedSMS = originalSMS.withErrorMessage(newErrorMessage);

        // Then
        assertThat(updatedSMS).isNotNull();
        assertThat(updatedSMS.errorMessage()).isEqualTo(newErrorMessage);
        assertThat(updatedSMS.updatedAt()).isAfter(VALID_UPDATED_AT);
        assertThat(updatedSMS.updatedAt()).isBeforeOrEqualTo(Instant.now());
        
        // All other fields should remain the same
        assertThat(updatedSMS.id()).isEqualTo(originalSMS.id());
        assertThat(updatedSMS.formerTeammateId()).isEqualTo(originalSMS.formerTeammateId());
        assertThat(updatedSMS.phoneNumber()).isEqualTo(originalSMS.phoneNumber());
        assertThat(updatedSMS.message()).isEqualTo(originalSMS.message());
        assertThat(updatedSMS.status()).isEqualTo(originalSMS.status());
        assertThat(updatedSMS.sentAt()).isEqualTo(originalSMS.sentAt());
        assertThat(updatedSMS.externalId()).isEqualTo(originalSMS.externalId());
    }

    @Test
    void should_allow_null_error_message_in_withErrorMessage() {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.FAILED)
                .sentAt(VALID_SENT_AT)
                .errorMessage("Original error")
                .build();

        // When
        SMSHistory updatedSMS = originalSMS.withErrorMessage(null);

        // Then
        assertThat(updatedSMS).isNotNull();
        assertThat(updatedSMS.errorMessage()).isNull();
        assertThat(updatedSMS.updatedAt()).isAfter(originalSMS.updatedAt() != null ? originalSMS.updatedAt() : Instant.MIN);
    }

    @Test
    void should_update_timestamp_each_time_withErrorMessage_is_called() throws InterruptedException {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.FAILED)
                .sentAt(VALID_SENT_AT)
                .build();

        // When
        SMSHistory firstUpdate = originalSMS.withErrorMessage("First error");
        Thread.sleep(1); // Ensure different timestamps
        SMSHistory secondUpdate = firstUpdate.withErrorMessage("Second error");

        // Then
        assertThat(secondUpdate.updatedAt()).isAfter(firstUpdate.updatedAt());
        assertThat(firstUpdate.updatedAt()).isAfter(originalSMS.updatedAt() != null ? originalSMS.updatedAt() : Instant.MIN);
        assertThat(secondUpdate.errorMessage()).isEqualTo("Second error");
        assertThat(firstUpdate.errorMessage()).isEqualTo("First error");
    }

    @Test
    void should_handle_empty_string_error_message_in_withErrorMessage() {
        // Given
        SMSHistory originalSMS = SMSHistory.builder()
                .id(VALID_ID)
                .formerTeammateId(VALID_FORMER_TEAMMATE_ID)
                .phoneNumber(VALID_PHONE)
                .message(VALID_MESSAGE)
                .status(SMSStatus.FAILED)
                .sentAt(VALID_SENT_AT)
                .errorMessage("Original error")
                .build();

        // When
        SMSHistory updatedSMS = originalSMS.withErrorMessage("");

        // Then
        assertThat(updatedSMS).isNotNull();
        assertThat(updatedSMS.errorMessage()).isEqualTo("");
        assertThat(updatedSMS.updatedAt()).isAfter(originalSMS.updatedAt() != null ? originalSMS.updatedAt() : Instant.MIN);
    }
}