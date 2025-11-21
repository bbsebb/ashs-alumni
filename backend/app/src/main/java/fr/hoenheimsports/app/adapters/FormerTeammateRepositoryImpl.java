package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.mappers.FormerTeammateMapper;
import fr.hoenheimsports.app.repositories.FormerTeammateEntityRepository;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class FormerTeammateRepositoryImpl implements FormerTeammateRepository {
    private final FormerTeammateEntityRepository formerTeammateEntityRepository;
private final FormerTeammateMapper formerTeammateMapper;
    public FormerTeammateRepositoryImpl(FormerTeammateEntityRepository formerTeammateEntityRepository, FormerTeammateMapper formerTeammateMapper) {
        this.formerTeammateEntityRepository = formerTeammateEntityRepository;
        this.formerTeammateMapper = formerTeammateMapper;
    }

    @Override
    public FormerTeammate save(FormerTeammate formerTeammate) {
        log.info("Saving former teammate {}", formerTeammate);
        var formerTeammateEntity = formerTeammateMapper.toEntity(formerTeammate);
        return formerTeammateMapper.toModel(formerTeammateEntityRepository.save(formerTeammateEntity));
    }

    @Override
    public List<FormerTeammate> findAll() {
        log.info("Retrieving all former teammates");
        var formerTeammateEntities = formerTeammateEntityRepository.findAll();
        return formerTeammateEntities.stream().map(formerTeammateMapper::toModel).toList();
    }

    @Override
    public List<FormerTeammate> findAllActiveFormerTeammates() {
        log.info("Retrieving all active former teammates");
        return formerTeammateEntityRepository.findAllActiveFormerTeammate().stream().map(formerTeammateMapper::toModel).toList();
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all former teammates");
        formerTeammateEntityRepository.deleteAll();
    }

    @Override
    public Optional<FormerTeammate> findById(UUID id) {
        log.info("Retrieving former teammate with id {}", id);
        var formerTeammateEntity = formerTeammateEntityRepository.findById(id);
        return formerTeammateEntity.map(formerTeammateMapper::toModel);
    }

    @Override
    public Optional<FormerTeammate> findByCode(String code) {
        log.info("Retrieving former teammate with code {}", code);
        var formerTeammateEntity = formerTeammateEntityRepository.findByCode((code));
        return formerTeammateEntity.map(formerTeammateMapper::toModel);
    }

    @Override
    public void deleteById(UUID id) {
        log.info("Deleting former teammate with id {}", id);
        formerTeammateEntityRepository.deleteById(id);
    }

    @Override
    public Optional<FormerTeammate> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName) {
        log.info("Retrieving former teammate with first name {} and last name {}", firstName, lastName);
        return formerTeammateEntityRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName,lastName).map(formerTeammateMapper::toModel);
    }

    @Override
    public Optional<FormerTeammate> findByPhone(String phone) {
        log.info("Retrieving former teammate with phone {}", phone);
        return formerTeammateEntityRepository.findByPhone(phone).map(formerTeammateMapper::toModel);
    }


}
