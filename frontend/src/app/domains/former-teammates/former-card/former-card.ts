import {Component, computed, inject, Signal} from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {CommonModule} from '@angular/common';
import {FormerTeammate} from '../models/former-teammates';
import {toSignal} from '@angular/core/rxjs-interop';
import {ActivatedRoute, Router} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {FormerTeammateHistoryStore} from '@app/domains/former-teammates/store/former-teammate-history-store';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {ContactStatusChip} from '@app/shared/components/contact-status-chip/contact-status-chip';
import {GenderIcon} from '@app/shared/components/gender-icon/gender-icon';
import {ActionFormerTeammateHistoryPipe} from '@app/shared/pipes/action-former-teammate-history-pipe';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {BackButton} from '@app/shared/components/back-button/back-button';

@Component({
  selector: 'app-former-card',
  imports: [
    CommonModule,
    MatCardModule,
    MatChipsModule,
    MatIconModule,
    MatBadgeModule,
    MatDividerModule,
    MatExpansionModule,
    ContactStatusChip,
    GenderIcon,
    ActionFormerTeammateHistoryPipe,
    RolePipe,
    BackButton
  ],
  templateUrl: './former-card.html',
  styleUrl: './former-card.scss'
})
export class FormerCard {
  private readonly router = inject(Router);
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);
  private readonly formerTeammateHistoriesStore = inject(FormerTeammateHistoryStore);
  paramsRouteSignal = toSignal(inject(ActivatedRoute).params.pipe());
  formerTeammateSignal: Signal<FormerTeammate | undefined>;
  formerTeammateHistoriesSignal: Signal<FormerTeammateHistory[]> ;

  constructor() {
    this.formerTeammateSignal = computed(this.findFormerTeammate());
    this.formerTeammateHistoriesSignal = computed(this.getFormerTeammateHistories())
    if(this.formerTeammateSignal() === undefined) {
      void this.router.navigate(['/error']);
    }
  }

  private getFormerTeammateHistories() {
    return () => {
      const formerTeammateId = this.formerTeammateSignal()?.id;
      if (formerTeammateId === undefined) {
        return []
      }
      let formerTeammateHistoriesById = this.formerTeammateHistoriesStore.getFormerTeammateHistoriesById(formerTeammateId);
      return formerTeammateHistoriesById();
    };
  }

  private findFormerTeammate() {
    return () => {
      const formerTeammateId: string | undefined = this.paramsRouteSignal()?.['id'];
      if (formerTeammateId === undefined) {
        return undefined
      }
      let formerTeammateById = this.formerTeammatesStore.getFormerTeammateById(formerTeammateId);
      return formerTeammateById();
    };
  }
}
