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

export const routes: Routes = [
  {path: '', redirectTo: '/former-teammates', pathMatch: 'full'},
  {path: 'event-registration', component: Event},
  {path: 'former-teammates', component: FormerList},
  {path: 'former-teammates/create', component: FormerCreate},
  {path: 'former-teammates/edit/:id', component: FormerUpdate},
  {path: 'former-teammates/validate/:code', component: FormerValidation},
  {path: 'former-teammates/validated', component: FormerValidationSuccess},
  {path: 'former-teammates/:id', component: FormerCard},
  {path: 'error', component: NotFound},
  {path: '**', component: NotFound}
];
