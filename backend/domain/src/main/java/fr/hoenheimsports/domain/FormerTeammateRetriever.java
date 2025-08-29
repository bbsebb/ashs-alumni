package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.GetAllFormerTeammates;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

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
