import {computed, inject, Injectable} from '@angular/core';
import {FORMER_TEAMMATE_HISTORY_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammate-history-gateway';
import {UUID} from '@app/shared/types/uuid';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammateHistoryStore {
  private readonly formerTeammateHistoryResource;
  private readonly formerTeammateHistoryGateway = inject(FORMER_TEAMMATE_HISTORY_GATEWAY);

  constructor() {
    this.formerTeammateHistoryResource = this.formerTeammateHistoryGateway.getFormerTeammateHistories();
  }

  get formerTeammateHistoryResourceRef() {
    return this.formerTeammateHistoryResource;
  }

  isLoading() {
    return this.formerTeammateHistoryResource.isLoading;
  }

  hasError() {
    return computed(() => !!this.formerTeammateHistoryResource.error());
  }

  getFormerTeammateHistoriesById(contactId: UUID) {
    return computed(() => {
      if (!this.formerTeammateHistoryResource.hasValue()) {
        return [];
      }
      return this.formerTeammateHistoryResource.value()?.filter((formerTeammateHistory) => formerTeammateHistory.contactId === contactId)
    })
  }
}
