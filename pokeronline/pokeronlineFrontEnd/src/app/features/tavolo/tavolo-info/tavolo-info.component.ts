import {Component, Input} from '@angular/core';
import Tavolo from '../../../models/tavolo';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-tavolo-info',
  imports: [
    DatePipe
  ],
  templateUrl: './tavolo-info.component.html',
  styleUrl: './tavolo-info.component.scss'
})
export class TavoloInfoComponent {
  tavoloExample: Partial<Tavolo> = {};
  @Input() tavolo!: Tavolo;


}
