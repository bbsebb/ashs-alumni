import {Injectable} from '@angular/core';
import {FormerTeammateHistoryGateway} from '@app/domains/former-teammates/gateways/former-teammate-history-gateway';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {httpResource, HttpResourceRef} from '@angular/common/http';
import {environment} from '@environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammateHistoryGatewayStub implements FormerTeammateHistoryGateway {
  getFormerTeammateHistories(): HttpResourceRef<FormerTeammateHistory[] | undefined> {
    return httpResource<FormerTeammateHistory[] | undefined>(() => `${environment.apiUrl}/former-teammate-histories`)
  }

}
