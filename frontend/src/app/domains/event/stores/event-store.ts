import {computed, effect, inject, Injectable, ResourceRef, Signal} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {EventGatewayImpl} from '@app/domains/event/gateways/event-gateway-impl';
import {Participant} from '@app/domains/event/models/participant';
import {HttpResourceRef} from '@angular/common/http';
import {ParticipantRequest} from '@app/domains/event/dtos/participant-request';
import {Observable, tap} from 'rxjs';

@Injectable(
  {providedIn: 'root'}
)
export class EventStore {
  private readonly participantsResource: HttpResourceRef<Participant[] | undefined>;
  private eventGateway = inject(EventGatewayImpl);
  readonly isLoading: Signal<boolean>;
  readonly hasError: Signal<boolean>;

  constructor() {
    this.participantsResource = this.eventGateway.getParticipants();
    this.isLoading = computed(() => this.participantsResource.isLoading());
    this.hasError = computed(() => !!this.participantsResource.error());
    effect(() => {
      this.participantsResource.value();
      console.log('mise à jour de la resource dans le store');
    });
  }

  get formerTeammatesResourceRef() {
    return this.participantsResource;
  }

  registerParticipant( participantRequest:ParticipantRequest): Observable<Participant> {
    return this.eventGateway.registerParticipant(participantRequest).pipe(
      tap(() => this.participantsResource.reload()) //TODO: reload only if the participants is the one that was updated
    );
  }

  getFormerTeammateByKcId(kcId: UUID): Participant | undefined {
    return computed(() => this.participantsResource.value()?.find((participant) => participant.kcId === kcId))()
  }
}
