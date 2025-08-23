package fr.hoenheimsports.formerteammate.domain;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.spi.stubs.FormerTeammateRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class FormerTeammateRetrieverTest {

    private FormerTeammateRepositoryStub repositoryStub;
    private FormerTeammateRetriever retriever;

    @BeforeEach
    void setUp() {
        repositoryStub = new FormerTeammateRepositoryStub();
        repositoryStub.clear();
        retriever = new FormerTeammateRetriever(repositoryStub);
    }

    @Test
    void should_return_empty_list_when_no_former_teammates_exist() {
        // When
        List<FormerTeammate> result = retriever.execute();

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    void should_return_all_former_teammates_when_they_exist() {
        // Given
        FormerTeammate teammate1 = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.M)
                .phone("123456789")
                .birthDate(LocalDate.of(1990, 1, 1))
                .roles(List.of(Role.PLAYER))
                .status(ContactStatus.VALIDATED)
                .build();

        FormerTeammate teammate2 = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .firstName("Jane")
                .lastName("Smith")
                .gender(Gender.F)
                .status(ContactStatus.PENDING)
                .build();

        repositoryStub.save(teammate1);
        repositoryStub.save(teammate2);

        // When
        List<FormerTeammate> result = retriever.execute();

        // Then
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder(teammate1, teammate2);
    }

    @Test
    void should_return_copy_of_list_not_original_repository_list() {
        // Given
        FormerTeammate teammate = FormerTeammate.builder()
                .id(UUID.randomUUID())
                .firstName("Test")
                .lastName("User")
                .gender(Gender.M)
                .status(ContactStatus.VALIDATED)
                .build();

        repositoryStub.save(teammate);

        // When
        List<FormerTeammate> result = retriever.execute();

        // Then
        assertThat(result).isNotSameAs(repositoryStub.getSavedEntities());
        assertThat(result).containsExactly(teammate);
    }
}