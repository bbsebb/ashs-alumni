import {Component, effect, inject, input, output} from '@angular/core';
import {FormControl, NonNullableFormBuilder, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatError, MatFormField, MatHint, MatInput, MatLabel, MatPrefix, MatSuffix} from '@angular/material/input';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from '@angular/material/datepicker';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {MatButton} from '@angular/material/button';
import {MatProgressBar} from '@angular/material/progress-bar';
import {MatDivider} from '@angular/material/divider';
import {Role} from '@app/domains/former-teammates/models/role';
import {Gender} from '@app/domains/former-teammates/models/gender';
import {PhoneUtils} from '@app/shared/utils/phone-utils';

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
    MatButtonToggleGroup,
    MatButtonToggle,
    RolePipe,
    MatDatepickerInput,
    MatHint,
    MatDatepickerToggle,
    MatDatepicker,
    MatSuffix,
    MatError,
    BackButton,
    MatButton,
    MatProgressBar,
    MatDivider,
    MatPrefix
  ],
  templateUrl: './former-form.html',
  styleUrl: './former-form.scss',
})
export class FormerForm {
  titleInputSignal = input.required<string>({alias: 'title'});
  actionInputSignal = input.required<string>({alias: 'action'});
  prefillFormerTeammateFormValueSignal = input<FormerTeammateFormValue | undefined>(undefined, {alias: 'prefillFormerTeammate'});
  isLoading = input<boolean>(false);
  formerTeammateFormValueSubmitted = output<FormerTeammateFormValue>();

  /** Start date for date picker (set to 1975) */
  readonly startAt = new Date(1975, 0, 1);
  // ===========================
  // PRIVATE DEPENDENCIES
  // ===========================
  /** Available roles for former teammates */
  readonly roles: Role[] = ['PLAYER', 'COACH', 'PRESIDENT', 'ASSISTANT'];
  /** Reactive form for former teammate data */
  formerForm;


  // ===========================
  // PUBLIC PROPERTIES
  // ===========================


  /** Form builder for reactive forms */
  private readonly formBuilder = inject(NonNullableFormBuilder);

  // ===========================
  // CONSTRUCTOR
  // ===========================

  constructor() {
    // Initialize the reactive form
    this.formerForm = this.buildForm();
    effect(() => {
      const prefillFormerTeammate = this.prefillFormerTeammateFormValueSignal();
      if (prefillFormerTeammate) {
        this.populateFormFields(prefillFormerTeammate);
      }
    });
    effect(() => {
      if (this.isLoading()) {
        this.formerForm.disable();
      } else {
        this.formerForm.enable();
      }
    });

  }

  /**
   * Handles form submission for both create and update operations.
   * Validates form data and call the appropriate store method based on the current mode.
   * Shows success/error notifications and navigates to the teammate detail page on success.
   */
  onSubmit(): void {
    if (this.formerForm.valid) {
      const formValue = this.formerForm.getRawValue();
      formValue.phone = PhoneUtils.formatPhoneNumberWithPrefix(formValue.phone);
      this.formerTeammateFormValueSubmitted.emit(formValue);
    }
  }

  // ===========================
  // PRIVATE METHODS
  // ===========================



  /**
   * Populates form fields with data from the teammate being edited.
   * Only called when in edit mode.
   */
  private populateFormFields(formerTeammateFormValue: FormerTeammateFormValue | undefined): void {
    if (!formerTeammateFormValue) {
      return;
    }
    this.formerForm.patchValue({
      gender: formerTeammateFormValue.gender,
      firstName: formerTeammateFormValue.firstName,
      lastName: formerTeammateFormValue.lastName,
      phone: PhoneUtils.removePhoneNumberPrefix(formerTeammateFormValue.phone),
      birthDate: formerTeammateFormValue.birthDate,
      roles: formerTeammateFormValue.roles,
    });
  }


  // ===========================
  // PUBLIC METHODS
  // ===========================


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

}

export interface FormerTeammateFormValue {
  gender: Gender,
  firstName: string,
  lastName: string,
  phone: string | null,
  birthDate: Date | null,
  roles: Role[]
}

