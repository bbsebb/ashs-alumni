import {FormerTeammate} from './former-teammates';
import {UUID} from '@app/shared/types/uuid';

export type Action = 'CREATE' | 'UPDATE' |  'DELETE';

export interface FormerTeammateHistory {
  id: UUID;                // UUID
  contactId: UUID;         // Référence vers Contact
  action: Action;
  previousValue?: FormerTeammate;       // Valeur précédente (optionnelle, selon contexte)
  newValue: FormerTeammate;            // Nouvelle valeur (optionnelle, selon contexte)
  changedAt: Date;         // ISODate
  changedByUserId?: UUID; // UserId ayant effectué le changement
  changedByUserName?: string;
}
