import { Component } from '@angular/core';
import {MatToolbar} from '@angular/material/toolbar';
import {MatButton} from '@angular/material/button';
import {RouterLink, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'header[appHeader]',
  imports: [
    MatToolbar,
    MatButton,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {

  login() {

  }
}
