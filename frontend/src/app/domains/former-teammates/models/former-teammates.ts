import {UUID} from '@app/shared/types/uuid';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {Gender} from '@app/domains/former-teammates/models/gender';
import {Role} from '@app/domains/former-teammates/models/role';
import {ContactStatus} from '@app/domains/former-teammates/models/contact-status';
import {SMSHistory} from '@app/domains/former-teammates/models/sms-history';





export interface FormerTeammate {
  id: Readonly<UUID>;
  firstName: string;
  lastName: string;
  gender: Gender;
  phone?: string;
  email?: string;
  birthDate?: string;          // format ISO (YYYY-MM-DD)
  roles: Role[];
  status: ContactStatus;
  formerTeammateHistories?: FormerTeammateHistory[];
  SMSHistories?: SMSHistory[];
}
