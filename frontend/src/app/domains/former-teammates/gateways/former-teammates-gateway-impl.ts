import {Injectable} from '@angular/core';
import {FormerTeammatesGateway} from './former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../models/former-teammates';
import {HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesGatewayImpl implements FormerTeammatesGateway {
  getFormerTeammateById(id: string | UUID): HttpResourceRef<FormerTeammate | undefined> {
    throw new Error("Method not implemented.");
  }

  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined> {
    throw new Error("Method not implemented.");
  }

  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammate> {
    throw new Error('Method not implemented.');
  }

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate> {
    throw new Error('Method not implemented.');
  }

  deleteFormerTeammate(formerTeammateId: UUID): Observable<void> {
    throw new Error('Method not implemented.');
  }

  getFormerTeammates(): HttpResourceRef<FormerTeammate[] | undefined> {
    throw new Error('Method not implemented.');
  }

}
