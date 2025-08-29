package fr.hoenheimsports.app.controllers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.services.SecurityContextService;
import fr.hoenheimsports.domain.FormerTeammateRetriever;
import fr.hoenheimsports.domain.api.FormerTeammateRegistrar;
import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/former-teammates")
public class FormerTeammateController {

    private final FormerTeammateRegistrar formerTeammateRegistrar;
    private final FormerTeammateRetriever formerTeammateRetriever;
    private final FormerTeammateMapper formerTeammateMapper;
    private final SecurityContextService securityContextService;

    public FormerTeammateController(FormerTeammateRegistrar formerTeammateRegistrar, FormerTeammateRetriever formerTeammateRetriever, FormerTeammateMapper formerTeammateMapper, SecurityContextService securityContextService) {
        this.formerTeammateRegistrar = formerTeammateRegistrar;
        this.formerTeammateRetriever = formerTeammateRetriever;
        this.formerTeammateMapper = formerTeammateMapper;
        this.securityContextService = securityContextService;
    }

    @PostMapping()
    public ResponseEntity<FormerTeammateResponse> registerFormerTeammate(@RequestBody @Valid FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationCommand = formerTeammateMapper.toCommand(formerTeammateRequest);
        var formerTeammate = formerTeammateRegistrar.registerFormerTeammate(formerTeammateRegistrationCommand, securityContextService.getCurrentContext());
        return ResponseEntity.ok(formerTeammateMapper.toResponse(formerTeammate));
    }

    @GetMapping()
    public ResponseEntity<List<FormerTeammateResponse>> findAllFormerTeammates() {
        var formerTeammate = formerTeammateRetriever.execute();
        return ResponseEntity.ok(formerTeammateMapper.toResponseList(formerTeammate));
    }
}
