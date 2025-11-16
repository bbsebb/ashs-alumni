package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.entities.Participant;
import fr.hoenheimsports.app.services.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("participants")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Void> registerParticipant(@RequestBody @Valid ParticipantRequest participant) {
        this.eventService.registerParticipant(participant);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("participants")
    public ResponseEntity<List<ParticipantResponse>> findAllParticipants() {
        return ResponseEntity.ok(this.eventService.findAllParticipants());
    }
}
