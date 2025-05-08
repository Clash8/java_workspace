package it.prova.esamestudenteflowspringboot.dao;

import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;

public interface EsameDAO {

	public Esame get(int id);
	public void addStudentToEsame(Studente studenteInput, Esame esameInput);

}
