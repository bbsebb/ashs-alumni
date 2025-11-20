import { Component } from '@angular/core';
import {MatCard, MatCardContent, MatCardHeader, MatCardSubtitle, MatCardTitle} from "@angular/material/card";
import {MatIcon} from '@angular/material/icon';


@Component({
  selector: 'app-event-details',
    imports: [
        MatCard,
        MatCardContent,
        MatCardHeader,
        MatCardSubtitle,
        MatCardTitle,
        MatIcon
    ],
  templateUrl: './event-details.html',
  styleUrl: './event-details.scss'
})
export class EventDetails {

}
