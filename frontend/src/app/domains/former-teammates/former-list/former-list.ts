import {Component, inject, ResourceRef} from '@angular/core';
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
  MatTable
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
  readonly formerTeammatesResource :ResourceRef<FormerTeammate[] |  undefined> = inject(FormerTeammatesStore).formerTeammatesResourceRef;
  readonly columnsToDisplayed = ['firstName', 'lastName', 'phone'];
}
