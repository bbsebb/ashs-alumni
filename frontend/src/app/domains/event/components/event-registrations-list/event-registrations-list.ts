import {Component, computed, effect, inject, signal, Signal} from '@angular/core';
import {EventStore} from '@app/domains/event/stores/event-store';
import {Participant} from '@app/domains/event/models/participant';
import {MatCard, MatCardContent, MatCardHeader, MatCardSubtitle, MatCardTitle} from '@angular/material/card';
import {MatDivider} from '@angular/material/divider';
import {MatListItem, MatNavList} from '@angular/material/list';
import {UpperCasePipe} from '@angular/common';
import {MatIcon} from '@angular/material/icon';
import {ParticipantCard} from '@app/domains/event/components/participant-card/participant-card';
import {MatProgressBar} from '@angular/material/progress-bar';

@Component({
  selector: 'app-event-registrations-list',
  imports: [
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardSubtitle,
    MatDivider,
    MatCardContent,
    MatNavList,
    MatListItem,
    MatIcon,
    MatProgressBar,
    UpperCasePipe,
    ParticipantCard
  ],
  templateUrl: './event-registrations-list.html',
  styleUrl: './event-registrations-list.scss'
})
export class EventRegistrationsList {

  private readonly eventStore = inject(EventStore);
  isLoading = this.eventStore.isLoading;
  hasError = this.eventStore.hasError;
  participants: Signal<Participant[] | undefined>  = signal([]);
  participantsNumber = computed(() => this.participants()?.length ?? 0);

  constructor() {
    effect(() => {
      this.participants = this.eventStore.formerTeammatesResourceRef.value;
    });

  }


}
