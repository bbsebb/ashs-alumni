import {computed, inject, Injectable} from '@angular/core';
import {KEYCLOAK_EVENT_SIGNAL, KeycloakEventType, ReadyArgs, typeEventArgs} from 'keycloak-angular';
import Keycloak from 'keycloak-js';
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  isAuthenticatedSignal ;
  private readonly keycloakEventSignal = inject(KEYCLOAK_EVENT_SIGNAL);
  private readonly keycloak = inject(Keycloak);

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

  async login() {
    await this.keycloak.login();
  }

  async logout() {
    await this.keycloak.logout();
  }



}
