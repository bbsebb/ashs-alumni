package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.spi.stubs.FormerTeammateRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("FormerTeammateUpdater - Tests de mise à jour du statut de contact")
class FormerTeammateUpdaterTest {

    private FormerTeammateUpdater formerTeammateUpdater;
    private TestableFormerTeammateRepositoryStub repositoryStub;
    private FormerTeammate sampleFormerTeammate;
    private UUID sampleId;

    @BeforeEach
    void setUp() {
        repositoryStub = new TestableFormerTeammateRepositoryStub();
        formerTeammateUpdater = new FormerTeammateUpdater(repositoryStub);
        
        sampleId = UUID.randomUUID();
        sampleFormerTeammate = FormerTeammate.builder()
                .id(sampleId)
                .firstName("Jean")
                .lastName("Dupont")
                .gender(Gender.MALE)
                .status(ContactStatus.PENDING)
                .build();
    }

    @Test
    @DisplayName("Devrait mettre à jour le statut de contact par ID quand l'ancien coéquipier existe")
    void shouldUpdateContactStatusByIdWhenFormerTeammateExists() {
        // Given
        repositoryStub.save(sampleFormerTeammate);
        repositoryStub.clearSaveHistory(); // Clear initial save
        ContactStatus newStatus = ContactStatus.VALIDATED;

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(sampleId, newStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(newStatus);
        assertThat(result.id()).isEqualTo(sampleId);
        assertThat(result.firstName()).isEqualTo(sampleFormerTeammate.firstName());
        assertThat(result.lastName()).isEqualTo(sampleFormerTeammate.lastName());
        
        // Verify the repository was called to save
        assertThat(repositoryStub.getSavedFormerTeammates()).hasSize(1);
        assertThat(repositoryStub.getSavedFormerTeammates().get(0).status()).isEqualTo(newStatus);
    }

    @Test
    @DisplayName("Devrait retourner null quand l'ancien coéquipier n'existe pas par ID")
    void shouldReturnNullWhenFormerTeammateNotFoundById() {
        // Given
        UUID nonExistentId = UUID.randomUUID();
        ContactStatus newStatus = ContactStatus.VALIDATED;

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(nonExistentId, newStatus);

        // Then
        assertThat(result).isNull();
        assertThat(repositoryStub.getSavedFormerTeammates()).isEmpty();
    }

    @Test
    @DisplayName("Devrait mettre à jour le statut de contact directement sur l'entité")
    void shouldUpdateContactStatusDirectlyOnEntity() {
        // Given
        ContactStatus newStatus = ContactStatus.UNREACHABLE;

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(sampleFormerTeammate, newStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(newStatus);
        assertThat(result.id()).isEqualTo(sampleFormerTeammate.id());
        assertThat(result.firstName()).isEqualTo(sampleFormerTeammate.firstName());
        assertThat(result.lastName()).isEqualTo(sampleFormerTeammate.lastName());
        
        // Verify original object is unchanged (immutability)
        assertThat(sampleFormerTeammate.status()).isEqualTo(ContactStatus.PENDING);
        
        // Verify the repository was called to save
        assertThat(repositoryStub.getSavedFormerTeammates()).hasSize(1);
        assertThat(repositoryStub.getSavedFormerTeammates().get(0).status()).isEqualTo(newStatus);
    }

    @ParameterizedTest
    @MethodSource("provideContactStatusTransitions")
    @DisplayName("Devrait gérer toutes les transitions de statut par ID")
    void shouldHandleAllContactStatusTransitionsById(String testCase, ContactStatus fromStatus, ContactStatus toStatus) {
        // Given
        FormerTeammate teammate = sampleFormerTeammate.withContactStatus(fromStatus);
        repositoryStub.save(teammate);
        repositoryStub.clearSaveHistory(); // Clear initial save

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(sampleId, toStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(toStatus);
        assertThat(repositoryStub.getSavedFormerTeammates()).hasSize(1);
        assertThat(repositoryStub.getSavedFormerTeammates().get(0).status()).isEqualTo(toStatus);
    }

    @ParameterizedTest
    @MethodSource("provideContactStatusTransitions")
    @DisplayName("Devrait gérer toutes les transitions de statut directement")
    void shouldHandleAllContactStatusTransitionsDirectly(String testCase, ContactStatus fromStatus, ContactStatus toStatus) {
        // Given
        FormerTeammate teammate = sampleFormerTeammate.withContactStatus(fromStatus);

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(teammate, toStatus);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(toStatus);
        assertThat(teammate.status()).isEqualTo(fromStatus); // Original unchanged
        assertThat(repositoryStub.getSavedFormerTeammates()).hasSize(1);
        assertThat(repositoryStub.getSavedFormerTeammates().get(0).status()).isEqualTo(toStatus);
    }

    @ParameterizedTest
    @MethodSource("provideAllContactStatuses")
    @DisplayName("Devrait sauvegarder correctement tous les statuts de contact")
    void shouldSaveAllContactStatusesCorrectly(ContactStatus status, String description) {
        // Given
        repositoryStub.save(sampleFormerTeammate);
        repositoryStub.clearSaveHistory(); // Clear initial save

        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(sampleId, status);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.status()).isEqualTo(status);
        
        // Verify persistence
        FormerTeammate savedTeammate = repositoryStub.getSavedFormerTeammates().get(0);
        assertThat(savedTeammate.status()).isEqualTo(status);
    }

    @Test
    @DisplayName("Devrait préserver l'immutabilité lors des mises à jour")
    void shouldPreserveImmutabilityDuringUpdates() {
        // Given
        ContactStatus originalStatus = ContactStatus.PENDING;
        ContactStatus newStatus = ContactStatus.VALIDATED;
        
        FormerTeammate originalTeammate = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .firstName("Marie")
                .lastName("Martin")
                .gender(Gender.FEMALE)
                .status(originalStatus)
                .build();

        // When
        FormerTeammate updatedTeammate = formerTeammateUpdater.updateContactStatus(originalTeammate, newStatus);

        // Then
        assertThat(updatedTeammate).isNotSameAs(originalTeammate);
        assertThat(updatedTeammate.status()).isEqualTo(newStatus);
        assertThat(originalTeammate.status()).isEqualTo(originalStatus);
        
        // Verify all other properties are preserved
        assertThat(updatedTeammate.id()).isEqualTo(originalTeammate.id());
        assertThat(updatedTeammate.firstName()).isEqualTo(originalTeammate.firstName());
        assertThat(updatedTeammate.lastName()).isEqualTo(originalTeammate.lastName());
        assertThat(updatedTeammate.gender()).isEqualTo(originalTeammate.gender());
        assertThat(updatedTeammate.phone()).isEqualTo(originalTeammate.phone());
        assertThat(updatedTeammate.email()).isEqualTo(originalTeammate.email());
        assertThat(updatedTeammate.birthDate()).isEqualTo(originalTeammate.birthDate());
        assertThat(updatedTeammate.roles()).isEqualTo(originalTeammate.roles());
    }

    @Test
    @DisplayName("Devrait appeler le repository correctement lors de la sauvegarde")
    void shouldCallRepositoryCorrectlyDuringSave() {
        // Given
        ContactStatus newStatus = ContactStatus.VALIDATED;
        
        // When
        FormerTeammate result = formerTeammateUpdater.updateContactStatus(sampleFormerTeammate, newStatus);
        
        // Then
        assertThat(result).isNotNull();
        assertThat(repositoryStub.getSavedFormerTeammates()).hasSize(1);
        
        FormerTeammate savedTeammate = repositoryStub.getSavedFormerTeammates().get(0);
        assertThat(savedTeammate.status()).isEqualTo(newStatus);
        assertThat(savedTeammate.id()).isEqualTo(sampleFormerTeammate.id());
    }

    static Stream<Arguments> provideContactStatusTransitions() {
        return Stream.of(
                arguments("NOT_REQUESTED vers SUBMITTED", ContactStatus.NOT_REQUESTED, ContactStatus.SUBMITTED),
                arguments("SUBMITTED vers PENDING", ContactStatus.SUBMITTED, ContactStatus.PENDING),
                arguments("PENDING vers VALIDATED", ContactStatus.PENDING, ContactStatus.VALIDATED),
                arguments("PENDING vers UNREACHABLE", ContactStatus.PENDING, ContactStatus.UNREACHABLE),
                arguments("VALIDATED vers NOT_REQUESTED", ContactStatus.VALIDATED, ContactStatus.NOT_REQUESTED),
                arguments("UNREACHABLE vers SUBMITTED", ContactStatus.UNREACHABLE, ContactStatus.SUBMITTED),
                arguments("Même statut PENDING", ContactStatus.PENDING, ContactStatus.PENDING),
                arguments("Même statut VALIDATED", ContactStatus.VALIDATED, ContactStatus.VALIDATED)
        );
    }

    static Stream<Arguments> provideAllContactStatuses() {
        return Stream.of(
                arguments(ContactStatus.NOT_REQUESTED, "Statut non demandé"),
                arguments(ContactStatus.SUBMITTED, "Statut soumis"),
                arguments(ContactStatus.PENDING, "Statut en attente"),
                arguments(ContactStatus.VALIDATED, "Statut validé"),
                arguments(ContactStatus.UNREACHABLE, "Statut injoignable")
        );
    }

    /**
     * Extension du FormerTeammateRepositoryStub pour les tests.
     * Ajoute la capacité de suivre les opérations de sauvegarde.
     */
    private static class TestableFormerTeammateRepositoryStub extends FormerTeammateRepositoryStub {
        private final List<FormerTeammate> savedTeammates = new ArrayList<>();

        @Override
        public FormerTeammate save(FormerTeammate formerTeammate) {
            FormerTeammate result = super.save(formerTeammate);
            savedTeammates.add(result);
            return result;
        }

        public List<FormerTeammate> getSavedFormerTeammates() {
            return new ArrayList<>(savedTeammates);
        }

        public void clearSaveHistory() {
            savedTeammates.clear();
        }
    }
}