import {Component, computed, effect, inject, input, viewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatNoDataRow,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {MatPaginator} from '@angular/material/paginator';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {toSignal} from '@angular/core/rxjs-interop';
import {MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {RouterLink} from '@angular/router';
import {ContactStatusChip} from '@app/shared/components/contact-status-chip/contact-status-chip';

@Component({
  selector: 'app-former-table',
  imports: [
    MatCell,
    MatCellDef,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatPaginator,
    MatRow,
    MatRowDef,
    MatSort,
    MatSortHeader,
    MatTable,
    MatHeaderCellDef,
    MatIcon,
    MatIconButton,
    RouterLink,
    ContactStatusChip,
    MatNoDataRow,

  ],
  templateUrl: './former-table.html',
  styleUrl: './former-table.scss',

})
export class FormerTable {

  // Input
  readonly filterFormerTeammates = input.required<FormerTeammate[]>();

  // ViewChild references
  private readonly matPaginator = viewChild(MatPaginator);
  private readonly matSort = viewChild(MatSort);

  // Table configuration
  readonly columnsToDisplayedSignal ;
  readonly dataSource = new MatTableDataSource<FormerTeammate>([]);



  constructor() {
    const breakpointObserver =  toSignal(inject(BreakpointObserver).observe([Breakpoints.XSmall]));
    this.columnsToDisplayedSignal = computed(() => {
      if(breakpointObserver()?.matches) {
        return ['firstName', 'lastName', 'phone'];
      } else {
        return ['gender', 'firstName', 'lastName', 'phone', 'status','view'];
      }
    })




    effect(() => {
      this.dataSource.data = this.filterFormerTeammates();
      console.log('Mise à jour de la table')
    });
    effect(() => {
      this.dataSource.paginator = this.matPaginator() ?? null;
      this.dataSource.sort = this.matSort() ?? null;
    });
  }


}
