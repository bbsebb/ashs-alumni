package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.UseCase;
import fr.hoenheimsports.domain.api.GetFormerTeammates;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.List;

@UseCase
public class FormerTeammateRetriever implements GetFormerTeammates {
    private final FormerTeammateRepository formerTeammateRepository;

    public FormerTeammateRetriever(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    @Override
    public List<FormerTeammate> findAllFormerTeammates() {
        return this.formerTeammateRepository.findAll();
    }

    @Override
    public List<FormerTeammate> findAllActiveFormerTeammates() {
        return this.formerTeammateRepository.findAllActiveFormerTeammates();
    }

    @Override
    public FormerTeammate findByCode(String code) {
        return this.formerTeammateRepository.findByCode(code).orElseThrow(() -> new FormerTeammateNotFoundException("Le code de validation est invalide ou inconnu"));
    }

}
