import {computed, effect, inject, Injectable, ResourceRef, Signal} from '@angular/core';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {UUID} from '@app/shared/types/uuid';
import {EventGatewayImpl} from '@app/domains/event/services/event-gateway-impl';
import {Participant} from '@app/domains/event/models/participant';
import {HttpResourceRef} from '@angular/common/http';

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

  getFormerTeammateById(id: number) {
    return computed(() => this.participantsResource.value()?.find((participant) => participant.id === id))
  }
}
