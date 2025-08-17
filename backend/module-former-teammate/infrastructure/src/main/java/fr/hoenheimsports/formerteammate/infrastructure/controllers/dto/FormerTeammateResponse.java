package fr.hoenheimsports.formerteammate.infrastructure.controllers.dto;

import fr.hoenheimsports.formerteammate.domain.models.ContactStatus;
import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record FormerTeammateResponse(
        UUID id,
        String firstName,
        String lastName,
        Gender gender,
        String phone,
        LocalDate birthDate,
        List<Role> roles,
        ContactStatus status
) {
}
