import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Router } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [MatCardModule, MatButtonModule, MatIconModule],
  templateUrl: './not-found.html',
  styleUrl: './not-found.scss'
})
export class NotFound {
  constructor(private router: Router) {}

  goHome() {
    this.router.navigate(['/home']);
  }
}
