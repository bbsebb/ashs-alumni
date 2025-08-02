import {UUID} from '@app/shared/types/uuid';

export type ContactStatus = 'SUBMITTED' | 'PENDING' | 'VALIDATED' | 'NOT_REQUESTED' | 'UNREACHABLE';
export type role = 'PLAYER' | 'COACH' | 'PRESIDENT' | 'ASSISTANT';

export interface FormerTeammate {
  id: UUID;                    // UUID
  firstName: string;
  lastName: string;
  phone?: string;
  email?: string;
  birthDate?: string;            // format ISO (YYYY-MM-DD)
  roles: role[];
  status: ContactStatus;
}
