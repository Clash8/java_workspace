package it.prova.esamestudenteflowspringboot.service;

import org.springframework.stereotype.Service;

import it.prova.esamestudenteflowspringboot.model.Studente;
@Service
public class AltriProfessoriServiceImpl implements AltriProfessoriService {

	@Override
	public void esaminaInAltreDiscipline(Studente studente) {
		System.out.println("Interrogazioni varie allo studente "+studente+ " effettuate...");

	}

}
