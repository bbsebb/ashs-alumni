import {Component, input, signal} from '@angular/core';
import {MatButton} from '@angular/material/button';
import {RouterLink} from '@angular/router';
import {MatIcon} from '@angular/material/icon';

@Component({
  selector: 'app-back-button',
  imports: [
    MatButton,
    MatIcon,
    RouterLink
  ],
  template: `
    <button mat-button [routerLink]="[link()]" type="button">
      <mat-icon>arrow_back</mat-icon>
      Retour
    </button>
  `,
  styles: ``
})
export class BackButton {
  link = input.required<string>();
}
