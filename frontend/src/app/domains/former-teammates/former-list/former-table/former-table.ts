import {Component, effect, input, viewChild} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable, MatTableDataSource
} from "@angular/material/table";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {MatPaginator} from '@angular/material/paginator';
import {FormerTeammate} from '@app/domains/former-teammates/former-teammates';

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
    MatHeaderCellDef
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
  readonly columnsToDisplayed = ['gender', 'firstName', 'lastName', 'phone', 'status'];
  readonly dataSource = new MatTableDataSource<FormerTeammate>([]);

  constructor() {
    effect(() => {
      this.dataSource.data = this.filterFormerTeammates();
    });
    effect(() => {
      this.dataSource.paginator = this.matPaginator() ?? null;
      this.dataSource.sort = this.matSort() ?? null;
    });
  }
}
