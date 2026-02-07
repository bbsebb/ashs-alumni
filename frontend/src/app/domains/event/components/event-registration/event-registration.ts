import {Component, effect, inject, signal} from '@angular/core';
import {FormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import {EventStore} from '@app/domains/event/stores/event-store';
import {ParticipantRequest} from '@app/domains/event/dtos/participant-request';
import {NotificationService} from '@app/shared/services/notification-service';
import {ProblemDetail} from '@app/shared/models/problem-detail';
import {AuthenticationService} from '@app/shared/services/authentication';
import {MatCheckbox} from '@angular/material/checkbox';
import {MatDialog} from '@angular/material/dialog';
import {
  EventRegistrationConfirmation
} from '@app/domains/event/components/event-registration/event-registration-confirmation';
import {filter, switchMap, tap} from 'rxjs';
import {MatProgressSpinner} from '@angular/material/progress-spinner';


@Component({
  selector: 'app-event-registration',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatCheckbox,
    MatProgressSpinner
  ],
  templateUrl: './event-registration.html',
  styleUrls: ['./event-registration.scss']
})
export class EventRegistration {
  private readonly fb = inject(FormBuilder);
  private readonly eventStore = inject(EventStore);
  private readonly notificationService = inject(NotificationService);
  private readonly authenticationService = inject(AuthenticationService);
  private readonly dialog = inject(MatDialog);

  constructor(
  ) {
    effect(() => {
      this.form.patchValue({
        lastName: this.authenticationService.userProfileResource.value()?.lastName ?? '',
        firstName: this.authenticationService.userProfileResource.value()?.firstName ?? '',
        email: this.authenticationService.userProfileResource.value()?.email ?? '',
      })
    });
  }


  readonly priceEuros = 25;

  isSubmitting = signal(false);

  readonly form = this.fb.nonNullable.group({
    lastName: ['', Validators.required],
    firstName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    comments: [''],
    hasVegetarianOption: [false]
  });


  onSubmit() {
    this.isSubmitting.set(true);
    if (this.form.valid) {
      const request = this.buildParticipantRequest();
      this.dialog.open(EventRegistrationConfirmation, {
        data: request,
        width: '500px'
      }).afterClosed().pipe(
        tap(confirmed => {
          if (!confirmed) {
            this.isSubmitting.set(false);
          }
        }),
        filter(confirmed => !!confirmed),
        switchMap(() => this.eventStore.registerParticipant(request)),
      ).subscribe({
          next: () => {
            this.notificationService.showSuccess("Inscription validée. Merci pour votre participation !");
            this.isSubmitting.set(false);
          },
          error: (err) => {
            this.notificationService.showError(err.error as ProblemDetail,"Une erreur est survenue; veuillez réessayer plus tard.");
            this.isSubmitting.set(false);
          }
          }
        );
    }


  }

  private buildParticipantRequest(): ParticipantRequest {
    const { firstName, lastName, email, comments, hasVegetarianOption } = this.form.getRawValue();

    return {
      firstname: firstName,
      lastname: lastName,
      email: email,
      comments: comments,
      hasVegetarianOption: hasVegetarianOption
    };
  }
}
