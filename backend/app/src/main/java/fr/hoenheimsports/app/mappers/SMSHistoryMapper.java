package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.entities.SMSHistoryEntity;
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
    SMSHistoryEntity toEntity(SMSHistory smsHistory);

    /**
     * Convertit une entité SMSHistoryEntity en modèle domain SMSHistory
     *
     * @param smsHistoryEntity l'entité JPA à convertir
     * @return le modèle domain
     */
    SMSHistory toModel(SMSHistoryEntity smsHistoryEntity);

    /**
     * Convertit une liste d'entités en liste de modèles domain
     *
     * @param smsHistoryEntities la liste d'entités à convertir
     * @return la liste de modèles domain
     */
    List<SMSHistory> toModelList(List<SMSHistoryEntity> smsHistoryEntities);

    /**
     * Convertit une liste de modèles domain en liste d'entités
     *
     * @param smsHistories la liste de modèles domain à convertir
     * @return la liste d'entités JPA
     */
    @Mapping(target = "formerTeammate", ignore = true) // Relation gérée séparément
    List<SMSHistoryEntity> toEntityList(List<SMSHistory> smsHistories);
}
