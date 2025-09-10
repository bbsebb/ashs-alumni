package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.FormerTeammateHistoryEntity;
import fr.hoenheimsports.domain.models.FormerTeammateHistory;
import fr.hoenheimsports.domain.models.Phone;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface FormerTeammateHistoryMapper {

    /**
     * Convertit un modèle domain FormerTeammateHistory en entité FormerTeammateHistoryEntity
     *
     * @param formerTeammateHistory le modèle domain à convertir
     * @return l'entité JPA
     */
    FormerTeammateHistoryEntity toEntity(FormerTeammateHistory formerTeammateHistory);

    /**
     * Convertit une entité FormerTeammateHistoryEntity en modèle domain FormerTeammateHistory
     *
     * @param formerTeammateHistoryEntity l'entité JPA à convertir
     * @return le modèle domain
     */
    FormerTeammateHistory toModel(FormerTeammateHistoryEntity formerTeammateHistoryEntity);

    // Conversions personnalisées pour les types Optional
    default Optional<String> stringToOptional(String value) {
        return Optional.ofNullable(value);
    }

    default String optionalToString(Optional<String> optional) {
        return optional.orElse(null);
    }

    default Optional<LocalDate> dateToOptional(LocalDate date) {
        return Optional.ofNullable(date);
    }

    default LocalDate optionalDateToDate(Optional<LocalDate> optionalDate) {
        return optionalDate.orElse(null);
    }

    default Optional<Phone> phoneToOptional(String phone) {
        if (phone == null) {
            return Optional.empty();
        }
        return Optional.of(Phone.of(phone));
    }

    default String optionalPhoneToPhone(Optional<Phone> optionalPhone) {
        return optionalPhone.map(Phone::toString).orElse(null);
    }

    // Direct mapping methods for MapStruct
    default Phone map(String value) {
        if (value == null) {
            return null;
        }
        return Phone.of(value);
    }

    default String map(Phone phone) {
        if (phone == null) {
            return null;
        }
        return phone.toString();
    }
}