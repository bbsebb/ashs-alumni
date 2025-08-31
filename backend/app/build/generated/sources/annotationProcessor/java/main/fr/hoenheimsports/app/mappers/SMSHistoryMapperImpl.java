package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-31T21:50:23+0200",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 24.0.1 (Eclipse Adoptium)"
)
@Component
public class SMSHistoryMapperImpl implements SMSHistoryMapper {

    @Override
    public SMSHistoryEntity toEntity(SMSHistory smsHistory) {
        if ( smsHistory == null ) {
            return null;
        }

        SMSHistoryEntity.SMSHistoryEntityBuilder sMSHistoryEntity = SMSHistoryEntity.builder();

        sMSHistoryEntity.id( smsHistory.id() );
        sMSHistoryEntity.formerTeammateId( smsHistory.formerTeammateId() );
        sMSHistoryEntity.phoneNumber( smsHistory.phoneNumber() );
        sMSHistoryEntity.message( smsHistory.message() );
        sMSHistoryEntity.status( smsHistory.status() );
        sMSHistoryEntity.sentAt( smsHistory.sentAt() );
        sMSHistoryEntity.updatedAt( smsHistory.updatedAt() );
        sMSHistoryEntity.externalId( smsHistory.externalId() );
        sMSHistoryEntity.errorMessage( smsHistory.errorMessage() );

        return sMSHistoryEntity.build();
    }

    @Override
    public SMSHistory toModel(SMSHistoryEntity smsHistoryEntity) {
        if ( smsHistoryEntity == null ) {
            return null;
        }

        UUID id = null;
        UUID formerTeammateId = null;
        String phoneNumber = null;
        String message = null;
        SMSStatus status = null;
        Instant sentAt = null;
        Instant updatedAt = null;
        String externalId = null;
        String errorMessage = null;

        id = smsHistoryEntity.getId();
        formerTeammateId = smsHistoryEntity.getFormerTeammateId();
        phoneNumber = smsHistoryEntity.getPhoneNumber();
        message = smsHistoryEntity.getMessage();
        status = smsHistoryEntity.getStatus();
        sentAt = smsHistoryEntity.getSentAt();
        updatedAt = smsHistoryEntity.getUpdatedAt();
        externalId = smsHistoryEntity.getExternalId();
        errorMessage = smsHistoryEntity.getErrorMessage();

        SMSHistory sMSHistory = new SMSHistory( id, formerTeammateId, phoneNumber, message, status, sentAt, updatedAt, externalId, errorMessage );

        return sMSHistory;
    }

    @Override
    public List<SMSHistory> toModelList(List<SMSHistoryEntity> smsHistoryEntities) {
        if ( smsHistoryEntities == null ) {
            return null;
        }

        List<SMSHistory> list = new ArrayList<SMSHistory>( smsHistoryEntities.size() );
        for ( SMSHistoryEntity sMSHistoryEntity : smsHistoryEntities ) {
            list.add( toModel( sMSHistoryEntity ) );
        }

        return list;
    }

    @Override
    public List<SMSHistoryEntity> toEntityList(List<SMSHistory> smsHistories) {
        if ( smsHistories == null ) {
            return null;
        }

        List<SMSHistoryEntity> list = new ArrayList<SMSHistoryEntity>( smsHistories.size() );
        for ( SMSHistory sMSHistory : smsHistories ) {
            list.add( toEntity( sMSHistory ) );
        }

        return list;
    }
}
