import { Component } from '@angular/core';
import { TAVOLI } from '../../../../mock/mock';
import {DatePipe, NgForOf, NgIf} from '@angular/common';
import Tavolo from '../../../models/tavolo';
import {TavoloInfoComponent} from '../tavolo-info/tavolo-info.component';
import {TavoloFilterComponent} from '../tavolo-filter/tavolo-filter.component';
import TavoloExample from '../../../models/tavoloFilter';

@Component({
  selector: 'app-tavolo-list',
  imports: [
    NgForOf,
    DatePipe,
    NgIf,
    TavoloInfoComponent,
    TavoloFilterComponent
  ],
  templateUrl: './tavolo-list.component.html',
  styleUrl: './tavolo-list.component.scss'
})
export class TavoloListComponent {
  tavoloExample: Partial<TavoloExample> = {};

  tavoli = TAVOLI;
  selectedTavolo: Tavolo | null = null;

  showInfo(tavolo: Tavolo): void {
    this.selectedTavolo = tavolo;
  }

  hideInfo(): void {
    this.selectedTavolo = null;
  }
}
