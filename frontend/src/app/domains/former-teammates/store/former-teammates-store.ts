import {computed, effect, inject, Injectable, ResourceRef} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/createFormerTeammate';
import {Observable, tap} from 'rxjs';
import {UpdateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/updateFormerTeammate';
import {HttpResourceRef} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesStore {
  private readonly formerTeammatesResource: ResourceRef<FormerTeammate[] | undefined>;
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

  isLoading() {
    return computed(() => this.formerTeammatesResource.isLoading());
  }

  hasError() {
    return computed(() => !!this.formerTeammatesResource.error());
  }

  getFormerTeammateById(id: string | UUID) {
    return computed(() => this.formerTeammatesResource.value()?.find((formerTeammate) => formerTeammate.id === id))
  }


  createFormerTeammate(createFormerTeammate: CreateFormerTeammate) {
    return this.formerTeammatesGateway.createFormerTeammate(createFormerTeammate).pipe(
      tap(this.updateStore('add')
      ));
  }

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate> {
    return this.formerTeammatesGateway.updateFormerTeammate(updateFormerTeammate).pipe(
      tap(this.updateStore('update')));
  }

  deleteTeammate(id: UUID): Observable<void> {
    return this.formerTeammatesGateway.deleteFormerTeammate(id).pipe(
      tap(() => this.formerTeammatesResource.update(formerTeammates => formerTeammates?.filter(formerTeammate => formerTeammate.id !== id)))
    )
  }


  private updateStore(operationType: 'add' | 'update'): (formerTeammate: FormerTeammate) => void {
    return newFormerTeammate => {
      switch (operationType) {
        case 'add' : {
          this.formerTeammatesResource.update(this.addCreatedFormerTeammateInStore(newFormerTeammate));
          break;
        }
        case 'update' : {
          this.formerTeammatesResource.update(this.updateTeammateInStore(newFormerTeammate));
          break;
        }
        default: {
          throw new Error('Invalid operation type');
        }
      }
    };
  }

  private updateTeammateInStore(newFormerTeammate: FormerTeammate): (formerTeammates: FormerTeammate[] | undefined) => FormerTeammate[] | undefined {
    return formerTeammates => formerTeammates?.map(formerTeammate => formerTeammate.id === newFormerTeammate.id ? newFormerTeammate : formerTeammate);
  }

  private addCreatedFormerTeammateInStore(newFormerTeammate: FormerTeammate): (formerTeammates: FormerTeammate[] | undefined) => FormerTeammate[] | undefined {
    return (formerTeammates) => {
      if (formerTeammates === undefined) {
        return undefined;
      }
      return [...formerTeammates, newFormerTeammate]
    };
  }


  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined> {
    return this.formerTeammatesGateway.getFormerTeammateByCode(code);
  }
}
