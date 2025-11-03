package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.SMSHistoryResponse;
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
    date = "2025-10-28T19:26:30+0100",
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
    public SMSHistoryResponse toResponse(SMSHistory smsHistory) {
        if ( smsHistory == null ) {
            return null;
        }

        UUID id = null;
        UUID formerTeammateId = null;
        String message = null;
        SMSStatus status = null;
        Instant sentAt = null;
        Instant updatedAt = null;
        String externalId = null;
        String errorMessage = null;

        id = smsHistory.id();
        formerTeammateId = smsHistory.formerTeammateId();
        message = smsHistory.message();
        status = smsHistory.status();
        sentAt = smsHistory.sentAt();
        updatedAt = smsHistory.updatedAt();
        externalId = smsHistory.externalId();
        errorMessage = smsHistory.errorMessage();

        String phoneNumber = phoneToMaskedString(smsHistory.phoneNumber());

        SMSHistoryResponse sMSHistoryResponse = new SMSHistoryResponse( id, formerTeammateId, phoneNumber, message, status, sentAt, updatedAt, externalId, errorMessage );

        return sMSHistoryResponse;
    }

    @Override
    public List<SMSHistoryResponse> toResponseList(List<SMSHistory> smsHistories) {
        if ( smsHistories == null ) {
            return null;
        }

        List<SMSHistoryResponse> list = new ArrayList<SMSHistoryResponse>( smsHistories.size() );
        for ( SMSHistory sMSHistory : smsHistories ) {
            list.add( toResponse( sMSHistory ) );
        }

        return list;
    }
}
