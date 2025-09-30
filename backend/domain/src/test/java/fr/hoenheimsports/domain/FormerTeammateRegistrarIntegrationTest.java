package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.api.commands.ContextDetails;
import fr.hoenheimsports.domain.api.commands.CurrentUser;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.services.*;
import fr.hoenheimsports.domain.services.validations.FormerTeammateUniquenessValidationService;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;
import fr.hoenheimsports.domain.spi.stubs.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("FormerTeammateRegistrar Integration Tests")
class FormerTeammateRegistrarIntegrationTest {

    private FormerTeammateRegistrar formerTeammateRegistrar;
    private FormerTeammateRepositoryStub formerTeammateRepository;
    private FormerTeammateHistoryRepositoryStub historyRepository;
    private SMSSenderStub smsSender;

    @BeforeEach
    void setUp() {
        // Initialize stubs
        formerTeammateRepository = new FormerTeammateRepositoryStub();
        historyRepository = new FormerTeammateHistoryRepositoryStub();
        SMSHistoryRepositoryStub smsHistoryRepository = new SMSHistoryRepositoryStub();
        smsSender = new SMSSenderStub();
        GenerateIdStub idGenerator = new GenerateIdStub();

        // Initialize domain services
        var uniquenessValidationService = new FormerTeammateUniquenessValidationService(formerTeammateRepository);
        var formerTeammateCreator = new FormerTeammateCreator(idGenerator, formerTeammateRepository, uniquenessValidationService);
        var formerTeammateHistoryCreator = new FormerTeammateHistoryCreator(idGenerator, historyRepository);
        var formerTeammateUpdater = new FormerTeammateUpdater(formerTeammateRepository);
        var phoneValidationService = new PhoneValidationService();
        var smsService = new ValidateFormerTeammateBySMSSender(smsSender, smsHistoryRepository, phoneValidationService);
        var handleSMSValidation = new SMSValidationHandler(formerTeammateUpdater, smsService,formerTeammateHistoryCreator);
        // Initialize the registrar under test
        formerTeammateRegistrar = new FormerTeammateRegistrar(
            formerTeammateCreator,
            formerTeammateHistoryCreator,
                handleSMSValidation
        );
    }

    @Test
    @DisplayName("Should register former teammate without authenticated user (SUBMITTED status)")
    void shouldRegisterFormerTeammateWithoutAuthenticatedUser() {
        // Given
        var command = createRegistrationCommand("Jean", "Dupont", "+33123456789", "jean.dupont@email.com");
        var context = createContextWithoutUser();

        // When
        var result = formerTeammateRegistrar.registerFormerTeammate(command, context);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo("Jean");
        assertThat(result.lastName()).isEqualTo("Dupont");
        assertThat(result.phone().map(Phone::value).orElse("")).isEqualTo("+33123456789");
        assertThat(result.email().orElse("")).isEqualTo("jean.dupont@email.com");
        assertThat(result.status()).isEqualTo(ContactStatus.SUBMITTED);

        // Verify former teammate was saved
        assertThat(formerTeammateRepository.findAll()).hasSize(1);
        
        // Verify initial history was created
        var allHistories = historyRepository.getAllSavedHistories();
        var historyEntries = allHistories.stream()
            .filter(h -> h.formerTeammateId().equals(result.id()))
            .toList();
        assertThat(historyEntries).hasSize(1);
        assertThat(historyEntries.getFirst().description()).isEqualTo("Enregistrement initial");
        assertThat(historyEntries.getFirst().updatedBy()).isEqualTo("Anonyme");

        // Verify no SMS was sent
        assertThat(smsSender.getSentSMSCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Should register former teammate with authenticated user and successful SMS (PENDING status)")
    void shouldRegisterFormerTeammateWithAuthenticatedUserAndSuccessfulSMS() {
        // Given
        var command = createRegistrationCommand("Marie", "Martin", "+33987654321", "marie.martin@email.com");
        var context = createContextWithUser();
        
        // Configure SMS sender to succeed
        smsSender.simulateFailure(false);

        // When
        var result = formerTeammateRegistrar.registerFormerTeammate(command, context);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo("Marie");
        assertThat(result.lastName()).isEqualTo("Martin");
        assertThat(result.phone().map(Phone::value).orElse("")).isEqualTo("+33987654321");
        assertThat(result.email().orElse("")).isEqualTo("marie.martin@email.com");
        assertThat(result.status()).isEqualTo(ContactStatus.PENDING);

        // Verify former teammate was saved
        assertThat(formerTeammateRepository.findAll()).hasSize(1);
        
        // Verify two history entries were created (creation + status update)
        var allHistories = historyRepository.getAllSavedHistories();
        var historyEntries = allHistories.stream()
            .filter(h -> h.formerTeammateId().equals(result.id()))
            .toList();
        assertThat(historyEntries).hasSize(2);
        
        var creationHistory = historyEntries.stream()
            .filter(h -> h.description().equals("Enregistrement initial"))
            .findFirst().orElse(null);
        assertThat(creationHistory).isNotNull();
        assertThat(creationHistory.updatedBy()).isEqualTo("admin");

        var statusHistory = historyEntries.stream()
            .filter(h -> h.description().contains("Modification du status"))
            .findFirst().orElse(null);
        assertThat(statusHistory).isNotNull();
        assertThat(statusHistory.updatedBy()).isEqualTo("admin");
        assertThat(statusHistory.description()).contains("SUBMITTED à PENDING");

        // Verify SMS was sent
        var sentSMS = smsSender.getSentSMSHistory();
        assertThat(sentSMS).hasSize(1);
        assertThat(sentSMS.getFirst().phoneNumber().value()).isEqualTo("+33987654321");
        assertThat(sentSMS.getFirst().status()).isEqualTo(SMSStatus.SENT);
    }

    @Test
    @DisplayName("Should register former teammate with authenticated user and failed SMS (UNREACHABLE status)")
    void shouldRegisterFormerTeammateWithAuthenticatedUserAndFailedSMS() {
        // Given
        var command = createRegistrationCommand("Pierre", "Durand", "+33456789123", "pierre.durand@email.com");
        var context = createContextWithUser();
        
        // Configure SMS sender to fail
        smsSender.simulateFailure(true);

        // When
        var result = formerTeammateRegistrar.registerFormerTeammate(command, context);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.firstName()).isEqualTo("Pierre");
        assertThat(result.lastName()).isEqualTo("Durand");
        assertThat(result.phone().map(Phone::value).orElse("")).isEqualTo("+33456789123");
        assertThat(result.email().orElse("")).isEqualTo("pierre.durand@email.com");
        assertThat(result.status()).isEqualTo(ContactStatus.UNREACHABLE);

        // Verify former teammate was saved
        assertThat(formerTeammateRepository.findAll()).hasSize(1);
        
        // Verify two history entries were created (creation + status update)
        var allHistories = historyRepository.getAllSavedHistories();
        var historyEntries = allHistories.stream()
            .filter(h -> h.formerTeammateId().equals(result.id()))
            .toList();
        assertThat(historyEntries).hasSize(2);
        
        var statusHistory = historyEntries.stream()
            .filter(h -> h.description().contains("Modification du status"))
            .findFirst().orElse(null);
        assertThat(statusHistory).isNotNull();
        assertThat(statusHistory.description()).contains("SUBMITTED à UNREACHABLE");

        // Verify SMS attempt was recorded
        var sentSMS = smsSender.getSentSMSHistory();
        assertThat(sentSMS).hasSize(1);
        assertThat(sentSMS.getFirst().phoneNumber().value()).isEqualTo("+33456789123");
        assertThat(sentSMS.getFirst().status()).isEqualTo(SMSStatus.FAILED);
    }

    @Test
    @DisplayName("Should throw exception for invalid phone number")
    void shouldThrowExceptionForInvalidPhoneNumber() {
        // Given
        var command = createRegistrationCommand("Invalid", "Phone", "invalid-phone", "invalid@email.com");
        var context = createContextWithUser();

        // When/Then
        assertThatThrownBy(() -> formerTeammateRegistrar.registerFormerTeammate(command, context))
            .isInstanceOf(InvalidPhoneNumberException.class);

        // Verify no data was saved due to phone validation failure
        assertThat(formerTeammateRepository.findAll()).isEmpty();
        assertThat(historyRepository.getAllSavedHistories()).isEmpty();
        assertThat(smsSender.getSentSMSCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Should handle phone normalization correctly")
    void shouldHandlePhoneNormalizationCorrectly() {
        // Given - phone with spaces and dashes
        var command = createRegistrationCommand("Test", "User", "+33 1 23-45-67-89", "test@email.com");
        var context = createContextWithoutUser();

        // When
        var result = formerTeammateRegistrar.registerFormerTeammate(command, context);

        // Then
        assertThat(result.phone().map(Phone::value).orElse("")).isEqualTo("+33123456789"); // Normalized
        assertThat(result.status()).isEqualTo(ContactStatus.SUBMITTED);
    }

    @Test
    @DisplayName("Should handle multiple registrations correctly")
    void shouldHandleMultipleRegistrationsCorrectly() {
        // Given
        var command1 = createRegistrationCommand("User1", "Test", "+33111111111", "user1@email.com");
        var command2 = createRegistrationCommand("User2", "Test", "+33222222222", "user2@email.com");
        var context = createContextWithUser();
        
        smsSender.simulateFailure(false);

        // When
        var result1 = formerTeammateRegistrar.registerFormerTeammate(command1, context);
        var result2 = formerTeammateRegistrar.registerFormerTeammate(command2, context);

        // Then
        assertThat(result1.id()).isNotEqualTo(result2.id());
        assertThat(formerTeammateRepository.findAll()).hasSize(2);
        assertThat(historyRepository.getAllSavedHistories()).hasSize(4); // 2 creation + 2 status update
        assertThat(smsSender.getSentSMSCount()).isEqualTo(2);
    }

    private FormerTeammateRegistrationRequest createRegistrationCommand(String firstName, String lastName, String phone, String email) {
        return new FormerTeammateRegistrationRequest(
            Gender.MALE,
            firstName,
            lastName,
            email,
            phone,
            LocalDate.of(1990, 1, 1),
            List.of(Role.PLAYER)
        );
    }

    private ContextDetails createContextWithUser() {
        var user = new CurrentUser("user-id-" + "admin", "admin", Set.of());
        return new ContextDetails(Optional.of(user));
    }

    private ContextDetails createContextWithoutUser() {
        return new ContextDetails(Optional.empty());
    }
}