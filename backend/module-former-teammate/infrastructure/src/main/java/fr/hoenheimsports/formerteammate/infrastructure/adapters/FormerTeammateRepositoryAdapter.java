package fr.hoenheimsports.formerteammate.infrastructure.adapters;

import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import fr.hoenheimsports.formerteammate.infrastructure.mappers.FormerTeammateMapper;
import fr.hoenheimsports.formerteammate.infrastructure.repository.FormerTeammateEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FormerTeammateRepositoryAdapter implements FormerTeammateRepository {

    private final FormerTeammateEntityRepository entityRepository;
    private final FormerTeammateMapper mapper;

    public FormerTeammateRepositoryAdapter(FormerTeammateEntityRepository entityRepository, FormerTeammateMapper mapper) {
        this.entityRepository = entityRepository;
        this.mapper = mapper;
    }

    @Override
    public void save(FormerTeammate formerTeammate) {
        FormerTeammateEntity entity = mapper.toEntity(formerTeammate);
        entityRepository.save(entity);
    }

    @Override
    public List<FormerTeammate> findAll() {
        return entityRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteAll() {
        entityRepository.deleteAll();
    }

    @Override
    public Optional<FormerTeammate> findById(UUID id) {
        return entityRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        entityRepository.deleteById(id);
    }

}