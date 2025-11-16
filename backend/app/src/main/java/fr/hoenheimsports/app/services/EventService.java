package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.exceptions.ParticipantAlreadyExistsException;
import fr.hoenheimsports.app.mappers.ParticipantMapper;
import fr.hoenheimsports.app.repositories.EventRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    private final ParticipantMapper participantMapper;
    private final EventRepository eventRepository;
    private final EmailService emailService;

    public EventService(ParticipantMapper participantMapper, EventRepository eventRepository, EmailService emailService) {
        this.participantMapper = participantMapper;
        this.eventRepository = eventRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void registerParticipant(ParticipantRequest participantRequest) {
        var participant = this.participantMapper.toEntity(participantRequest);
        this.eventRepository
                .findByFirstnameIgnoreCaseAndLastname(participant.getFirstname(), participant.getLastname())
                .ifPresent(existing -> {
                    throw new ParticipantAlreadyExistsException("Le participante avec le nom et prénom %s %s existe déja"
                            .formatted(existing.getFirstname(), existing.getLastname()));
                });
        participant.setKcId(UUID.fromString(extractSubFromSecurityContext()));
        this.eventRepository.save(participant);
        emailService.envoyerEmailTexte(
                participant.getEmail(),
                "Confirmation d’inscription",
                """
                        Bonjour %s,
                        Votre inscription a l'événement est confirmée.
                        Cordialement, Séb.
                        """.formatted(participant.getFirstname())
        );
        emailService.envoyerEmailTexte(
                "sebastien.burckhardt@gmail.com",
                "Inscription soirée ancien",
                """
                        Prénom : %s
                        Nom : %s
                        Email : %s
                        Commentaires : %s
                        ID : %s
                        """.formatted(
                                participant.getFirstname(),
                                participant.getLastname(),
                        participant.getEmail(),
                        participant.getComments(),
                        participant.getId()
                        )
        );
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
