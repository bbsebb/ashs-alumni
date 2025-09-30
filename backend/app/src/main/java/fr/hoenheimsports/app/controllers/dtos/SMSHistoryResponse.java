package fr.hoenheimsports.app.controllers.dtos;

import fr.hoenheimsports.domain.models.SMSStatus;

import java.time.Instant;
import java.util.UUID;

public record SMSHistoryResponse(
        UUID id,
        UUID formerTeammateId,
        String phoneNumber,
        String message,
        SMSStatus status,
        Instant sentAt,
        Instant updatedAt,
        String externalId,
        String errorMessage
) {
}
