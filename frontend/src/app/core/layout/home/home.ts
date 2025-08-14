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
  gw = inject(FORMER_TEAMMATES_GATEWAY)


  constructor() {
    const resource = this.gw.getFormerTeammateByCode('550e8400-e29b-41d4-a716-446655440001')
    const resource2 = this.gw.getFormerTeammateByCode('550e8400-e29b-41d4-a716-446655440001')
    effect(() => {
      console.log('value', resource.value())
      console.log('value2', resource2.value())
    });
  }


  test() {

  }

}



