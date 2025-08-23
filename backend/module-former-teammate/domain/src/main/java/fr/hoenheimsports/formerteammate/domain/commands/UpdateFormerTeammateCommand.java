package fr.hoenheimsports.formerteammate.domain.commands;

import fr.hoenheimsports.formerteammate.domain.models.Gender;
import fr.hoenheimsports.formerteammate.domain.models.Role;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record UpdateFormerTeammateCommand(
        UUID id,
        Gender gender,
        String firstName,
        String lastName,
        String phone,
        LocalDate birthDate,
        List<Role> roles) {
}
