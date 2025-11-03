import {UUID} from '@app/shared/types/uuid';
import {SMSStatus} from '@app/domains/former-teammates/models/sms-status';

export interface SMSHistory {
  id: Readonly<UUID>;
  formerTeammateId: Readonly<UUID>;
  phoneNumber: string;
  message: string;
  status: SMSStatus;
  sentAt: string;              // ISO 8601 format
  updatedAt: string;           // ISO 8601 format
  externalId?: string;
  errorMessage?: string;
}
