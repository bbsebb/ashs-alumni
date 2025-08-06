import { Pipe, PipeTransform } from '@angular/core';
import {Role} from '@app/domains/former-teammates/models/former-teammates';

@Pipe({
  name: 'role'
})
export class RolePipe implements PipeTransform {

  transform(role:Role): unknown {
    switch (role) {
      case 'PLAYER':
        return 'Joueur';
        case 'COACH':
          return 'Coach';
      case 'PRESIDENT':
        return 'Président'
      case 'ASSISTANT':
        return 'Assistant'
      default:
        return role;
    }
  }

}
