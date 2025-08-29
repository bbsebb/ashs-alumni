import {
  ApplicationConfig,
  LOCALE_ID,
  provideBrowserGlobalErrorListeners,
  provideZoneChangeDetection
} from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { routes } from './app.routes';
import {provideHttpClient} from '@angular/common/http';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammates-gateway';
import {FormerTeammatesGatewayStub} from '@app/domains/former-teammates/gateways/stub/former-teammates-gateway-stub';
import {FORMER_TEAMMATE_HISTORY_GATEWAY} from '@app/domains/former-teammates/gateways/former-teammate-history-gateway';
import {
  FormerTeammateHistoryGatewayStub
} from '@app/domains/former-teammates/gateways/stub/former-teammate-history-gateway-stub';
import {registerLocaleData} from '@angular/common';
import {MAT_DATE_LOCALE, provideNativeDateAdapter} from '@angular/material/core';
import localeFr from '@angular/common/locales/fr';
import { provideKeycloak } from 'keycloak-angular';
import {environment} from '@environments/environment';

registerLocaleData(localeFr);


export const appConfig: ApplicationConfig = {
  providers: [
    provideNativeDateAdapter(),
    provideHttpClient(),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideAnimationsAsync(),
    provideKeycloak({
      config: {
        url: environment.keycloak.url,
        realm: environment.keycloak.realm,
        clientId: environment.keycloak.clientId,
      },
      initOptions: {
        onLoad: 'check-sso',
        silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html'
      }
    }),
    { provide: LOCALE_ID, useValue: 'fr-FR' },
    { provide: MAT_DATE_LOCALE, useValue: 'fr-FR' },
    {
      provide: FORMER_TEAMMATES_GATEWAY,
      useClass: FormerTeammatesGatewayStub,
    },
    {
      provide: FORMER_TEAMMATE_HISTORY_GATEWAY,
      useClass: FormerTeammateHistoryGatewayStub,
    }
  ]
};
