package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.services.FormerTeammateService;
import fr.hoenheimsports.app.services.SecurityContextService;
import fr.hoenheimsports.domain.FormerTeammateRetriever;
import fr.hoenheimsports.domain.api.RegisterFormerTeammate;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/former-teammates")
public class FormerTeammateController {

    private final RegisterFormerTeammate registerFormerTeammate;
    private final FormerTeammateRetriever formerTeammateRetriever;
    private final FormerTeammateMapper formerTeammateMapper;
    private final FormerTeammateService formerTeammateService;
    private final SecurityContextService securityContextService;

    public FormerTeammateController(RegisterFormerTeammate registerFormerTeammate, 
                                  FormerTeammateRetriever formerTeammateRetriever, 
                                  FormerTeammateMapper formerTeammateMapper, 
                                  FormerTeammateService formerTeammateService, 
                                  SecurityContextService securityContextService) {
        this.registerFormerTeammate = registerFormerTeammate;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.formerTeammateService = formerTeammateService;
        this.securityContextService = securityContextService;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationRequest = formerTeammateMapper.toRegistrationRequest(formerTeammateRequest);

        var formerTeammate = registerFormerTeammate.registerFormerTeammate(formerTeammateRegistrationRequest, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateService.buildFormerTeammateResponse(formerTeammate));
    }

    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates() {
        var formerTeammates = formerTeammateRetriever.findAllFormerTeammates();
        var responses = formerTeammateService.buildFormerTeammateResponses(formerTeammates);
        return ResponseEntity.ok(responses);
    }

}
