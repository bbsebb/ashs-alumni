package fr.hoenheimsports.app.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ParticipantRequest(
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @NotBlank
        @Email
        String email,
        String comments
) {
}
