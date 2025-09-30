package fr.hoenheimsports.domain.api.commands;

import fr.hoenheimsports.domain.models.SMSStatus;

/**
 * DTO pour mettre à jour le statut d'un SMS et le statut de contact associé
 * du FormerTeammate concerné.
 */
public record SMSUpdatedStatusDetails(
        SMSStatusUpdate smsStatusUpdate,
        FormerTeammateReference formerTeammateReference
) {

    /**
     * Informations de mise à jour du statut SMS
     */
    public record SMSStatusUpdate(
            String externalSmsId,
            SMSStatus smsStatus,
            String errorMessage,
            String errorCode
    ) {
    }

    /**
     * Référence vers le FormerTeammate concerné
     */
    public record FormerTeammateReference(
            String formerTeammateId
    ) {
    }
}
