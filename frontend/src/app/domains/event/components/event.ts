import {Component, inject} from '@angular/core';
import {EventRegistration} from '@app/domains/event/components/event-registration/event-registration';
import {EventRegistrationsList} from '@app/domains/event/components/event-registrations-list/event-registrations-list';
import {MatDivider} from '@angular/material/divider';
import {AuthenticationService} from '@app/shared/services/authentication';
import {EventRegistrationGuard} from '@app/domains/event/components/event-registration-guard/event-registration-guard';

@Component({
  selector: 'app-event',
  imports: [
    EventRegistration,
    EventRegistrationsList,
    MatDivider,
    EventRegistrationGuard
  ],
  templateUrl: './event.html',
  styleUrl: './event.scss'
})
export class Event {
    private readonly authenticationService = inject(AuthenticationService);
    isAuth = this.authenticationService.isAuthenticatedSignal;
}
