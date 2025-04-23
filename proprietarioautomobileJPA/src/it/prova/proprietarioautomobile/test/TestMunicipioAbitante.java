//package it.prova.municipioabitantejpa.test;
//
//import java.util.List;
//
//import org.hibernate.LazyInitializationException;
//
//import it.prova.municipioabitantejpa.dao.EntityManagerUtil;
//import it.prova.municipioabitantejpa.model.Automobile;
//import it.prova.municipioabitantejpa.model.Proprietario;
//import it.prova.municipioabitantejpa.service.MyServiceFactory;
//import it.prova.municipioabitantejpa.service.automobile.AutomobileService;
//import it.prova.municipioabitantejpa.service.proprietario.ProprietarioService;
//
//public class TestMunicipioAbitante {
//
//	public static void main(String[] args) {
//		// disabilito i log di hibernate
//		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
//
//		ProprietarioService proprietarioService = MyServiceFactory.getMunicipioServiceInstance();
//		AutomobileService automobileService = MyServiceFactory.getAbitanteServiceInstance();
//
//		try {
//
//
//			testCercaTuttiGliAbitantiConCodiceMunicipioIniziaCon(automobileService);
//			testCercaTuttiGliAbitantiConCognome(automobileService);
//			// ora con il service posso fare tutte le invocazioni che mi servono
////			System.out.println(
////					"In tabella Municipio ci sono " + municipioService.listAllProprietari().size() + " elementi.");
////
////			testInserisciMunicipio(municipioService);
////			System.out.println(
////					"In tabella Municipio ci sono " + municipioService.listAllProprietari().size() + " elementi.");
////
////			testInserisciAbitante(municipioService, abitanteService);
////			System.out.println(
////					"In tabella Municipio ci sono " + municipioService.listAllProprietari().size() + " elementi.");
////
////			testRimozioneAbitante(municipioService, abitanteService);
////			System.out.println(
////					"In tabella Municipio ci sono " + municipioService.listAllProprietari().size() + " elementi.");
////
////			testCercaTuttiGliAbitantiConNome(municipioService, abitanteService);
////			System.out.println(
////					"In tabella Municipio ci sono " + municipioService.listAllProprietari().size() + " elementi.");
////
////			testLazyInitExc(municipioService, abitanteService);
//
//		} catch (Throwable e) {
//			e.printStackTrace();
//		} finally {
//			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
//			// main
//			EntityManagerUtil.shutdown();
//		}
//
//	}
//
////	public List<Abitante> cercaTuttiGliAbitantiConCodiceMunicipioIniziaCon(String codice) throws Exception;
////
////	public List<Abitante> cercaTuttiGliAbitantiConCognome(String cognome) throws Exception;
////
////	public List<Municipio> cercaTuttiIMunicipiConMinorenni() throws Exception;
////
////	public List<Municipio> cercaTuttiDescrizioneIniziaCon(String iniziale) throws Exception;
//
//	private static void testCercaTuttiGliAbitantiConCodiceMunicipioIniziaCon(AutomobileService automobileService) throws Exception {
//		System.out.println(".......testCercaTuttiGliAbitantiConCodiceMunicipioIniziaCon.............");
//		String codiceMunicipio = "MUN001";
//		List<Automobile> listaAbitanti = automobileService.cercaTuttiGliAbitantiConCodiceMunicipioIniziaCon(codiceMunicipio);
//		System.out.println("Numero abitanti trovati: " + listaAbitanti.size());
//		for (Automobile automobile : listaAbitanti) {
//			System.out.println(automobile);
//		}
//		System.out.println(".......testCercaTuttiGliAbitantiConCodiceMunicipioIniziaCon fine: PASSED.............");
//	}
//
//	private static void testCercaTuttiGliAbitantiConCognome(AutomobileService automobileService) throws Exception {
//		System.out.println(".......testCercaTuttiGliAbitantiConCognome.............");
//		String cognome = "Rossi";
//		List<Automobile> listaAbitanti = automobileService.cercaTuttiGliAbitantiConCognome(cognome);
//		System.out.println("Numero abitanti trovati: " + listaAbitanti.size());
//		for (Automobile automobile : listaAbitanti) {
//			System.out.println(automobile);
//		}
//		System.out.println(".......testCercaTuttiGliAbitantiConCognome fine: PASSED.............");
//	}
//
//	private static void testCercaTuttiIMunicipiConMinorenni(ProprietarioService proprietarioService) throws Exception {
//
//	}
//
//
//	private static void testInserisciMunicipio(ProprietarioService proprietarioService) throws Exception {
//		System.out.println(".......testInserisciMunicipio inizio.............");
//		// creo nuovo municipio
//		Proprietario nuovoProprietario = new Proprietario("Municipio III", "III", "Via dei Nani");
//		if (nuovoProprietario.getId() != null)
//			throw new RuntimeException("testInserisciMunicipio fallito: record già presente ");
//
//		// salvo
//		proprietarioService.inserisciNuovo(nuovoProprietario);
//		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
//		// (NOVITA' RISPETTO AL PASSATO!!!)
//		if (nuovoProprietario.getId() == null)
//			throw new RuntimeException("testInserisciMunicipio fallito ");
//
//		System.out.println(".......testInserisciMunicipio fine: PASSED.............");
//	}
//
//	private static void testInserisciAbitante(ProprietarioService proprietarioService, AutomobileService automobileService)
//			throws Exception {
//		System.out.println(".......testInserisciAbitante inizio.............");
//
//		// creo nuovo abitante ma prima mi serve un municipio
//		List<Proprietario> listaMunicipiPresenti = proprietarioService.listAllProprietari();
//		if (listaMunicipiPresenti.isEmpty())
//			throw new RuntimeException("testInserisciAbitante fallito: non ci sono municipi a cui collegarci ");
//
//		Automobile nuovoAutomobile = new Automobile("Pluto", "Plutorum", 77, "Via Lecce");
//		// lo lego al primo municipio che trovo
//		nuovoAutomobile.setMunicipio(listaMunicipiPresenti.get(0));
//
//		// salvo il nuovo abitante
//		automobileService.inserisciNuovo(nuovoAutomobile);
//
//		// da questa riga in poi il record, se correttamente inserito, ha un nuovo id
//		// (NOVITA' RISPETTO AL PASSATO!!!)
//		if (nuovoAutomobile.getId() == null)
//			throw new RuntimeException("testInserisciAbitante fallito ");
//
//		// il test fallisce anche se non è riuscito a legare i due oggetti
//		if (nuovoAutomobile.getMunicipio() == null)
//			throw new RuntimeException("testInserisciAbitante fallito: non ha collegato il municipio ");
//
//		System.out.println(".......testInserisciAbitante fine: PASSED.............");
//	}
//
//	private static void testRimozioneAbitante(ProprietarioService proprietarioService, AutomobileService automobileService)
//			throws Exception {
//		System.out.println(".......testRimozioneAbitante inizio.............");
//
//		// inserisco un abitante che rimuoverò
//		// creo nuovo abitante ma prima mi serve un municipio
//		List<Proprietario> listaMunicipiPresenti = proprietarioService.listAllProprietari();
//		if (listaMunicipiPresenti.isEmpty())
//			throw new RuntimeException("testRimozioneAbitante fallito: non ci sono municipi a cui collegarci ");
//
//		Automobile nuovoAutomobile = new Automobile("Pietro", "Mitraglia", 33, "Via del Mare");
//		// lo lego al primo municipio che trovo
//		nuovoAutomobile.setMunicipio(listaMunicipiPresenti.get(0));
//
//		// salvo il nuovo abitante
//		automobileService.inserisciNuovo(nuovoAutomobile);
//
//		Long idAbitanteInserito = nuovoAutomobile.getId();
//		automobileService.rimuovi(idAbitanteInserito);
//		// proviamo a vedere se è stato rimosso
//		if (automobileService.caricaSingoloAbitante(idAbitanteInserito) != null)
//			throw new RuntimeException("testRimozioneAbitante fallito: record non cancellato ");
//		System.out.println(".......testRimozioneAbitante fine: PASSED.............");
//	}
//
//	private static void testCercaTuttiGliAbitantiConNome(ProprietarioService proprietarioService,
//														 AutomobileService automobileService) throws Exception {
//		System.out.println(".......testCercaTuttiGliAbitantiConNome inizio.............");
//
//		// inserisco un paio di abitanti di test
//		// prima mi serve un municipio
//		List<Proprietario> listaMunicipiPresenti = proprietarioService.listAllProprietari();
//		if (listaMunicipiPresenti.isEmpty())
//			throw new RuntimeException(
//					"testCercaTuttiGliAbitantiConNome fallito: non ci sono municipi a cui collegarci ");
//
//		Automobile nuovoAutomobile = new Automobile("Mariotto", "Bassi", 27, "Via Lucca");
//		Automobile nuovoAutomobile2 = new Automobile("Mariotto", "Nato", 37, "Via Roma");
//		// lo lego al primo municipio che trovo
//		nuovoAutomobile.setMunicipio(listaMunicipiPresenti.get(0));
//		nuovoAutomobile2.setMunicipio(listaMunicipiPresenti.get(0));
//
//		// salvo i nuovi abitante
//		automobileService.inserisciNuovo(nuovoAutomobile);
//		automobileService.inserisciNuovo(nuovoAutomobile2);
//
//		// ora mi aspetto due 'Mario'
//		if (automobileService.cercaTuttiGliAbitantiConNome("Mariotto").size() != 2)
//			throw new RuntimeException("testCercaTuttiGliAbitantiConNome fallito: numero record inatteso ");
//
//		// clean up code
//		automobileService.rimuovi(nuovoAutomobile.getId());
//		automobileService.rimuovi(nuovoAutomobile2.getId());
//
//		System.out.println(".......testCercaTuttiGliAbitantiConNome fine: PASSED.............");
//	}
//
//	private static void testLazyInitExc(ProprietarioService proprietarioService, AutomobileService automobileService)
//			throws Exception {
//		System.out.println(".......testLazyInitExc inizio.............");
//
//		// prima mi serve un municipio
//		List<Proprietario> listaMunicipiPresenti = proprietarioService.listAllProprietari();
//		if (listaMunicipiPresenti.isEmpty())
//			throw new RuntimeException("testLazyInitExc fallito: non ci sono municipi a cui collegarci ");
//
//		Proprietario proprietarioSuCuiFareIlTest = listaMunicipiPresenti.get(0);
//		// se interrogo la relazione devo ottenere un'eccezione visto che sono LAZY
//		try {
//			proprietarioSuCuiFareIlTest.getAutomobile().size();
//			// se la riga sovrastante non da eccezione il test fallisce
//			throw new RuntimeException("testLazyInitExc fallito: eccezione non lanciata ");
//		} catch (LazyInitializationException e) {
//			// 'spengo' l'eccezione per il buon fine del test
//		}
//		// una LazyInitializationException in quanto il contesto di persistenza è chiuso
//		// se usiamo un caricamento EAGER risolviamo...dipende da cosa ci serve!!!
//		// municipioService.caricaSingoloMunicipioConAbitanti(...);
//		System.out.println(".......testLazyInitExc fine: PASSED.............");
//	}
//
//}
