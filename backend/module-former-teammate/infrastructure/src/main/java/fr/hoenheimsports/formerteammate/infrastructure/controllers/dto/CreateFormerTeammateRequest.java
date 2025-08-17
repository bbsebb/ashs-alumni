package fr.hoenheimsports.formerteammate.infrastructure.controllers.dto;

import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;

import java.time.LocalDate;
import java.util.List;

public record CreateFormerTeammateRequest(
        Gender gender,
        String firstName,
        String lastName,
        String phone,
        LocalDate birthDate,
        List<Role> roles
) {
}
