package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FormerTeammateMapperTest {

    private FormerTeammateMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(FormerTeammateMapper.class);
    }

    @Test
    void toResponse_shouldMapAllFieldsCorrectly() {
        // Given
        UUID id = UUID.randomUUID();
        FormerTeammate formerTeammate = FormerTeammate.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(Arrays.asList(Role.PLAYER, Role.COACH))
                .status(ContactStatus.VALIDATED)
                .build();

        // When
        FormerTeammateResponse response = mapper.toResponse(formerTeammate);

        // Then
        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(id);
        assertThat(response.firstName()).isEqualTo("John");
        assertThat(response.lastName()).isEqualTo("Doe");
        assertThat(response.gender()).isEqualTo(Gender.M);
        assertThat(response.phone()).isEqualTo("0123456789");
        assertThat(response.birthDate()).isEqualTo(LocalDate.of(1990, 1, 15));
        assertThat(response.roles()).containsExactly(Role.PLAYER, Role.COACH);
        assertThat(response.status()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void toResponse_withNullInput_shouldReturnNull() {
        // When
        FormerTeammateResponse response = mapper.toResponse(null);

        // Then
        assertThat(response).isNull();
    }

    @Test
    void toResponseList_withValidList_shouldMapAllElements() {
        // Given
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        FormerTeammate teammate1 = FormerTeammate.builder()
                .id(id1)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammate teammate2 = FormerTeammate.builder()
                .id(id2)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0987654321")
                .birthDate(LocalDate.of(1985, 5, 20))
                .roles(List.of(Role.COACH))
                .status(ContactStatus.PENDING)
                .build();

        List<FormerTeammate> teammates = Arrays.asList(teammate1, teammate2);

        // When
        List<FormerTeammateResponse> responses = mapper.toResponseList(teammates);

        // Then
        assertThat(responses).hasSize(2);

        assertThat(responses.getFirst().id()).isEqualTo(id1);
        assertThat(responses.getFirst().firstName()).isEqualTo("John");
        assertThat(responses.getFirst().lastName()).isEqualTo("Doe");

        assertThat(responses.get(1).id()).isEqualTo(id2);
        assertThat(responses.get(1).firstName()).isEqualTo("Jane");
        assertThat(responses.get(1).lastName()).isEqualTo("Smith");
    }

    @Test
    void toResponseList_withEmptyList_shouldReturnEmptyList() {
        // Given
        List<FormerTeammate> emptyList = Collections.emptyList();

        // When
        List<FormerTeammateResponse> responses = mapper.toResponseList(emptyList);

        // Then
        assertThat(responses).isEmpty();
    }

    @Test
    void toResponseList_withNullInput_shouldReturnNull() {
        // When
        List<FormerTeammateResponse> responses = mapper.toResponseList(null);

        // Then
        assertThat(responses).isNull();
    }

    @ParameterizedTest
    @MethodSource("provideTeammateData")
    void toResponse_withDifferentInputs_shouldMapCorrectly(UUID id, String firstName, String lastName,
                                                           Gender gender, String phone, LocalDate birthDate,
                                                           List<Role> roles, ContactStatus status) {
        // Given
        FormerTeammate formerTeammate = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .phone(phone)
                .birthDate(birthDate)
                .roles(roles)
                .status(status)
                .build();

        // When
        FormerTeammateResponse response = mapper.toResponse(formerTeammate);

        // Then
        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(id);
        assertThat(response.firstName()).isEqualTo(firstName);
        assertThat(response.lastName()).isEqualTo(lastName);
        assertThat(response.gender()).isEqualTo(gender);
        assertThat(response.phone()).isEqualTo(phone);
        assertThat(response.birthDate()).isEqualTo(birthDate);
        assertThat(response.roles()).isEqualTo(roles);
        assertThat(response.status()).isEqualTo(status);
    }

    private static Stream<Arguments> provideTeammateData() {
        return Stream.of(
                Arguments.of(
                        UUID.randomUUID(),
                        "Alice",
                        "Johnson",
                        Gender.F,
                        "0111111111",
                        LocalDate.of(1992, 3, 10),
                        List.of(Role.PLAYER),
                        ContactStatus.VALIDATED
                ),
                Arguments.of(
                        UUID.randomUUID(),
                        "Bob",
                        "Wilson",
                        Gender.M,
                        "0222222222",
                        LocalDate.of(1988, 8, 25),
                        Arrays.asList(Role.COACH, Role.PLAYER),
                        ContactStatus.SUBMITTED
                ),
                Arguments.of(
                        UUID.randomUUID(),
                        "Charlie",
                        "Brown",
                        Gender.M,
                        "0333333333",
                        LocalDate.of(1995, 12, 5),
                        Collections.emptyList(),
                        ContactStatus.PENDING
                )
        );
    }

    @Test
    void toEntity_shouldMapAllFieldsCorrectly() {
        // Given
        UUID id = UUID.randomUUID();
        FormerTeammate formerTeammate = FormerTeammate.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("0123456789")
                .birthDate(LocalDate.of(1990, 1, 15))
                .roles(Arrays.asList(Role.PLAYER, Role.COACH))
                .status(ContactStatus.VALIDATED)
                .build();

        // When
        FormerTeammateEntity entity = mapper.toEntity(formerTeammate);

        // Then
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(id);
        assertThat(entity.getFirstName()).isEqualTo("John");
        assertThat(entity.getLastName()).isEqualTo("Doe");
        assertThat(entity.getGender()).isEqualTo(Gender.M);
        assertThat(entity.getPhone()).isEqualTo("0123456789");
        assertThat(entity.getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 15));
        assertThat(entity.getRoles()).containsExactly(Role.PLAYER, Role.COACH);
        assertThat(entity.getStatus()).isEqualTo(ContactStatus.VALIDATED);
    }

    @Test
    void toEntity_withNullInput_shouldReturnNull() {
        // When
        FormerTeammateEntity entity = mapper.toEntity(null);

        // Then
        assertThat(entity).isNull();
    }

    @Test
    void toDomain_shouldMapAllFieldsCorrectly() {
        // Given
        UUID id = UUID.randomUUID();
        FormerTeammateEntity entity = FormerTeammateEntity.builder()
                .id(id)
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .phone("0987654321")
                .birthDate(LocalDate.of(1985, 5, 20))
                .roles(Arrays.asList(Role.COACH, Role.PLAYER))
                .status(ContactStatus.PENDING)
                .build();

        // When
        FormerTeammate formerTeammate = mapper.toDomain(entity);

        // Then
        assertThat(formerTeammate).isNotNull();
        assertThat(formerTeammate.id()).isEqualTo(id);
        assertThat(formerTeammate.firstName()).isEqualTo("Jane");
        assertThat(formerTeammate.lastName()).isEqualTo("Smith");
        assertThat(formerTeammate.gender()).isEqualTo(Gender.F);
        assertThat(formerTeammate.phone()).isEqualTo("0987654321");
        assertThat(formerTeammate.birthDate()).isEqualTo(LocalDate.of(1985, 5, 20));
        assertThat(formerTeammate.roles()).containsExactly(Role.COACH, Role.PLAYER);
        assertThat(formerTeammate.status()).isEqualTo(ContactStatus.PENDING);
    }

    @Test
    void toDomain_withNullInput_shouldReturnNull() {
        // When
        FormerTeammate formerTeammate = mapper.toDomain(null);

        // Then
        assertThat(formerTeammate).isNull();
    }

    @ParameterizedTest
    @MethodSource("provideEntityData")
    void toEntity_withDifferentInputs_shouldMapCorrectly(UUID id, String firstName, String lastName,
                                                         Gender gender, String phone, LocalDate birthDate,
                                                         List<Role> roles, ContactStatus status) {
        // Given
        FormerTeammate formerTeammate = FormerTeammate.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .phone(phone)
                .birthDate(birthDate)
                .roles(roles)
                .status(status)
                .build();

        // When
        FormerTeammateEntity entity = mapper.toEntity(formerTeammate);

        // Then
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isEqualTo(id);
        assertThat(entity.getFirstName()).isEqualTo(firstName);
        assertThat(entity.getLastName()).isEqualTo(lastName);
        assertThat(entity.getGender()).isEqualTo(gender);
        assertThat(entity.getPhone()).isEqualTo(phone);
        assertThat(entity.getBirthDate()).isEqualTo(birthDate);
        assertThat(entity.getRoles()).isEqualTo(roles);
        assertThat(entity.getStatus()).isEqualTo(status);
    }

    @ParameterizedTest
    @MethodSource("provideEntityData")
    void toDomain_withDifferentInputs_shouldMapCorrectly(UUID id, String firstName, String lastName,
                                                         Gender gender, String phone, LocalDate birthDate,
                                                         List<Role> roles, ContactStatus status) {
        // Given
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

        // When
        FormerTeammate formerTeammate = mapper.toDomain(entity);

        // Then
        assertThat(formerTeammate).isNotNull();
        assertThat(formerTeammate.id()).isEqualTo(id);
        assertThat(formerTeammate.firstName()).isEqualTo(firstName);
        assertThat(formerTeammate.lastName()).isEqualTo(lastName);
        assertThat(formerTeammate.gender()).isEqualTo(gender);
        assertThat(formerTeammate.phone()).isEqualTo(phone);
        assertThat(formerTeammate.birthDate()).isEqualTo(birthDate);
        assertThat(formerTeammate.roles()).isEqualTo(roles);
        assertThat(formerTeammate.status()).isEqualTo(status);
    }

    private static Stream<Arguments> provideEntityData() {
        return Stream.of(
                Arguments.of(
                        UUID.randomUUID(),
                        "Michael",
                        "Brown",
                        Gender.M,
                        "0444444444",
                        LocalDate.of(1991, 7, 12),
                        List.of(Role.PLAYER),
                        ContactStatus.VALIDATED
                ),
                Arguments.of(
                        UUID.randomUUID(),
                        "Sarah",
                        "Davis",
                        Gender.F,
                        "0555555555",
                        LocalDate.of(1993, 11, 8),
                        Arrays.asList(Role.COACH, Role.PLAYER),
                        ContactStatus.SUBMITTED
                ),
                Arguments.of(
                        UUID.randomUUID(),
                        "Alex",
                        "Wilson",
                        Gender.M,
                        null,
                        LocalDate.of(1987, 4, 3),
                        Collections.emptyList(),
                        ContactStatus.PENDING
                )
        );
    }
}