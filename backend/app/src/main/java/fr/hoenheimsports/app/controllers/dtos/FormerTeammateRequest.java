package fr.hoenheimsports.app.controllers.dtos;

import fr.hoenheimsports.app.controllers.validators.ValidPhone;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record FormerTeammateRequest(
        @NotBlank(message = "Le prénom est obligatoire")
        String firstName,
        @NotBlank(message = "Le nom est obligatoire")
        String lastName,
        @NotNull(message = "Le genre est obligatoire")
        Gender gender,
        String phone,
        @Email(message = "L'adresse email est invalide")
        String email,
        LocalDate birthDate,
        List<Role> roles
) {
}
