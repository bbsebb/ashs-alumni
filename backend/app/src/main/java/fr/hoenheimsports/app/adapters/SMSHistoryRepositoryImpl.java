package fr.hoenheimsports.app.adapters;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import fr.hoenheimsports.app.mappers.SMSHistoryMapper;
import fr.hoenheimsports.app.repositories.SMSHistoryEntityRepository;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.spi.SMSHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SMSHistoryRepositoryImpl implements SMSHistoryRepository {
    private final SMSHistoryEntityRepository smsHistoryEntityRepository;
    private final SMSHistoryMapper smsHistoryMapper;

    public SMSHistoryRepositoryImpl(SMSHistoryEntityRepository smsHistoryEntityRepository, SMSHistoryMapper smsHistoryMapper) {
        this.smsHistoryEntityRepository = smsHistoryEntityRepository;
        this.smsHistoryMapper = smsHistoryMapper;
    }

    @Override
    public void save(SMSHistory smsHistory) {

        // Vérifie si l'entité existe déjà
        var existingEntity = smsHistoryEntityRepository.findById(smsHistory.id());

        if (existingEntity.isPresent()) {
            // Met à jour l'entité existante pour préserver la relation formerTeammate
            var entityToUpdate = existingEntity.get();
            updateExistingEntity(entityToUpdate, smsHistory);
            smsHistoryEntityRepository.save(entityToUpdate);
        } else {
            // Nouvelle entité
            smsHistoryEntityRepository.save(smsHistoryMapper.toEntity(smsHistory));
        }

    }

    /**
     * Met à jour une entité existante avec les données du modèle domain,
     * en préservant les relations JPA existantes.
     */
    private void updateExistingEntity(SMSHistoryEntity entity, SMSHistory smsHistory) {
        // Met à jour seulement les champs modifiables, pas la relation formerTeammate
        entity.setFormerTeammateId(smsHistory.formerTeammateId());
        entity.setPhoneNumber(smsHistory.phoneNumber().value());
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
        return smsHistoryEntityRepository.findByExternalId(externalId).map(smsHistoryMapper::toModel);
    }

    @Override
    public List<SMSHistory> findAllSMSHistoryByFormerTeammateId(UUID formerTeammateId) {
       return smsHistoryEntityRepository.findByFormerTeammateId(formerTeammateId).stream().map(smsHistoryMapper::toModel).toList();
    }
}
