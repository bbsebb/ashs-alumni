import {Component, inject} from '@angular/core';
import {FormControl, FormsModule, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatError, MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatError,
    MatFormField,
    MatInput,
    MatLabel,
    BackButton,
    MatButton
  ],
  templateUrl: './register.html',
  styleUrl: './register.scss'
})
export class Register {
  private readonly formBuilder = inject(NonNullableFormBuilder);
  formRegister = this.formBuilder.group({
    email: new FormControl<string>('',{nonNullable: true, validators: [Validators.required,Validators.email]}),
    password: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    passwordConfirmation: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    firstName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    lastName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
  });

  protected onSubmit() {

  }

  protected isLoading() {
    return undefined;
  }
}
