import {Component, Input} from '@angular/core';
import Tavolo from '../../../models/tavoloFilter';
import {FormsModule} from '@angular/forms';
import {UTENTI} from '../../../../mock/mock';
import {Stato} from '../../../models/utente';
import {NgForOf} from '@angular/common';
import TavoloExample from '../../../models/tavoloFilter';

@Component({
  selector: 'app-tavolo-filter',
  imports: [
    FormsModule,
    NgForOf
  ],
  standalone: true,
  templateUrl: './tavolo-filter.component.html',
  styleUrl: './tavolo-filter.component.scss'
})
export class TavoloFilterComponent {
  @Input() tavoloExample!: Partial<TavoloExample>;
  utenti = UTENTI;
  
}
