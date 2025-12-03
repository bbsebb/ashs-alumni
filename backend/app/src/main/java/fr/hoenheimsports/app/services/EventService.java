package fr.hoenheimsports.app.services;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.entities.Participant;
import fr.hoenheimsports.app.exceptions.ParticipantAlreadyExistsException;
import fr.hoenheimsports.app.mappers.ParticipantMapper;
import fr.hoenheimsports.app.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
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
        log.debug("Participant {} avec ne nom : {} et prénom : {} enregistré",participant.getId(),participant.getFirstname(),participant.getLastname());
        emailService.envoyerEmailTexte(
                participant.getEmail(),
                "Confirmation d’inscription",
                getMessageHtml(participant)
        );
        emailService.envoyerEmailTexte(
                "sebastien.burckhardt@hoenheimsports.fr",
                "Inscription soirée ancien",
                getMessageForAdmin(participant)
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

    private static String getMessageForAdmin(Participant participant) {
        return """
                        Prénom : %s
                        Nom : %s
                        Email : %s
                        Commentaires : %s
                        ID : %s
                        a l'option végétarienne : %b
                        """.formatted(
                participant.getFirstname(),
                participant.getLastname(),
                participant.getEmail(),
                participant.getComments(),
                participant.getId(),
                participant.getHasVegetarianOption()
        );
    }

    private static String getMessageHtml(Participant participant) {
        String optionVege = Boolean.TRUE.equals(participant.getHasVegetarianOption()) ? "Oui 🥗" : "Non";
        String commentaire = (participant.getComments() != null && !participant.getComments().isBlank())
                ? participant.getComments() : "Aucun";
        return """
                    <!DOCTYPE html>
                    <html>
                    <body style="margin: 0; padding: 0; font-family: Arial, sans-serif; background-color: #f4f4f4;">
                        <div style="max-width: 600px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; overflow: hidden; box-shadow: 0 2px 8px rgba(0,0,0,0.1);">
                           \s
                            <!-- En-tête -->
                            <div style="background-color: #2E86C1; padding: 20px; text-align: center; color: #ffffff;">
                                <h1 style="margin: 0; font-size: 24px;">Inscription Validée ✅</h1>
                            </div>
                   \s
                            <!-- Contenu Principal -->
                            <div style="padding: 20px;">
                                <p style="font-size: 16px; color: #333;">Bonjour <strong>%s</strong>,</p>
                                <p style="font-size: 16px; color: #333;">C'est tout bon ! Votre inscription pour la soirée des anciens est bien enregistrée.</p>
                               \s
                                <!-- Récapitulatif -->
                                <div style="background-color: #f8f9fa; border-left: 4px solid #2E86C1; padding: 15px; margin: 20px 0;">
                                    <h3 style="margin-top: 0; color: #2E86C1;">📝 Vos informations</h3>
                                    <ul style="list-style: none; padding: 0; margin: 0;">
                                        <li style="margin-bottom: 8px;"><strong>Nom :</strong> %s %s</li>
                                        <li style="margin-bottom: 8px;"><strong>Option végétarienne :</strong> %s</li>
                                        <li><strong>Commentaire :</strong> %s</li>
                                    </ul>
                                </div>
                   \s
                                <!-- Détails Pratiques -->
                                <h3 style="border-bottom: 2px solid #eee; padding-bottom: 10px; color: #333;">📍 Infos Pratiques</h3>
                                <p>
                                    📅 <strong>Date :</strong> Samedi 10 janvier 2026<br>
                                    📍 <strong>Lieu :</strong> Gymnase municipal de Hoenheim, rue des Vosges<br>
                                    💶 <strong>À régler sur place :</strong> 25€ <span style="font-size: 0.9em; color: #666;">(Paiement à l'arrivée)</span>
                                </p>
                                <p style="color: #c0392b; font-size: 14px; margin-top: 10px;">
                                    ⚠️ <strong>Attention :</strong> Toute annulation doit se faire 1 semaine à l'avance à l'adresse <a href="mailto:sebastien.burckhardt@hoenheimsports.fr" style="color: #c0392b;">sebastien.burckhardt@hoenheimsports.fr</a>
                                </p>
                   \s
                                <!-- Programme -->
                                <h3 style="border-bottom: 2px solid #eee; padding-bottom: 10px; color: #333;">🏐 Programme de la soirée</h3>
                                <table style="width: 100%%; border-collapse: collapse;">
                                    <tr>
                                        <td style="padding: 8px 0; vertical-align: top; width: 100px;"><strong>16h00 - 19h00</strong></td>
                                        <td style="padding: 8px 0;">Matchs pour ceux qui peuvent 🤾</td>
                                    </tr>
                                    <tr>
                                        <td style="padding: 8px 0; vertical-align: top;"><strong>19h00</strong></td>
                                        <td style="padding: 8px 0;">Début du repas 🍽️<br><em style="color: #555;">(Bouchée à la reine)</em></td>
                                    </tr>
                                </table>
                   \s
                                <br>
                                <p style="text-align: center; margin-top: 30px;">À très vite !<br><strong>Séb.</strong></p>
                            </div>
                           \s
                            <!-- Pied de page -->
                            <div style="background-color: #eee; padding: 10px; text-align: center; font-size: 12px; color: #777;">
                                Hoenheim Sports
                            </div>
                        </div>
                    </body>
                    </html>
                   \s""".formatted(
                participant.getFirstname(),
                participant.getFirstname(),
                participant.getLastname(),
                optionVege,
                commentaire
        );
    }
}
