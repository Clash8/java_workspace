package it.prova.esamestudenteflowspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.esamestudenteflowspringboot.model.Esame;
import it.prova.esamestudenteflowspringboot.model.Studente;
import it.prova.esamestudenteflowspringboot.service.EsameService;

@SpringBootApplication
public class EsamestudenteflowspringbootApplication implements CommandLineRunner {

	@Autowired
	private EsameService esameService;

	public static void main(String[] args) {
		SpringApplication.run(EsamestudenteflowspringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Esame esame = esameService.caricaEsame(1);

		// aggiungo uno studente
		Studente studente = new Studente(44L, "Antonio", "Mollo");

		// aggiungo lo studente all'esame caricato in tabella
		esameService.aggiungiStudenteAdEsame(studente, esame);

		// avvio
		esameService.avviaEsame(esame);
	}

}
