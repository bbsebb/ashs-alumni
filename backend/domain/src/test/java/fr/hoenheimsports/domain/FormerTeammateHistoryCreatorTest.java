package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.services.FormerTeammateHistoryCreator;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateHistoryRepositoryStub;
import fr.hoenheimsports.domain.spi.stubs.GenerateIdStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FormerTeammateHistoryCreator Tests")
class FormerTeammateHistoryCreatorTest {

    private FormerTeammateHistoryCreator historyCreator;
    private FormerTeammateHistoryRepositoryStub historyRepository;

    private UUID testFormerTeammateId;
    private String testUpdatedBy;
    private String testDescription;
    private FormerTeammate testFormerTeammate;

    @BeforeEach
    void setUp() {
        // Setup stubs
        historyRepository = new FormerTeammateHistoryRepositoryStub();
        GenerateIdStub idGenerator = new GenerateIdStub();
        
        // Create service under test
        historyCreator = new FormerTeammateHistoryCreator(idGenerator, historyRepository);

        // Setup test data
        testFormerTeammateId = UUID.randomUUID();
        testUpdatedBy = "testUser";
        testDescription = "Test history entry";
        
        testFormerTeammate = FormerTeammate.builder()
                .id(testFormerTeammateId)
                .gender(Gender.MALE)
                .firstName("John")
                .lastName("Doe")
                .phone("+33123456789")
                .email("john.doe@example.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.SUBMITTED)
                .build();
    }

    @Test
    @DisplayName("Should create history entry for creation with all fields")
    void shouldCreateHistoryEntryForCreationWithAllFields() {
        // When
        var result = historyCreator.createHistoryForCreation(testFormerTeammate, testUpdatedBy, testDescription);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.id()).isNotNull();
        assertThat(result.formerTeammateId()).isEqualTo(testFormerTeammateId);
        assertThat(result.phoneAtTime()).hasValue(new Phone("+33123456789"));
        assertThat(result.emailAtTime()).hasValue("john.doe@example.com");
        assertThat(result.birthDateAtTime()).hasValue(LocalDate.of(1990, 1, 1));
        assertThat(result.rolesAtTime()).containsExactly(Role.PLAYER);
        assertThat(result.statusAtTime()).isEqualTo(ContactStatus.SUBMITTED);
        assertThat(result.updatedAt()).isEqualTo(LocalDate.now());
        assertThat(result.historyAction()).isEqualTo(HistoryAction.CREATED);
        assertThat(result.updatedBy()).isEqualTo(testUpdatedBy);
        assertThat(result.description()).isEqualTo(testDescription);
        
        // Verify saved in repository
        assertThat(historyRepository.getAllSavedHistories()).hasSize(1);
        assertThat(historyRepository.getAllSavedHistories().getFirst()).isEqualTo(result);
    }

    @Test
    @DisplayName("Should create history entry for update with all fields")
    void shouldCreateHistoryEntryForUpdateWithAllFields() {
        // When
        var result = historyCreator.createHistoryForUpdate(testFormerTeammate, testUpdatedBy, testDescription);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.id()).isNotNull();
        assertThat(result.formerTeammateId()).isEqualTo(testFormerTeammateId);
        assertThat(result.phoneAtTime()).hasValue(new Phone("+33123456789"));
        assertThat(result.emailAtTime()).hasValue("john.doe@example.com");
        assertThat(result.birthDateAtTime()).hasValue(LocalDate.of(1990, 1, 1));
        assertThat(result.rolesAtTime()).containsExactly(Role.PLAYER);
        assertThat(result.statusAtTime()).isEqualTo(ContactStatus.SUBMITTED);
        assertThat(result.updatedAt()).isEqualTo(LocalDate.now());
        assertThat(result.historyAction()).isEqualTo(HistoryAction.UPDATED);
        assertThat(result.updatedBy()).isEqualTo(testUpdatedBy);
        assertThat(result.description()).isEqualTo(testDescription);
        
        // Verify saved in repository
        assertThat(historyRepository.getAllSavedHistories()).hasSize(1);
        assertThat(historyRepository.getAllSavedHistories().getFirst()).isEqualTo(result);
    }

    @Test
    @DisplayName("Should create history entry with minimal FormerTeammate fields")
    void shouldCreateHistoryEntryWithMinimalFormerTeammateFields() {
        // Given
        var minimalFormerTeammate = FormerTeammate.builder()
                .id(testFormerTeammateId)
                .gender(Gender.FEMALE)
                .firstName("Jane")
                .lastName("Smith")
                .status(ContactStatus.PENDING)
                .build();

        // When
        var result = historyCreator.createHistoryForCreation(minimalFormerTeammate, testUpdatedBy, testDescription);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.formerTeammateId()).isEqualTo(testFormerTeammateId);
        assertThat(result.phoneAtTime()).isEmpty();
        assertThat(result.emailAtTime()).isEmpty();
        assertThat(result.birthDateAtTime()).isEmpty();
        assertThat(result.rolesAtTime()).isEmpty();
        assertThat(result.statusAtTime()).isEqualTo(ContactStatus.PENDING);
        assertThat(result.historyAction()).isEqualTo(HistoryAction.CREATED);
    }

    @ParameterizedTest
    @MethodSource("provideHistoryActionScenarios")
    @DisplayName("Should handle different history actions correctly")
    void shouldHandleDifferentHistoryActions(HistoryAction action, String methodName, String description) {
        // When & Then
        if (action == HistoryAction.CREATED) {
            var result = historyCreator.createHistoryForCreation(testFormerTeammate, testUpdatedBy, description);
            assertThat(result.historyAction()).isEqualTo(HistoryAction.CREATED);
        } else if (action == HistoryAction.UPDATED) {
            var result = historyCreator.createHistoryForUpdate(testFormerTeammate, testUpdatedBy, description);
            assertThat(result.historyAction()).isEqualTo(HistoryAction.UPDATED);
        }
    }

    @ParameterizedTest
    @MethodSource("provideContactStatusScenarios")
    @DisplayName("Should capture different contact statuses correctly")
    void shouldCaptureDifferentContactStatusesCorrectly(ContactStatus status, String description) {
        // Given
        var formerTeammateWithStatus = testFormerTeammate.withContactStatus(status);

        // When
        var result = historyCreator.createHistoryForCreation(formerTeammateWithStatus, testUpdatedBy, testDescription);

        // Then
        assertThat(result.statusAtTime()).isEqualTo(status);
    }

    @ParameterizedTest
    @MethodSource("provideRoleScenarios")
    @DisplayName("Should capture different role combinations correctly")
    void shouldCaptureDifferentRoleCombinationsCorrectly(List<Role> roles, String description) {
        // Given
        var formerTeammateWithRoles = FormerTeammate.builder()
                .id(testFormerTeammateId)
                .gender(Gender.MALE)
                .firstName("John")
                .lastName("Doe")
                .roles(roles)
                .status(ContactStatus.SUBMITTED)
                .build();

        // When
        var result = historyCreator.createHistoryForUpdate(formerTeammateWithRoles, testUpdatedBy, testDescription);

        // Then
        assertThat(result.rolesAtTime()).containsExactlyElementsOf(roles);
    }

    @Test
    @DisplayName("Should generate unique IDs for multiple history entries")
    void shouldGenerateUniqueIdsForMultipleHistoryEntries() {
        // When
        var result1 = historyCreator.createHistoryForCreation(testFormerTeammate, testUpdatedBy, "First entry");
        var result2 = historyCreator.createHistoryForUpdate(testFormerTeammate, testUpdatedBy, "Second entry");
        var result3 = historyCreator.createHistoryForCreation(testFormerTeammate, "otherUser", "Third entry");

        // Then
        assertThat(result1.id()).isNotEqualTo(result2.id());
        assertThat(result1.id()).isNotEqualTo(result3.id());
        assertThat(result2.id()).isNotEqualTo(result3.id());
        
        // Verify all saved in repository
        assertThat(historyRepository.getAllSavedHistories()).hasSize(3);
    }

    @Test
    @DisplayName("Should capture snapshot of FormerTeammate state at time of creation")
    void shouldCaptureSnapshotOfFormerTeammateStateAtTimeOfCreation() {
        // Given
        var originalFormerTeammate = testFormerTeammate;
        
        // When
        var historyEntry = historyCreator.createHistoryForCreation(originalFormerTeammate, testUpdatedBy, testDescription);
        
        // Simulate FormerTeammate being modified after history creation
        var modifiedFormerTeammate = originalFormerTeammate.withContactStatus(ContactStatus.VALIDATED);
        
        // Then - History should still capture original state
        assertThat(historyEntry.statusAtTime()).isEqualTo(ContactStatus.SUBMITTED);
        assertThat(modifiedFormerTeammate.status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    @DisplayName("Should handle different updatedBy values correctly")
    void shouldHandleDifferentUpdatedByValuesCorrectly() {
        // Given
        String systemUser = "system";
        String regularUser = "john.doe";
        String adminUser = "admin@ashs.fr";

        // When
        var systemEntry = historyCreator.createHistoryForCreation(testFormerTeammate, systemUser, "System creation");
        var userEntry = historyCreator.createHistoryForUpdate(testFormerTeammate, regularUser, "User update");
        var adminEntry = historyCreator.createHistoryForCreation(testFormerTeammate, adminUser, "Admin creation");

        // Then
        assertThat(systemEntry.updatedBy()).isEqualTo(systemUser);
        assertThat(userEntry.updatedBy()).isEqualTo(regularUser);
        assertThat(adminEntry.updatedBy()).isEqualTo(adminUser);
    }

    @Test
    @DisplayName("Should save history entries with current date")
    void shouldSaveHistoryEntriesWithCurrentDate() {
        // Given
        LocalDate today = LocalDate.now();

        // When
        var result1 = historyCreator.createHistoryForCreation(testFormerTeammate, testUpdatedBy, testDescription);
        var result2 = historyCreator.createHistoryForUpdate(testFormerTeammate, testUpdatedBy, testDescription);

        // Then
        assertThat(result1.updatedAt()).isEqualTo(today);
        assertThat(result2.updatedAt()).isEqualTo(today);
    }

    // Test data providers
    static Stream<Arguments> provideHistoryActionScenarios() {
        return Stream.of(
                Arguments.of(HistoryAction.CREATED, "createHistoryForCreation", "Creation scenario"),
                Arguments.of(HistoryAction.UPDATED, "createHistoryForUpdate", "Update scenario")
        );
    }

    static Stream<Arguments> provideContactStatusScenarios() {
        return Stream.of(
                Arguments.of(ContactStatus.SUBMITTED, "Submitted status"),
                Arguments.of(ContactStatus.PENDING, "Pending status"),
                Arguments.of(ContactStatus.VALIDATED, "Validated status"),
                Arguments.of(ContactStatus.UNREACHABLE, "Unreachable status")
        );
    }

    static Stream<Arguments> provideRoleScenarios() {
        return Stream.of(
                Arguments.of(List.of(), "No roles"),
                Arguments.of(List.of(Role.PLAYER), "Single role - Player"),
                Arguments.of(List.of(Role.COACH), "Single role - Coach"),
                Arguments.of(List.of(Role.PRESIDENT), "Single role - President"),
                Arguments.of(List.of(Role.ASSISTANT), "Single role - Assistant"),
                Arguments.of(List.of(Role.PLAYER, Role.COACH), "Multiple roles - Player and Coach"),
                Arguments.of(List.of(Role.PRESIDENT, Role.COACH, Role.PLAYER), "Multiple roles - All leadership"),
                Arguments.of(List.of(Role.PLAYER, Role.COACH, Role.PRESIDENT, Role.ASSISTANT), "All roles")
        );
    }
}