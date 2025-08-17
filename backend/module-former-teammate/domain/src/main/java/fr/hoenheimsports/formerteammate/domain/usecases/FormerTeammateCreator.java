package fr.hoenheimsports.formerteammate.domain.usecases;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.api.CreateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.domain.spi.GenerateId;
import fr.hoenheimsports.formerteammate.domain.usecases.commands.CreateFormerTeammateCommand;

@DomainService
public class FormerTeammateCreator implements CreateFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;
    private final GenerateId generateId;

    public FormerTeammateCreator(FormerTeammateRepository formerTeammateRepository, GenerateId generateId) {
        this.formerTeammateRepository = formerTeammateRepository;
        this.generateId = generateId;
    }

    @Override
    public FormerTeammate execute(CreateFormerTeammateCommand createFormerTeammateCommand) {
        FormerTeammate formerTeammate = this.createFormerTeammate(createFormerTeammateCommand);
        formerTeammateRepository.save(formerTeammate);
        return formerTeammate;
    }

    private FormerTeammate createFormerTeammate(CreateFormerTeammateCommand createFormerTeammateCommand) {
        return FormerTeammate.builder()
                .id(this.generateId.generate())
                .firstName(createFormerTeammateCommand.firstName())
                .lastName(createFormerTeammateCommand.lastName())
                .gender(createFormerTeammateCommand.gender())
                .phone(createFormerTeammateCommand.phone())
                .birthDate(createFormerTeammateCommand.birthDate())
                .roles(createFormerTeammateCommand.roles())
                .status(this.generateStatus())
                .build();
    }


    private ContactStatus generateStatus() {
        return ContactStatus.SUBMITTED;
    }
}
