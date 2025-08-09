import {inject, Injectable} from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import {Notification} from '@app/shared/components/notification/notification';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private snackBar = inject(MatSnackBar);
  constructor() { }


  showInfo(message: string) {
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'info',0))
  }

  showError(message: string) {
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'error',0))
  }

  showSuccess(message: string) {
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'success'))
  }
}


function buildNotificationConfig(message: string,level:'info' | 'error' | 'success' = 'info',duration = 5000) {
  return {
    panelClass: [`${level}-notification`],
    data: message,
    duration: duration,
  };
}
