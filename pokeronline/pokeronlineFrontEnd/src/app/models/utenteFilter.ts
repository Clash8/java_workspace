import { Stato } from './utente';


export default interface UtenteExample {
  nome: string;
  cognome: string;
  username: string;
  esperienzaAccumulata: number;
  creditoAccumulato: number;
  stato: Stato;
}
