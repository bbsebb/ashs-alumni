package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.usecases.commands.CreateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.CreateFormerTeammateRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateFormerTeammateCommandFactory {

    public CreateFormerTeammateCommand createFrom(CreateFormerTeammateRequest request) {

        return new CreateFormerTeammateCommand(
                request.gender(),
                request.firstName().trim(),
                request.lastName().trim(),
                request.phone(),
                request.birthDate(),
                request.roles()
        );
    }


}

