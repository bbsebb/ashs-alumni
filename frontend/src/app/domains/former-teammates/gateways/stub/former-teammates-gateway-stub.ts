import {computed, inject, Injectable, Signal} from '@angular/core';
import {FormerTeammatesGateway} from '../former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '../../dto/payloads/createFormerTeammate';
import {UpdateFormerTeammate} from '../../dto/payloads/updateFormerTeammate';
import {FormerTeammate} from '../../models/former-teammates';
import {HttpClient, httpResource, HttpResourceRef} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '@environments/environment';
import {toSignal} from '@angular/core/rxjs-interop';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesGatewayStub implements FormerTeammatesGateway {


  private readonly httpClient = inject(HttpClient);


  constructor() {


  }

  getFormerTeammateById(id: string | UUID): HttpResourceRef<FormerTeammate | undefined> {
    return httpResource<FormerTeammate | undefined>(() => `${environment.apiUrl}/former-teammates/${id}`)
  }

  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined> {
    const codesSignal = toSignal(this.httpClient.get<SMS[]>(`${environment.apiUrl}/code-SMS?code=${code}`));
    const codeSignal: Signal<string | undefined> = computed(() => codesSignal()?.at(0)?.formerTeammateId)
    return httpResource(() => `${environment.apiUrl}/former-teammates/${codeSignal()}`);
    //return httpResource(() => `${environment.apiUrl}/error`); // simulate an error
  }

  createFormerTeammate(createFormerTeammate: CreateFormerTeammate): Observable<FormerTeammate> {
    return this.httpClient.post<FormerTeammate>(`${environment.apiUrl}/former-teammates`, createFormerTeammate)
  }

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate> {

    return this.httpClient.patch<FormerTeammate>(`${environment.apiUrl}/former-teammates/${updateFormerTeammate.id}`, updateFormerTeammate)
  }

  deleteFormerTeammate(formerTeammateId: UUID): Observable<void> {
    return this.httpClient.delete<void>(`${environment.apiUrl}/former-teammates/${formerTeammateId}`)
  }

  getFormerTeammates(): HttpResourceRef<FormerTeammate[] | undefined> {
    return httpResource<FormerTeammate[] | undefined>(() => `${environment.apiUrl}/former-teammates`)
    //return httpResource<FormerTeammate[] | undefined>(() => `${environment.apiUrl}/error`) // simulate an error
  }


}

type SMS = {
  "id": string;
  "formerTeammateId": string;
  "code": string;
  "isUsed": boolean;
  "usedAt": string;
}
