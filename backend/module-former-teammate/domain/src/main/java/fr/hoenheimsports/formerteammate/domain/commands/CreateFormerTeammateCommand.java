package fr.hoenheimsports.formerteammate.domain.commands;

import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;

import java.time.LocalDate;
import java.util.List;

public record CreateFormerTeammateCommand(
        Gender gender,
        String firstName,
        String lastName,
        String phone,
        LocalDate birthDate,
        List<Role> roles,
        boolean isAuthenticated,
        boolean isAdmin
) {
}

