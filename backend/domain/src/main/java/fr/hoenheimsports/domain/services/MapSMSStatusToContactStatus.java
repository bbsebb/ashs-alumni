package fr.hoenheimsports.domain.services;

import fr.hoenheimsports.domain.models.ContactStatus;
import fr.hoenheimsports.domain.models.SMSStatus;

public interface MapSMSStatusToContactStatus {
    ContactStatus map(SMSStatus smsStatus);
}
