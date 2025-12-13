package fr.hoenheimsports.domain.models;

public enum ContactStatus {
    SUBMITTED("Soumis"),
    @Deprecated
    PENDING("En attente"),
    VALIDATED("Validé"),
    NOT_REQUESTED("Non demandé"),
    UNREACHABLE("Injoignable"),
    SENDING("Envoi en cours"),
    WAITING("SMS reçu");

    private final String label;

    ContactStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
