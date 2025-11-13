import {InjectionToken} from '@angular/core';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../models/former-teammates';
import {HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';


export interface FormerTeammatesGateway {
  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammate>;

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate>;

  validateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate,code: UUID): Observable<FormerTeammate>

  deleteFormerTeammate(formerTeammateId: UUID): Observable<void>;

  getFormerTeammates(): HttpResourceRef<FormerTeammate[] | undefined>;

  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined>;

  getFormerTeammateById(id: string | UUID): HttpResourceRef<FormerTeammate | undefined>;

  resendSMS(id: Readonly<UUID>): Observable<FormerTeammate>;
}

export const FORMER_TEAMMATES_GATEWAY = new InjectionToken<FormerTeammatesGateway>('FormerTeammatesGateway');
