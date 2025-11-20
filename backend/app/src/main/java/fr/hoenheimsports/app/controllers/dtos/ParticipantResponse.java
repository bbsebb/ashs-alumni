package fr.hoenheimsports.app.controllers.dtos;

import java.util.UUID;

public record ParticipantResponse(
        long id,
        String firstname,
        String lastname,
        String email,
        Boolean hasVegetarianOption,
        String comments,
        UUID kcId
) {
}
