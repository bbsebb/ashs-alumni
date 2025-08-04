import {UUID} from '@app/shared/types/uuid';

export type ContactStatus = 'SUBMITTED' | 'PENDING' | 'VALIDATED' | 'NOT_REQUESTED' | 'UNREACHABLE';
export type role = 'PLAYER' | 'COACH' | 'PRESIDENT' | 'ASSISTANT';
export type Gender = "M" | "F";

export interface FormerTeammate {
  id: Readonly<UUID>;                    // UUID
  firstName: string;
  lastName: string;
  gender: Gender;
  phone?: string;
  email?: string;
  birthDate?: string;            // format ISO (YYYY-MM-DD)
  roles: role[];
  status: ContactStatus;
}
