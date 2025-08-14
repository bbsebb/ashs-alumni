import {Component, computed, inject, ResourceRef, signal, WritableSignal} from '@angular/core';
import {ReactiveFormsModule} from '@angular/forms';
import {MatSortModule} from '@angular/material/sort';
import {FormerTeammate} from '@app/domains/former-teammates/models/former-teammates';
import {FormerTeammatesStore} from '@app/domains/former-teammates/store/former-teammates-store';
import {FormerTable} from '@app/domains/former-teammates/components/former-list/former-table/former-table';
import {
  FormerFilter,
  FormerTeammatesFilter
} from '@app/domains/former-teammates/components/former-list/former-filter/former-filter';
import {MatFabButton} from '@angular/material/button';
import {MatIcon} from '@angular/material/icon';
import {toSignal} from '@angular/core/rxjs-interop';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {RouterLink} from '@angular/router';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {LoadingComponent} from '@app/shared/components/loading/loading';

@Component({
  selector: 'app-former-list',
  standalone: true,
  imports: [
    MatSortModule,
    ReactiveFormsModule,
    FormerTable,
    FormerFilter,
    LoadingComponent,
    MatFabButton,
    MatIcon,
    RouterLink,
    LoadErrorComponent,

  ],
  templateUrl: './former-list.html',
  styleUrl: './former-list.scss'
})
export class FormerList {

  // Injected services
  readonly formerTeammatesResource: ResourceRef<FormerTeammate[] | undefined> = inject(FormerTeammatesStore).formerTeammatesResourceRef;
  readonly breakpointObserver = toSignal(inject(BreakpointObserver).observe([Breakpoints.XSmall]));

  // Table configuration
  readonly filteredFormerTeammates = this.filterData();

  // Signals
  private readonly formerTeammatesFilterSignal: WritableSignal<FormerTeammatesFilter> = signal({
    gender: [],
    contactStatus: [],
    searchByName: ''
  });

  /**
   * Constructeur du composant.
   * Initialise les effets pour la mise à jour automatique des données filtrées
   * et la configuration de la pagination et du tri.
   */
  constructor() {
  }

  /**
   * Crée un signal computed qui filtre les données des anciens coéquipiers
   * en appliquant successivement les filtres par genre, statut de contact et nom.
   * @returns Signal computed contenant la liste filtrée des anciens coéquipiers
   */
  filterData() {
    return computed(() => {
      if (!this.formerTeammatesResource.hasValue()) {
        return [];
      }

      return this.formerTeammatesResource.value()
        .filter((formerTeammate) => this.filterByGender(formerTeammate))
        .filter((formerTeammate) => this.filterByContactStatus(formerTeammate))
        .filter((formerTeammate) => this.filterByName(formerTeammate))
    })
  }

  filterChange($event: FormerTeammatesFilter) {
    this.formerTeammatesFilterSignal.set($event)
  }

  /**
   * Filtre un ancien coéquipier par genre selon les critères sélectionnés.
   * @param formerTeammate L'ancien coéquipier à filtrer
   * @returns true si l'ancien coéquipier correspond aux critères de genre ou si aucun filtre n'est appliqué
   */
  private filterByGender(formerTeammate: FormerTeammate): boolean {
    let genderFilter = this.formerTeammatesFilterSignal().gender;
    if (genderFilter.length === 0) {
      return true;
    }
    return genderFilter.includes(formerTeammate.gender);
  }

  /**
   * Filtre un ancien coéquipier par statut de contact selon les critères sélectionnés.
   * @param formerTeammate L'ancien coéquipier à filtrer
   * @returns true si l'ancien coéquipier correspond aux critères de statut ou si aucun filtre n'est appliqué
   */
  private filterByContactStatus(formerTeammate: FormerTeammate): boolean {
    let contactStatusFilter = this.formerTeammatesFilterSignal().contactStatus;
    if (contactStatusFilter.length === 0) {
      return true;
    }
    return contactStatusFilter.includes(formerTeammate.status);
  }

  /**
   * Filtre un ancien coéquipier par nom (prénom ou nom de famille) selon le terme de recherche.
   * @param formerTeammate L'ancien coéquipier à filtrer
   * @returns true si le prénom ou nom de famille contient le terme de recherche ou si aucun terme n'est saisi
   */
  private filterByName(formerTeammate: FormerTeammate): boolean {
    let searchByNameFilter = this.formerTeammatesFilterSignal().searchByName;
    if (searchByNameFilter.trim().length === 0) {
      return true;
    }
    return formerTeammate.firstName.includes(searchByNameFilter) || formerTeammate.lastName.includes(searchByNameFilter);
  }
}
