package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
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
}