package fr.hoenheimsports.formerteammate.domain;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.api.UpdateFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.commands.UpdateFormerTeammateCommand;
import fr.hoenheimsports.formerteammate.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;

@DomainService
public class FormerTeammateUpdater implements UpdateFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;

    public FormerTeammateUpdater(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    @Override
    public FormerTeammate execute(UpdateFormerTeammateCommand updateFormerTeammateCommand) {
        FormerTeammate formerTeammate = this.updateFormerTeammate(updateFormerTeammateCommand);
        formerTeammateRepository.save(formerTeammate);
        return formerTeammate;
    }

    private FormerTeammate updateFormerTeammate(UpdateFormerTeammateCommand updateFormerTeammateCommand) {
        var oldFormerTeammate = formerTeammateRepository.findById(updateFormerTeammateCommand.id()).orElseThrow(() -> new FormerTeammateNotFoundException("Former teammate with id " + updateFormerTeammateCommand.id() + " does not exist"));
        return FormerTeammate.builder()
                .id(updateFormerTeammateCommand.id())
                .firstName(updateFormerTeammateCommand.firstName())
                .lastName(updateFormerTeammateCommand.lastName())
                .gender(updateFormerTeammateCommand.gender())
                .phone(updateFormerTeammateCommand.phone())
                .birthDate(updateFormerTeammateCommand.birthDate())
                .roles(updateFormerTeammateCommand.roles())
                .status(oldFormerTeammate.status())
                .build();
    }
}
