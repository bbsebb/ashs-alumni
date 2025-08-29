import {Component, inject, signal} from '@angular/core';
import {FormerForm, FormerTeammateFormValue} from '@app/domains/former-teammates/components/former-form/former-form';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {NotificationService} from '@app/shared/services/notification';
import {Router} from '@angular/router';
import {CreateFormerTeammate} from '@app/domains/former-teammates/dto/payloads/createFormerTeammate';
import {FormerTeammateMapper} from '@app/domains/former-teammates/service/former-teammate-mapper';

@Component({
  selector: 'app-former-create',
  imports: [
    FormerForm
  ],
  templateUrl: './former-create.html',
  styleUrl: './former-create.scss'
})
export class FormerCreate {
  // === DEPENDENCY INJECTION ===
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);
  private readonly notificationService = inject(NotificationService);
  private readonly router = inject(Router);
  private readonly mapper = inject(FormerTeammateMapper)
  isSubmitting = signal(false);

  // ==========================================
  // === LEVEL 1: PUBLIC INTERFACE ===
  // ==========================================

  /**
   * Public method called when the form is submitted
   * Validates data and triggers the creation of a new contact
   * @param formerTeammateFormValue - The submitted form data
   */
  onSubmit(formerTeammateFormValue: FormerTeammateFormValue) {
    this.createFormerTeammate(this.mapper.mapFormValueToCreateFormerTeammate(formerTeammateFormValue));
  }

  // ==========================================
  // === LEVEL 2: BUSINESS LOGIC ===
  // ==========================================

  /**
   * Performs the creation of a new former teammate contact via the store
   * Configures handlers for different request states
   * @param formValue - The contact creation object
   */
  private createFormerTeammate(formValue: CreateFormerTeammate) {
    this.isSubmitting.set(true);
    this.formerTeammatesStore.createFormerTeammate(formValue).subscribe({
      next: this.handleSuccess(),
      error: this.handleError(),
      complete: this.handleComplete()
    });
  }

  // ==========================================
  // === LEVEL 3: HANDLERS AND UTILITIES ===
  // ==========================================

  /**
   * Handler called on successful creation
   * Shows success notification and navigates to detail page
   * @returns Callback function to handle the created contact
   */
  private handleSuccess(): (formValue: FormerTeammate) => void {
    return (createdFormerTeammate: FormerTeammate) => {
      this.isSubmitting.set(false);
      this.showSuccessNotification();
      this.navigateToDetail(createdFormerTeammate.id);
    }
  }

  /**
   * Handler called on creation error
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
    return () => console.log('Contact created successfully');
  }

  /**
   * Shows success notification for contact creation
   */
  private showSuccessNotification() {
    this.notificationService.showSuccess('Le contact a été crée');
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


