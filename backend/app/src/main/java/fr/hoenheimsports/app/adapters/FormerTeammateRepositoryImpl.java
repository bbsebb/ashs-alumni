package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.repositories.FormerTeammateEntityRepository;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FormerTeammateRepositoryImpl implements FormerTeammateRepository {
    private final FormerTeammateEntityRepository formerTeammateEntityRepository;
private final FormerTeammateMapper formerTeammateMapper;
    public FormerTeammateRepositoryImpl(FormerTeammateEntityRepository formerTeammateEntityRepository, FormerTeammateMapper formerTeammateMapper) {
        this.formerTeammateEntityRepository = formerTeammateEntityRepository;
        this.formerTeammateMapper = formerTeammateMapper;
    }

    @Override
    public FormerTeammate save(FormerTeammate formerTeammate) {
        var formerTeammateEntity = formerTeammateMapper.toEntity(formerTeammate);
        return formerTeammateMapper.toModel(formerTeammateEntityRepository.save(formerTeammateEntity));
    }

    @Override
    public List<FormerTeammate> findAll() {
        var formerTeammateEntities = formerTeammateEntityRepository.findAll();
        return formerTeammateEntities.stream().map(formerTeammateMapper::toModel).toList();
    }

    @Override
    public void deleteAll() {
        formerTeammateEntityRepository.deleteAll();
    }

    @Override
    public Optional<FormerTeammate> findById(UUID id) {
        var formerTeammateEntity = formerTeammateEntityRepository.findById(id);
        return formerTeammateEntity.map(formerTeammateMapper::toModel);
    }

    @Override
    public void deleteById(UUID id) {
        formerTeammateEntityRepository.deleteById(id);
    }

    @Override
    public Optional<FormerTeammate> findByFirstNameAndLastName(String firstName, String lastName) {
        return formerTeammateEntityRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAllIgnoreCase(firstName,lastName).map(formerTeammateMapper::toModel);
    }

    @Override
    public Optional<FormerTeammate> findByPhone(String phone) {
        return formerTeammateEntityRepository.findByPhone(phone).map(formerTeammateMapper::toModel);
    }
}
