package fr.hoenheimsports.formerteammate.infrastructure.adapters;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import fr.hoenheimsports.formerteammate.infrastructure.repository.FormerTeammateEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FormerTeammateRepositoryAdapterTest {

    @Mock
    private FormerTeammateEntityRepository entityRepository;

    @Mock
    private FormerTeammateMapper mapper;

    @InjectMocks
    private FormerTeammateRepositoryAdapter adapter;

    private FormerTeammate formerTeammate;
    private FormerTeammateEntity formerTeammateEntity;
    private UUID testId;

    @BeforeEach
    void setUp() {
        testId = UUID.randomUUID();

        formerTeammate = FormerTeammate.builder()
                .id(testId)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();

        formerTeammateEntity = FormerTeammateEntity.builder()
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
    void save_shouldMapDomainToEntityAndCallRepositorySave() {
        // Given
        when(mapper.toEntity(formerTeammate)).thenReturn(formerTeammateEntity);

        // When
        adapter.save(formerTeammate);

        // Then
        verify(mapper, times(1)).toEntity(formerTeammate);
        verify(entityRepository, times(1)).save(formerTeammateEntity);
    }

    @Test
    void findAll_shouldReturnMappedDomainObjects() {
        // Given
        FormerTeammateEntity entity1 = FormerTeammateEntity.builder()
                .id(UUID.randomUUID())
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .build();

        FormerTeammateEntity entity2 = FormerTeammateEntity.builder()
                .id(UUID.randomUUID())
                .firstName("Bob")
                .lastName("Wilson")
                .gender(Gender.M)
                .build();

        FormerTeammate domain1 = FormerTeammate.builder()
                .id(entity1.getId())
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammate domain2 = FormerTeammate.builder()
                .id(entity2.getId())
                .firstName("Bob")
                .lastName("Wilson")
                .gender(Gender.M)
                .status(ContactStatus.PENDING)
                .build();

        List<FormerTeammateEntity> entities = Arrays.asList(entity1, entity2);

        when(entityRepository.findAll()).thenReturn(entities);
        when(mapper.toDomain(entity1)).thenReturn(domain1);
        when(mapper.toDomain(entity2)).thenReturn(domain2);

        // When
        List<FormerTeammate> result = adapter.findAll();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(domain1, domain2);
        verify(entityRepository, times(1)).findAll();
        verify(mapper, times(1)).toDomain(entity1);
        verify(mapper, times(1)).toDomain(entity2);
    }

    @Test
    void findAll_withEmptyRepository_shouldReturnEmptyList() {
        // Given
        when(entityRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        List<FormerTeammate> result = adapter.findAll();

        // Then
        assertThat(result).isEmpty();
        verify(entityRepository, times(1)).findAll();
        verify(mapper, never()).toDomain(any());
    }

    @Test
    void findById_withExistingId_shouldReturnMappedOptional() {
        // Given
        when(entityRepository.findById(testId)).thenReturn(Optional.of(formerTeammateEntity));
        when(mapper.toDomain(formerTeammateEntity)).thenReturn(formerTeammate);

        // When
        Optional<FormerTeammate> result = adapter.findById(testId);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(formerTeammate);
        verify(entityRepository, times(1)).findById(testId);
        verify(mapper, times(1)).toDomain(formerTeammateEntity);
    }

    @Test
    void findById_withNonExistingId_shouldReturnEmptyOptional() {
        // Given
        UUID nonExistingId = UUID.randomUUID();
        when(entityRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // When
        Optional<FormerTeammate> result = adapter.findById(nonExistingId);

        // Then
        assertThat(result).isEmpty();
        verify(entityRepository, times(1)).findById(nonExistingId);
        verify(mapper, never()).toDomain(any());
    }

    @Test
    void deleteById_shouldCallRepositoryDeleteById() {
        // When
        adapter.deleteById(testId);

        // Then
        verify(entityRepository, times(1)).deleteById(testId);
    }

    @Test
    void deleteAll_shouldCallRepositoryDeleteAll() {
        // When
        adapter.deleteAll();

        // Then
        verify(entityRepository, times(1)).deleteAll();
    }
}