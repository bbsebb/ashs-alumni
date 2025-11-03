package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateHistoryResponse;
import fr.hoenheimsports.app.entities.FormerTeammateHistoryEntity;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.models.Role;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class FormerTeammateHistoryMapperImpl implements FormerTeammateHistoryMapper {

    @Override
    public FormerTeammateHistoryEntity toEntity(FormerTeammateHistory formerTeammateHistory) {
        if ( formerTeammateHistory == null ) {
            return null;
        }

        FormerTeammateHistoryEntity.FormerTeammateHistoryEntityBuilder formerTeammateHistoryEntity = FormerTeammateHistoryEntity.builder();

        formerTeammateHistoryEntity.id( formerTeammateHistory.id() );
        formerTeammateHistoryEntity.formerTeammateId( formerTeammateHistory.formerTeammateId() );
        formerTeammateHistoryEntity.emailAtTime( map( formerTeammateHistory.emailAtTime() ) );
        formerTeammateHistoryEntity.birthDateAtTime( map( formerTeammateHistory.birthDateAtTime() ) );
        List<Role> list = formerTeammateHistory.rolesAtTime();
        if ( list != null ) {
            formerTeammateHistoryEntity.rolesAtTime( new ArrayList<Role>( list ) );
        }
        formerTeammateHistoryEntity.statusAtTime( formerTeammateHistory.statusAtTime() );
        formerTeammateHistoryEntity.updatedAt( formerTeammateHistory.updatedAt() );
        formerTeammateHistoryEntity.historyAction( formerTeammateHistory.historyAction() );
        formerTeammateHistoryEntity.updatedBy( formerTeammateHistory.updatedBy() );
        formerTeammateHistoryEntity.description( formerTeammateHistory.description() );

        formerTeammateHistoryEntity.phoneAtTime( optionalPhoneToString(formerTeammateHistory.phoneAtTime()) );

        return formerTeammateHistoryEntity.build();
    }

    @Override
    public FormerTeammateHistory toModel(FormerTeammateHistoryEntity formerTeammateHistoryEntity) {
        if ( formerTeammateHistoryEntity == null ) {
            return null;
        }

        FormerTeammateHistory.Builder formerTeammateHistory = FormerTeammateHistory.builder();

        formerTeammateHistory.id( formerTeammateHistoryEntity.getId() );
        formerTeammateHistory.formerTeammateId( formerTeammateHistoryEntity.getFormerTeammateId() );
        formerTeammateHistory.phoneAtTime( map( formerTeammateHistoryEntity.getPhoneAtTime() ) );
        formerTeammateHistory.emailAtTime( formerTeammateHistoryEntity.getEmailAtTime() );
        formerTeammateHistory.birthDateAtTime( formerTeammateHistoryEntity.getBirthDateAtTime() );
        List<Role> list = formerTeammateHistoryEntity.getRolesAtTime();
        if ( list != null ) {
            formerTeammateHistory.rolesAtTime( new ArrayList<Role>( list ) );
        }
        formerTeammateHistory.statusAtTime( formerTeammateHistoryEntity.getStatusAtTime() );
        formerTeammateHistory.updatedAt( formerTeammateHistoryEntity.getUpdatedAt() );
        formerTeammateHistory.historyAction( formerTeammateHistoryEntity.getHistoryAction() );
        formerTeammateHistory.updatedBy( formerTeammateHistoryEntity.getUpdatedBy() );
        formerTeammateHistory.description( formerTeammateHistoryEntity.getDescription() );

        return formerTeammateHistory.build();
    }

    @Override
    public FormerTeammateHistoryResponse toResponse(FormerTeammateHistory formerTeammateHistory) {
        if ( formerTeammateHistory == null ) {
            return null;
        }

        UUID id = null;
        UUID formerTeammateId = null;
        String emailAtTime = null;
        LocalDate birthDateAtTime = null;
        List<Role> rolesAtTime = null;
        ContactStatus statusAtTime = null;
        LocalDateTime updatedAt = null;
        HistoryAction historyAction = null;
        String updatedBy = null;
        String description = null;

        id = formerTeammateHistory.id();
        formerTeammateId = formerTeammateHistory.formerTeammateId();
        emailAtTime = map( formerTeammateHistory.emailAtTime() );
        birthDateAtTime = map( formerTeammateHistory.birthDateAtTime() );
        List<Role> list = formerTeammateHistory.rolesAtTime();
        if ( list != null ) {
            rolesAtTime = new ArrayList<Role>( list );
        }
        statusAtTime = formerTeammateHistory.statusAtTime();
        updatedAt = formerTeammateHistory.updatedAt();
        historyAction = formerTeammateHistory.historyAction();
        updatedBy = formerTeammateHistory.updatedBy();
        description = formerTeammateHistory.description();

        String phoneAtTime = optionalPhoneToMaskedString(formerTeammateHistory.phoneAtTime());

        FormerTeammateHistoryResponse formerTeammateHistoryResponse = new FormerTeammateHistoryResponse( id, formerTeammateId, phoneAtTime, emailAtTime, birthDateAtTime, rolesAtTime, statusAtTime, updatedAt, historyAction, updatedBy, description );

        return formerTeammateHistoryResponse;
    }
}
