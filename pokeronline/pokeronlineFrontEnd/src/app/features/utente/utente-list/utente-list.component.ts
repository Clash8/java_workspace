import { Component } from '@angular/core';
import {DatePipe, NgForOf, NgIf} from "@angular/common";
import {UTENTI} from "../../../../mock/mock";
import Tavolo from '../../../models/tavolo';
import Utente from '../../../models/utente';
import {UtenteInfoComponent} from '../utente-info/utente-info.component';
import UtenteExample from '../../../models/utenteFilter';
import {UtenteFilterComponent} from '../utente-filter/utente-filter.component';

@Component({
  selector: 'app-utente-list',
  imports: [
    DatePipe,
    NgForOf,
    UtenteInfoComponent,
    NgIf,
    UtenteFilterComponent
  ],
  templateUrl: './utente-list.component.html',
  styleUrl: './utente-list.component.scss'
})
export class UtenteListComponent {
  utenteExample: Partial<UtenteExample> = {};

  utenti = UTENTI;
  selectedUtente: Utente | null = null;

  showInfo(utente: Utente): void {
    this.selectedUtente = utente;
  }

  hideInfo(): void {
    this.selectedUtente = null;
  }

  get filteredUtenti(): Utente[] {
    return this.utenti.filter(utente => {
      return (
        (!this.utenteExample.nome || utente.nome.toLowerCase().includes(this.utenteExample.nome.toLowerCase())) &&
        (!this.utenteExample.cognome || utente.cognome.toLowerCase().includes(this.utenteExample.cognome.toLowerCase())) &&
        (!this.utenteExample.username || utente.username.toLowerCase().includes(this.utenteExample.username.toLowerCase())) &&
        (!this.utenteExample.stato || utente.stato === this.utenteExample.stato)
      );
    });
  }

}


