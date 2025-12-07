package fr.hoenheimsports.domain.services;


import fr.hoenheimsports.domain.annotations.DomainService;
import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.SMSStatus;

@DomainService
public class SMSStatusToContactStatusMapper implements MapSMSStatusToContactStatus{
    @Override
    public ContactStatus map(SMSStatus smsStatus) {
        return switch (smsStatus) {
            case QUEUED,ACCEPTED,SCHEDULED,SENDING,SENT -> ContactStatus.SENDING;
            case FAILED,UNDELIVERED,CANCELED,UNKNOWN -> ContactStatus.UNREACHABLE;
            case READ,DELIVERED -> ContactStatus.WAITING;
        };
    }
}
