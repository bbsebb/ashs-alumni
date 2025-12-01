import {Gender} from '@app/domains/former-teammates/models/gender';
import {Role} from '@app/domains/former-teammates/models/role';


export interface CreateFormerTeammate {
  gender: Gender;
  firstName: string;
  lastName: string ;
  phone: string | null;
  birthDate: string | null;
  email: string | null;
  roles: Role[];
}
