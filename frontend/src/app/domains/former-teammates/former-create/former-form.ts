import {ChangeDetectionStrategy, Component, computed, effect, inject} from '@angular/core';
import {toSignal} from '@angular/core/rxjs-interop';
import {FormControl, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {MatError, MatFormField, MatHint, MatInput, MatLabel, MatSuffix} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from '@angular/material/datepicker';
import {FormerTeammate, Gender, Role} from '@app/domains/former-teammates/models/former-teammates';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {NotificationService} from '@app/shared/services/notification';

/**
 * Component for creating and editing former teammates.
 * Handles both create and update operations through a reactive form.
 */
@Component({
  selector: 'app-former-form',
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
  templateUrl: './former-form.html',
  styleUrl: './former-form.scss',
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class FormerForm {
  // ===========================
  // PRIVATE DEPENDENCIES
  // ===========================

  /** Route parameters as signal */
  private readonly activatedRoute = toSignal(inject(ActivatedRoute).params);

  /** Store for managing former teammates data */
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);

  /** Signal containing the teammate to edit (undefined for create mode) */
  private readonly formerTeammateToEditSignal = this.formerTeammatesStore.getFormerTeammateById(this.activatedRoute()?.['id']);

  /** Service for showing notifications */
  private readonly notification = inject(NotificationService);

  /** Router for navigation */
  private readonly router = inject(Router);

  /** Form builder for reactive forms */
  private readonly formBuilder = inject(NonNullableFormBuilder);

  // ===========================
  // PUBLIC PROPERTIES
  // ===========================

  /** Start date for date picker (set to 1975) */
  readonly startAt = new Date(1975, 0, 1);

  /** Available roles for former teammates */
  readonly roles: Role[] = ['PLAYER', 'COACH', 'PRESIDENT', 'ASSISTANT'];

  /** Reactive form for former teammate data */
  formerForm;

  /** Signal indicating if component is in create mode (true) or edit mode (false) */
  isCreateModeSignal = computed(() => this.formerTeammateToEditSignal() === undefined);

  // ===========================
  // CONSTRUCTOR
  // ===========================

  constructor() {
    // Initialize the reactive form
    this.formerForm = this.buildForm();

    // Set up reactive effects for form population and validation
    effect(() => {
      this.redirectIfInvalidTeammate();
      if (!this.isCreateModeSignal()) {
        this.populateFormFields();
      }
    });
  }

  // ===========================
  // PRIVATE METHODS
  // ===========================

  /**
   * Populates form fields with data from the teammate being edited.
   * Only called when in edit mode.
   */
  private populateFormFields(): void {
    this.formerForm.patchValue({
      gender: this.formerTeammateToEditSignal()?.gender,
      firstName: this.formerTeammateToEditSignal()?.firstName,
      lastName: this.formerTeammateToEditSignal()?.lastName,
      phone: this.formerTeammateToEditSignal()?.phone,
      birthDate: this.formerTeammateToEditSignal()?.birthDate,
      roles: this.formerTeammateToEditSignal()?.roles,
    });
  }

  /**
   * Redirects to error page if trying to edit a non-existent teammate.
   * Validates that the ID in the route corresponds to an existing teammate.
   */
  private redirectIfInvalidTeammate(): void {
    if (this.formerTeammateToEditSignal() === undefined && this.activatedRoute()?.['id'] !== undefined) {
      void this.router.navigate(['/error']);
    }
  }

  /**
   * Builds and configures the reactive form with validation rules.
   * @returns FormGroup with all form controls and their validators
   */
  private buildForm() {
    return this.formBuilder.group({
      gender: new FormControl<Gender>('M', {nonNullable: true, validators: [Validators.required]}),
      firstName: new FormControl<string>('', {nonNullable: true, validators: [Validators.required]}),
      lastName: new FormControl<string>('', {nonNullable: true, validators: [Validators.required]}),
      phone: new FormControl<string>(''),
      birthDate: new FormControl<Date | null>(null),
      roles: new FormControl<Role[]>([], {nonNullable: true}),
    });
  }

  // ===========================
  // PUBLIC METHODS
  // ===========================

  /**
   * Handles form submission for both create and update operations.
   * Validates form data and calls appropriate store method based on current mode.
   * Shows success/error notifications and navigates to teammate detail page on success.
   */
  onSubmit(): void {
    console.log(this.formerForm.errors);

    if (this.formerForm.valid) {
      console.log(this.isCreateModeSignal());

      // Determine operation based on current mode (create vs edit)
      const saveFormerTeammate$ = this.isCreateModeSignal() ?
        this.formerTeammatesStore.createFormerTeammate(this.formerForm.getRawValue())
        : this.formerTeammatesStore.updateFormerTeammate({
          id: this.formerTeammateToEditSignal()!.id,
          ...this.formerForm.getRawValue()
        });

      // Prepare success messages based on operation type
      const successMessage = this.isCreateModeSignal() ?
        'Contact a été crée' :
        'Contact a été modifié';
      const logMessage = this.isCreateModeSignal() ?
        'Contact created.' :
        'Contact updated.';

      // Execute the save operation
      saveFormerTeammate$.subscribe({
        next: (formerTeammate: FormerTeammate) => {
          this.notification.showSuccess(successMessage);
          void this.router.navigate(['/former-teammates', formerTeammate.id]);
        },
        error: (err) => {
          this.notification.showError('Une erreur est survenue. Veuillez réessayer plus tard.');
          console.error(err);
        },
        complete: () => console.log(logMessage)
      });
    }
  }



}


