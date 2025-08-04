import {InjectionToken} from '@angular/core';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from './dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from './dto/payloads/updateFormerTeammate';
import {FormerTeammate} from './former-teammates';
import {HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FormerTeammateDTO} from '@app/domains/former-teammates/dto/responses/former-teammate-dto';


export interface  FormerTeammatesGateway {
  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammateDTO>;
  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammateDTO>;
  deleteFormerTeammate(formerTeammateId: UUID): Observable<void>;
  getFormerTeammates(): HttpResourceRef<FormerTeammate[] |  undefined>;
}
export const FORMER_TEAMMATES_GATEWAY = new InjectionToken<FormerTeammatesGateway>('FormerTeammatesGateway');
