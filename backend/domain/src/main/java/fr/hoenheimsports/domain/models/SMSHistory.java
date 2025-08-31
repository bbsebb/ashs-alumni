package fr.hoenheimsports.domain.models;

import java.time.Instant;
import java.util.UUID;

public record SMSHistory(
        UUID id,
        UUID formerTeammateId,
        String phoneNumber,
        String message,
        SMSStatus status,
        Instant sentAt,
        Instant updatedAt,
        String externalId, // ID du fournisseur SMS
        String errorMessage

) {
}
