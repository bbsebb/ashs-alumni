import {Component, inject} from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatButton} from '@angular/material/button';
import {RouterLink, RouterLinkActive} from '@angular/router';
import {toSignal} from '@angular/core/rxjs-interop';
import {BreakpointObserver, Breakpoints} from '@angular/cdk/layout';
import {AuthenticationService} from '@app/shared/services/authentication';
import {MatIcon} from '@angular/material/icon';

@Component({
  selector: 'header[appHeader]',
  imports: [
    MatToolbar,
    MatButton,
    RouterLink,
    RouterLinkActive,
    MatIcon
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {
  readonly breakpointObserver =  toSignal(inject(BreakpointObserver).observe([Breakpoints.XSmall]));
  readonly authService = inject(AuthenticationService);

}
