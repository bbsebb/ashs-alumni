package fr.hoenheimsports.app.controllers.dtos;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.HistoryAction;
import fr.hoenheimsports.domain.models.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record FormerTeammateHistoryResponse(
        UUID id,
        UUID formerTeammateId,
        String phoneAtTime,
        String emailAtTime,
        LocalDate birthDateAtTime,
        List<Role> rolesAtTime,
        ContactStatus statusAtTime,
        LocalDate updatedAt,
        HistoryAction historyAction,
        String updatedBy,
        String description
) {
}
