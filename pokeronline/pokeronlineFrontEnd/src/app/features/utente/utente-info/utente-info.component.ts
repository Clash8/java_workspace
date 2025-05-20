import {Component, Input} from '@angular/core';
import {UTENTI} from '../../../../mock/mock';
import Utente from '../../../models/utente';
import {DatePipe} from '@angular/common';

@Component({
  selector: 'app-utente-info',
  imports: [
    DatePipe
  ],
  templateUrl: './utente-info.component.html',
  styleUrl: './utente-info.component.scss'
})
export class UtenteInfoComponent {
  @Input() utente!: Utente;
}
