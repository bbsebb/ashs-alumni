package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.entities.Participant;
import fr.hoenheimsports.app.services.EventService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@Slf4j
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("participants")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void> registerParticipant(@RequestBody @Valid ParticipantRequest participant) {
        log.info("Registering participant {}", participant);
        this.eventService.registerParticipant(participant);
        log.info("Participant {} registered", participant);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("participants")
    public ResponseEntity<List<ParticipantResponse>> findAllParticipants() {
        log.info("Retrieving all participants");
        return ResponseEntity.ok(this.eventService.findAllParticipants());
    }
}
