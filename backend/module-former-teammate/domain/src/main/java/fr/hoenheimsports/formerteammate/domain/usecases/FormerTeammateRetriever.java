package fr.hoenheimsports.formerteammate.domain.usecases;

import fr.hoenheimsports.formerteammate.domain.annotations.DomainService;
import fr.hoenheimsports.formerteammate.domain.api.GetAllFormerTeammates;
import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;

import java.util.List;

@DomainService
public class FormerTeammateRetriever implements GetAllFormerTeammates {
    private final FormerTeammateRepository formerTeammateRepository;

    public FormerTeammateRetriever(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    @Override
    public List<FormerTeammate> execute() {
        return this.formerTeammateRepository.findAll();
    }
}
