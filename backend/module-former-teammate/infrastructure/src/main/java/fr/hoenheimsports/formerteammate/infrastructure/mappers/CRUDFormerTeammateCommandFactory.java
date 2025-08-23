package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.commands.CreateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.commands.UpdateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.UpdateFormerTeammateRequest;
import fr.hoenheimsports.user.domain.models.CurrentUser;
import fr.hoenheimsports.user.domain.models.Role;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CRUDFormerTeammateCommandFactory {


    public CreateFormerTeammateCommand createFrom(CreateFormerTeammateRequest request, Optional<CurrentUser> currentUser) {
        var isAdmin = currentUser.map((cu) -> cu.roles().contains(Role.ADMIN)).orElse(false);
        return new CreateFormerTeammateCommand(
                request.gender(),
                request.firstName().trim(),
                request.lastName().trim(),
                request.phone(),
                request.birthDate(),
                request.roles(),
                currentUser.isPresent(),
                isAdmin

        );
    }

    public UpdateFormerTeammateCommand createFrom(UpdateFormerTeammateRequest request, UUID id) {
        return new UpdateFormerTeammateCommand(
                id,
                request.gender(),
                request.firstName().trim(),
                request.lastName().trim(),
                request.phone(),
                request.birthDate(),
                request.roles()
        );
    }


}

