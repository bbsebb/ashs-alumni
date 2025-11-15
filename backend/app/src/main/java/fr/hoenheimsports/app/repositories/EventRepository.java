package fr.hoenheimsports.app.repositories;

import fr.hoenheimsports.app.entities.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Participant, Long> {
}