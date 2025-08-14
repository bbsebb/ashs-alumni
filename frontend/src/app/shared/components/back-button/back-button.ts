import {Component, input} from '@angular/core';
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
  /**
   * The return link route path for the back button navigation.
   *
   * This property defines the route that the back button will navigate to when clicked.
   * It should be a valid Angular router path string.
   *
   * @example
   * // Navigate back to the home page
   * <app-back-button link="/home" />
   *
   * @example
   * // Navigate back to a list view
   * <app-back-button link="/former-teammates" />
   *
   * @example
   * // Navigate back with route parameters
   * <app-back-button link="/users/123" />
   */
  link = input.required<string>();
}
