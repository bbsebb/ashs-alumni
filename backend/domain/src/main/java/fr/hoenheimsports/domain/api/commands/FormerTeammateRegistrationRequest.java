package fr.hoenheimsports.domain.api.commands;

import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;

import java.time.LocalDate;
import java.util.List;

public record FormerTeammateRegistrationRequest(
        Gender gender, String firstName, String lastName, String email, String phone, LocalDate birthDate, List<Role> roles
) {
}
