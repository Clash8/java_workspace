package it.prova.gestionesocieta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionesocieta.service.BatteriaDiTestService;

@SpringBootApplication
public class GestioneSocietaApplication implements CommandLineRunner{
	
	@Autowired
	private BatteriaDiTestService batteriaDiTestService;	

	public static void main(String[] args) {
		SpringApplication.run(GestioneSocietaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("################ START   #################");
		System.out.println("################ eseguo i test  #################");


		batteriaDiTestService.testInserimentoSocieta();
		batteriaDiTestService.testfindSocietaByExample();
		batteriaDiTestService.testRemoveSocieta();
		batteriaDiTestService.testInserimentoDipendenteConThrowException();
		batteriaDiTestService.testInserimentoProgetto();
		batteriaDiTestService.testCollegaDipendenteConThrowsException();
		batteriaDiTestService.testCollegaProgettoConThrowsException();
		batteriaDiTestService.testListaClientiDataSocietaInInput();
		batteriaDiTestService.testListaNomiProgettiDelleSocietaConDuratMaggioreDiUnAnno();
		batteriaDiTestService.testListaProgettiInCuiLavoraAlmenoUnDipendenteRicco();
		batteriaDiTestService.testDipendentePiuAnziano();







		System.out.println("################ FINE - PASSED  #################");
	}

}
