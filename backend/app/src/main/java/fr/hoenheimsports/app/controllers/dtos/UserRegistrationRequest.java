package fr.hoenheimsports.app.controllers.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationRequest(
        String formerTeammateId,
        @Email
        @NotBlank
        String email,
        @NotBlank
        String lastName,
        @NotBlank
        String firstName,
        @NotBlank
        String password) {
}
