package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
import fr.hoenheimsports.domain.models.Phone;
import fr.hoenheimsports.domain.models.SMSHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SMSHistoryMapper {

    /**
     * Convertit un modèle domain SMSHistory en entité SMSHistoryEntity
     *
     * @param smsHistory le modèle domain à convertir
     * @return l'entité JPA
     */
    @Mapping(target = "formerTeammate", ignore = true) // Relation gérée séparément
    @Mapping(target = "phoneNumber", expression = "java(phoneToString(smsHistory.phoneNumber()))")
    SMSHistoryEntity toEntity(SMSHistory smsHistory);

    /**
     * Convertit une entité SMSHistoryEntity en modèle domain SMSHistory
     *
     * @param smsHistoryEntity l'entité JPA à convertir
     * @return le modèle domain
     */
    @Mapping(target = "phoneNumber", expression = "java(stringToPhone(smsHistoryEntity.getPhoneNumber()))")
    SMSHistory toModel(SMSHistoryEntity smsHistoryEntity);

    /**
     * Convertit une liste d'entités en liste de modèles domain
     *
     * @param smsHistoryEntities la liste d'entités à convertir
     * @return la liste de modèles domain
     */
    List<SMSHistory> toModelList(List<SMSHistoryEntity> smsHistoryEntities);

    /**
     * Convertit un objet Phone en String pour l'entité
     *
     * @param phone l'objet Phone
     * @return la valeur string du téléphone
     */
    default String phoneToString(Phone phone) {
        return phone != null ? phone.value() : null;
    }

    /**
     * Convertit un String en objet Phone pour le modèle domain
     *
     * @param phoneNumber le numéro de téléphone en string
     * @return l'objet Phone
     */
    default Phone stringToPhone(String phoneNumber) {
        return phoneNumber != null ? Phone.of(phoneNumber) : null;
    }
}
