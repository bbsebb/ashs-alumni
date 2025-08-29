import { Pipe, PipeTransform } from '@angular/core';
import {ContactStatus} from '@app/domains/former-teammates/models/former-teammates';

@Pipe({
  name: 'contactStatusDetail'
})
export class ContactStatusDetailPipe implements PipeTransform {

  transform(status: ContactStatus): string {
    switch (status) {
      case 'SUBMITTED':
        return 'SMS non envoyé, vérification en cours.';
      case 'PENDING':
        return 'SMS envoyé, en attente de réponse du destinataire';
      case 'VALIDATED':
        return 'SMS envoyé et réponse positive du destinataire.';
      case 'NOT_REQUESTED':
        return 'Ne souhaite plus être contacté';
      case 'UNREACHABLE':
        return 'Téléphone non fourni ou erroné. En attente de nouveau contact.';
      default:
        return status;
    }
  }
}
