import { Routes } from '@angular/router';
import {Home} from './core/layout/home/home';
import {EventRegistration} from './domains/event/event-registration/event-registration';
import {FormerList} from './domains/former-teammates/former-list/former-list';
import {NotFound} from './core/layout/not-found/not-found';

export const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'event-registration', component: EventRegistration },
  { path: 'former-teammates/former-list', component: FormerList },
  { path: '**', component: NotFound }
];
