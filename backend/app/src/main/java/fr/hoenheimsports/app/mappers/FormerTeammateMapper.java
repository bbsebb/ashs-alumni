package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationRequest;
import fr.hoenheimsports.domain.api.commands.UpdateFormerTeammateRequest;
import fr.hoenheimsports.domain.api.commands.ValidateFormerTeammateRequest;
import fr.hoenheimsports.domain.models.FormerTeammate;
import fr.hoenheimsports.domain.models.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface FormerTeammateMapper {
    /**
     * Convertit une requête FormerTeammateRequest en commande FormerTeammateRegistrationRequest
     *
     * @param request la requête à convertir
     * @return la commande de registration
     */
    FormerTeammateRegistrationRequest toRegistrationRequest(FormerTeammateRequest request);

    /**
     * Convertit un modèle domain FormerTeammate en réponse FormerTeammateResponse
     *
     * @param formerTeammate le modèle domain à convertir
     * @return la réponse DTO
     */
    @Mapping(target = "formerTeammateHistories", ignore = true)
    @Mapping(target = "SMSHistories", ignore = true)
    @Mapping(target = "phone" , expression = "java(optionalPhoneToMaskedString(formerTeammate.phone()))")
    FormerTeammateResponse toResponse(FormerTeammate formerTeammate);


    @Mapping(target = "smsHistory", ignore = true)
    @Mapping(target = "formerTeammateHistory", ignore = true)
    @Mapping(target = "phone" , expression = "java(optionalPhoneToString(formerTeammate.phone()))")
    FormerTeammateEntity toEntity(FormerTeammate formerTeammate);

    FormerTeammate toModel(FormerTeammateEntity formerTeammateEntity);


    default <T> T map(Optional<T> optional) {
        return optional.orElse(null);
    }


    default String optionalPhoneToString(Optional<Phone> optionalPhone) {
        return optionalPhone.map(Phone::getRawValue).orElse(null);
    }

    default String optionalPhoneToMaskedString(Optional<Phone> optionalPhone) {
        return optionalPhone.map(Phone::toString).orElse(null);
    }


    default UpdateFormerTeammateRequest toUpdateRequest(String id, FormerTeammateRequest formerTeammateRequest) {
        var formerTeammateRegistrationRequest = toRegistrationRequest(formerTeammateRequest);
        var uuid = UUID.fromString(id);
        return new UpdateFormerTeammateRequest(
                uuid,
                formerTeammateRegistrationRequest.firstName(),
                formerTeammateRegistrationRequest.lastName(),
                formerTeammateRegistrationRequest.gender(),
                formerTeammateRegistrationRequest.phone(),
                formerTeammateRegistrationRequest.email(),
                formerTeammateRegistrationRequest.birthDate(),
                formerTeammateRegistrationRequest.roles()
        );
    }

    default ValidateFormerTeammateRequest toValidateRequest(String code, FormerTeammateRequest formerTeammateRequest,String kcUserID) {
        var formerTeammateRegistrationRequest = toRegistrationRequest(formerTeammateRequest);
        return new ValidateFormerTeammateRequest(
                formerTeammateRegistrationRequest.firstName(),
                formerTeammateRegistrationRequest.lastName(),
                formerTeammateRegistrationRequest.gender(),
                formerTeammateRegistrationRequest.phone(),
                formerTeammateRegistrationRequest.email(),
                formerTeammateRegistrationRequest.birthDate(),
                formerTeammateRegistrationRequest.roles(),
                code.trim().toUpperCase(),
                kcUserID
        );
    }
}
