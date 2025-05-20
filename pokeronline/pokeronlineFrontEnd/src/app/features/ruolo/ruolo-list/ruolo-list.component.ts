import { Component } from '@angular/core';
import { RUOLI } from '../../../../mock/mock';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-ruolo-list',
  imports: [
    NgForOf
  ],
  templateUrl: './ruolo-list.component.html',
  styleUrl: './ruolo-list.component.scss'
})
export class RuoloListComponent {
  ruoli = RUOLI;

}
