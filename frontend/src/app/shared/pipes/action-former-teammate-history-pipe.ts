import { Pipe, PipeTransform } from '@angular/core';
import {Action} from '@app/domains/former-teammates/models/former-teamate-history';

@Pipe({
  name: 'actionFormerTeammateHistory'
})
export class ActionFormerTeammateHistoryPipe implements PipeTransform {

  transform(action:Action): unknown {
    switch (action) {
      case "CREATE":
        return "Création";
        case "UPDATE":
          return "Modification";
          case "DELETE":
            return "Suppression";
      default:
        return action;
    }
  }


}
