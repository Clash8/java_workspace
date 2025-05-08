package it.prova.esamestudenteflowspringboot.service;

import org.springframework.stereotype.Service;

import it.prova.esamestudenteflowspringboot.model.Studente;
@Service
public class ProfessoreMatematicaServiceImpl implements
		ProfessoreMatematicaService {

	@Override
	public void esaminaInMatematica(Studente studente) {
		System.out.println("Interrogazioni di matematica allo studente "+studente+ " effettuate...");
	}

}
