import {Component, computed, effect, inject, input, viewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {MatPaginator} from '@angular/material/paginator';
import {FormerTeammate} from '@app/domains/former-teammates/former-teammates';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {toSignal} from '@angular/core/rxjs-interop';
import {ContactStatusPipe} from '@app/shared/pipes/contact-status-pipe';
import {MatTooltip} from '@angular/material/tooltip';
import {ContactStatusDetailPipe} from '@app/shared/pipes/contact-status-detail-pipe';
import {MatIconButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {RouterLink} from '@angular/router';

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
    ContactStatusPipe,
    MatTooltip,
    ContactStatusDetailPipe,
    MatIcon,
    MatIconButton,
    RouterLink,

  ],
  templateUrl: './former-table.html',
  styleUrl: './former-table.scss'
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
        return ['firstName', 'lastName', 'phone','view'];
      } else {
        return ['gender', 'firstName', 'lastName', 'phone', 'status','view'];
      }
    })


    effect(() => {
      this.dataSource.sort = this.matSort() ?? null;
      this.dataSource.paginator = this.matPaginator() ?? null;
    })

    effect(() => {
      this.dataSource.data = this.filterFormerTeammates();
    });
    effect(() => {
      this.dataSource.paginator = this.matPaginator() ?? null;
      this.dataSource.sort = this.matSort() ?? null;
    });
  }


}
