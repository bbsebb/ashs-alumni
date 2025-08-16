import {Component, inject} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {AuthenticationService} from '@app/shared/services/authentication';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-former-validation-success',
  standalone: true,
  imports: [MatButtonModule, MatCardModule, MatIconModule, RouterLink],
  templateUrl: './former-validation-success.html',
  styleUrl: './former-validation-success.scss'
})
export class FormerValidationSuccess {
  private readonly authService = inject(AuthenticationService);

  register() {
    void this.authService.register();
  }
}
