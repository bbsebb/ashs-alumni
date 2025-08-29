import {InjectionToken} from '@angular/core';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {HttpResourceRef} from '@angular/common/http';


export interface FormerTeammateHistoryGateway {
  getFormerTeammateHistories(): HttpResourceRef<FormerTeammateHistory[] | undefined>;
}

export const FORMER_TEAMMATE_HISTORY_GATEWAY = new InjectionToken<FormerTeammateHistoryGateway>('FormerTeammateHistoryGateway');
