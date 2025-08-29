import {Component, computed, inject, signal, Signal} from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatDividerModule} from '@angular/material/divider';
import {MatExpansionModule} from '@angular/material/expansion';
import {CommonModule} from '@angular/common';

import {toSignal} from '@angular/core/rxjs-interop';
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {FormerTeammateHistoryStore} from '@app/domains/former-teammates/store/former-teammate-history-store';
import {FormerTeammateHistory} from '@app/domains/former-teammates/models/former-teamate-history';
import {ContactStatusChip} from '@app/shared/components/contact-status-chip/contact-status-chip';
import {GenderIcon} from '@app/shared/components/gender-icon/gender-icon';
import {ActionFormerTeammateHistoryPipe} from '@app/shared/pipes/action-former-teammate-history-pipe';
import {RolePipe} from '@app/shared/pipes/role-pipe';
import {BackButton} from '@app/shared/components/back-button/back-button';
import {MatButton} from '@angular/material/button';
import {HasRolesDirective} from 'keycloak-angular';
import {NotificationService} from '@app/shared/services/notification';
import {DialogService} from '@app/shared/services/dialog';
import {EMPTY, switchMap} from 'rxjs';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {LoadingComponent} from '@app/shared/components/loading/loading';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {MatProgressBar} from '@angular/material/progress-bar';

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
    RouterLink,
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
  /** Signal containing the history records for the current former teammate */
  formerTeammateHistoriesSignal: Signal<FormerTeammateHistory[]>;
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
  /** Store for managing former teammate history records */
  private readonly formerTeammateHistoriesStore = inject(FormerTeammateHistoryStore);
  readonly historiesIsLoading = this.formerTeammateHistoriesStore.isLoading();
  readonly historiesHasError = this.formerTeammateHistoriesStore.hasError();

  // ===== CONSTRUCTOR AND INITIALIZATION =====

  constructor() {
    // Initialize computed signals for teammate and their histories
    this.formerTeammateSignal = this.findFormerTeammate();
    this.formerTeammateHistoriesSignal = computed(this.getFormerTeammateHistories());

    this.isLoading = this.formerTeammatesStore.isLoading();
    this.hasError = this.formerTeammatesStore.hasError()

  }

  // ===== PRIVATE METHODS - DATA RETRIEVAL =====

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
  delete() {
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
      error: () => {
        this.isDeleting.set(false);
        // Deletion failed - show an error message
        this.notificationService.showError('Une erreur est survenue. Veuillez réessayer plus tard.');
      }
    });
  }

  /**
   * Creates a computed function to retrieve former teammate histories
   *
   * @returns A function that returns the histories for the current teammate
   *          or an empty array if no teammate ID is available
   */
  private getFormerTeammateHistories() {
    return () => {
      const formerTeammateId = this.formerTeammateSignal()?.id;

      // Return an empty array if no teammate is selected
      if (formerTeammateId === undefined) {
        return [];
      }

      // Retrieve histories from the store and return the signal value
      const formerTeammateHistoriesById = this.formerTeammateHistoriesStore.getFormerTeammateHistoriesById(formerTeammateId);
      return formerTeammateHistoriesById();
    };
  }

  // ===== PUBLIC METHODS - USER ACTIONS =====

  /**
   * Creates a computed function to find the former teammate based on route parameters
   *
   * @returns A function that returns the former teammate matching the route ID,
   *          or undefined if no ID is provided or teammate is not found
   */
  private findFormerTeammate() {
    return this.formerTeammatesStore.getFormerTeammateById(this.paramsRouteSignal()['id'])
  }
}
