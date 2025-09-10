package fr.hoenheimsports.app.controllers.dtos;

public record TwilioWebhookRequest(
        // Paramètres obligatoires (basés sur vos vrais logs)
        String MessageSid,
        String MessageStatus,
        String SmsSid,           // Doublon de MessageSid pour compatibilité
        String SmsStatus,        // Doublon de MessageStatus pour compatibilité
        String From,
        String To,
        String AccountSid,
        String ApiVersion,
        String RawDlrDoneDate,   // Timestamp de livraison spécifique

        // Paramètres optionnels (peuvent être null)
        String ErrorCode,
        String ErrorMessage,
        String Body,
        String NumSegments,
        String NumMedia,
        String DateCreated,
        String DateUpdated,
        String DateSent,
        String Direction,
        String Price,
        String PriceUnit,
        String Uri,
        String MessagingServiceSid

) {
    public String messageSid() {
        return MessageSid != null ? MessageSid : SmsSid;
    }

    public String messageStatus() {
        return MessageStatus != null ? MessageStatus : SmsStatus;
    }

    public String from() {
        return From;
    }

    public String to() {
        return To;
    }

    public String errorCode() {
        return ErrorCode;
    }

    public String errorMessage() {
        return ErrorMessage;
    }

    public String accountSid() {
        return AccountSid;
    }

    public String body() {
        return Body;
    }

    public String apiVersion() {
        return ApiVersion;
    }

}

