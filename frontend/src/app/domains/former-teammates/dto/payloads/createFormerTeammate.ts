import {Role} from '@app/domains/former-teammates/models/former-teammates';

export interface CreateFormerTeammate {
  gender: string;
  firstName: string;
  lastName: string ;
  phone: string | null;
  birthDate: Date | null;
  roles: Role[];
}
