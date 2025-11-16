import {Component, input, InputSignal} from '@angular/core';
import {TitleCasePipe} from '@angular/common';
import {Participant} from '@app/domains/event/models/participant';
import {MatIcon} from '@angular/material/icon';
import {MatCard, MatCardHeader, MatCardSubtitle} from '@angular/material/card';

@Component({
  selector: 'app-participant-card',
  imports: [
    MatIcon,
    MatCard,
    MatCardHeader,
    MatCardSubtitle,
    TitleCasePipe
  ],
  templateUrl: './participant-card.html',
  styleUrl: './participant-card.scss'
})
export class ParticipantCard {
   participant: InputSignal<Participant> = input.required<Participant>();


}
