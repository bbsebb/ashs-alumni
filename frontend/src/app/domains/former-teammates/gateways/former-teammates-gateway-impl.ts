import {inject, Injectable} from '@angular/core';
import {FormerTeammatesGateway} from './former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../models/former-teammates';
import {HttpClient, httpResource, HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '@environments/environment';


@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesGatewayImpl implements FormerTeammatesGateway {
  markFormerTeammateAsNotRequested(id: Readonly<UUID>): Observable<FormerTeammate> {
    return this.httpClient.post<FormerTeammate>(`${environment.apiUrl}/former-teammates/${id}/not_requested`, null);
  }

  private readonly httpClient = inject(HttpClient);
  getFormerTeammateById(id: string | UUID): HttpResourceRef<FormerTeammate | undefined> {
    return httpResource<FormerTeammate | undefined>(() => `${environment.apiUrl}/former-teammates/${id}`)
  }

  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined> {
    return httpResource<FormerTeammate | undefined>(() => `${environment.apiUrl}/former-teammates/validate/${code}`)
  }

  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammate> {
    return this.httpClient.post<FormerTeammate>(`${environment.apiUrl}/former-teammates`, createFormerTeammate)
  }

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate> {
    return this.httpClient.put<FormerTeammate>(`${environment.apiUrl}/former-teammates/${updateFormerTeammate.id}`, updateFormerTeammate)
  }

  validateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate,code: UUID): Observable<FormerTeammate> {
    return this.httpClient.put<FormerTeammate>(`${environment.apiUrl}/former-teammates/validate/${code}`, updateFormerTeammate)
  }

  deleteFormerTeammate(formerTeammateId: UUID): Observable<void> {
    return this.httpClient.delete<void>(`${environment.apiUrl}/former-teammates/${formerTeammateId}`)
  }

  getFormerTeammates(): HttpResourceRef<FormerTeammate[] | undefined> {
    return httpResource<FormerTeammate[] | undefined>(() =>
      `${environment.apiUrl}/former-teammates?isActive=true`)
  }

  resendSMS(id: Readonly<UUID>): Observable<FormerTeammate> {
    return this.httpClient.post<FormerTeammate>(`${environment.apiUrl}/former-teammates/${id}/resend-sms`, null);
  }


}
