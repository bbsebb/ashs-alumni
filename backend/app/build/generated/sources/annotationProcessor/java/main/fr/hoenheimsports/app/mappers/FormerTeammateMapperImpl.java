package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-31T21:46:59+0200",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 24.0.1 (Eclipse Adoptium)"
)
@Component
public class FormerTeammateMapperImpl implements FormerTeammateMapper {

    @Override
    public FormerTeammateRegistrationCommand toCommand(FormerTeammateRequest request) {
        if ( request == null ) {
            return null;
        }

        Gender gender = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String phone = null;
        LocalDate birthDate = null;
        List<Role> roles = null;

        gender = request.gender();
        firstName = request.firstName();
        lastName = request.lastName();
        email = request.email();
        phone = request.phone();
        birthDate = request.birthDate();
        List<Role> list = request.roles();
        if ( list != null ) {
            roles = new ArrayList<Role>( list );
        }

        FormerTeammateRegistrationCommand formerTeammateRegistrationCommand = new FormerTeammateRegistrationCommand( gender, firstName, lastName, email, phone, birthDate, roles );

        return formerTeammateRegistrationCommand;
    }

    @Override
    public FormerTeammateResponse toResponse(FormerTeammate formerTeammate) {
        if ( formerTeammate == null ) {
            return null;
        }

        UUID id = null;
        String firstName = null;
        String lastName = null;
        Gender gender = null;
        String phone = null;
        String email = null;
        LocalDate birthDate = null;
        List<Role> roles = null;
        ContactStatus status = null;

        id = formerTeammate.id();
        firstName = formerTeammate.firstName();
        lastName = formerTeammate.lastName();
        gender = formerTeammate.gender();
        phone = optionalPhoneToPhone( formerTeammate.phone() );
        email = optionalToString( formerTeammate.email() );
        birthDate = optionalDateToDate( formerTeammate.birthDate() );
        List<Role> list = formerTeammate.roles();
        if ( list != null ) {
            roles = new ArrayList<Role>( list );
        }
        status = formerTeammate.status();

        FormerTeammateResponse formerTeammateResponse = new FormerTeammateResponse( id, firstName, lastName, gender, phone, email, birthDate, roles, status );

        return formerTeammateResponse;
    }

    @Override
    public List<FormerTeammateResponse> toResponseList(List<FormerTeammate> formerTeammates) {
        if ( formerTeammates == null ) {
            return null;
        }

        List<FormerTeammateResponse> list = new ArrayList<FormerTeammateResponse>( formerTeammates.size() );
        for ( FormerTeammate formerTeammate : formerTeammates ) {
            list.add( toResponse( formerTeammate ) );
        }

        return list;
    }

    @Override
    public FormerTeammateEntity toEntity(FormerTeammate formerTeammate) {
        if ( formerTeammate == null ) {
            return null;
        }

        FormerTeammateEntity.FormerTeammateEntityBuilder formerTeammateEntity = FormerTeammateEntity.builder();

        formerTeammateEntity.id( formerTeammate.id() );
        formerTeammateEntity.firstName( formerTeammate.firstName() );
        formerTeammateEntity.lastName( formerTeammate.lastName() );
        formerTeammateEntity.gender( formerTeammate.gender() );
        formerTeammateEntity.phone( optionalPhoneToPhone( formerTeammate.phone() ) );
        formerTeammateEntity.email( optionalToString( formerTeammate.email() ) );
        formerTeammateEntity.birthDate( optionalDateToDate( formerTeammate.birthDate() ) );
        List<Role> list = formerTeammate.roles();
        if ( list != null ) {
            formerTeammateEntity.roles( new ArrayList<Role>( list ) );
        }
        formerTeammateEntity.status( formerTeammate.status() );

        return formerTeammateEntity.build();
    }

    @Override
    public FormerTeammate toModel(FormerTeammateEntity formerTeammateEntity) {
        if ( formerTeammateEntity == null ) {
            return null;
        }

        FormerTeammate.Builder formerTeammate = FormerTeammate.builder();

        formerTeammate.id( formerTeammateEntity.getId() );
        formerTeammate.firstName( formerTeammateEntity.getFirstName() );
        formerTeammate.lastName( formerTeammateEntity.getLastName() );
        formerTeammate.gender( formerTeammateEntity.getGender() );
        formerTeammate.phone( formerTeammateEntity.getPhone() );
        formerTeammate.email( formerTeammateEntity.getEmail() );
        formerTeammate.birthDate( formerTeammateEntity.getBirthDate() );
        List<Role> list = formerTeammateEntity.getRoles();
        if ( list != null ) {
            formerTeammate.roles( new ArrayList<Role>( list ) );
        }
        formerTeammate.status( formerTeammateEntity.getStatus() );

        return formerTeammate.build();
    }
}
