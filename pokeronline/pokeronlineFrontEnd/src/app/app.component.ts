import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {TavoloListComponent} from './features/tavolo/tavolo-list/tavolo-list.component';
import {UtenteListComponent} from './features/utente/utente-list/utente-list.component';
import {RuoloListComponent} from './features/ruolo/ruolo-list/ruolo-list.component';
import {NgIf} from '@angular/common';
import {TavoloFilterComponent} from './features/tavolo/tavolo-filter/tavolo-filter.component';
import {UtenteFilterComponent} from './features/utente/utente-filter/utente-filter.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, TavoloListComponent, UtenteListComponent, RuoloListComponent, NgIf, TavoloFilterComponent, UtenteFilterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  currentPage: string = '';

  changePage(page: string): void {
    this.currentPage = page;
  }
}
