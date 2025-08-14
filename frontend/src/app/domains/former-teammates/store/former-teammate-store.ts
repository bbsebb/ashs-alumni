import {inject, Injectable} from '@angular/core';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammateStore {
  //private readonly formerTeammateResource: ResourceRef<FormerTeammate | undefined>;
  private formerTeammatesGateway = inject(FORMER_TEAMMATES_GATEWAY)

  constructor() {

  }

}
