package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.BindUserId;
import fr.hoenheimsports.domain.exceptions.FormerTeammateNotFoundException;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;

import java.util.UUID;

@DomainService
public class UserIdBinder implements BindUserId {
    private final FormerTeammateRepository formerTeammateRepository;

    public UserIdBinder(FormerTeammateRepository formerTeammateRepository) {
        this.formerTeammateRepository = formerTeammateRepository;
    }

    @Override
    public FormerTeammate bind(String userId, String formerTeammateId) {
        var formerTeammate = this.formerTeammateRepository.findById(UUID.fromString(formerTeammateId)).orElseThrow(() -> new FormerTeammateNotFoundException("L'entité Contact à modifier n'a pas été trouvée"));
        formerTeammate = formerTeammate.withContactKcUserId(UUID.fromString(userId));
        return this.formerTeammateRepository.save(formerTeammate);
    }
}
