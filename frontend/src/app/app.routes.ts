import { Routes } from '@angular/router';
import {Home} from './core/layout/home/home';
import {EventRegistration} from './domains/event/event-registration/event-registration';
import {FormerList} from './domains/former-teammates/former-list/former-list';
import {NotFound} from './core/layout/not-found/not-found';
import {FormerCard} from '@app/domains/former-teammates/former-card/former-card';
import {FormerForm} from '@app/domains/former-teammates/former-create/former-form';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'event-registration', component: EventRegistration },
  { path: 'former-teammates/former-list', component: FormerList },
  { path: 'former-teammates/create', component: FormerForm },
  { path: 'former-teammates/edit/:id', component: FormerForm },
  { path: 'former-teammates/:id', component: FormerCard },
  { path: 'error', component: NotFound },
  { path: '**', component: NotFound }
];
