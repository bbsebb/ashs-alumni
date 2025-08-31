package fr.hoenheimsports.domain;

import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.api.FormerTeammateRegistrar;
import fr.hoenheimsports.domain.api.SendSMSToValidateFormerTeammate;
import fr.hoenheimsports.domain.api.commands.ContextCommand;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.exceptions.InvalidPhoneNumberException;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.services.validations.PhoneValidationService;
import fr.hoenheimsports.domain.spi.FormerTeammateRepository;
import fr.hoenheimsports.domain.spi.IdGenerator;

import java.util.UUID;

@DomainService
public class RegisterFormerTeammate implements FormerTeammateRegistrar {
    private final IdGenerator  idGenerator;
    private final FormerTeammateRepository formerTeammateRepository;
    private final PhoneValidationService phoneValidationService;
    private final SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate;

    public RegisterFormerTeammate(IdGenerator idGenerator, FormerTeammateRepository formerTeammateRepository, PhoneValidationService phoneValidationService, SendSMSToValidateFormerTeammate sendSMSToValidateFormerTeammate) {
        this.idGenerator = idGenerator;
        this.formerTeammateRepository = formerTeammateRepository;
        this.phoneValidationService = phoneValidationService;
        this.sendSMSToValidateFormerTeammate = sendSMSToValidateFormerTeammate;
    }
    @Override
    public FormerTeammate registerFormerTeammate(FormerTeammateRegistrationCommand formerTeammateRegistrationCommand, ContextCommand contextCommand) {


        //Gestion des cas d'authentification
        var contactStatus = ContactStatus.SUBMITTED;
        var currentUser = contextCommand.currentUser();
        if(!phoneValidationService.isValid(formerTeammateRegistrationCommand.phone())) {
            contactStatus = ContactStatus.UNREACHABLE;
        }

        var uuid = idGenerator.generateId();




        //creation de mon formerTeammate
        var formerTeammate = FormerTeammate.builder()
                .id(uuid)
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
        //If current user is present, user is authenticated, send SMS
        // if(currentUser.isPresent()) {
        var phone = phoneValidationService.validateAndNormalize(formerTeammateRegistrationCommand.phone());
        sendSMSToValidateFormerTeammate.sendSMS(phone,"text",uuid);
        contactStatus = ContactStatus.PENDING;
        // }
        //return
        return formerTeammate;
    }
}
