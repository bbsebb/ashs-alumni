import {Component, inject} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {AuthenticationService} from '@app/shared/services/authentication';

@Component({
  selector: 'app-event-registration-guard',
  standalone: true,
  imports: [MatButtonModule, MatCardModule, MatIconModule],
  templateUrl: './event-registration-guard.html',
  styleUrl: './event-registration-guard.scss'
})
export class EventRegistrationGuard {
  private readonly authService = inject(AuthenticationService);

  register() {
    void this.authService.register('/event-registration');
  }

  login() {
    void this.authService.login('/event-registration');
  }
}
