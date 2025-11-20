import {Component, computed, effect, inject, signal} from '@angular/core';
import {EventRegistration} from '@app/domains/event/components/event-registration/event-registration';
import {EventRegistrationsList} from '@app/domains/event/components/event-registrations-list/event-registrations-list';
import {MatDivider} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';
import {AuthenticationService} from '@app/shared/services/authentication';
import {EventRegistrationGuard} from '@app/domains/event/components/event-registration-guard/event-registration-guard';
import {EventDetails} from '@app/domains/event/components/event-details/event-details';
import {UUID} from '@app/shared/types/uuid';
import {EventStore} from '@app/domains/event/stores/event-store';
import {EventRegistered} from '@app/domains/event/components/event-registered/event-registered';

@Component({
  selector: 'app-event',
  imports: [
    EventRegistration,
    EventRegistrationsList,
    MatDivider,
    EventRegistrationGuard,
    MatIconModule,
    EventDetails,
    EventRegistered
  ],
  templateUrl: './event.html',
  styleUrl: './event.scss'
})
export class Event {
    private readonly authenticationService = inject(AuthenticationService);
    private readonly eventStore = inject(EventStore);
    readonly isAuth = this.authenticationService.isAuthenticatedSignal;

  readonly participantSignal = computed(() => {
    const kcUserId = this.authenticationService.userProfileResource.value()?.id;
    if(!kcUserId) {
      return undefined;
    }
    return this.eventStore.getFormerTeammateByKcId(kcUserId);
  })



}
