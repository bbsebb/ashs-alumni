package fr.hoenheimsports.app.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ParticipantRequest(
        @NotBlank(message = "Le prénom est obligatoire")
        String firstname,
        @NotBlank(message = "Le nom est obligatoire")
        String lastname,
        @NotBlank(message = "L'adresse email est obligatoire")
        @Email(message = "L'adresse email est invalide")
        String email,
        String comments,
        Boolean hasVegetarianOption
) {
}
