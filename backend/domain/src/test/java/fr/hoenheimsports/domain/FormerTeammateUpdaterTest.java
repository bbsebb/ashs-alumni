package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.models.*;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateRepositoryStub;
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

import static org.assertj.core.api.Assertions.*;

@DisplayName("FormerTeammateUpdater Tests")
class FormerTeammateUpdaterTest {

    private FormerTeammateUpdater formerTeammateUpdater;
    private FormerTeammateRepositoryStub formerTeammateRepository;

    private UUID testFormerTeammateId;
    private FormerTeammate testFormerTeammate;

    @BeforeEach
    void setUp() {
        // Setup stubs
        formerTeammateRepository = new FormerTeammateRepositoryStub();
        
        // Create service under test
        formerTeammateUpdater = new FormerTeammateUpdater(formerTeammateRepository);

        // Setup test data
        testFormerTeammateId = UUID.randomUUID();
        
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
                
        // Save test FormerTeammate in repository
        formerTeammateRepository.save(testFormerTeammate);
    }

    @Test
    @DisplayName("Should update contact status by ID successfully")
    void shouldUpdateContactStatusByIdSuccessfully() {
        // Given
        ContactStatus newStatus = ContactStatus.PENDING;

        // When
        var result = formerTeammateUpdater.updateContactStatus(testFormerTeammateId, newStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo(testFormerTeammateId);
        assertThat(result.status()).isEqualTo(newStatus);
        
        // Verify other fields remain unchanged
        assertThat(result.firstName()).isEqualTo(testFormerTeammate.firstName());
        assertThat(result.lastName()).isEqualTo(testFormerTeammate.lastName());
        assertThat(result.phone()).isEqualTo(testFormerTeammate.phone());
        assertThat(result.email()).isEqualTo(testFormerTeammate.email());
        assertThat(result.birthDate()).isEqualTo(testFormerTeammate.birthDate());
        assertThat(result.roles()).isEqualTo(testFormerTeammate.roles());
        
        // Verify saved in repository
        var savedInRepository = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(savedInRepository).isPresent();
        assertThat(savedInRepository.get().status()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Should update contact status by entity successfully")
    void shouldUpdateContactStatusByEntitySuccessfully() {
        // Given
        ContactStatus newStatus = ContactStatus.VALIDATED;

        // When
        var result = formerTeammateUpdater.updateContactStatus(testFormerTeammate, newStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo(testFormerTeammateId);
        assertThat(result.status()).isEqualTo(newStatus);
        
        // Verify other fields remain unchanged
        assertThat(result.firstName()).isEqualTo(testFormerTeammate.firstName());
        assertThat(result.lastName()).isEqualTo(testFormerTeammate.lastName());
        assertThat(result.phone()).isEqualTo(testFormerTeammate.phone());
        assertThat(result.email()).isEqualTo(testFormerTeammate.email());
        assertThat(result.birthDate()).isEqualTo(testFormerTeammate.birthDate());
        assertThat(result.roles()).isEqualTo(testFormerTeammate.roles());
        
        // Verify saved in repository
        var savedInRepository = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(savedInRepository).isPresent();
        assertThat(savedInRepository.get().status()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Should return null when updating non-existent FormerTeammate by ID")
    void shouldReturnNullWhenUpdatingNonExistentFormerTeammateById() {
        // Given
        UUID nonExistentId = UUID.randomUUID();
        ContactStatus newStatus = ContactStatus.PENDING;

        // When
        var result = formerTeammateUpdater.updateContactStatus(nonExistentId, newStatus);

        // Then
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("provideContactStatusTransitions")
    @DisplayName("Should handle different contact status transitions correctly")
    void shouldHandleDifferentContactStatusTransitions(ContactStatus fromStatus, ContactStatus toStatus, String description) {
        // Given
        var formerTeammateWithStatus = testFormerTeammate.withContactStatus(fromStatus);
        formerTeammateRepository.save(formerTeammateWithStatus);

        // When
        var result = formerTeammateUpdater.updateContactStatus(formerTeammateWithStatus, toStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(toStatus);
        
        // Verify saved in repository
        var savedInRepository = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(savedInRepository).isPresent();
        assertThat(savedInRepository.get().status()).isEqualTo(toStatus);
    }

    @ParameterizedTest
    @MethodSource("provideAllContactStatuses")
    @DisplayName("Should update to all possible contact statuses correctly")
    void shouldUpdateToAllPossibleContactStatusesCorrectly(ContactStatus newStatus, String description) {
        // When
        var result = formerTeammateUpdater.updateContactStatus(testFormerTeammateId, newStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(newStatus);
        
        // Verify saved in repository
        var savedInRepository = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(savedInRepository).isPresent();
        assertThat(savedInRepository.get().status()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Should handle multiple updates to same FormerTeammate")
    void shouldHandleMultipleUpdatesToSameFormerTeammate() {
        // When - Apply multiple status updates
        var result1 = formerTeammateUpdater.updateContactStatus(testFormerTeammateId, ContactStatus.PENDING);
        var result2 = formerTeammateUpdater.updateContactStatus(result1, ContactStatus.VALIDATED);
        var result3 = formerTeammateUpdater.updateContactStatus(result2.id(), ContactStatus.UNREACHABLE);

        // Then
        assertThat(result1.status()).isEqualTo(ContactStatus.PENDING);
        assertThat(result2.status()).isEqualTo(ContactStatus.VALIDATED);
        assertThat(result3.status()).isEqualTo(ContactStatus.UNREACHABLE);
        
        // Verify final state in repository
        var finalSavedState = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(finalSavedState).isPresent();
        assertThat(finalSavedState.get().status()).isEqualTo(ContactStatus.UNREACHABLE);
    }

    @Test
    @DisplayName("Should preserve immutability when updating contact status")
    void shouldPreserveImmutabilityWhenUpdatingContactStatus() {
        // Given
        ContactStatus originalStatus = testFormerTeammate.status();
        ContactStatus newStatus = ContactStatus.VALIDATED;

        // When
        var updatedFormerTeammate = formerTeammateUpdater.updateContactStatus(testFormerTeammate, newStatus);

        // Then
        // Original entity should remain unchanged
        assertThat(testFormerTeammate.status()).isEqualTo(originalStatus);
        
        // Updated entity should have new status
        assertThat(updatedFormerTeammate.status()).isEqualTo(newStatus);
        
        // They should be different instances
        assertThat(updatedFormerTeammate).isNotSameAs(testFormerTeammate);
        
        // But have same ID
        assertThat(updatedFormerTeammate.id()).isEqualTo(testFormerTeammate.id());
    }

    @Test
    @DisplayName("Should handle FormerTeammates with different field combinations")
    void shouldHandleFormerTeammatesWithDifferentFieldCombinations() {
        // Given - FormerTeammate with minimal fields
        var minimalFormerTeammate = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .gender(Gender.FEMALE)
                .firstName("Jane")
                .lastName("Smith")
                .status(ContactStatus.SUBMITTED)
                .build();
        formerTeammateRepository.save(minimalFormerTeammate);

        // Given - FormerTeammate with all fields
        var completeFormerTeammate = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .gender(Gender.MALE)
                .firstName("Bob")
                .lastName("Wilson")
                .phone("+33987654321")
                .email("bob.wilson@example.com")
                .birthDate(LocalDate.of(1985, 5, 15))
                .roles(List.of(Role.COACH, Role.PRESIDENT))
                .status(ContactStatus.PENDING)
                .build();
        formerTeammateRepository.save(completeFormerTeammate);

        // When
        var updatedMinimal = formerTeammateUpdater.updateContactStatus(minimalFormerTeammate.id(), ContactStatus.VALIDATED);
        var updatedComplete = formerTeammateUpdater.updateContactStatus(completeFormerTeammate.id(), ContactStatus.UNREACHABLE);

        // Then
        assertThat(updatedMinimal).isNotNull();
        assertThat(updatedMinimal.status()).isEqualTo(ContactStatus.VALIDATED);
        assertThat(updatedMinimal.phone()).isEmpty();
        assertThat(updatedMinimal.email()).isEmpty();
        
        assertThat(updatedComplete).isNotNull();
        assertThat(updatedComplete.status()).isEqualTo(ContactStatus.UNREACHABLE);
        assertThat(updatedComplete.phone()).isPresent();
        assertThat(updatedComplete.email()).isPresent();
        assertThat(updatedComplete.roles()).containsExactly(Role.COACH, Role.PRESIDENT);
    }

    @Test
    @DisplayName("Should update contact status and maintain data integrity")
    void shouldUpdateContactStatusAndMaintainDataIntegrity() {
        // Given
        ContactStatus newStatus = ContactStatus.PENDING;
        int initialRepositorySize = formerTeammateRepository.findAll().size();

        // When
        var result = formerTeammateUpdater.updateContactStatus(testFormerTeammateId, newStatus);

        // Then
        assertThat(result).isNotNull();
        
        // Verify repository size hasn't changed (update, not insert)
        assertThat(formerTeammateRepository.findAll()).hasSize(initialRepositorySize);
        
        // Verify the entity was updated in place
        var retrievedEntity = formerTeammateRepository.findById(testFormerTeammateId);
        assertThat(retrievedEntity).isPresent();
        assertThat(retrievedEntity.get()).isEqualTo(result);
        assertThat(retrievedEntity.get().status()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Should handle concurrent updates gracefully")
    void shouldHandleConcurrentUpdatesGracefully() {
        // Given
        UUID sharedId = testFormerTeammateId;

        // When - Simulate concurrent updates
        var update1 = formerTeammateUpdater.updateContactStatus(sharedId, ContactStatus.PENDING);
        var update2 = formerTeammateUpdater.updateContactStatus(sharedId, ContactStatus.VALIDATED);
        var update3 = formerTeammateUpdater.updateContactStatus(sharedId, ContactStatus.UNREACHABLE);

        // Then - Last update should win
        assertThat(update3.status()).isEqualTo(ContactStatus.UNREACHABLE);
        
        var finalState = formerTeammateRepository.findById(sharedId);
        assertThat(finalState).isPresent();
        assertThat(finalState.get().status()).isEqualTo(ContactStatus.UNREACHABLE);
    }

    // Test data providers
    static Stream<Arguments> provideContactStatusTransitions() {
        return Stream.of(
                Arguments.of(ContactStatus.SUBMITTED, ContactStatus.PENDING, "SUBMITTED to PENDING"),
                Arguments.of(ContactStatus.SUBMITTED, ContactStatus.UNREACHABLE, "SUBMITTED to UNREACHABLE"),
                Arguments.of(ContactStatus.PENDING, ContactStatus.VALIDATED, "PENDING to VALIDATED"),
                Arguments.of(ContactStatus.PENDING, ContactStatus.UNREACHABLE, "PENDING to UNREACHABLE"),
                Arguments.of(ContactStatus.VALIDATED, ContactStatus.UNREACHABLE, "VALIDATED to UNREACHABLE"),
                Arguments.of(ContactStatus.UNREACHABLE, ContactStatus.PENDING, "UNREACHABLE to PENDING (retry)"),
                Arguments.of(ContactStatus.UNREACHABLE, ContactStatus.VALIDATED, "UNREACHABLE to VALIDATED (manual validation)"),
                Arguments.of(ContactStatus.VALIDATED, ContactStatus.PENDING, "VALIDATED to PENDING (re-verification)")
        );
    }

    static Stream<Arguments> provideAllContactStatuses() {
        return Stream.of(
                Arguments.of(ContactStatus.SUBMITTED, "Update to SUBMITTED"),
                Arguments.of(ContactStatus.PENDING, "Update to PENDING"),
                Arguments.of(ContactStatus.VALIDATED, "Update to VALIDATED"),
                Arguments.of(ContactStatus.UNREACHABLE, "Update to UNREACHABLE")
        );
    }
}