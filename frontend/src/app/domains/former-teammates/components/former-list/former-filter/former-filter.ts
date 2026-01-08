import {Component, computed, effect, inject, input, OnInit, output, signal} from '@angular/core';
import {FormBuilder, FormControl, ReactiveFormsModule} from '@angular/forms';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {MatExpansionPanel, MatExpansionPanelHeader, MatExpansionPanelTitle} from '@angular/material/expansion';
import {ContactStatusPipe} from '@app/shared/pipes/contact-status-pipe';
import {Gender} from '@app/domains/former-teammates/models/gender';
import {CONTACT_STATUSES, ContactStatus} from '@app/domains/former-teammates/models/contact-status';
import {MatIcon} from '@angular/material/icon';
import {MatIconButton} from '@angular/material/button';

@Component({
  selector: 'app-former-filter',
  imports: [
    ReactiveFormsModule,
    MatButtonToggleGroup,
    MatButtonToggle,
    MatFormField,
    MatLabel,
    MatInput,
    MatExpansionPanel,
    MatExpansionPanelHeader,
    MatExpansionPanelTitle,
    ContactStatusPipe,
    MatIcon,
    MatIconButton
  ],
  templateUrl: './former-filter.html',
  styleUrl: './former-filter.scss'
})
export class FormerFilter implements OnInit{
  formerTeammatesFilterSignal = input<FormerTeammatesFilter>();
  // Output
  filterChange = output<FormerTeammatesFilter>()

  // Détermine si le panel doit être ouvert
  readonly panelOpen = signal(false);
  // 2. Un computed juste pour savoir si on affiche le bouton "Reset"
  readonly hasActiveFilters = computed(() => {
    const v = this.formerTeammatesFilterSignal();
    if (!v) return false;
    return v.gender.length > 0 || v.contactStatus.length > 0 || v.searchByName.trim().length > 0;
  });

  private hasAutoExpanded = false;
  // Injected services
  private readonly formBuilder = inject(FormBuilder);

  // Form controls
  readonly formFilter = this.formBuilder.group({
    gender: new FormControl<Gender[]>([]),
    contactStatus: new FormControl<ContactStatus[]>([]),
    searchByName: new FormControl<string>('')
  });

  readonly statusFilter: ContactStatus[] = CONTACT_STATUSES;


  constructor() {
    effect(() => {
      const filter = this.formerTeammatesFilterSignal();
      if (filter) {
        this.formFilter.patchValue(filter, { emitEvent: false });

        // 3. Logique d'ouverture automatique au chargement
        // On ne l'exécute que si on n'a pas encore auto-expand et qu'il y a des filtres
        if (!this.hasAutoExpanded && (filter.gender.length > 0 || filter.contactStatus.length > 0 || filter.searchByName)) {
          this.panelOpen.set(true);
          this.hasAutoExpanded = true;
        }
      }
    });
  }

  ngOnInit(): void {
    this.formFilter.valueChanges.subscribe( filter => this.filterChange.emit({
      gender: filter.gender ?? [],
      contactStatus: filter.contactStatus ?? [],
      searchByName: filter.searchByName ?? ''
    }))

  }

  /**
   * Réinitialise le formulaire aux valeurs par défaut
   */
  resetFilters() {
    this.formFilter.setValue({
      gender: [],
      contactStatus: [],
      searchByName: ''
    });
  }
}

export interface FormerTeammatesFilter {
  gender: Gender[];
  contactStatus: ContactStatus[];
  searchByName: string;
}
