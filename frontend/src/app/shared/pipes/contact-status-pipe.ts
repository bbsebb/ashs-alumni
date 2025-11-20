import { Pipe, PipeTransform } from '@angular/core';
import {ContactStatus} from '@app/domains/former-teammates/models/contact-status';

@Pipe({
  name: 'contactStatus'
})
export class ContactStatusPipe implements PipeTransform {

  transform(status: ContactStatus): string {
    switch (status) {
      case 'SUBMITTED':
        return 'Soumis';
      case 'PENDING':
        return 'En attente';
      case 'VALIDATED':
        return 'Validé';
      case 'NOT_REQUESTED':
        return 'Non sollicité';
      case 'UNREACHABLE':
        return 'Injoignable';
      default:
        return status;
    }
  }

}
