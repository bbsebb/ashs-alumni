package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.services.FormerTeammateService;
import fr.hoenheimsports.app.services.SecurityContextService;
import fr.hoenheimsports.domain.FormerTeammateRetriever;
import fr.hoenheimsports.domain.api.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/former-teammates")
@Slf4j
public class FormerTeammateController {

    private final RegisterFormerTeammate formerTeammateRegistrar;
    private final EditFormerTeammate formerTeammateEditor;
    private final GetFormerTeammates formerTeammateRetriever;
    private final FormerTeammateMapper formerTeammateMapper;
    private final FormerTeammateService formerTeammateService;
    private final SecurityContextService securityContextService;
    private final RemoveFormerTeammate formerTeammateRemover;
    private final ResendSMSToFormerTeammate SMSToFormerTeammateSender;
    private final ValidateFormerTeammate formerTeammateValidator;
    private final MarkAsNotRequestedFormerTeammate formerTeammateNotRequestedMarker;

    public FormerTeammateController(RegisterFormerTeammate formerTeammateRegistrar, EditFormerTeammate formerTeammateEditor,
                                    FormerTeammateRetriever formerTeammateRetriever,
                                    FormerTeammateMapper formerTeammateMapper,
                                    FormerTeammateService formerTeammateService,
                                    SecurityContextService securityContextService, RemoveFormerTeammate formerTeammateRemover, ResendSMSToFormerTeammate SMSToFormerTeammateSender, ValidateFormerTeammate formerTeammateValidator, MarkAsNotRequestedFormerTeammate formerTeammateNotRequestedMarker) {
        this.formerTeammateRegistrar = formerTeammateRegistrar;
        this.formerTeammateEditor = formerTeammateEditor;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.formerTeammateService = formerTeammateService;
        this.securityContextService = securityContextService;
        this.formerTeammateRemover = formerTeammateRemover;
        this.SMSToFormerTeammateSender = SMSToFormerTeammateSender;
        this.formerTeammateValidator = formerTeammateValidator;
        this.formerTeammateNotRequestedMarker = formerTeammateNotRequestedMarker;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        log.info("Registering former teammate {}", formerTeammateRequest);
        var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(formerTeammateRequest);
        var formerTeammate = formerTeammateRegistrar.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());
        log.info("Former teammate {} registered", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PostMapping("/{id}/resend-sms")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> resendSms(@PathVariable String id) {
        log.info("Resending SMS to former teammate {}", id);
        var formerTeammate = SMSToFormerTeammateSender.resendSMS(UUID.fromString(id),securityContextService.getCurrentContext());
        log.info("SMS resent to former teammate {}", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PostMapping("/{id}/not_requested")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> markAsNotRequested(@PathVariable String id) {
        log.info("Marking former teammate {} as not requested", id);
        var formerTeammate = formerTeammateNotRequestedMarker.markAsNotRequestedFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        log.info("Former teammate {} marked as not requested", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> editFormerTeammate(@PathVariable String id,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        log.info("Editing former teammate {}", formerTeammateRequest);
        var updateFormerTeammate = formerTeammateMapper.toUpdateRequest(id,formerTeammateRequest);
        var formerTeammate = formerTeammateEditor.editFormerTeammate(updateFormerTeammate, securityContextService.getCurrentContext());
        log.info("Former teammate {} edited", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/validate/{code}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> validateFormerTeammate(@PathVariable String code,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        log.info("Validating former teammate {}", formerTeammateRequest);
        var validateFormerTeammateRequest = formerTeammateMapper.toValidateRequest(code,formerTeammateRequest);
        var formerTeammate = formerTeammateValidator.valideFormerTeammate(validateFormerTeammateRequest);
        log.info("Former teammate {} validated", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }


    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates(@RequestParam(required = false) boolean isActive) {
        log.info("Retrieving all former teammates");
        var formerTeammates = isActive ? formerTeammateRetriever.findAllActiveFormerTeammates()  : formerTeammateRetriever.findAllFormerTeammates();
        var responses = formerTeammateService.buildFormerTeammateResponses(formerTeammates);
        log.info("Retrieved {} former teammates", responses.size());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<FormerTeammateResponse> findFormerTeammatesByCode(@PathVariable String code) {
        log.info("Retrieving former teammate with code {}", code);
        var formerTeammate  = formerTeammateRetriever.findByCode(code);
        var response = formerTeammateService.buildFormerTeammateResponse(formerTeammate);
        log.info("Retrieved former teammate {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFormerTeammate(@PathVariable String id) {
        log.info("Removing former teammate {}", id);
        formerTeammateRemover.removeFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        log.info("Former teammate {} removed", id);
        return ResponseEntity.noContent().build();
    }

}
