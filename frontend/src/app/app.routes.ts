import {Routes} from '@angular/router';
import {FormerList} from '@app/domains/former-teammates/components/former-list/former-list';
import {NotFound} from './core/layout/not-found/not-found';

import {FormerValidation} from '@app/domains/former-teammates/components/former-validation/former-validation';
import {FormerCreate} from '@app/domains/former-teammates/components/former-create/former-create';
import {FormerCard} from '@app/domains/former-teammates/components/former-card/former-card';
import {FormerUpdate} from '@app/domains/former-teammates/components/former-update/former-update';
import {
  FormerValidationSuccess
} from '@app/domains/former-teammates/components/former-validation-success/former-validation-success';
import {Event} from '@app/domains/event/components/event';
import {Register} from '@app/domains/auth/components/register/register';
import {RegisterConfirmation} from '@app/domains/auth/components/register-confirmation/register-confirmation';

export const routes: Routes = [
  { path: '', redirectTo: '/former-teammates', pathMatch: 'full' },

  // Groupe : Événements
  {
    path: 'event-registration',
    title: 'Événement',
    children: [
      { path: '', component: Event }
    ]
  },

  // Groupe : Anciens coéquipiers
  {
    path: 'former-teammates',
    title: 'Anciens coéquipiers',
    children: [
      { path: '', component: FormerList },
      { path: 'create', component: FormerCreate, title: 'Ajouter' },
      { path: 'edit/:id', component: FormerUpdate, title: 'Modifier' },
      { path: 'validate/:code', component: FormerValidation, title: 'Validation' },
      { path: 'validated', component: FormerValidationSuccess, title: 'Confirmation' },
      { path: ':id', component: FormerCard, title: 'Details' },
    ]
  },

  // Groupe : Inscription
  {
    path: 'register',
    title: 'Inscription',
    children: [
      { path: '', component: Register },
      { path: 'confirmation', component: RegisterConfirmation, title: 'Confirmation' },
      { path: ':id', component: Register, title: 'Détails' },
    ]
  },

  { path: 'error', component: NotFound, title: 'Erreur' },
  { path: '**', component: NotFound, title: 'Page non trouvée' }
];
