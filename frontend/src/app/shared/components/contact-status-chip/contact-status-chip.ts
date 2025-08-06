import {Component, input} from '@angular/core';
import {MatChip, MatChipSet} from '@angular/material/chips';
import {ContactStatusPipe} from '@app/shared/pipes/contact-status-pipe';
import {ContactStatus} from '@app/domains/former-teammates/models/former-teammates';
import {UpperCasePipe} from '@angular/common';
import {ContactStatusDetailPipe} from '@app/shared/pipes/contact-status-detail-pipe';
import {MatTooltip} from '@angular/material/tooltip';

@Component({
  selector: 'app-contact-status-chip',
  imports: [
    MatChipSet,
    MatChip,
    ContactStatusPipe,
    UpperCasePipe,
    ContactStatusDetailPipe,
    MatTooltip
  ],
  templateUrl: './contact-status-chip.html',
  styleUrl: './contact-status-chip.scss'
})
export class ContactStatusChip {
   statusSignal = input.required<ContactStatus>({alias: 'status'})
}
