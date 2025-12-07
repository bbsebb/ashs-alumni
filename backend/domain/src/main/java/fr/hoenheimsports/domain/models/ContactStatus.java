package fr.hoenheimsports.domain.models;

public enum ContactStatus {
    SUBMITTED("Soumis"),
    PENDING("En attente"),
    VALIDATED("Validé"),
    NOT_REQUESTED("Non demandé"),
    UNREACHABLE("Injoignable"),
    SENDING("Envoi en cours"),
    WAITING("Lien envoyé [arrivé]");

    private final String label;

    ContactStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
