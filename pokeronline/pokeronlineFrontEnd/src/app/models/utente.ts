import Ruolo from './ruolo';

export type Stato = 'ATTIVO' | 'SOSPESO' | 'DISABILITATO'; // Adjust if needed

export default interface Utente {
  id: number;
  nome: string;
  cognome: string;
  username: string;
  dataRegistrazione: Date;
  esperienzaAccumulata: number;
  creditoAccumulato: number;
  stato: Stato;
  ruolo: Ruolo;
}
