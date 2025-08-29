import {UUID} from '@app/shared/types/uuid';
import {Gender, Role} from '@app/domains/former-teammates/models/former-teammates';

export interface UpdateFormerTeammate {
  id: Readonly<UUID>;                    // UUID
  firstName: string;
  lastName: string;
  gender: Gender;
  phone: string | null;
  birthDate: Date | null;            // format ISO (YYYY-MM-DD)
  roles: Role[];
}
