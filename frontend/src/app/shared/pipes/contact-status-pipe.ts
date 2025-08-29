import { Pipe, PipeTransform } from '@angular/core';
import {ContactStatus} from '@app/domains/former-teammates/models/former-teammates';

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
        return 'Non demandé';
      case 'UNREACHABLE':
        return 'Injoignable';
      default:
        return status;
    }
  }

}
