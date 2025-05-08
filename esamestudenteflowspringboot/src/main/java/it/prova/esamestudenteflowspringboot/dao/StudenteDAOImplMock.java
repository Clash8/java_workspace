package it.prova.esamestudenteflowspringboot.dao;

import org.springframework.stereotype.Component;

import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;

@Component
public class StudenteDAOImplMock implements StudenteDAO {

	@Override
	public void insert(Studente input) {
		for (Esame esameItem : DbMock.ESAMI) {
			if(esameItem.getId() == input.getEsame().getId())
				esameItem.addToStudenti(input);
		}
	}
}
