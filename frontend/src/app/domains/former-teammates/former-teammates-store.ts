import {computed, inject, Injectable, ResourceRef} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/former-teammates-gateway';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesStore {
  private readonly formerTeammatesResource :ResourceRef<FormerTeammate[] |  undefined>;
  private formerTeammatesGateway = inject(FORMER_TEAMMATES_GATEWAY)
  constructor() {
    this.formerTeammatesResource = this.formerTeammatesGateway.getFormerTeammates();
  }

  get formerTeammatesResourceRef() {
    return this.formerTeammatesResource;
  }

  getFormerTeammateById(id: string) {
    return computed(() => this.formerTeammatesResource.value()?.find((formerTeammate) => formerTeammate.id === id))
  }
}
