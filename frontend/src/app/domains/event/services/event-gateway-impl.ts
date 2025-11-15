import {inject, Injectable} from '@angular/core';
import {HttpClient, httpResource} from '@angular/common/http';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {environment} from '@environments/environment.development';
import {Participant} from '@app/domains/event/models/participant';

@Injectable(
  {providedIn: 'root'}
)
export class EventGatewayImpl {
  private readonly httpClient = inject(HttpClient);

  constructor() {
  }

  public getParticipants() {
    return httpResource<Participant[] | undefined>(() => `${environment.apiUrl}/event/participants`)
  }
}
