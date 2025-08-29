import {Component, inject, ViewEncapsulation} from '@angular/core';
import {
  MAT_SNACK_BAR_DATA,
  MatSnackBarAction,
  MatSnackBarActions,
  MatSnackBarLabel,
  MatSnackBarRef
} from '@angular/material/snack-bar';
import {MatButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';

@Component({
  selector: 'app-notification',
  imports: [
    MatSnackBarLabel,
    MatSnackBarActions,
    MatSnackBarAction,
    MatButton,
    MatIcon
  ],
  templateUrl: './notification.html',
  styleUrl: './notification.scss',
  encapsulation: ViewEncapsulation.None,
  host: {
    'class': 'notification-container'
  }

})
export class Notification {
  data:string = inject(MAT_SNACK_BAR_DATA);
  snackBarRef = inject(MatSnackBarRef);
  constructor() { }
}
