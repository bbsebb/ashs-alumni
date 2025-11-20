import {Component, computed, effect, inject, input, Signal} from '@angular/core';
import {EventStore} from '@app/domains/event/stores/event-store';
import {AuthenticationService} from '@app/shared/services/authentication';
import {MatIconModule} from '@angular/material/icon';
import {MatCardModule} from '@angular/material/card';
import {Participant} from '@app/domains/event/models/participant';

@Component({
  selector: 'app-event-registered',
  standalone: true,
  imports: [MatIconModule, MatCardModule],
  templateUrl: './event-registered.html',
  styleUrl: './event-registered.scss'
})
export class EventRegistered {
  readonly  participant = input.required<Participant>();
}
