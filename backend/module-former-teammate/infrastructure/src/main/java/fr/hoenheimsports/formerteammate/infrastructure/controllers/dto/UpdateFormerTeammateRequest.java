package fr.hoenheimsports.formerteammate.infrastructure.controllers.dto;

import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record UpdateFormerTeammateRequest(
        @NotNull Gender gender,
        @NotEmpty String firstName,
        @NotEmpty String lastName,
        String phone,
        LocalDate birthDate,
        List<Role> roles
) {
}
