package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.services.FormerTeammateService;
import fr.hoenheimsports.app.services.SecurityContextService;
import fr.hoenheimsports.domain.FormerTeammateRetriever;
import fr.hoenheimsports.domain.api.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/former-teammates")
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

    public FormerTeammateController(RegisterFormerTeammate formerTeammateRegistrar, EditFormerTeammate formerTeammateEditor,
                                    FormerTeammateRetriever formerTeammateRetriever,
                                    FormerTeammateMapper formerTeammateMapper,
                                    FormerTeammateService formerTeammateService,
                                    SecurityContextService securityContextService, RemoveFormerTeammate formerTeammateRemover, ResendSMSToFormerTeammate SMSToFormerTeammateSender, ValidateFormerTeammate formerTeammateValidator) {
        this.formerTeammateRegistrar = formerTeammateRegistrar;
        this.formerTeammateEditor = formerTeammateEditor;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.formerTeammateService = formerTeammateService;
        this.securityContextService = securityContextService;
        this.formerTeammateRemover = formerTeammateRemover;
        this.SMSToFormerTeammateSender = SMSToFormerTeammateSender;
        this.formerTeammateValidator = formerTeammateValidator;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(formerTeammateRequest);
        var formerTeammate = formerTeammateRegistrar.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PostMapping("/{id}/resend-sms")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> resendSms(@PathVariable String id) {
        var formerTeammate = SMSToFormerTeammateSender.resendSMS(UUID.fromString(id),securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> editFormerTeammate(@PathVariable String id,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var updateFormerTeammate = formerTeammateMapper.toUpdateRequest(id,formerTeammateRequest);
        var formerTeammate = formerTeammateEditor.editFormerTeammate(updateFormerTeammate, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/validate/{code}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> validateFormerTeammate(@PathVariable String code,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var validateFormerTeammateRequest = formerTeammateMapper.toValidateRequest(code,formerTeammateRequest);
        var formerTeammate = formerTeammateValidator.valideFormerTeammate(validateFormerTeammateRequest);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }


    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates(@RequestParam(required = false) boolean isActive) {
        var formerTeammates = isActive ? formerTeammateRetriever.findAllActiveFormerTeammates()  : formerTeammateRetriever.findAllFormerTeammates();
        var responses = formerTeammateService.buildFormerTeammateResponses(formerTeammates);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<FormerTeammateResponse> findFormerTeammatesByCode(@PathVariable String code) {
        var formerTeammate  = formerTeammateRetriever.findByCode(code);
        var response = formerTeammateService.buildFormerTeammateResponse(formerTeammate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFormerTeammate(@PathVariable String id) {
        formerTeammateRemover.removeFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        return ResponseEntity.noContent().build();
    }

}
