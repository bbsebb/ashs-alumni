package fr.hoenheimsports.formerteammate.infrastructure.controllers;

import fr.hoenheimsports.formerteammate.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.api.GetAllFormerTeammates;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.CreateFormerTeammateCommandFactory;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FormerTeammateController {
    private final CreateFormerTeammate createFormerTeammateService;
    private final GetAllFormerTeammates getAllFormerTeammatesService;
    private final CreateFormerTeammateCommandFactory createFormerTeammateCommandFactory;
    private final FormerTeammateMapper formerTeammateMapper;

    public FormerTeammateController(CreateFormerTeammate createFormerTeammateService, GetAllFormerTeammates getAllFormerTeammatesService, CreateFormerTeammateCommandFactory createFormerTeammateCommandFactory, FormerTeammateMapper formerTeammateMapper) {
        this.createFormerTeammateService = createFormerTeammateService;
        this.getAllFormerTeammatesService = getAllFormerTeammatesService;
        this.createFormerTeammateCommandFactory = createFormerTeammateCommandFactory;
        this.formerTeammateMapper = formerTeammateMapper;
    }

    @GetMapping("/former-teammmates")
    public ResponseEntity<List<FormerTeammateResponse>> getFormerTeammates() {
        var formerTeammates = this.getAllFormerTeammatesService.execute();
        var responses = this.formerTeammateMapper.toResponseList(formerTeammates);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/former-teammmates")
    ResponseEntity<FormerTeammateResponse> createFormerTeammate(@RequestBody CreateFormerTeammateRequest createFormerTeammateRequest) {
        var command = createFormerTeammateCommandFactory.createFrom(createFormerTeammateRequest);
        var createdFormerTeammate = this.createFormerTeammateService.execute(command);
        var response = this.formerTeammateMapper.toResponse(createdFormerTeammate);
        var location = URI.create("/api/former-teammates/" + createdFormerTeammate.id());
        return ResponseEntity.created(location).body(response);
    }
}
