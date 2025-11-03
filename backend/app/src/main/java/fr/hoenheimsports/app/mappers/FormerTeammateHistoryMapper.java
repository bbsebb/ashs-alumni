package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.FormerTeammateHistoryResponse;
import fr.hoenheimsports.app.entities.FormerTeammateHistoryEntity;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface FormerTeammateHistoryMapper {

    /**
     * Convertit un modèle domain FormerTeammateHistory en entité FormerTeammateHistoryEntity
     *
     * @param formerTeammateHistory le modèle domain à convertir
     * @return l'entité JPA
     */
    @Mapping(target = "formerTeammate", ignore = true)
    @Mapping(target = "phoneAtTime", expression = "java(optionalPhoneToString(formerTeammateHistory.phoneAtTime()))")
    FormerTeammateHistoryEntity toEntity(FormerTeammateHistory formerTeammateHistory);

    /**
     * Convertit une entité FormerTeammateHistoryEntity en modèle domain FormerTeammateHistory
     *
     * @param formerTeammateHistoryEntity l'entité JPA à convertir
     * @return le modèle domain
     */
    FormerTeammateHistory toModel(FormerTeammateHistoryEntity formerTeammateHistoryEntity);

    /**
     * Convertit un modèle domain FormerTeammateHistory en réponse FormerTeammateHistoryResponse
     *
     * @param formerTeammateHistory le modèle domain à convertir
     * @return la réponse DTO
     */
    @Mapping(target = "phoneAtTime", expression = "java(optionalPhoneToMaskedString(formerTeammateHistory.phoneAtTime()))")
    FormerTeammateHistoryResponse toResponse(FormerTeammateHistory formerTeammateHistory);




    default <T> T map(Optional<T> optional) {
        return optional.orElse(null);
    }

    default Phone map(String value) {
        if (value == null) {
            return null;
        }
        return Phone.of(value);
    }


    default String optionalPhoneToString(Optional<Phone> optionalPhone) {
        return optionalPhone.map(Phone::getRawValue).orElse(null);
    }
    default String optionalPhoneToMaskedString(Optional<Phone> optionalPhone) {
        return optionalPhone.map(Phone::toString).orElse(null);
    }


}