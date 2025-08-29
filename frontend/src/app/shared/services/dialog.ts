import {inject, Injectable} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {
  ConfirmationDialog,
  ConfirmationDialogData
} from '@app/shared/components/confirmation-dialog/confirmation-dialog';
import {map} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DialogService {
  private readonly dialog = inject(MatDialog);

  showConfirmation(content: string, title: string = 'Confirmation') {
    const dialogConfig = {data: {title: title, content: content}};

    return this.dialog.open<ConfirmationDialog, ConfirmationDialogData, boolean>(ConfirmationDialog, dialogConfig).afterClosed().pipe(
      map(response => response ?? false),
    );
  }
}
