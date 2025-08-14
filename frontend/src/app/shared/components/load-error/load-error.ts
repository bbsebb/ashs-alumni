import {Component, input} from '@angular/core';
import {MatCard, MatCardActions, MatCardContent} from '@angular/material/card';
import {MatIcon} from '@angular/material/icon';
import {BackButton} from '@app/shared/components/back-button/back-button';

@Component({
  selector: 'app-load-error',
  standalone: true,
  imports: [MatCard, MatCardContent, MatIcon, MatCardActions, BackButton],
  templateUrl: './load-error.html',
  styleUrl: './load-error.scss'
})
export class LoadErrorComponent {
  message = input<string>('Une erreur de chargement de la ressource est survenue.');
  backLink = input<string>('/home');
}
