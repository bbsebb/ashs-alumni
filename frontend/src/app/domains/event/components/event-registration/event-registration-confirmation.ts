import {Component, inject} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from '@angular/material/dialog';
import {MatButton} from '@angular/material/button';
import {ParticipantRequest} from '@app/domains/event/dtos/participant-request';

@Component({
  selector: 'app-event-registration-confirmation',
  standalone: true,
  imports: [
    MatDialogTitle,
    MatDialogContent,
    MatDialogActions,
    MatButton
  ],
  template: `
    <h2 mat-dialog-title>Confirmation inscription</h2>
    <mat-dialog-content>
      <p>Veuillez vérifier les informations suivantes :</p>
      <ul>
        <li><strong>Nom :</strong> {{ data.lastname }}</li>
        <li><strong>Prénom :</strong> {{ data.firstname }}</li>
        <li><strong>Email :</strong> {{ data.email }}</li>
        <li><strong>Option végétarienne :</strong> {{ data.hasVegetarianOption ? 'Oui' : 'Non' }}</li>
        <li><strong>Commentaires :</strong> {{ data.comments ? 'Oui' : 'Non' }}</li>
      </ul>

      <div class="info-box">
        <p>
          Nous communiquerons par la suite pour l'événement <strong>par email</strong> afin d'éviter des coûts supplémentaires.
        </p>
        <p>
          Le paiement des <strong>25€</strong> se fait sur place à la soirée.
        </p>
        <p class="warning">
          Merci de prévenir au moins une semaine à l'avance pour annuler à
          <a href="mailto:sebastien.burckhardt@hoenheimsports.fr">sebastien.burckhardt&#64;hoenheimsports.fr</a>
          pour éviter les frais supplémentaires.
        </p>
      </div>
    </mat-dialog-content>
    <mat-dialog-actions align="end">
      <button mat-button (click)="onCancel()">Annuler</button>
      <button mat-raised-button color="primary" (click)="onConfirm()">Confirmer l'inscription</button>
    </mat-dialog-actions>
  `,
  styles: [`
    ul { margin-bottom: 20px; }
    li { margin-bottom: 8px; }
    .info-box {
      background-color: #f5f5f5;
      padding: 15px;
      border-radius: 4px;
      font-size: 0.95rem;
    }
    .warning {
      margin-top: 15px;
      font-style: italic;
      color: #d32f2f;
    }
  `]
})
export class EventRegistrationConfirmation {
  readonly data = inject<ParticipantRequest>(MAT_DIALOG_DATA);
  private readonly dialogRef = inject(MatDialogRef<EventRegistrationConfirmation>);

  onConfirm() {
    this.dialogRef.close(true);
  }

  onCancel() {
    this.dialogRef.close(false);
  }
}
