package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusDetails;
import fr.hoenheimsports.domain.exceptions.FormerTeammateRepositoryException;
import fr.hoenheimsports.domain.exceptions.SMSHistoryRepositoryException;
import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.services.SMSUpdatedStatusHandler;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateRepositoryStub;
import fr.hoenheimsports.domain.spi.stubs.SMSHistoryRepositoryStub;
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

@DisplayName("SMSUpdatedStatusHandler Tests")
class SMSUpdatedStatusHandlerTest {
    
    private SMSUpdatedStatusHandler handler;
    private FormerTeammateRepositoryStub formerTeammateRepository;
    private SMSHistoryRepositoryStub smsHistoryRepository;

    private UUID testFormerTeammateId;
    private String testExternalSmsId;
    
    @BeforeEach
    void setUp() {
        formerTeammateRepository = new FormerTeammateRepositoryStub();
        smsHistoryRepository = new SMSHistoryRepositoryStub();
        handler = new SMSUpdatedStatusHandler(formerTeammateRepository, smsHistoryRepository);
        
        // Setup test data
        testFormerTeammateId = UUID.randomUUID();
        testExternalSmsId = "external-sms-123";

        FormerTeammate testFormerTeammate = new FormerTeammate(
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

        SMSHistory testSMSHistory = new SMSHistory(
                UUID.randomUUID(),
                testFormerTeammateId,
                new Phone("+33123456789"),
                "Test message",
                SMSStatus.QUEUED,
                Instant.now(),
                Instant.now(),
                testExternalSmsId,
                null
        );
        
        // Save test data in repositories
        formerTeammateRepository.save(testFormerTeammate);
        smsHistoryRepository.save(testSMSHistory);
    }
    
    @Test
    @DisplayName("Should do nothing when SMS status has not changed")
    void shouldDoNothingWhenSMSStatusHasNotChanged() {
        // Given
        var command = createCommand(SMSStatus.QUEUED, null, null);
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId).orElseThrow();
        var savedFormerTeammate = formerTeammateRepository.findById(testFormerTeammateId).orElseThrow();
        
        assertThat(savedSMSHistory.status()).isEqualTo(SMSStatus.QUEUED);
        assertThat(savedFormerTeammate.status()).isEqualTo(ContactStatus.SUBMITTED);
    }
    
    @Test
    @DisplayName("Should update to PENDING status when SMS is delivered")
    void shouldUpdateToPendingStatusWhenSMSIsDelivered() {
        // Given
        var command = createCommand(SMSStatus.DELIVERED, null, null);
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId).orElseThrow();
        var savedFormerTeammate = formerTeammateRepository.findById(testFormerTeammateId).orElseThrow();
        
        assertThat(savedSMSHistory.status()).isEqualTo(SMSStatus.DELIVERED);
        assertThat(savedFormerTeammate.status()).isEqualTo(ContactStatus.PENDING);
    }
    
    @Test
    @DisplayName("Should update to UNREACHABLE status when SMS fails")
    void shouldUpdateToUnreachableStatusWhenSMSFails() {
        // Given
        var command = createCommand(SMSStatus.FAILED, "30008", "Unknown destination handset");
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId).orElseThrow();
        var savedFormerTeammate = formerTeammateRepository.findById(testFormerTeammateId).orElseThrow();
        
        assertThat(savedSMSHistory.status()).isEqualTo(SMSStatus.FAILED);
        assertThat(savedSMSHistory.errorMessage()).isEqualTo("Erreur de type 30008 : Unknown destination handset");
        assertThat(savedFormerTeammate.status()).isEqualTo(ContactStatus.UNREACHABLE);
    }
    
    @ParameterizedTest(name = "Should handle SMS status {0} correctly")
    @MethodSource("provideSMSStatusScenarios")
    @DisplayName("Should handle different SMS status scenarios correctly")
    void shouldHandleDifferentSMSStatusScenariosCorrectly(SMSStatus smsStatus, ContactStatus expectedContactStatus, String description) {
        // Given
        var command = createCommand(smsStatus, null, null);
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId).orElseThrow();
        var savedFormerTeammate = formerTeammateRepository.findById(testFormerTeammateId).orElseThrow();
        
        assertThat(savedSMSHistory.status()).isEqualTo(smsStatus);
        assertThat(savedFormerTeammate.status()).isEqualTo(expectedContactStatus);
    }
    
    @Test
    @DisplayName("Should throw exception when SMS history is not found")
    void shouldThrowExceptionWhenSMSHistoryIsNotFound() {
        // Given
        var command = createCommandWithExternalId("non-existent-id", SMSStatus.DELIVERED, null, null);
        
        // When & Then
        assertThatThrownBy(() -> handler.handleSMSStatusUpdated(command))
                .isInstanceOf(SMSHistoryRepositoryException.class)
                .hasMessageContaining("L'historique des sms n'a pas été trouvé avec l'id : non-existent-id");
    }
    
    @Test
    @DisplayName("Should throw exception when former teammate is not found")
    void shouldThrowExceptionWhenFormerTeammateIsNotFound() {
        // Given
        var nonExistentId = UUID.randomUUID();
        var command = createCommandWithFormerTeammateId(nonExistentId.toString());
        
        // When & Then
        assertThatThrownBy(() -> handler.handleSMSStatusUpdated(command))
                .isInstanceOf(FormerTeammateRepositoryException.class)
                .hasMessageContaining("Le contact n'a pas été trouvé avec l'id " + nonExistentId);
    }
    
    @Test
    @DisplayName("Should throw exception when former teammate ID is invalid UUID")
    void shouldThrowExceptionWhenFormerTeammateIdIsInvalidUUID() {
        // Given
        var command = createCommandWithFormerTeammateId("invalid-uuid");
        
        // When & Then
        assertThatThrownBy(() -> handler.handleSMSStatusUpdated(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("Should handle error message formatting correctly for failed SMS")
    void shouldHandleErrorMessageFormattingCorrectlyForFailedSMS() {
        // Given
        var errorCode = "21211";
        var errorMessage = "The 'To' number is not a valid phone number";
        var command = createCommand(SMSStatus.FAILED, errorCode, errorMessage);
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId).orElseThrow();
        
        assertThat(savedSMSHistory.errorMessage())
                .isEqualTo("Erreur de type 21211 : The 'To' number is not a valid phone number");
    }
    
    @Test
    @DisplayName("Should save both SMS history and former teammate")
    void shouldSaveBothSMSHistoryAndFormerTeammate() {
        // Given
        var command = createCommand(SMSStatus.DELIVERED, null, null);
        
        // When
        handler.handleSMSStatusUpdated(command);
        
        // Then
        var savedSMSHistory = smsHistoryRepository.findByExternalID(testExternalSmsId);
        var savedFormerTeammate = formerTeammateRepository.findById(testFormerTeammateId);
        
        assertThat(savedSMSHistory).isPresent();
        assertThat(savedFormerTeammate).isPresent();
        assertThat(savedSMSHistory.get().status()).isEqualTo(SMSStatus.DELIVERED);
        assertThat(savedFormerTeammate.get().status()).isEqualTo(ContactStatus.PENDING);
    }
    
    // Helper methods
    
    private SMSUpdatedStatusDetails createCommand(SMSStatus smsStatus, String errorCode, String errorMessage) {
        return createCommandWithExternalId(testExternalSmsId, smsStatus, errorCode, errorMessage);
    }
    
    private SMSUpdatedStatusDetails createCommandWithExternalId(String externalSmsId, SMSStatus smsStatus, String errorCode, String errorMessage) {
        return createCommandWithFormerTeammateId(testFormerTeammateId.toString(), externalSmsId, smsStatus, errorCode, errorMessage);
    }
    
    private SMSUpdatedStatusDetails createCommandWithFormerTeammateId(String formerTeammateId) {
        return createCommandWithFormerTeammateId(formerTeammateId, testExternalSmsId, SMSStatus.DELIVERED, null, null);
    }
    
    private SMSUpdatedStatusDetails createCommandWithFormerTeammateId(String formerTeammateId, String externalSmsId, SMSStatus smsStatus, String errorCode, String errorMessage) {
        var smsStatusUpdate = new SMSUpdatedStatusDetails.SMSStatusUpdate(externalSmsId, smsStatus, errorMessage, errorCode);
        var formerTeammateReference = new SMSUpdatedStatusDetails.FormerTeammateReference(formerTeammateId);
        return new SMSUpdatedStatusDetails(smsStatusUpdate, formerTeammateReference);
    }
    
    // Data providers
    
    private static Stream<Arguments> provideSMSStatusScenarios() {
        return Stream.of(
                Arguments.of(SMSStatus.DELIVERED, ContactStatus.PENDING, "Delivered SMS should set contact to PENDING"),
                Arguments.of(SMSStatus.FAILED, ContactStatus.UNREACHABLE, "Failed SMS should set contact to UNREACHABLE"),
                Arguments.of(SMSStatus.UNDELIVERED, ContactStatus.UNREACHABLE, "Undelivered SMS should set contact to UNREACHABLE"),
                Arguments.of(SMSStatus.SENT, ContactStatus.SUBMITTED, "Sent SMS should set contact to SUBMITTED"),
                Arguments.of(SMSStatus.QUEUED, ContactStatus.SUBMITTED, "Queued SMS should set contact to SUBMITTED")
        );
    }
}