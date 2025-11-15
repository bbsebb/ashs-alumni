package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.mappers.ParticipantMapper;
import fr.hoenheimsports.app.repositories.EventRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final ParticipantMapper participantMapper;
    private final EventRepository eventRepository;

    public EventService(ParticipantMapper participantMapper, EventRepository eventRepository) {
        this.participantMapper = participantMapper;
        this.eventRepository = eventRepository;
    }

    public void registerParticipant(ParticipantRequest participantRequest) {
        var participant = this.participantMapper.toEntity(participantRequest);
        participant.setKcId(UUID.fromString(extractSubFromSecurityContext()));
        this.eventRepository.save(participant);
    }

    private String extractSubFromSecurityContext() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            var jwt = jwtAuth.getToken();
            return jwt.getSubject(); // champ "sub"
        }

        throw new IllegalStateException("Aucun JWT authentifié dans le contexte");
    }

    public List<ParticipantResponse> findAllParticipants() {
        return this.eventRepository.findAll().stream().map(participantMapper::toDto).toList();
    }
}
