package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateRequest;
import fr.hoenheimsports.app.controllers.dtos.FormerTeammateResponse;
import fr.hoenheimsports.app.entities.FormerTeammateEntity;
import fr.hoenheimsports.domain.api.commands.FormerTeammateRegistrationCommand;
import fr.hoenheimsports.domain.models.FormerTeammate;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface FormerTeammateMapper {
    /**
     * Convertit une requête FormerTeammateRequest en commande FormerTeammateRegistrationCommand
     *
     * @param request la requête à convertir
     * @return la commande de registration
     */
    FormerTeammateRegistrationCommand toCommand(FormerTeammateRequest request);

    /**
     * Convertit un modèle domain FormerTeammate en réponse FormerTeammateResponse
     *
     * @param formerTeammate le modèle domain à convertir
     * @return la réponse DTO
     */
    FormerTeammateResponse toResponse(FormerTeammate formerTeammate);

    List<FormerTeammateResponse> toResponseList(List<FormerTeammate> formerTeammates);

    FormerTeammateEntity toEntity(FormerTeammate formerTeammate);

    FormerTeammate toModel(FormerTeammateEntity formerTeammateEntity);

    // Conversions personnalisées si nécessaire
    default Optional<String> stringToOptional(String value) {
        return Optional.ofNullable(value);
    }

    default String optionalToString(Optional<String> optional) {
        return optional.orElse(null);
    }

    default Optional<LocalDate> dateToOptional(LocalDate date) {
        return Optional.ofNullable(date);
    }

    // Nouvelle méthode pour mapper Optional<LocalDate> vers LocalDate
    default LocalDate optionalDateToDate(Optional<LocalDate> optionalDate) {
        return optionalDate.orElse(null);
    }



}
