package it.prova.esamestudenteflowspringboot.service;

import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;

public interface EsameService {
	public Esame caricaEsame(int id);
	public void avviaEsame(Esame esame);
	public void aggiungiStudenteAdEsame(Studente studenteInput, Esame esameInput);
}
