package fr.hoenheimsports.app.mappers;

import fr.hoenheimsports.app.controllers.dtos.ParticipantRequest;
import fr.hoenheimsports.app.controllers.dtos.ParticipantResponse;
import fr.hoenheimsports.app.entities.Participant;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ParticipantMapper {
    Participant toEntity(ParticipantRequest participantRequest);

    ParticipantResponse toDto(Participant participant);


}