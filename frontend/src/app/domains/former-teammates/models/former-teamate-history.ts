import {UUID} from '@app/shared/types/uuid';
import {Role} from '@app/domains/former-teammates/models/role';
import {ContactStatus} from '@app/domains/former-teammates/models/contact-status';
import {HistoryAction} from '@app/domains/former-teammates/models/history-action';


export interface FormerTeammateHistory {
  id: Readonly<UUID>;
  formerTeammateId: UUID;
  phoneAtTime?: string;
  emailAtTime?: string;
  birthDateAtTime?: Date;    // format ISO (YYYY-MM-DD)
  rolesAtTime: Role[];
  statusAtTime: ContactStatus;
  updatedAt: Date;           // format ISO (YYYY-MM-DD)
  historyAction: HistoryAction;
  updatedBy: string;
  description: string;
}
