package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import fr.hoenheimsports.domain.models.SMSHistory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-09T19:20:05+0200",
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
        sMSHistoryEntity.message( smsHistory.message() );
        sMSHistoryEntity.status( smsHistory.status() );
        sMSHistoryEntity.sentAt( smsHistory.sentAt() );
        sMSHistoryEntity.updatedAt( smsHistory.updatedAt() );
        sMSHistoryEntity.externalId( smsHistory.externalId() );
        sMSHistoryEntity.errorMessage( smsHistory.errorMessage() );

        sMSHistoryEntity.phoneNumber( phoneToString(smsHistory.phoneNumber()) );

        return sMSHistoryEntity.build();
    }

    @Override
    public SMSHistory toModel(SMSHistoryEntity smsHistoryEntity) {
        if ( smsHistoryEntity == null ) {
            return null;
        }

        SMSHistory.Builder sMSHistory = SMSHistory.builder();

        sMSHistory.id( smsHistoryEntity.getId() );
        sMSHistory.formerTeammateId( smsHistoryEntity.getFormerTeammateId() );
        sMSHistory.message( smsHistoryEntity.getMessage() );
        sMSHistory.status( smsHistoryEntity.getStatus() );
        sMSHistory.sentAt( smsHistoryEntity.getSentAt() );
        sMSHistory.updatedAt( smsHistoryEntity.getUpdatedAt() );
        sMSHistory.externalId( smsHistoryEntity.getExternalId() );
        sMSHistory.errorMessage( smsHistoryEntity.getErrorMessage() );

        sMSHistory.phoneNumber( stringToPhone(smsHistoryEntity.getPhoneNumber()) );

        return sMSHistory.build();
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
}
