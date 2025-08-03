import {Component, inject, OnInit, output} from '@angular/core';
import {FormBuilder, FormControl, ReactiveFormsModule} from '@angular/forms';
import {MatButtonToggle, MatButtonToggleGroup} from '@angular/material/button-toggle';
import {MatFormField, MatInput, MatLabel} from '@angular/material/input';
import {ContactStatus, Gender} from '@app/domains/former-teammates/former-teammates';

@Component({
  selector: 'app-former-filter',
  imports: [
    ReactiveFormsModule,
    MatButtonToggleGroup,
    MatButtonToggle,
    MatFormField,
    MatLabel,
    MatInput
  ],
  templateUrl: './former-filter.html',
  styleUrl: './former-filter.scss'
})
export class FormerFilter implements OnInit{

  // Output
  filterChange = output<FormerTeammatesFilter>()
  // Injected services
  private readonly formBuilder = inject(FormBuilder);
  // Form controls
  readonly formFilter = this.formBuilder.group({
    gender: new FormControl<Gender[]>([]),
    contactStatus: new FormControl<ContactStatus[]>([]),
    searchByName: new FormControl<string>('')
  });

  ngOnInit(): void {
    this.formFilter.valueChanges.subscribe( filter => this.filterChange.emit({
      gender: filter.gender ?? [],
      contactStatus: filter.contactStatus ?? [],
      searchByName: filter.searchByName ?? ''
    }))

  }
}

export interface FormerTeammatesFilter {
  gender: Gender[];
  contactStatus: ContactStatus[];
  searchByName: string;
}
