package fr.hoenheimsports.app.controllers.dtos;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record FormerTeammateRequest(
        String firstName,
        String lastName,
        Gender gender,
        String phone,
        String email,
        LocalDate birthDate,
        List<Role> roles
) {
}
