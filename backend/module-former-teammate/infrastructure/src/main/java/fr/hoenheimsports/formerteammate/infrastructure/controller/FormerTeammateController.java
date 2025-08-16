package fr.hoenheimsports.formerteammate.infrastructure.controller;

import fr.hoenheimsports.formerteammate.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import fr.hoenheimsports.formerteammate.domain.usecases.commands.CreateFormerTeammateCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FormerTeammateController {
    private final CreateFormerTeammate createFormerTeammateService;

    public FormerTeammateController(CreateFormerTeammate createFormerTeammateService) {
        this.createFormerTeammateService = createFormerTeammateService;
    }

    @GetMapping("/former-teammmates")
    public FormerTeammate getFormerTeammates() {
        CreateFormerTeammateCommand command = new CreateFormerTeammateCommand(
                Gender.M,
                "John",
                "Doe",
                "1234567890",
                LocalDate.of(1990, 1, 1),
                List.of(Role.PLAYER, Role.COACH)
        );

        return this.createFormerTeammateService.execute(command);
    }
}
