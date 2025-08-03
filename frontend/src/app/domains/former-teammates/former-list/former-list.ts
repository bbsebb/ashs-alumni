import {Component, effect, inject, ResourceRef, signal, viewChild} from '@angular/core';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/former-teammates-gateway';
import {FormerTeammatesStore} from '@app/domains/former-teammates/former-teammates-store';
import {FormerTeammate} from '@app/domains/former-teammates/former-teammates';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable, MatTableDataSource
} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-former-list',
  standalone: true,
  imports: [
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatCellDef,
    MatHeaderCellDef,
    MatHeaderRow,
    MatRow,
    MatRowDef,
    MatHeaderRowDef,
    MatPaginator,
  ],
  templateUrl: './former-list.html',
  styleUrl: './former-list.scss'
})
export class FormerList {
  private readonly matPaginator = viewChild.required(MatPaginator);
  readonly formerTeammatesResource :ResourceRef<FormerTeammate[] |  undefined> = inject(FormerTeammatesStore).formerTeammatesResourceRef;
  dataSource = new MatTableDataSource<FormerTeammate>([]);
  readonly columnsToDisplayed = ['firstName', 'lastName', 'phone'];

  constructor() {
    effect(() => {
      if(this.formerTeammatesResource.hasValue()) {
        this.dataSource.data = this.formerTeammatesResource.value();
      }
    })
    effect(() => {
      this.dataSource.paginator = this.matPaginator()
    });
  }
}
