import {inject, Injectable} from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import {Notification} from '@app/shared/components/notification/notification';
import {ProblemDetail} from '@app/shared/models/problem-detail';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private snackBar = inject(MatSnackBar);
  constructor() { }


/*
  showInfo(message: string) {
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'info',0))
  }
*/

  showError(error:ProblemDetail,defaultMessage?: string) {
    defaultMessage = defaultMessage || 'Une erreur est survenue';
    const message = createMessageFromProblemDetail(error,defaultMessage);
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'error',0))
  }

  showSuccess(message: string) {
    this.snackBar.openFromComponent<Notification,string>(Notification, buildNotificationConfig(message,'success'))
  }
}


function buildNotificationConfig(message: string,level:'info' | 'error' | 'success' = 'info',duration = 5000): MatSnackBarConfig<string> {
  return {
    panelClass: [`${level}-notification`],
    data: message,
    duration: duration,
    verticalPosition: 'top',
  };
}

function createMessage(title:string|undefined,detail:string|undefined):string {
  if(!title){
    return detail || 'Une erreur est survenue';
  }
  if(!detail){
    return title;
  }
  return `${title} : ${detail}`;
}

function createMessageFromProblemDetail(error:ProblemDetail,defaultMessage:string):string{
  let message;
  switch (error.type) {
    case 'https://api.hoenheimsports.fr/errors/validation':
      if(error.type === 'https://api.hoenheimsports.fr/errors/validation' && Array.isArray(error["errors"]) && error["errors"].length > 0){
        console.log(error);
        const allErrorMessages = error["errors"]
          .map(e => e.message)
          .filter((m): m is string => !!m)
          .map(m => `➤ ${m}`)
          .join(' ');
        message = createMessage(error.title,allErrorMessages);
      } else {
        message = createMessage(error.title,error.detail);
      }
      break;
    case 'https://api.hoenheimsports.fr/errors/unauthorized':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/contact-already-exists':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/entity-already-removed':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/invalid-phone-number':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/missing-required-field':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/sms-history-not-found':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/former-teammate-not-found':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/sms-limit-exceeded':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/sms-wait-period':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/former-teammate-not-requested':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/former-teammate-final-status':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/user-already-exists':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/auth-error':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/runtime':
      message = createMessage(error.title,error.detail);
      break;
    case 'https://api.hoenheimsports.fr/errors/internal':
      message = createMessage(error.title,error.detail);
      break;
    default:
      // fallback si un type inconnu arrive
      message = defaultMessage || 'Une erreur est survenue';
      break;
  }
  return message;
}
