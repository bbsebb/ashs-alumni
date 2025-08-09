import {computed, effect, inject, Injectable, ResourceRef} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {FormerTeammateForm} from '@app/domains/former-teammates/dto/former-teammate-form';
import {CreateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/createFormerTeammate';
import {map, tap} from 'rxjs';
import {toSignal} from '@angular/core/rxjs-interop';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesStore {
  private readonly formerTeammatesResource :ResourceRef<FormerTeammate[] |  undefined>;
  private formerTeammatesGateway = inject(FORMER_TEAMMATES_GATEWAY)
  constructor() {
    this.formerTeammatesResource = this.formerTeammatesGateway.getFormerTeammates();
    effect(() => {
      this.formerTeammatesResource.value();
      console.log('mise à jour de la resource dans le store');
    });
  }

  get formerTeammatesResourceRef() {
    return this.formerTeammatesResource;
  }

  getFormerTeammateById(id: string | UUID) {
    return computed(() => this.formerTeammatesResource.value()?.find((formerTeammate) => formerTeammate.id === id))
  }

  createFormerTeammate(createFormerTeammate: CreateFormerTeammate) {
    return this.formerTeammatesGateway.createFormerTeammate(createFormerTeammate).pipe(
      tap(this.updateStore()
    ));
  }


  private updateStore(): (formerTeammate: FormerTeammate) => void {
    return newFormerTeammate => {
      this.formerTeammatesResource.update(this.addCreatedFormerTeammateInStore(newFormerTeammate));
    };
  }

  private addCreatedFormerTeammateInStore(newFormerTeammate: FormerTeammate) : (formerTeammates: FormerTeammate[] | undefined) => FormerTeammate[] | undefined {
    return (formerTeammates) => {
      if (formerTeammates === undefined) {
        return undefined;
      }
      return [...formerTeammates, newFormerTeammate]
    };
  }
}
