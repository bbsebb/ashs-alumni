package fr.hoenheimsports.domain.api.commands;

import fr.hoenheimsports.domain.models.SMSStatus;

/**
 * DTO pour mettre à jour le statut d'un SMS et le statut de contact associé
 * du FormerTeammate concerné.
 */
public record SMSStatusDetails(
        String externalSmsId,
        SMSStatus smsStatus,
        String errorMessage,
        String errorCode
) {
}
