package it.prova.esamestudenteflowspringboot.service;

import org.springframework.stereotype.Service;

import it.prova.esamestudenteflowspringboot.model.Studente;
@Service
public class ProfessoreItalianoServiceImpl implements ProfessoreItalianoService {

	@Override
	public void esaminaInLetteratura(Studente studente) {
		System.out.println("Interrogazione di letteratura allo studente "+studente+ " effettuate...");
	}

}
