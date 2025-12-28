package fr.hoenheimsports.app.controllers.dtos;

import fr.hoenheimsports.domain.models.Gender;
import fr.hoenheimsports.domain.models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
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
        @Past(message = "La date de naissance doit être dans le passé")
        LocalDate birthDate,
        List<Role> roles
) {
}
