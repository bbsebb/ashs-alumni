import {Component, computed, effect, inject, signal, Signal} from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {CommonModule} from '@angular/common';

import {toSignal} from '@angular/core/rxjs-interop';
import {ActivatedRoute, Router} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {ContactStatusChip} from '@app/shared/components/contact-status-chip/contact-status-chip';
import {GenderIcon} from '@app/shared/components/gender-icon/gender-icon';
import {ActionFormerTeammateHistoryPipe} from '@app/shared/pipes/action-former-teammate-history-pipe';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {MatButton} from '@angular/material/button';
import {HasRolesDirective} from 'keycloak-angular';
import {NotificationService} from '@app/shared/services/notification';
import {DialogService} from '@app/shared/services/dialog';
import {EMPTY, filter, switchMap} from 'rxjs';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {LoadingComponent} from '@app/shared/components/loading/loading';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {MatProgressBar} from '@angular/material/progress-bar';
import {ProblemDetail} from '@app/shared/models/problem-detail';

/**
 * FormerCard Component
 *
 * This component displays detailed information about a former teammate,
 * including their personal details and history records. It provides functionality
 * to view teammate information and delete teammate records with confirmation.
 *
 * Features:
 * - Displays former teammate details in a card format
 * - Shows teammate history information
 * - Handles route parameters to identify the teammate
 * - Provides delete functionality with confirmation dialog
 * - Displays loading and error states using dedicated components
 */
@Component({
  selector: 'app-former-card',
  imports: [
    CommonModule,
    MatCardModule,
    MatChipsModule,
    MatIconModule,
    MatBadgeModule,
    MatDividerModule,
    MatExpansionModule,
    ContactStatusChip,
    GenderIcon,
    ActionFormerTeammateHistoryPipe,
    RolePipe,
    BackButton,
    MatButton,
    HasRolesDirective,
    LoadingComponent,
    LoadErrorComponent,
    MatProgressBar
  ],
  templateUrl: './former-card.html',
  styleUrl: './former-card.scss'
})
export class FormerCard {
  // ===== DEPENDENCY INJECTIONS =====

  /** Signal containing current route parameters, used to extract teammate ID */
  paramsRouteSignal = toSignal(inject(ActivatedRoute).params.pipe(), {requireSync: true});
  /** Signal containing the current former teammate data based on route parameters */
  formerTeammateSignal: Signal<FormerTeammate | undefined>;
  isRemovedFormerTeammateSignal = computed(
    () => this.formerTeammateSignal()?.formerTeammateHistories?.some(
      formerTeammateHistory => formerTeammateHistory.historyAction === 'REMOVED')
  )

  isMarkedAsNotRequestedFormerTeammateSignal = computed(() => this.formerTeammateSignal()?.status === 'NOT_REQUESTED')

  /** Loading state signal for the former teammates resource */
  isLoading: Signal<boolean>;
  /** Error state signal for the former teammates resource */
  hasError: Signal<boolean>;
  isDeleting = signal(false);
  private readonly notificationService = inject(NotificationService);
  /** Service for displaying confirmation and other dialogs */
  private readonly dialogService = inject(DialogService);

  // ===== SIGNALS AND COMPUTED PROPERTIES =====
  /** Angular router for navigation */
  private readonly router = inject(Router);
  /** Store for managing former teammates data */
  private readonly formerTeammatesStore = inject(FormerTeammatesStore);


  // ===== CONSTRUCTOR AND INITIALIZATION =====

  constructor() {
    // Initialize computed signals for teammate and their histories
    this.formerTeammateSignal = this.findFormerTeammate();

    this.isLoading = this.formerTeammatesStore.isLoading();
    this.hasError = this.formerTeammatesStore.hasError();
    effect(() => {
      console.log('isRemovedFormerTeammateSignal', this.isRemovedFormerTeammateSignal());
    });

  }



  /**
   * Handles the deletion of the current former teammate
   *
   * This method:
   * 1. Validates that a teammate is currently selected
   * 2. Shows a confirmation dialog to the user
   * 3. Processes the deletion if confirmed
   * 4. Shows success/error notifications
   * 5. Navigates back to the teammate's list on success
   */
  onDelete() {
    this.isDeleting.set(true);
    const formerTeammate = this.formerTeammateSignal();

    // Defensive check to ensure teammate exists before attempting deletion
    if (!formerTeammate) {
      console.warn('the teammate is undefined');
      return;
    }

    // Prepare confirmation dialog content
    const content = `êtes-vous sur de supprimer le contact ${formerTeammate.firstName} ${formerTeammate.lastName}`;
    const title = 'Confirmation suppression';

    // Show a confirmation dialog and handle the response
    this.dialogService.showConfirmation(content, title).pipe(
      switchMap((confirmation) => {
        if (confirmation) {
          // User confirmed deletion - proceed with deletion
          return this.formerTeammatesStore.deleteTeammate(formerTeammate.id);
        } else {
          // User cancelled deletion - return empty observable
          this.isDeleting.set(false);
          return EMPTY;
        }
      })
    ).subscribe({
      next: () => {

        // Deletion successful - show a success message and navigate away
        this.notificationService.showSuccess('Le contact a été supprimé');
        void this.router.navigate(['/former-teammates']);
        console.log('Contact deleted.');
      },
      error: (err) => {
        this.isDeleting.set(false);
        // Deletion failed - show an error message
        this.notificationService.showError(err.error as ProblemDetail,'Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });
  }

  protected onSendSMS() {
    const formerTeammate = this.formerTeammateSignal();

    // Defensive check to ensure teammate exists before attempting deletion
    if (!formerTeammate) {
      console.warn('the teammate is undefined');
      return;
    }

    // Prepare confirmation dialog content
    const content = `Vous allez renvoyer un SMS à ${formerTeammate.firstName} ${formerTeammate.lastName} au numéro suivant : ${formerTeammate.phone}`;
    const title = 'Confirmation l\'envoie';

    // Show a confirmation dialog and handle the response
    this.dialogService.showConfirmation(content, title).pipe(
      filter(response => response),
      switchMap((confirmation) => {
          return this.formerTeammatesStore.handleResendSMS(formerTeammate.id);
      })
    ).subscribe({
      next: () => {

        // Deletion successful - show a success message and navigate away
        this.notificationService.showSuccess('Le sms a été renvoyé');
        console.log('SMS  sent.');
      },
      error: (err) => {
        // Deletion failed - show an error message
        this.notificationService.showError(err.error as ProblemDetail,'Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });

  }


  private findFormerTeammate() {
    return this.formerTeammatesStore.getFormerTeammateById(this.paramsRouteSignal()['id'])
  }


  protected onUpdate() {
    const formerTeammate = this.formerTeammateSignal();

    // Defensive check to ensure teammate exists before attempting deletion
    if (!formerTeammate) {
      console.warn('the teammate is undefined');
      return;
    }

    if(formerTeammate.status !== "VALIDATED") {
      return void this.router.navigate(['/former-teammates','edit', formerTeammate.id]);
    }

    // Prepare confirmation dialog content
    const content = `Le contact a déjà été validé par son propriétaire et ne devrait plus être modifié. Êtes-vous sur de modifier le contact ${formerTeammate.firstName} ${formerTeammate.lastName}`;
    const title = 'Allez à la page de modification';

    // Show a confirmation dialog and handle the response
    this.dialogService.showConfirmation(content, title)
      .pipe(filter(response => response))
      .subscribe({
      next: (response) => {
          void this.router.navigate(['/former-teammates','edit', formerTeammate.id]);
      },
      error: (err) => {
        this.notificationService.showError(err.error as ProblemDetail,'Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });
  }

  protected onMarkNotRequested() {
    const formerTeammate = this.formerTeammateSignal();

    // Defensive check to ensure teammate exists before attempting deletion
    if (!formerTeammate) {
      console.warn('the teammate is undefined');
      return;
    }
    // Prepare confirmation dialog content
    const content = `Le contact  « ${formerTeammate.firstName} ${formerTeammate.lastName} » sera noté comme ne souhaitant plus être contacté`;
    const title = 'Marquer le contact comme non sollicité';

    // Show a confirmation dialog and handle the response
    this.dialogService.showConfirmation(content, title)

      .pipe(
        filter(response => response),
        switchMap(() => this.formerTeammatesStore.handleMarkAsNotRequested(formerTeammate.id))
      )
      .subscribe({
      next: (response) => {
        this.notificationService.showSuccess('Le status du contact a été mis à jour vers « NON SOLLICITÉ »');
      },
      error: (err) => {
        this.notificationService.showError(err.error as ProblemDetail,'Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });
  }
}
