package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.FormerTeammateHistoryEntity;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-09T19:35:48+0200",
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
        formerTeammateHistoryEntity.phoneAtTime( optionalPhoneToPhone( formerTeammateHistory.phoneAtTime() ) );
        formerTeammateHistoryEntity.emailAtTime( optionalToString( formerTeammateHistory.emailAtTime() ) );
        formerTeammateHistoryEntity.birthDateAtTime( optionalDateToDate( formerTeammateHistory.birthDateAtTime() ) );
        List<Role> list = formerTeammateHistory.rolesAtTime();
        if ( list != null ) {
            formerTeammateHistoryEntity.rolesAtTime( new ArrayList<Role>( list ) );
        }
        formerTeammateHistoryEntity.statusAtTime( formerTeammateHistory.statusAtTime() );
        formerTeammateHistoryEntity.updatedAt( formerTeammateHistory.updatedAt() );
        formerTeammateHistoryEntity.historyAction( formerTeammateHistory.historyAction() );
        formerTeammateHistoryEntity.updatedBy( formerTeammateHistory.updatedBy() );
        formerTeammateHistoryEntity.description( formerTeammateHistory.description() );

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
}
