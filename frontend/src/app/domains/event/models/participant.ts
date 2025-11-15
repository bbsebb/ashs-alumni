import {UUID} from '@app/shared/types/uuid';

export interface Participant {
  id: Readonly<number>;
  firstname: string;
  lastname: string;
  email: string;
  comments: string;
  kcId: Readonly<UUID>;
}
