package it.prova.esamestudenteflowspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.esamestudenteflowspringboot.dao.EsameDAO;
import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;
@Service
public class EsameServiceImpl implements EsameService {
	
	@Autowired
	private ProfessoreItalianoService professoreItalianoService;
	@Autowired
	private ProfessoreMatematicaService professoreMatematicaService;
	@Autowired
	private AltriProfessoriService altriProfessoriService;
	@Autowired
	private EsameDAO esameDAO;
	

	@Override
	public void avviaEsame(Esame esame) {
		System.out.println("Inizio esame........................");
		System.out.println("************************************");
		for (Studente studente : esame.getStudenti()) {
			System.out.println("Inizio esame del candidato: "+studente);
			professoreItalianoService.esaminaInLetteratura(studente);
			professoreMatematicaService.esaminaInMatematica(studente);
			altriProfessoriService.esaminaInAltreDiscipline(studente);
			System.out.println("Termine esame del candidato: "+studente);
			System.out.println("************************************");
		}
		System.out.println("************************************");
		System.out.println("Termine esame........................");
		
	}
	
	@Override
	public Esame caricaEsame(int id) {
		return esameDAO.get(id);
	}

	@Override
	public void aggiungiStudenteAdEsame(Studente studenteInput, Esame esameInput) {
		esameDAO.addStudentToEsame(studenteInput, esameInput);
	}

}
