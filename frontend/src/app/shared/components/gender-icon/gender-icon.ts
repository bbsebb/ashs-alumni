import {Component, input} from '@angular/core';
import {Gender} from '@app/domains/former-teammates/models/former-teammates';
import {MatIcon} from '@angular/material/icon';

@Component({
  selector: 'app-gender-icon',
  imports: [
    MatIcon
  ],
  templateUrl: './gender-icon.html',
  styleUrl: './gender-icon.scss'
})
export class GenderIcon {
    genderSignal = input.required<Gender>({alias: 'gender'})
    getIcon() {
        return this.genderSignal() === 'M' ? 'male' : 'female';
    }
}
