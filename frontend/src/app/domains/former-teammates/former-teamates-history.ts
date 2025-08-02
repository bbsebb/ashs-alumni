import {FormerTeammate} from './former-teammates';
import {UUID} from '@app/shared/types/uuid';



export interface FormerTeammatesHistory {
  id: UUID;                // UUID
  contactId: UUID;         // Référence vers Contact
  action: 'CREATE' | 'UPDATE' |  'DELETE';
  previousValue?: FormerTeammate;       // Valeur précédente (optionnelle, selon contexte)
  newValue: FormerTeammate;            // Nouvelle valeur (optionnelle, selon contexte)
  changedAt: Date;         // ISODate
  changedBy: UUID;         // UserId ayant effectué le changement
}
