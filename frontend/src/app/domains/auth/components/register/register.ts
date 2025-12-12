import {Component, computed, effect, inject, input, signal} from '@angular/core';
import {FormControl, FormsModule, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatError, MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {MatButton} from '@angular/material/button';
import {passwordMatchValidator} from '@app/shared/validators/passwordMatchValidator';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {AuthGatewayImpl} from '@app/domains/auth/gateways/auth-gateway-impl';
import {MatDivider} from '@angular/material/list';
import {MatProgressBar} from '@angular/material/progress-bar';
import {NotificationService} from '@app/shared/services/notification';
import {Router} from '@angular/router';

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
    MatButton,
    MatDivider,
    MatProgressBar
  ],
  templateUrl: './register.html',
  styleUrl: './register.scss'
})
export class Register {
  private readonly formBuilder = inject(NonNullableFormBuilder);
  private readonly formerTeammateStores = inject(FormerTeammatesStore)
  private readonly authGateway = inject(AuthGatewayImpl);
  private readonly notificationService = inject(NotificationService);
  private readonly router = inject(Router);
  formRegister;
  id = input<string>();
  private readonly prefill;
  isSubmitting = signal(false);

  constructor() {
    this.formRegister = this.buildForm();
    this.prefill = computed(() => {
    const id = this.id();
    if(id) {
      return this.formerTeammateStores.getFormerTeammateById(id)();
    }
    return undefined;
  });
    effect(() => {
      const prefill = this.prefill();
      if (prefill) {
        this.formRegister.patchValue({
          email: prefill.email,
          firstName: prefill.firstName,
          lastName: prefill.lastName,
        });
      }
    });
  }

  private buildForm() {
    return this.formBuilder.group({
      email: new FormControl<string>('',{nonNullable: true, validators: [Validators.required,Validators.email]}),
      passwords: this.formBuilder.group({
        password: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
        passwordConfirmation: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
      }, {
        validators: passwordMatchValidator
      }),
      firstName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
      lastName: new FormControl<string>('',{nonNullable: true, validators: [Validators.required]}),
    });
  }

  protected onSubmit() {

    if(!this.formRegister.invalid) {
      this.isSubmitting.set(true);
      this.authGateway.registerUser({
        email: this.formRegister.getRawValue().email,
        firstName: this.formRegister.getRawValue().firstName,
        password: this.formRegister.getRawValue().passwords.password,
        lastName: this.formRegister.getRawValue().lastName,
        formerTeammateId: this.id()
      }).subscribe({
        next: () => {
          this.notificationService.showSuccess("Votre compte a été crée");
          void this.router.navigate(['/register/confirmation']);
          this.isSubmitting.set(false);
        },
        error: (err) => {
          this.notificationService.showError(err.error);

          this.isSubmitting.set(false);
        }
      })
    }
  }


}


