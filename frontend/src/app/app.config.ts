import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

import { routes } from './app.routes';
import {provideHttpClient} from '@angular/common/http';
import {FORMER_TEAMMATES_GATEWAY} from '@app/domains/former-teammates/former-teammates-gateway';
import {FormerTeammatesGatewayStub} from '@app/domains/former-teammates/stub/former-teammates-gateway-stub';

export const appConfig: ApplicationConfig = {
  providers: [
    provideHttpClient(),
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideAnimationsAsync(),
    {
      provide: FORMER_TEAMMATES_GATEWAY,
      useClass: FormerTeammatesGatewayStub,
    }
  ]
};
