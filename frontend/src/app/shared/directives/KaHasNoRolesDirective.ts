import {Directive, effect, inject, input, TemplateRef, ViewContainerRef} from '@angular/core';
import Keycloak from 'keycloak-js';
import {KEYCLOAK_EVENT_SIGNAL, KeycloakEventType, ReadyArgs, typeEventArgs} from 'keycloak-angular';

@Directive({
  selector: '[kaHasNoRoles]',
  standalone: true
})
export class KaHasNoRolesDirective {

  private templateRef = inject<TemplateRef<unknown>>(TemplateRef);
  private viewContainer = inject(ViewContainerRef);
  private keycloak = inject(Keycloak);
  private keycloakSignal = inject(KEYCLOAK_EVENT_SIGNAL);


  roles = input.required<string[]>({ alias: 'kaHasNoRoles' });

  /**
   * Ressource (Signal Input optionnel).
   */
  resource = input<string | undefined>(undefined, { alias: 'kaHasNoRolesResource' });

  /**
   * Check Realm (Signal Input avec valeur par défaut).
   */
  checkRealm = input(false, { alias: 'kaHasNoRolesCheckRealm' });

  constructor() {
    this.viewContainer.clear();



    /**
     * This effect will reevaluate roles after authentication or token refresh.
     * Or clear the view on logout.
     */
    effect(() => {
      const keycloakEvent = this.keycloakSignal();

      switch (keycloakEvent.type) {
        case KeycloakEventType.Ready: {
          const authenticated = typeEventArgs<ReadyArgs>(keycloakEvent.args);
          if (!authenticated) {
            this.render();
          } else {
            this.viewContainer.clear();
          }
          break;
        }
        case KeycloakEventType.AuthSuccess:
        case KeycloakEventType.AuthRefreshSuccess:
        case KeycloakEventType.TokenExpired:
          this.render();
          break;
        case KeycloakEventType.AuthLogout:
          this.viewContainer.clear();
          break;
        default:
          break;
      }
    });
  }

  /**
   * Clear the view and render it if user has access.
   */
  private render(): void {

    const hasAccess = this.checkUserHasNoRoles();
    this.viewContainer.clear();

    if (hasAccess) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }
  }

  /**
   * Checks if the user has at least one of the specified roles in the resource or realm.
   * @returns True if the user has access, false otherwise.
   */
  private checkUserHasNoRoles(): boolean {
    // On accède aux valeurs via les parenthèses () car ce sont des signaux
    const currentRoles = this.roles();
    const currentResource = this.resource();
    const isRealmChecked = this.checkRealm();
    console.log(currentRoles, currentResource, isRealmChecked);
    const hasResourceRole = currentRoles.some((role) => this.keycloak.hasResourceRole(role, currentResource));

    const hasRealmRole = isRealmChecked ? currentRoles.some((role) => this.keycloak.hasRealmRole(role)) : false;

    return !hasResourceRole && !hasRealmRole;
  }
}
