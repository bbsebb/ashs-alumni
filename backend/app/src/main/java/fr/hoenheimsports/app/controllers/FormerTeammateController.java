package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
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
    private final SecurityContextService securityContextService;

    public FormerTeammateController(RegisterFormerTeammate registerFormerTeammate, FormerTeammateRetriever formerTeammateRetriever, FormerTeammateMapper formerTeammateMapper, SecurityContextService securityContextService) {
        this.registerFormerTeammate = registerFormerTeammate;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.securityContextService = securityContextService;
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationCommand = formerTeammateMapper.toCommand(formerTeammateRequest);
        var formerTeammate = registerFormerTeammate.registerFormerTeammate(formerTeammateRegistrationCommand, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateMapper.toResponse(formerTeammate));
    }

    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates() {
        var formerTeammate = formerTeammateRetriever.execute();
        return ResponseEntity.ok(formerTeammateMapper.toResponseList(formerTeammate));
    }
}
