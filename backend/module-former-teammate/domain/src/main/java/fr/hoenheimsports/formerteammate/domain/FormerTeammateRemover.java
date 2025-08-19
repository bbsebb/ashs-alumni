package fr.hoenheimsports.formerteammate.domain;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.api.DeleteFormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;

import java.util.UUID;

@DomainService
public class FormerTeammateRemover implements DeleteFormerTeammate {
    private final FormerTeammateRepository formerTeammateRepository;

    public FormerTeammateRemover(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    @Override
    public void execute(UUID id) {
        formerTeammateRepository.deleteById(id);
    }
}
