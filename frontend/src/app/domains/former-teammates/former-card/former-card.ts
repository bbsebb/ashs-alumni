import {Component, computed, inject, Signal} from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {CommonModule} from '@angular/common';
import {FormerTeammate} from '../former-teammates';
import {toSignal} from '@angular/core/rxjs-interop';
import {ActivatedRoute} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/former-teammates-store';

@Component({
  selector: 'app-former-card',
  imports: [
    CommonModule,
    MatCardModule,
    MatChipsModule,
    MatIconModule,
    MatBadgeModule,
    MatDividerModule,
    MatExpansionModule
  ],
  templateUrl: './former-card.html',
  styleUrl: './former-card.scss'
})
export class FormerCard {
  paramsRouteSignal = toSignal(inject(ActivatedRoute).params.pipe());
  formerTeammateSignal: Signal<FormerTeammate | undefined>;

  constructor() {
    const formerTeammatesStore = inject(FormerTeammatesStore);
    this.formerTeammateSignal = computed(() => {
      const formerTeammateId:string |undefined = this.paramsRouteSignal()?.['id'];
      if(formerTeammateId === undefined) {
        return undefined
      }
      return formerTeammatesStore.getFormerTeammateById(formerTeammateId)();
    })
  }

}
