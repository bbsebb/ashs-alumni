package fr.hoenheimsports.domain.api.commands;

import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;

import java.time.LocalDate;
import java.util.List;

public record UpdateFormerTeammateRequest(
        String newFirstName,
        String newLastName,
        Gender newGender,
        String newPhone,
        String newEmail,
        LocalDate newBirthDate,
        List<Role> roles
) {
}
