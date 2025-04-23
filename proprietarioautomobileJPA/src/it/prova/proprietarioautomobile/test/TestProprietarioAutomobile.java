package it.prova.proprietarioautomobile.test;

import it.prova.proprietarioautomobile.dao.EntityManagerUtil;
import it.prova.proprietarioautomobile.model.Automobile;
import it.prova.proprietarioautomobile.model.Proprietario;
import it.prova.proprietarioautomobile.service.MyServiceFactory;
import it.prova.proprietarioautomobile.service.automobile.AutomobileService;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioService;

import java.util.List;


public class TestProprietarioAutomobile {

	public static void main(String[] args) {
		// disabilito i log di hibernate
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		ProprietarioService proprietarioService = MyServiceFactory.getProprietarioServiceInstance();
		AutomobileService automobileService = MyServiceFactory.getAutomobileServiceInstance();

		try {
			System.out.println("ListAllAutomobili");
			List<Automobile> automobili = automobileService.listAllAutomobili();
			for (Automobile automobileItem : automobili) {
				System.out.println(automobileItem);
			}
			System.out.println("ListAllProprietari");
			List<Proprietario> proprietari = proprietarioService.listAllProprietari();
			for (Proprietario proprietarioItem : proprietari) {
				System.out.println(proprietarioItem);
			}

			Automobile automobileInstance = automobileService.caricaSingoloAutomobile(2L);
			System.out.println("Automobile con id 1: " + automobileInstance);

			Proprietario proprietarioInstance = proprietarioService.caricaSingoloProprietario(1L);
			System.out.println("Proprietario con id 1: " + proprietarioInstance);

			System.out.println("inserisco una nuova automobile");
			Automobile newAutomobile = new Automobile("Fiat", "Panda", "AB123CD");
			automobileService.inserisciNuovo(newAutomobile);
			System.out.println("Automobile inserita: " + newAutomobile);
			System.out.println("inserisco un nuovo proprietario");
			Proprietario newProprietario = new Proprietario("Mario", "Rossi", "1234567890");
			proprietarioService.inserisciNuovo(newProprietario);
			System.out.println("Proprietario inserito: " + newProprietario);

			System.out.println("Aggiorno l'automobile");
			automobileInstance.setMarca("Fiat");
			automobileInstance.setModello("Panda");
			automobileInstance.setTarga("AB123CD");
			automobileService.aggiorna(automobileInstance);
			System.out.println("Automobile aggiornata: " + automobileInstance);
			System.out.println("Aggiorno il proprietario");
			proprietarioInstance.setNome("Mario1");
			proprietarioInstance.setCognome("Rossi1");
			proprietarioInstance.setCf("1234567890");
			proprietarioService.aggiorna(proprietarioInstance);
			System.out.println("Proprietario aggiornato: " + proprietarioInstance);

//			System.out.println("Rimuovo l'automobile");
//			automobileService.rimuovi(automobileInstance.getId());
//			System.out.println("Automobile rimossa: " + automobileInstance);
//			System.out.println("Rimuovo il proprietario");
//			proprietarioService.rimuovi(proprietarioInstance);
//			System.out.println("Proprietario rimosso: " + proprietarioInstance);







		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

}
