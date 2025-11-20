import {computed, effect, inject, Injectable, ResourceRef} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {CreateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/createFormerTeammate';
import {Observable, tap} from 'rxjs';
import {UpdateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/updateFormerTeammate';
import {HttpResourceRef} from '@angular/common/http';
import {Form} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FormerTeammatesStore {
  private readonly formerTeammatesResource: HttpResourceRef<FormerTeammate[] | undefined>;
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
      tap(() => this.formerTeammatesResource.reload())); //TODO: reload only if the formerTeammate is the one that was updated
  }

  updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate): Observable<FormerTeammate> {
    return this.formerTeammatesGateway.updateFormerTeammate(updateFormerTeammate).pipe(
      tap(() => this.formerTeammatesResource.reload())); //TODO: reload only if the formerTeammate is the one that was updated
  }

  validateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate,code:UUID): Observable<FormerTeammate> {
    return this.formerTeammatesGateway.validateFormerTeammate(updateFormerTeammate,code).pipe(
      tap(() => this.formerTeammatesResource.reload())); //TODO: reload only if the formerTeammate is the one that was updated
  }

  deleteTeammate(id: UUID): Observable<void> {
    return this.formerTeammatesGateway.deleteFormerTeammate(id).pipe(
      tap(() => this.formerTeammatesResource.reload()) //TODO: reload only if the formerTeammate is the one that was updated
    );
  }




  getFormerTeammateByCode(code: string): HttpResourceRef<FormerTeammate | undefined> {
    return this.formerTeammatesGateway.getFormerTeammateByCode(code);
  }

  handleResendSMS(id: Readonly<UUID>):Observable<FormerTeammate> {
    return this.formerTeammatesGateway.resendSMS(id).pipe(
      tap(() => this.formerTeammatesResource.reload()) //TODO: reload only if the formerTeammate is the one that was updated
    );
  }

  handleMarkAsNotRequested(id: Readonly<UUID>):Observable<FormerTeammate> {
    return this.formerTeammatesGateway.markFormerTeammateAsNotRequested(id).pipe(
      tap(() => this.formerTeammatesResource.reload()) //TODO: reload only if the formerTeammate is the one that was updated
    );
  }
}
