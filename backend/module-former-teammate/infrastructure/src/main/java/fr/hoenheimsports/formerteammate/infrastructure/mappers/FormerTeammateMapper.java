package fr.hoenheimsports.formerteammate.infrastructure.mappers;

import fr.hoenheimsports.formerteammate.domain.models.FormerTeammate;
import fr.hoenheimsports.formerteammate.infrastructure.controllers.dto.FormerTeammateResponse;
import fr.hoenheimsports.formerteammate.infrastructure.entity.FormerTeammateEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FormerTeammateMapper {

    FormerTeammateResponse toResponse(FormerTeammate formerTeammate);

    List<FormerTeammateResponse> toResponseList(List<FormerTeammate> formerTeammates);

    FormerTeammateEntity toEntity(FormerTeammate formerTeammate);

    FormerTeammate toDomain(FormerTeammateEntity entity);
}