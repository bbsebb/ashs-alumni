package fr.hoenheimsports.formerteammate.infrastructure.adapters;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.annotations.Stub;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.domain.spi.stubs.FormerTeammateRepositoryStub;
import fr.hoenheimsports.formerteammate.domain.spi.stubs.UUIDGeneratorStub;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Testcontainers
@ContextConfiguration(classes = FormerTeammateRepositoryAdapterIntegrationTest.TestConfig.class)
class FormerTeammateRepositoryAdapterIntegrationTest {

    @TestConfiguration
    @ComponentScan(basePackages = "fr.hoenheimsports",
            includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {DomainService.class, Stub.class})},
            excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {UUIDGeneratorStub.class, FormerTeammateRepositoryStub.class})}
    )
    static class TestConfig {
        // Tu peux définir d'autres beans de test ici si nécessaire
    }


    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17-alpine");

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FormerTeammateRepository formerTeammateRepositoryAdapter;

    private FormerTeammate testFormerTeammate;
    private UUID testId;

    @BeforeEach
    void setUp() {
        testId = UUID.randomUUID();
        testFormerTeammate = FormerTeammate.builder()
                .id(testId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();
    }

    @Test
    void save_shouldPersistFormerTeammateToDatabase() {
        // When
        formerTeammateRepositoryAdapter.save(testFormerTeammate);
        entityManager.flush();

        // Then
        FormerTeammateEntity savedEntity = entityManager.find(FormerTeammateEntity.class, testId);
        assertThat(savedEntity).isNotNull();
        assertThat(savedEntity.getId()).isEqualTo(testId);
        assertThat(savedEntity.getFirstName()).isEqualTo("John");
        assertThat(savedEntity.getLastName()).isEqualTo("Doe");
        assertThat(savedEntity.getGender()).isEqualTo(Gender.M);
        assertThat(savedEntity.getPhone()).isEqualTo("0123456789");
        assertThat(savedEntity.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 15));
        assertThat(savedEntity.getRoles()).containsExactly(Role.PLAYER);
        assertThat(savedEntity.getStatus()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void findAll_shouldReturnAllFormerTeammatesFromDatabase() {
        // Given
        FormerTeammateEntity entity1 = createAndPersistEntity(
                UUID.randomUUID(), "Jane", "Smith", Gender.F, "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH), ContactStatus.PENDING
        );
        FormerTeammateEntity entity2 = createAndPersistEntity(
                UUID.randomUUID(), "Bob", "Wilson", Gender.M, "0555123456",
                LocalDate.of(1992, 8, 10), List.of(Role.PLAYER, Role.COACH), ContactStatus.VALIDATED
        );
        entityManager.flush();

        // When
        List<FormerTeammate> result = formerTeammateRepositoryAdapter.findAll();

        // Then
        assertThat(result).hasSize(2);

        FormerTeammate teammate1 = result.stream()
                .filter(t -> t.id().equals(entity1.getId()))
                .findFirst()
                .orElseThrow();
        assertThat(teammate1.firstName()).isEqualTo("Jane");
        assertThat(teammate1.lastName()).isEqualTo("Smith");
        assertThat(teammate1.gender()).isEqualTo(Gender.F);
        assertThat(teammate1.status()).isEqualTo(ContactStatus.PENDING);

        FormerTeammate teammate2 = result.stream()
                .filter(t -> t.id().equals(entity2.getId()))
                .findFirst()
                .orElseThrow();
        assertThat(teammate2.firstName()).isEqualTo("Bob");
        assertThat(teammate2.lastName()).isEqualTo("Wilson");
        assertThat(teammate2.roles()).containsExactlyInAnyOrder(Role.PLAYER, Role.COACH);
    }

    @Test
    void findAll_withEmptyDatabase_shouldReturnEmptyList() {
        // When
        List<FormerTeammate> result = formerTeammateRepositoryAdapter.findAll();

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void findById_withExistingId_shouldReturnOptionalWithFormerTeammate() {
        // Given
        createAndPersistEntity(
                testId, "John", "Doe", Gender.M, "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER), ContactStatus.VALIDATED
        );
        entityManager.flush();

        // When
        Optional<FormerTeammate> result = formerTeammateRepositoryAdapter.findById(testId);

        // Then
        assertThat(result).isPresent();
        FormerTeammate teammate = result.get();
        assertThat(teammate.id()).isEqualTo(testId);
        assertThat(teammate.firstName()).isEqualTo("John");
        assertThat(teammate.lastName()).isEqualTo("Doe");
        assertThat(teammate.gender()).isEqualTo(Gender.M);
        assertThat(teammate.phone()).isEqualTo("0123456789");
        assertThat(teammate.birthDate()).isEqualTo(LocalDate.of(1990, 1, 15));
        assertThat(teammate.roles()).containsExactly(Role.PLAYER);
        assertThat(teammate.status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void findById_withNonExistingId_shouldReturnEmptyOptional() {
        // Given
        UUID nonExistingId = UUID.randomUUID();

        // When
        Optional<FormerTeammate> result = formerTeammateRepositoryAdapter.findById(nonExistingId);

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void deleteById_shouldRemoveFormerTeammateFromDatabase() {
        // Given
        createAndPersistEntity(
                testId, "John", "Doe", Gender.M, "0123456789",
                LocalDate.of(1990, 1, 15), List.of(Role.PLAYER), ContactStatus.VALIDATED
        );
        entityManager.flush();

        assertThat(entityManager.find(FormerTeammateEntity.class, testId)).isNotNull();

        // When
        formerTeammateRepositoryAdapter.deleteById(testId);
        entityManager.flush();

        // Then
        FormerTeammateEntity deletedEntity = entityManager.find(FormerTeammateEntity.class, testId);
        assertThat(deletedEntity).isNull();
    }

    @Test
    void deleteAll_shouldRemoveAllFormerTeammatesFromDatabase() {
        // Given
        createAndPersistEntity(
                UUID.randomUUID(), "Jane", "Smith", Gender.F, "0987654321",
                LocalDate.of(1985, 5, 20), List.of(Role.COACH), ContactStatus.PENDING
        );
        createAndPersistEntity(
                UUID.randomUUID(), "Bob", "Wilson", Gender.M, "0555123456",
                LocalDate.of(1992, 8, 10), List.of(Role.PLAYER), ContactStatus.VALIDATED
        );
        entityManager.flush();

        // Verify data exists
        List<FormerTeammate> beforeDelete = formerTeammateRepositoryAdapter.findAll();
        assertThat(beforeDelete).hasSize(2);

        // When
        formerTeammateRepositoryAdapter.deleteAll();
        entityManager.flush();

        // Then
        List<FormerTeammate> afterDelete = formerTeammateRepositoryAdapter.findAll();
        assertThat(afterDelete).isEmpty();
    }

    private FormerTeammateEntity createAndPersistEntity(UUID id, String firstName, String lastName,
                                                        Gender gender, String phone, LocalDate birthDate,
                                                        List<Role> roles, ContactStatus status) {
        FormerTeammateEntity entity = FormerTeammateEntity.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .phone(phone)
                .birthDate(birthDate)
                .roles(roles)
                .status(status)
                .build();
        entityManager.persist(entity);
        return entity;
    }
}