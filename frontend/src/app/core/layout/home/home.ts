import {Component, effect, inject} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {DialogService} from '@app/shared/services/dialog';


@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatButton
  ],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home {
  notiSer = inject(DialogService);

  constructor() {

  }

  test() {
    const confirmationResponseSignal = this.notiSer.showConfirmation('test content', 'test title');

  }
}
