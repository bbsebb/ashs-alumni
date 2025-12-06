package fr.hoenheimsports.app.controllers;

import com.twilio.twiml.MessagingResponse;
import fr.hoenheimsports.app.controllers.dtos.TwilioWebhookRequest;
import fr.hoenheimsports.app.mappers.TwilioMessageMapper;
import fr.hoenheimsports.app.services.EmailService;
import fr.hoenheimsports.domain.api.GetFormerTeammates;
import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusDetails;
import fr.hoenheimsports.domain.services.HandleSMSUpdatedStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/webhooks/twilio")
@Tag(name = "Twilio Webhooks", description = "API pour gérer les callbacks Twilio")
@Slf4j
public class
TwilioWebhookController {
    private final HandleSMSUpdatedStatus handleSMSUpdatedStatus;
    private final TwilioMessageMapper twilioMessageMapper;
    private final EmailService emailService;
    private final GetFormerTeammates formerTeammateRetriever;


    public TwilioWebhookController(HandleSMSUpdatedStatus handleSMSUpdatedStatus, TwilioMessageMapper twilioMessageMapper, EmailService emailService, GetFormerTeammates formerTeammateRetriever) {
        this.handleSMSUpdatedStatus = handleSMSUpdatedStatus;
        this.twilioMessageMapper = twilioMessageMapper;
        this.emailService = emailService;
        this.formerTeammateRetriever = formerTeammateRetriever;
    }


    @PostMapping("/status")
    @Operation(summary = "Webhook de statut SMS",
            description = "Reçoit les callbacks de statut SMS de Twilio pour les SIDs autorisés uniquement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Webhook traité avec succès"),
            @ApiResponse(responseCode = "400", description = "Requête invalide"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur")
    })
    @Transactional
    public ResponseEntity<Void> handleStatusCallback(
            @ModelAttribute TwilioWebhookRequest request, @RequestParam String formerTeammateId) {
        log.debug("Handling status callback {}", request);
        SMSUpdatedStatusDetails command = twilioMessageMapper.toSMSUpdatedStatusCommand(request, formerTeammateId);
        handleSMSUpdatedStatus.handleSMSStatusUpdated(command);
        log.debug("Status callback handled");
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/income", produces = MediaType.APPLICATION_XML_VALUE)
    public String receiveSms(
            @RequestParam(value = "From") String fromNumber,
            @RequestParam(value = "Body") String messageBody,
            @RequestParam(value = "To") String toNumber
    ) {

        var smsInputSenderName = this.formerTeammateRetriever.findByPhone(fromNumber).map(formerTeammate -> formerTeammate.firstName() + " " + formerTeammate.lastName()).orElse("Inconnu");
        this.emailService.envoyerEmailTexte(
                "sebastien.burckhardt@hoenheimsports.fr",
                "SMS Income de %s".formatted(smsInputSenderName),
                """
                        Message de : %s
                        Pour : %s
                        Contenu : %s
                        """.formatted(fromNumber, toNumber, messageBody)
        );

        MessagingResponse twiml = new MessagingResponse.Builder().build();
        return twiml.toXml();
    }


}
