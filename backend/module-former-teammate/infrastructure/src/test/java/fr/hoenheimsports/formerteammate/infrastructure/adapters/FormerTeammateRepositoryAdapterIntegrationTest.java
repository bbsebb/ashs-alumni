package fr.hoenheimsports.formerteammate.infrastructure.adapters;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Testcontainers
class FormerTeammateRepositoryAdapterIntegrationTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17-alpine");

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private FormerTeammateRepository formerTeammateRepositoryAdapter;


    @Test
    public void should_return_empty_list_when_no_former_teammates_exist() {
        // GIVEN : la base est vide (c'est le cas par défaut au démarrage d'un test @DataJpaTest)

        // WHEN : on appelle la méthode
        var result = formerTeammateRepositoryAdapter.findAll();

        // THEN : la liste retournée doit être vide
        assertThat(result).isEmpty();
    }

    @Test
    public void should_save_and_find_former_teammate() {
        // GIVEN
        UUID id = UUID.randomUUID();
        FormerTeammateEntity entity = FormerTeammateEntity.builder()
                .id(id)
                .gender(Gender.F)
                .firstName("Alice")
                .lastName("Dupont")
                .status(ContactStatus.NOT_REQUESTED)
                .build();

        entityManager.persistAndFlush(entity);

        // WHEN
        var result = formerTeammateRepositoryAdapter.findById(id);

        // THEN
        assertThat(result).isPresent();
        assertThat(result.get().firstName()).isEqualTo("Alice");
    }


}