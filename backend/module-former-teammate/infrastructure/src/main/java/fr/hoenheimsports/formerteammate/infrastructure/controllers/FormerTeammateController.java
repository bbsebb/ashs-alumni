package fr.hoenheimsports.formerteammate.infrastructure.controllers;

import fr.hoenheimsports.formerteammate.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.api.DeleteFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.api.GetAllFormerTeammates;
import fr.hoenheimsports.formerteammate.domain.api.UpdateFormerTeammate;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.UpdateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.CRUDFormerTeammateCommandFactory;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FormerTeammateController {
    private final CreateFormerTeammate createFormerTeammateService;
    private final UpdateFormerTeammate updateFormerTeammateService;
    private final DeleteFormerTeammate deleteFormerTeammateService;
    private final GetAllFormerTeammates getAllFormerTeammatesService;
    private final CRUDFormerTeammateCommandFactory crudFormerTeammateCommandFactory;
    private final FormerTeammateMapper formerTeammateMapper;


    public FormerTeammateController(CreateFormerTeammate createFormerTeammateService, UpdateFormerTeammate updateFormerTeammateService, DeleteFormerTeammate deleteFormerTeammateService, GetAllFormerTeammates getAllFormerTeammatesService, CRUDFormerTeammateCommandFactory crudFormerTeammateCommandFactory, FormerTeammateMapper formerTeammateMapper) {
        this.createFormerTeammateService = createFormerTeammateService;
        this.updateFormerTeammateService = updateFormerTeammateService;
        this.deleteFormerTeammateService = deleteFormerTeammateService;
        this.getAllFormerTeammatesService = getAllFormerTeammatesService;
        this.crudFormerTeammateCommandFactory = crudFormerTeammateCommandFactory;
        this.formerTeammateMapper = formerTeammateMapper;
    }

    @GetMapping("/former-teammmates")
    public ResponseEntity<List<FormerTeammateResponse>> getFormerTeammates() {
        var formerTeammates = this.getAllFormerTeammatesService.execute();
        var responses = this.formerTeammateMapper.toResponseList(formerTeammates);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/former-teammmates")
    ResponseEntity<FormerTeammateResponse> createFormerTeammate(@RequestBody @Valid CreateFormerTeammateRequest createFormerTeammateRequest) {
        var command = crudFormerTeammateCommandFactory.createFrom(createFormerTeammateRequest);
        var createdFormerTeammate = this.createFormerTeammateService.execute(command);
        var response = this.formerTeammateMapper.toResponse(createdFormerTeammate);
        var location = URI.create("/api/former-teammates/" + response.id());
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/former-teammmates/{id}")
    ResponseEntity<FormerTeammateResponse> updateFormerTeammate(@PathVariable("id") UUID id, @RequestBody @Valid UpdateFormerTeammateRequest updateFormerTeammateRequest) {
        var command = crudFormerTeammateCommandFactory.createFrom(updateFormerTeammateRequest, id);
        var updatedFormerTeammate = this.updateFormerTeammateService.execute(command);
        var response = this.formerTeammateMapper.toResponse(updatedFormerTeammate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/former-teammmates/{id}")
    ResponseEntity<Void> deleteFormerTeammate(@PathVariable("id") UUID id) {
        deleteFormerTeammateService.execute(id);
        return ResponseEntity.noContent().build();
    }
}
