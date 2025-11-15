import {Component, effect, inject} from '@angular/core';
import {EventStore} from '@app/domains/event/stores/event-store';
import {Participant} from '@app/domains/event/models/participant';

@Component({
  selector: 'app-event-registrations-list',
  imports: [],
  templateUrl: './event-registrations-list.html',
  styleUrl: './event-registrations-list.scss'
})
export class EventRegistrationsList {

  private readonly eventStore = inject(EventStore);
  isLoading = this.eventStore.isLoading;
  hasError = this.eventStore.hasError;
  participants: Participant[] | undefined = [];

  constructor() {
    effect(() => {
      this.participants = this.eventStore.formerTeammatesResourceRef.value();
    });

  }


}
