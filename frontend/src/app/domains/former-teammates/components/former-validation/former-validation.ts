import {Component, computed, inject, signal} from '@angular/core';
import {NotificationService} from '@app/shared/services/notification';
import {ActivatedRoute, Router} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {toSignal} from '@angular/core/rxjs-interop';
import {map} from 'rxjs';
import {UUID} from '@app/shared/types/uuid';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FormerForm, FormerTeammateFormValue} from '@app/domains/former-teammates/components/former-form/former-form';
import {UpdateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/updateFormerTeammate';
import {FormerTeammateMapper} from '@app/domains/former-teammates/service/former-teammate-mapper';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {LoadingComponent} from '@app/shared/components/loading/loading';
import {ProblemDetail} from '@app/shared/models/problem-detail';

@Component({
  selector: 'app-former-validation',
  imports: [
    FormerForm,
    LoadErrorComponent,
    LoadingComponent
  ],
  templateUrl: './former-validation.html',
  styleUrl: './former-validation.scss'
})
export class FormerValidation {
  // === DEPENDENCY INJECTION ===
  private readonly mapper = inject(FormerTeammateMapper);
  private readonly notificationService = inject(NotificationService);
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);
  private readonly activatedRoute = inject(ActivatedRoute);
  private readonly router = inject(Router);


  // === COMPONENT STATE ===
  prefillFormerTeammateFormSignal;
  private readonly code;

  //readonly formerTeammate;
  readonly loadedResource
  readonly isLoading
  readonly isSubmitting = signal(false);
  hasError;


  constructor() {
    // Initialize the identifier from route parameters
    this.code = toSignal(this.getCodeFromRoute(), {requireSync: true});
    this.loadedResource = this.formerTeammatesStore.getFormerTeammateByCode(this.code());
    this.hasError = computed(() => !!this.loadedResource.error());
    this.isLoading = this.loadedResource.isLoading;

    // Initialize the form prefill signal
    this.prefillFormerTeammateFormSignal = this.getPrefillFormerTeammateFormSignal();

  }

  // ==========================================
  // === LEVEL 1: PUBLIC INTERFACE ===
  // ==========================================

  /**
   * Public method called when the form is submitted
   * Validates data and triggers the contact update
   * @param formerTeammateFormValue - The submitted form data
   */
  onSubmit(formerTeammateFormValue: FormerTeammateFormValue) {
    const id = this.code();
    this.updateFormerTeammate(this.mapper.mapFormValueToUpdateFormerTeammate(formerTeammateFormValue, id));
  }

  // ==========================================
  // === LEVEL 2: BUSINESS LOGIC ===
  // ==========================================

  /**
   * Performs the former teammate contact update via the store
   * Configures handlers for different request states
   * @param updateFormerTeammate - The contact update object
   */
  private updateFormerTeammate(updateFormerTeammate: UpdateFormerTeammate) {
    this.isSubmitting.set(true);
    this.formerTeammatesStore.validateFormerTeammate(updateFormerTeammate,this.code()).subscribe({
      next: this.handleSuccess(),
      error: this.handleError(),
      complete: this.handleComplete()
    });
  }

  /**
   * Creates a computed signal to prefill the form
   * Retrieves contact data and transforms it to form format
   * @returns Signal containing form data or undefined
   */
  private getPrefillFormerTeammateFormSignal() {

    return computed(() => {
      const formerTeammate = this.loadedResource.value();
      if (!formerTeammate) {
        return undefined;
      }
      return this.mapper.mapFormerTeammateToFormerTeammateFormValue(formerTeammate);
    })
  }


  // ==========================================
  // === LEVEL 3: HANDLERS AND UTILITIES ===
  // ==========================================

  /**
   * Handler called on successful update
   * Shows success notification and navigates to detail page
   * @returns Callback function to handle the updated contact
   */
  private handleSuccess(): (formValue: FormerTeammate) => void {
    return (formerTeammate: FormerTeammate) => {
      this.isSubmitting.set(false);
      this.showSuccessNotification();
      // Navigate to the success page to propose next steps
      void this.router.navigate(['/register', formerTeammate.id]);
    }
  }

  /**
   * Handler called on update error
   * Shows error notification and logs error to console
   * @returns Callback function to handle errors
   */
  private handleError(): (err: any) => void {
    return (err: any) => {
      this.isSubmitting.set(false);
      this.showErrorNotification(err.error as ProblemDetail);
      console.error(err);
    }
  }

  /**
   * Handler called at the end of the request (success or failure)
   * Logs confirmation message to console
   * @returns Callback function for completion
   */
  private handleComplete(): () => void {
    return () => console.log('Contact validated successfully');
  }

  /**
   * Extracts identifier from route parameters
   * @returns Observable containing UUID or undefined
   */
  private getCodeFromRoute() {
    return this.activatedRoute.params.pipe(
      map(params => params['code'] as UUID),
    )
  }

  /**
   * Shows success notification for contact validation
   */
  private showSuccessNotification() {
    this.notificationService.showSuccess('Le contact a été validé');
  }

  /**
   * Shows generic error notification
   */
  private showErrorNotification(err:ProblemDetail) {
    this.notificationService.showError(err,'Une erreur est survenue. Veuillez réessayer plus tard.');
  }


}
