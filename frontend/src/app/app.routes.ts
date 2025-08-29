import {Routes} from '@angular/router';
import {Home} from './core/layout/home/home';
import {EventRegistration} from './domains/event/event-registration/event-registration';
import {FormerList} from '@app/domains/former-teammates/components/former-list/former-list';
import {NotFound} from './core/layout/not-found/not-found';

import {FormerValidation} from '@app/domains/former-teammates/components/former-validation/former-validation';
import {FormerCreate} from '@app/domains/former-teammates/components/former-create/former-create';
import {FormerCard} from '@app/domains/former-teammates/components/former-card/former-card';
import {FormerUpdate} from '@app/domains/former-teammates/components/former-update/former-update';
import {
  FormerValidationSuccess
} from '@app/domains/former-teammates/components/former-validation-success/former-validation-success';

export const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: Home},
  {path: 'event-registration', component: EventRegistration},
  {path: 'former-teammates', component: FormerList},
  {path: 'former-teammates/create', component: FormerCreate},
  {path: 'former-teammates/edit/:id', component: FormerUpdate},
  {path: 'former-teammates/validate/:code', component: FormerValidation},
  {path: 'former-teammates/validated', component: FormerValidationSuccess},
  {path: 'former-teammates/:id', component: FormerCard},
  {path: 'error', component: NotFound},
  {path: '**', component: NotFound}
];
