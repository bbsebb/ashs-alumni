package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.FormerTeammateRegistrar;
import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.domain.spi.IdGenerator;

import java.util.UUID;

@DomainService
public class RegisterFormerTeammate implements FormerTeammateRegistrar {
    private final IdGenerator  idGenerator;
    private final FormerTeammateRepository formerTeammateRepository;

    public RegisterFormerTeammate(IdGenerator idGenerator, FormerTeammateRepository formerTeammateRepository) {
        this.idGenerator = idGenerator;
        this.formerTeammateRepository = formerTeammateRepository;
    }
    @Override
    public FormerTeammate registerFormerTeammate(FormerTeammateRegistrationCommand formerTeammateRegistrationCommand, ContextCommand contextCommand) {


        //Gestion des cas d'authentification
        var contactStatus = ContactStatus.SUBMITTED;
        var currentUser = contextCommand.currentUser();
        if(formerTeammateRegistrationCommand.phone() == null) {
            contactStatus = ContactStatus.UNREACHABLE;
        }
        if(currentUser.isPresent()) {
            //Envoie du sms en asynchrone
            //Si ok
            //contactStatus = ContactStatus.PENDING;
            //si ko
            //contactStatus = ContactStatus.UNREACHABLE;
        }


        //creation de mon formerTeammate
        var formerTeammate = FormerTeammate.builder()
                .id(idGenerator.generateId())
                .gender(formerTeammateRegistrationCommand.gender())
                .firstName(formerTeammateRegistrationCommand.firstName())
                .lastName(formerTeammateRegistrationCommand.lastName())
                .phone(formerTeammateRegistrationCommand.phone())
                .email(formerTeammateRegistrationCommand.email())
                .birthDate(formerTeammateRegistrationCommand.birthDate())
                .roles(formerTeammateRegistrationCommand.roles())
                .status(contactStatus).build();

        //Enregistrement dans le repos
        formerTeammateRepository.save(formerTeammate);
        //return
        return formerTeammate;
    }
}
