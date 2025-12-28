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
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        log.debug("Registering former teammate {}", formerTeammateRequest);
        var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(formerTeammateRequest);
        var formerTeammate = formerTeammateRegistrar.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());
        log.debug("Former teammate {} registered", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PostMapping("/group")
    public ResponseEntity<List<Map<String, Object>>> registerFormerTeammates(@RequestBody @Valid List<FormerTeammateRequest> formerTeammateRequests) {
        log.debug("Registering former teammates group of size {}", formerTeammateRequests.size());
        List<Map<String, Object>> results = new ArrayList<>();

        for (FormerTeammateRequest request : formerTeammateRequests) {
            Map<String, Object> itemResult = new HashMap<>();
            try {
                var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(request);
                var formerTeammate = formerTeammateRegistrar.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());

                itemResult.put("result", formerTeammate.id());
                itemResult.put("object", formerTeammateService.buildFormerTeammateResponse(formerTeammate));
            } catch (Exception e) {
                log.error("Error processing request in group", e);
                itemResult.put("result", "error");
                itemResult.put("object", ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage()));
            }
            results.add(itemResult);
        }

        log.debug("Former teammates group processed");
        return ResponseEntity.ok(results);
    }


    @PostMapping("/{id}/resend-sms")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> resendSms(@PathVariable String id) {
        log.debug("Resending SMS to former teammate {}", id);
        var formerTeammate = SMSToFormerTeammateSender.resendSMS(UUID.fromString(id),securityContextService.getCurrentContext());
        log.debug("SMS resent to former teammate {}", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PostMapping("/resend-sms")
    @Transactional
    public ResponseEntity<List<FormerTeammateResponse>> resendSmsForAllWaitingFormerTeammates() {
        log.debug("Resending SMS to all waiting former teammates");
        var formerTeammates = SMSToFormerTeammateSender.resendSMSForAllWaitingFormerTeammates(securityContextService.getCurrentContext());
        log.debug("SMS resent to {} former teammates", formerTeammates.size());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponses(formerTeammates));
    }





    @PostMapping("/{id}/not_requested")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> markAsNotRequested(@PathVariable String id) {
        log.debug("Marking former teammate {} as not requested", id);
        var formerTeammate = formerTeammateNotRequestedMarker.markAsNotRequestedFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        log.debug("Former teammate {} marked as not requested", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> editFormerTeammate(@PathVariable String id,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        log.debug("Editing former teammate {}", formerTeammateRequest);
        var updateFormerTeammate = formerTeammateMapper.toUpdateRequest(id,formerTeammateRequest);
        var formerTeammate = formerTeammateEditor.editFormerTeammate(updateFormerTeammate, securityContextService.getCurrentContext());
        log.debug("Former teammate {} edited", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/validate/{code}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> validateFormerTeammate(@PathVariable String code,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        log.debug("Validating former teammate {}", formerTeammateRequest);
        var validateFormerTeammateRequest = formerTeammateMapper.toValidateRequest(code,formerTeammateRequest);
        var formerTeammate = formerTeammateValidator.valideFormerTeammateByCode(validateFormerTeammateRequest);
        log.debug("Former teammate {} validated", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/{id}/validate")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> validateFormerTeammate(@PathVariable String id) {
        log.debug("Validating former teammate by id {}", id);
        var formerTeammate = formerTeammateValidator.valideFormerTeammateById(id,securityContextService.getCurrentContext());
        log.debug("Former teammate {} validated by id", formerTeammate);
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }


    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates(@RequestParam(required = false) boolean isActive) {
        log.debug("Retrieving all former teammates");
        var formerTeammates = isActive ? formerTeammateRetriever.findAllActiveFormerTeammates()  : formerTeammateRetriever.findAllFormerTeammates();
        var responses = formerTeammateService.buildFormerTeammateResponses(formerTeammates);
        log.debug("Retrieved {} former teammates", responses.size());
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/validate/{code}")
    public ResponseEntity<FormerTeammateResponse> findFormerTeammatesByCode(@PathVariable String code) {
        log.debug("Retrieving former teammate with code {}", code);
        var formerTeammate  = formerTeammateRetriever.findByCode(code);
        var response = formerTeammateService.buildFormerTeammateResponse(formerTeammate);
        log.debug("Retrieved former teammate {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFormerTeammate(@PathVariable String id) {
        log.debug("Removing former teammate {}", id);
        formerTeammateRemover.removeFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        log.debug("Former teammate {} removed", id);
        return ResponseEntity.noContent().build();
    }

}
