package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.services.FormerTeammateService;
import fr.hoenheimsports.app.services.SecurityContextService;
import fr.hoenheimsports.domain.FormerTeammateRetriever;
import fr.hoenheimsports.domain.api.EditFormerTeammate;
import fr.hoenheimsports.domain.api.GetFormerTeammates;
import fr.hoenheimsports.domain.api.RegisterFormerTeammate;
import fr.hoenheimsports.domain.api.RemoveFormerTeammate;
import fr.hoenheimsports.domain.models.HistoryAction;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/former-teammates")
public class FormerTeammateController {

    private final RegisterFormerTeammate registerFormerTeammate;
    private final EditFormerTeammate editFormerTeammate;
    private final GetFormerTeammates formerTeammateRetriever;
    private final FormerTeammateMapper formerTeammateMapper;
    private final FormerTeammateService formerTeammateService;
    private final SecurityContextService securityContextService;
    private final RemoveFormerTeammate removeFormerTeammate;

    public FormerTeammateController(RegisterFormerTeammate registerFormerTeammate, EditFormerTeammate editFormerTeammate,
                                    FormerTeammateRetriever formerTeammateRetriever,
                                    FormerTeammateMapper formerTeammateMapper,
                                    FormerTeammateService formerTeammateService,
                                    SecurityContextService securityContextService, RemoveFormerTeammate removeFormerTeammate) {
        this.registerFormerTeammate = registerFormerTeammate;
        this.editFormerTeammate = editFormerTeammate;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.formerTeammateService = formerTeammateService;
        this.securityContextService = securityContextService;
        this.removeFormerTeammate = removeFormerTeammate;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(formerTeammateRequest);
        var formerTeammate = registerFormerTeammate.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FormerTeammateResponse> editFormerTeammate(@PathVariable String id,@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var updateFormerTeammate = formerTeammateMapper.toUpdateRequest(id,formerTeammateRequest);
        var formerTeammate = editFormerTeammate.editFormerTeammate(updateFormerTeammate, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates(@RequestParam(required = false) boolean isActive) {
        var formerTeammates = isActive ? formerTeammateRetriever.findAllActiveFormerTeammates()  : formerTeammateRetriever.findAllFormerTeammates();
        var responses = formerTeammateService.buildFormerTeammateResponses(formerTeammates);
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFormerTeammate(@PathVariable String id) {
        removeFormerTeammate.removeFormerTeammate(UUID.fromString(id),securityContextService.getCurrentContext());
        return ResponseEntity.noContent().build();
    }

}
