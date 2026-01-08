import {Component, computed, inject, ResourceRef} from '@angular/core';
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
import {ActivatedRoute, Router, RouterLink} from '@angular/router';
import {LoadErrorComponent} from '@app/shared/components/load-error/load-error';
import {LoadingComponent} from '@app/shared/components/loading/loading';
import {Gender} from '@app/domains/former-teammates/models/gender';
import {ContactStatus} from '@app/domains/former-teammates/models/contact-status';

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
  private readonly router = inject(Router);
  private readonly route = inject(ActivatedRoute);
  private readonly queryParams = toSignal(this.route.queryParamMap);
  private readonly store = inject(FormerTeammatesStore);
  // Injected services
  readonly formerTeammatesResource: ResourceRef<FormerTeammate[] | undefined> = this.store.formerTeammatesResourceRef;
  readonly breakpointObserver = toSignal(inject(BreakpointObserver).observe([Breakpoints.XSmall]));

  // Table configuration
  readonly filteredFormerTeammates = this.filterData();

  // Signals
  readonly formerTeammatesFilterSignal = computed<FormerTeammatesFilter>(() => {
    const params = this.queryParams();

    return {
      gender: (params?.getAll('gender') ?? []) as Gender[],
      contactStatus: (params?.getAll('contactStatus') ?? []) as ContactStatus[],
      searchByName: params?.get('searchByName') ?? ''
    };
  });

  /**
   * Constructeur du composant.
   * Initialise les effets pour la mise à jour automatique des données filtrées
   * et la configuration de la pagination et du tri.
   */
  constructor() {
    // 2. Restauration au chargement initial :
    // Si l'URL est vide mais que le store a des données, on les remet dans l'URL
    const params = inject(ActivatedRoute).snapshot.queryParamMap;
    const savedFilter = this.store.filterState();

    if (params.keys.length === 0 && (savedFilter.gender.length > 0 || savedFilter.contactStatus.length > 0 || savedFilter.searchByName)) {
      this.applyFiltersToUrl(savedFilter);
    }
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
    this.store.filterState.set($event);
    this.applyFiltersToUrl($event);
  }

  private applyFiltersToUrl(filter: FormerTeammatesFilter) {
    void this.router.navigate([], {
      relativeTo: this.route,
      queryParams: {
        gender: filter.gender.length ? filter.gender : null,
        contactStatus: filter.contactStatus.length ? filter.contactStatus : null,
        searchByName: filter.searchByName || null
      },
      queryParamsHandling: 'merge',
    });
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
    let searchByNameFilter = this.formerTeammatesFilterSignal().searchByName.toLowerCase();
    if (searchByNameFilter.trim().length === 0) {
      return true;
    }
    return formerTeammate.firstName.toLowerCase().includes(searchByNameFilter) || formerTeammate.lastName.toLowerCase().includes(searchByNameFilter);
  }
}
