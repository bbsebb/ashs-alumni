import {Component, computed, inject, signal} from '@angular/core';
import {FormerForm, FormerTeammateFormValue} from '@app/domains/former-teammates/components/former-form/former-form';
import {ActivatedRoute, Router} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {map} from 'rxjs';
import {toSignal} from '@angular/core/rxjs-interop';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {UUID} from '@app/shared/types/uuid';
import {UpdateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/updateFormerTeammate';
import {NotificationService} from '@app/shared/services/notification';
import {FormerTeammateMapper} from '@app/domains/former-teammates/service/former-teammate-mapper';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {LoadingComponent} from '@app/shared/components/loading/loading';


@Component({
  selector: 'app-former-update',
  imports: [
    FormerForm,
    LoadErrorComponent,
    LoadingComponent
  ],
  templateUrl: './former-update.html',
  styleUrl: './former-update.scss'
})
export class FormerUpdate {
  // === DEPENDENCY INJECTION ===
  private readonly mapper = inject(FormerTeammateMapper)
  private readonly notificationService = inject(NotificationService);
  private readonly router = inject(Router);
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);
  private readonly activatedRoute = inject(ActivatedRoute);

  // === COMPONENT STATE ===
  prefillFormerTeammateFormSignal;
  private readonly id;
  isLoading;
  hasError;
  isSubmitting = signal(false)

  constructor() {
    // Initialize the identifier from route parameters
    this.id = toSignal(this.getIdFromRoute(), {requireSync: true});

    // Initialize the form prefill signal
    this.prefillFormerTeammateFormSignal = this.getPrefillFormerTeammateFormSignal();
    this.isLoading = this.formerTeammatesStore.isLoading();
    this.hasError = this.formerTeammatesStore.hasError()
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
    const id = this.id();
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
    this.formerTeammatesStore.updateFormerTeammate(updateFormerTeammate).subscribe({
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
      const formerTeammate = this.formerTeammatesStore.getFormerTeammateById(this.id())()
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
    return (updatedFormerTeammate: FormerTeammate) => {
      this.isSubmitting.set(false);
      this.showSuccessNotification();
      this.navigateToDetail(updatedFormerTeammate.id);
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
      this.showErrorNotification();
      console.error(err);
    }
  }

  /**
   * Handler called at the end of the request (success or failure)
   * Logs confirmation message to console
   * @returns Callback function for completion
   */
  private handleComplete(): () => void {
    return () => console.log('Contact updated successfully');
  }

  /**
   * Extracts identifier from route parameters
   * @returns Observable containing UUID or undefined
   */
  private getIdFromRoute() {
    return this.activatedRoute.params.pipe(
      map(params => params['id'] as UUID))
  }

  /**
   * Shows success notification for contact modification
   */
  private showSuccessNotification() {
    this.notificationService.showSuccess('Le contact a été modifié');
  }

  /**
   * Shows generic error notification
   */
  private showErrorNotification() {
    this.notificationService.showError('Une erreur est survenue. Veuillez réessayer plus tard.');
  }


  /**
   * Navigates to contact detail page
   * @param id - The contact identifier to display
   */
  private navigateToDetail(id: string) {
    void this.router.navigate(['/former-teammates', id]);
  }

}
