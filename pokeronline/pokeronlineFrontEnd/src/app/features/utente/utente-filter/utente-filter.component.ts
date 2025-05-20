import {Component, Input} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {NgForOf} from '@angular/common';
import {Stato} from '../../../models/utente';
import Utente from '../../../models/utenteFilter';

@Component({
  selector: 'app-utente-filter',
  imports: [
    NgForOf,
    FormsModule
  ],
  standalone: true,
  templateUrl: './utente-filter.component.html',
  styleUrl: './utente-filter.component.scss'
})
export class UtenteFilterComponent {
  stati : Stato[] = ['ATTIVO', 'SOSPESO', 'DISABILITATO'];
  @Input() utenteExample!: Partial<Utente>;
}
