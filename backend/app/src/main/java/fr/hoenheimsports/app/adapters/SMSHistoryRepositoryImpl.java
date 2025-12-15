package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import fr.hoenheimsports.app.mappers.SMSHistoryMapper;
import fr.hoenheimsports.app.repositories.SMSHistoryEntityRepository;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class SMSHistoryRepositoryImpl implements SMSHistoryRepository {
    private final SMSHistoryEntityRepository smsHistoryEntityRepository;
    private final SMSHistoryMapper smsHistoryMapper;

    public SMSHistoryRepositoryImpl(SMSHistoryEntityRepository smsHistoryEntityRepository, SMSHistoryMapper smsHistoryMapper) {
        this.smsHistoryEntityRepository = smsHistoryEntityRepository;
        this.smsHistoryMapper = smsHistoryMapper;
    }

    @Override
    public void save(SMSHistory smsHistory) {
        log.debug("Saving SMS history {}", smsHistory);
        // Vérifie si l'entité existe déjà
        var existingEntity = smsHistoryEntityRepository.findById(smsHistory.id());
        SMSHistoryEntity smsHistoryEntity;
        if (existingEntity.isPresent()) {
            log.debug("Entity already exists, updating it");
            // Met à jour l'entité existante pour préserver la relation formerTeammate
            var entityToUpdate = existingEntity.get();
            updateExistingEntity(entityToUpdate, smsHistory);
            smsHistoryEntity = smsHistoryEntityRepository.save(entityToUpdate);
        } else {
            log.debug("Entity does not exist, creating it");
            // Nouvelle entité
            smsHistoryEntity =smsHistoryEntityRepository.save(smsHistoryMapper.toEntity(smsHistory));
        }
        log.debug("SMS history saved {}", smsHistoryEntity);
    }

    /**
     * Met à jour une entité existante avec les données du modèle domain,
     * en préservant les relations JPA existantes.
     */
    private void updateExistingEntity(SMSHistoryEntity entity, SMSHistory smsHistory) {
        log.debug("Updating existing entity {}", entity);
        // Met à jour seulement les champs modifiables, pas la relation formerTeammate
        entity.setFormerTeammateId(smsHistory.formerTeammateId());
        entity.setPhoneNumber(smsHistory.phoneNumber().phoneNumber());
        entity.setMessage(smsHistory.message());
        entity.setStatus(smsHistory.status());
        entity.setSentAt(smsHistory.sentAt());
        entity.setUpdatedAt(smsHistory.updatedAt());
        entity.setExternalId(smsHistory.externalId());
        entity.setErrorMessage(smsHistory.errorMessage());
        // Note : formerTeammate n'est pas modifié, préservant la relation existante
    }


    @Override
    public Optional<SMSHistory> findByExternalID(String externalId) {
        log.debug("Retrieving SMS history with external id {}", externalId);
        var smsHistoryOptional = smsHistoryEntityRepository.findByExternalId(externalId).map(smsHistoryMapper::toModel);
        log.debug("SMS history retrieved {}", smsHistoryOptional);
        return smsHistoryOptional;
    }

    @Override
    public List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId) {
        log.debug("Retrieving all SMS history by former teammate id {}", formerTeammateId);
        List<SMSHistory> smsHistoryList = smsHistoryEntityRepository.findByFormerTeammateId(formerTeammateId).stream().map(smsHistoryMapper::toModel).toList();
        log.debug("SMS histories by former teammate id retrieved {}", smsHistoryList);
        return smsHistoryList;
    }

    @Override
    public List<SMSHistory> findAllSMSHistoryByPhoneNumber(Phone phoneNumber) {
        log.debug("Retrieving all SMS history by phone number {}", phoneNumber);
        List<SMSHistory> smsHistoryList = smsHistoryEntityRepository.findAllByPhoneNumber(phoneNumber.getRawValue()).stream().map(smsHistoryMapper::toModel).toList();
        log.debug("SMS histories by phone retrieved {}", smsHistoryList);
        return smsHistoryList;
    }
}
