import {computed, inject, Injectable, resource} from '@angular/core';
import {KEYCLOAK_EVENT_SIGNAL, KeycloakEventType, ReadyArgs, typeEventArgs} from 'keycloak-angular';
import Keycloak from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  isAuthenticatedSignal;
  private readonly keycloakEventSignal = inject(KEYCLOAK_EVENT_SIGNAL);
  private readonly keycloak = inject(Keycloak);
  userProfileResource = resource({
    loader:  async () => {
      try {
        return await this.keycloak.loadUserProfile()
      } catch(e) {
        return undefined
      }
    }
  });
  constructor() {


    this.isAuthenticatedSignal = computed(() => {
      if (this.keycloakEventSignal().type === KeycloakEventType.Ready) {
        return typeEventArgs<ReadyArgs>(this.keycloakEventSignal().args);
      }
      if (this.keycloakEventSignal().type === KeycloakEventType.AuthLogout) {
        return false;
      }
      return false;
    })
  }

  async login(url: string = '/former-teammates') {
    await this.keycloak.login({
      redirectUri: `${window.location.origin}${url}`,
    });
  }

  async logout(url: string = '/former-teammates') {
    await this.keycloak.logout({
      redirectUri: `${window.location.origin}${url}`,
    });
  }

  async register(url: string = '/former-teammates') {
    await this.keycloak.register({
      redirectUri: `${window.location.origin}${url}`,
    });
  }




}
