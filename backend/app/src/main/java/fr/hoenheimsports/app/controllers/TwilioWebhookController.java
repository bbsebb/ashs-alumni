package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.TwilioWebhookRequest;
import fr.hoenheimsports.app.mappers.TwilioMessageMapper;
import fr.hoenheimsports.domain.services.HandleSMSUpdatedStatus;
import fr.hoenheimsports.domain.api.commands.SMSUpdatedStatusDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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

    public TwilioWebhookController(HandleSMSUpdatedStatus handleSMSUpdatedStatus, TwilioMessageMapper twilioMessageMapper) {
        this.handleSMSUpdatedStatus = handleSMSUpdatedStatus;
        this.twilioMessageMapper = twilioMessageMapper;
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
        log.info("Handling status callback {}", request);
        SMSUpdatedStatusDetails command = twilioMessageMapper.toSMSUpdatedStatusCommand(request, formerTeammateId);
        handleSMSUpdatedStatus.handleSMSStatusUpdated(command);
        log.info("Status callback handled");
        return ResponseEntity.ok().build();
    }


}
