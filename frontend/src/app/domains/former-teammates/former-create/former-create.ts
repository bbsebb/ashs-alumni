import {ChangeDetectionStrategy, Component, inject} from '@angular/core';
import {MatError, MatFormField, MatHint, MatInput, MatLabel, MatSuffix} from '@angular/material/input';
import {FormControl, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatButton} from '@angular/material/button';
import {Role} from '@app/domains/former-teammates/models/former-teammates';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from '@angular/material/datepicker';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {FormerTeammateDTO} from '@app/domains/former-teammates/dto/responses/former-teammate-dto';
import {BackButton} from '@app/shared/components/back-button/back-button';


@Component({
  selector: 'app-former-create',
  imports: [
    MatFormField,
    MatLabel,
    MatInput,
    ReactiveFormsModule,
    MatButton,
    MatButtonToggleGroup,
    MatButtonToggle,
    RolePipe,
    MatDatepickerInput,
    MatHint,
    MatDatepickerToggle,
    MatDatepicker,
    MatSuffix,
    MatError,
    BackButton
  ],
  templateUrl: './former-create.html',
  styleUrl: './former-create.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class FormerCreate {
  readonly startAt = new Date(1975, 0, 1);
  private readonly formBuilder = inject(NonNullableFormBuilder);
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);

// Définition du formulaire
  formerForm = this.formBuilder.group({
    gender: new FormControl<string>('M',{nonNullable: true, validators: [Validators.required]}),
    firstName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    lastName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    phone: new FormControl<string>(''),
    birthDate: new FormControl<Date | null>(null),
    roles: new FormControl<Role[]>([],{nonNullable: true}),
  });


  // Constantes pour les options
  readonly roles: Role[] = ['PLAYER', 'COACH', 'PRESIDENT', 'ASSISTANT'];





  onSubmit(): void {
    if (this.formerForm.valid) {
      this.formerTeammatesStore.createFormerTeammate(this.formerForm.getRawValue()).subscribe({
        next: (formerTeammate: FormerTeammateDTO) => {console.log(formerTeammate)},
        error: (error) => {console.log(error)},
        complete: () => {console.log('FormerTeammate created successfully')}
      });
    }
  }
}


