package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByFirstnameIgnoreCaseAndLastname(String firstname, String lastname);
}