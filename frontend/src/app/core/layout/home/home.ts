import {Component, effect, inject} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';


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



  constructor() {

  }


  test() {

  }

}



