package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.exceptions.MissingRequiredFieldException;
import fr.hoenheimsports.domain.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("SMSValidationHandler Tests")
class SMSValidationHandlerTest {

    private SMSValidationHandler handler;
    private UpdateFormerTeammateStub updateFormerTeammateStub;
    private SendSMSToValidateFormerTeammateStub sendSMSToValidateFormerTeammateStub;
    private CreateFormerTeammateHistoryStub createFormerTeammateHistoryStub;

    private UUID testFormerTeammateId;
    private String testUpdatedBy;
    private FormerTeammate testFormerTeammate;

    @BeforeEach
    void setUp() {
        updateFormerTeammateStub = new UpdateFormerTeammateStub();
        sendSMSToValidateFormerTeammateStub = new SendSMSToValidateFormerTeammateStub();
        createFormerTeammateHistoryStub = new CreateFormerTeammateHistoryStub();
        
        handler = new SMSValidationHandler(
                updateFormerTeammateStub,
                sendSMSToValidateFormerTeammateStub,
                createFormerTeammateHistoryStub
        );

        // Setup test data
        testFormerTeammateId = UUID.randomUUID();
        testUpdatedBy = "test-user";

        testFormerTeammate = new FormerTeammate(
                testFormerTeammateId,
                "John",
                "Doe",
                Gender.MALE,
                Optional.of(new Phone("+33123456789")),
                Optional.of("john.doe@test.com"),
                Optional.of(LocalDate.of(1990, 1, 1)),
                List.of(),
                ContactStatus.SUBMITTED
        );
    }

    @Test
    @DisplayName("Should update status to PENDING when SMS sending succeeds")
    void shouldUpdateStatusToPendingWhenSMSSendingSucceeds() {
        // Given
        sendSMSToValidateFormerTeammateStub.setShouldSimulateFailure(false);
        
        // When
        FormerTeammate result = handler.handleSMSValidation(testFormerTeammate, testUpdatedBy);

        // Then
        assertThat(result.status()).isEqualTo(ContactStatus.PENDING);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates()).hasSize(1);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates().get(0).status()).isEqualTo(ContactStatus.PENDING);
        assertThat(createFormerTeammateHistoryStub.getCreatedHistories()).hasSize(1);
        
        FormerTeammateHistory history = createFormerTeammateHistoryStub.getCreatedHistories().get(0);
        assertThat(history.updatedBy()).isEqualTo(testUpdatedBy);
        assertThat(history.description()).contains("SUBMITTED", "PENDING");
    }

    @Test
    @DisplayName("Should update status to UNREACHABLE when SMS sending fails")
    void shouldUpdateStatusToUnreachableWhenSMSSendingFails() {
        // Given
        sendSMSToValidateFormerTeammateStub.setShouldSimulateFailure(true);
        
        // When
        FormerTeammate result = handler.handleSMSValidation(testFormerTeammate, testUpdatedBy);

        // Then
        assertThat(result.status()).isEqualTo(ContactStatus.UNREACHABLE);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates()).hasSize(1);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates().get(0).status()).isEqualTo(ContactStatus.UNREACHABLE);
        assertThat(createFormerTeammateHistoryStub.getCreatedHistories()).hasSize(1);
        
        FormerTeammateHistory history = createFormerTeammateHistoryStub.getCreatedHistories().get(0);
        assertThat(history.updatedBy()).isEqualTo(testUpdatedBy);
        assertThat(history.description()).contains("SUBMITTED", "UNREACHABLE");
    }

    @ParameterizedTest(name = "Should handle SMS result {0} and set status to {1}")
    @MethodSource("provideSMSResultScenarios")
    @DisplayName("Should handle different SMS sending result scenarios correctly")
    void shouldHandleDifferentSMSResultScenariosCorrectly(boolean smsSuccess, ContactStatus expectedStatus, String description) {
        // Given
        sendSMSToValidateFormerTeammateStub.setShouldSimulateFailure(!smsSuccess);
        
        // When
        FormerTeammate result = handler.handleSMSValidation(testFormerTeammate, testUpdatedBy);

        // Then
        assertThat(result.status()).isEqualTo(expectedStatus);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates()).hasSize(1);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates().get(0).status()).isEqualTo(expectedStatus);
    }

    @ParameterizedTest(name = "Should handle former teammate with initial status {0}")
    @MethodSource("provideInitialStatusScenarios")
    @DisplayName("Should handle different initial contact statuses correctly")
    void shouldHandleDifferentInitialContactStatusesCorrectly(ContactStatus initialStatus, String description) {
        // Given
        FormerTeammate formerTeammateWithStatus = new FormerTeammate(
                testFormerTeammateId,
                "John",
                "Doe",
                Gender.MALE,
                Optional.of(new Phone("+33123456789")),
                Optional.of("john.doe@test.com"),
                Optional.of(LocalDate.of(1990, 1, 1)),
                List.of(),
                initialStatus
        );
        sendSMSToValidateFormerTeammateStub.setShouldSimulateFailure(false);
        
        // When
        FormerTeammate result = handler.handleSMSValidation(formerTeammateWithStatus, testUpdatedBy);

        // Then
        assertThat(result.status()).isEqualTo(ContactStatus.PENDING);
        
        FormerTeammateHistory history = createFormerTeammateHistoryStub.getCreatedHistories().get(0);
        assertThat(history.description()).contains(initialStatus.toString(), "PENDING");
    }

    @Test
    @DisplayName("Should throw exception when former teammate has no phone number")
    void shouldThrowExceptionWhenFormerTeammateHasNoPhoneNumber() {
        // Given
        FormerTeammate formerTeammateWithoutPhone = new FormerTeammate(
                testFormerTeammateId,
                "John",
                "Doe",
                Gender.MALE,
                Optional.empty(),
                Optional.of("john.doe@test.com"),
                Optional.of(LocalDate.of(1990, 1, 1)),
                List.of(),
                ContactStatus.SUBMITTED
        );

        // When & Then
        assertThatThrownBy(() -> handler.handleSMSValidation(formerTeammateWithoutPhone, testUpdatedBy))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should throw exception when formerTeammate is null")
    void shouldThrowExceptionWhenFormerTeammateIsNull() {
        // When & Then
        assertThatThrownBy(() -> handler.handleSMSValidation(null, testUpdatedBy))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Should throw exception when updatedBy is null")
    void shouldThrowExceptionWhenUpdatedByIsNull() {
        // When & Then
        assertThatThrownBy(() -> handler.handleSMSValidation(testFormerTeammate, null))
                .isInstanceOf(MissingRequiredFieldException.class)
                .hasMessageContaining("updatedBy");
    }

    @Test
    @DisplayName("Should call all dependencies with correct parameters")
    void shouldCallAllDependenciesWithCorrectParameters() {
        // Given
        sendSMSToValidateFormerTeammateStub.setShouldSimulateFailure(false);
        
        // When
        handler.handleSMSValidation(testFormerTeammate, testUpdatedBy);

        // Then
        // Verify SendSMSToValidateFormerTeammate was called correctly
        assertThat(sendSMSToValidateFormerTeammateStub.getSentSMSCalls()).hasSize(1);
        SendSMSToValidateFormerTeammateStub.SMSCall smsCall = sendSMSToValidateFormerTeammateStub.getSentSMSCalls().get(0);
        assertThat(smsCall.phoneNumber()).isEqualTo("+33123456789");
        assertThat(smsCall.message()).isEqualTo("message test du sms");
        assertThat(smsCall.formerTeammateId()).isEqualTo(testFormerTeammateId);

        // Verify UpdateFormerTeammate was called correctly
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates()).hasSize(1);
        assertThat(updateFormerTeammateStub.getUpdatedFormerTeammates().get(0).id()).isEqualTo(testFormerTeammateId);

        // Verify CreateFormerTeammateHistory was called correctly
        assertThat(createFormerTeammateHistoryStub.getCreatedHistories()).hasSize(1);
        FormerTeammateHistory history = createFormerTeammateHistoryStub.getCreatedHistories().get(0);
        assertThat(history.formerTeammateId()).isEqualTo(testFormerTeammateId);
        assertThat(history.updatedBy()).isEqualTo(testUpdatedBy);
    }

    // Test data providers
    private static Stream<Arguments> provideSMSResultScenarios() {
        return Stream.of(
                Arguments.of(true, ContactStatus.PENDING, "SMS sent successfully"),
                Arguments.of(false, ContactStatus.UNREACHABLE, "SMS sending failed")
        );
    }

    private static Stream<Arguments> provideInitialStatusScenarios() {
        return Stream.of(
                Arguments.of(ContactStatus.SUBMITTED, "From submitted status"),
                Arguments.of(ContactStatus.PENDING, "From pending status"),
                Arguments.of(ContactStatus.VALIDATED, "From validated status"),
                Arguments.of(ContactStatus.UNREACHABLE, "From unreachable status")
        );
    }

    // Test stub classes
    private static class UpdateFormerTeammateStub implements UpdateFormerTeammate {
        private final List<FormerTeammate> updatedFormerTeammates = new java.util.ArrayList<>();

        @Override
        public FormerTeammate updateContactStatus(UUID formerTeammateId, ContactStatus newStatus) {
            throw new UnsupportedOperationException("Not used in SMS validation handler");
        }

        @Override
        public FormerTeammate updateContactStatus(FormerTeammate formerTeammate, ContactStatus newStatus) {
            FormerTeammate updated = new FormerTeammate(
                    formerTeammate.id(),
                    formerTeammate.firstName(),
                    formerTeammate.lastName(),
                    formerTeammate.gender(),
                    formerTeammate.phone(),
                    formerTeammate.email(),
                    formerTeammate.birthDate(),
                    formerTeammate.roles(),
                    newStatus
            );
            updatedFormerTeammates.add(updated);
            return updated;
        }

        public List<FormerTeammate> getUpdatedFormerTeammates() {
            return updatedFormerTeammates;
        }
    }

    private static class SendSMSToValidateFormerTeammateStub implements SendSMSToValidateFormerTeammate {
        private boolean shouldSimulateFailure = false;
        private final List<SMSCall> sentSMSCalls = new java.util.ArrayList<>();

        @Override
        public SMSHistory sendSMS(String phoneNumber, String message, UUID formerTeammateId) {
            sentSMSCalls.add(new SMSCall(phoneNumber, message, formerTeammateId));
            
            SMSStatus status = shouldSimulateFailure ? SMSStatus.FAILED : SMSStatus.DELIVERED;
            return new SMSHistory(
                    UUID.randomUUID(),
                    formerTeammateId,
                    new Phone(phoneNumber),
                    message,
                    status,
                    Instant.now(),
                    Instant.now(),
                    "stub-external-id-" + UUID.randomUUID(),
                    shouldSimulateFailure ? "Erreur simulée dans le stub" : null
            );
        }

        public void setShouldSimulateFailure(boolean shouldSimulateFailure) {
            this.shouldSimulateFailure = shouldSimulateFailure;
        }

        public List<SMSCall> getSentSMSCalls() {
            return sentSMSCalls;
        }

        public record SMSCall(String phoneNumber, String message, UUID formerTeammateId) {}
    }

    private static class CreateFormerTeammateHistoryStub implements CreateFormerTeammateHistory {
        private final List<FormerTeammateHistory> createdHistories = new java.util.ArrayList<>();

        @Override
        public FormerTeammateHistory createHistoryForCreation(FormerTeammate formerTeammate, String updatedBy, String description) {
            throw new UnsupportedOperationException("Not used in SMS validation handler");
        }

        @Override
        public FormerTeammateHistory createHistoryForUpdate(FormerTeammate formerTeammate, String updatedBy, String description) {
            FormerTeammateHistory history = new FormerTeammateHistory(
                    UUID.randomUUID(),
                    formerTeammate.id(),
                    formerTeammate.phone(),
                    formerTeammate.email(),
                    formerTeammate.birthDate(),
                    formerTeammate.roles(),
                    formerTeammate.status(),
                    java.time.LocalDate.now(),
                    HistoryAction.UPDATED,
                    updatedBy,
                    description
            );
            createdHistories.add(history);
            return history;
        }

        public List<FormerTeammateHistory> getCreatedHistories() {
            return createdHistories;
        }
    }
}