package it.prova.esamestudenteflowspringboot.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;

public class DbMock {
	
	public static final List<Esame> ESAMI = new ArrayList<Esame>();
	
	static {
		Esame esame1 = new Esame(1L,"Esame maturità liceo");
		Studente studente1 = new Studente(11L,"Mario", "Rossi",esame1);
		esame1.addToStudenti(studente1);
		Studente studente2 = new Studente(22L,"Giuseppe", "Bianchi",esame1);
		esame1.addToStudenti(studente2);
		Studente studente3 = new Studente(33L,"Francesco", "Verdi",esame1);
		esame1.addToStudenti(studente3);
		ESAMI.add(esame1);
	}

}
