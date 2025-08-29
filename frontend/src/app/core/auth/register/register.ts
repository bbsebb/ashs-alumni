import {Component} from '@angular/core';
import {MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './register.html',
  styleUrl: './register.scss'
})
export class RegisterComponent {}
