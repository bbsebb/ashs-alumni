import { Component } from '@angular/core';
import {EventRegistration} from '@app/domains/event/components/event-registration/event-registration';
import {EventRegistrationsList} from '@app/domains/event/components/event-registrations-list/event-registrations-list';

@Component({
  selector: 'app-event',
  imports: [
    EventRegistration,
    EventRegistrationsList
  ],
  templateUrl: './event.html',
  styleUrl: './event.scss'
})
export class Event {

}
