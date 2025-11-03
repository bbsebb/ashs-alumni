import {Pipe, PipeTransform} from '@angular/core';
import {HistoryAction} from '@app/domains/former-teammates/models/history-action';

@Pipe({
  name: 'actionFormerTeammateHistory'
})
export class ActionFormerTeammateHistoryPipe implements PipeTransform {

  transform(action: HistoryAction): string {
    switch (action) {
      case "CREATED":
        return "Création";
      case "UPDATED":
        return "Modification";
      case "REMOVED":
        return "Suppression";
      default:
        return action;
    }
  }


}
