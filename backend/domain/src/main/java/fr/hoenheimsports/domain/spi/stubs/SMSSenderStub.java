
package fr.hoenheimsports.domain.spi.stubs;

import fr.hoenheimsports.domain.annotations.Stub;
import fr.hoenheimsports.domain.models.SMSHistory;
import fr.hoenheimsports.domain.models.SMSStatus;
import fr.hoenheimsports.domain.spi.SMSSender;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Stub
public class SMSSenderStub implements SMSSender {
    
    private final List<SMSHistory> sentSMSHistory = new ArrayList<>();
    private boolean simulateFailure = false;
    private SMSStatus defaultStatus = SMSStatus.SENT;
    
    @Override
    public SMSHistory sendSMS(String message, String phoneNumber, UUID formerTeammateId) {
        var smsHistory = new SMSHistory(
                UUID.randomUUID(),
                formerTeammateId,
                phoneNumber,
                message,
                simulateFailure ? SMSStatus.FAILED : defaultStatus,
                Instant.now(),
                Instant.now(),
                "stub-external-id-" + UUID.randomUUID(),
                simulateFailure ? "Erreur simulée dans le stub" : null
        );
        
        sentSMSHistory.add(smsHistory);
        return smsHistory;
    }
    
    // Méthodes utilitaires pour les tests
    public List<SMSHistory> getSentSMSHistory() {
        return new ArrayList<>(sentSMSHistory);
    }
    
    public void clearHistory() {
        sentSMSHistory.clear();
    }
    
    public void simulateFailure(boolean shouldFail) {
        this.simulateFailure = shouldFail;
    }
    
    public void setDefaultStatus(SMSStatus status) {
        this.defaultStatus = status;
    }
    
    public int getSentSMSCount() {
        return sentSMSHistory.size();
    }
    
    public boolean hasSentSMSTo(String phoneNumber) {
        return sentSMSHistory.stream()
                .anyMatch(sms -> sms.phoneNumber().equals(phoneNumber));
    }
    
    public boolean hasSentSMSWith(String message) {
        return sentSMSHistory.stream()
                .anyMatch(sms -> sms.message().equals(message));
    }
}
