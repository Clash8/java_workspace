package it.prova.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.model.User;
import it.prova.service.MyServiceFactory;
import it.prova.service.user.UserService;

public class TestUser {

	public static void main(String[] args) {

		// parlo direttamente con il service
		UserService userService = MyServiceFactory.getUserServiceImpl();

		try {

//			// ora con il service posso fare tutte le invocazioni che mi servono
//			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");
//
//			testInserimentoNuovoUser(userService);
//			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");
//
//			testRimozioneUser(userService);
//			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");
//
//			testFindByExample(userService);
//			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");
//
//			testUpdateUser(userService);
//			System.out.println("In tabella ci sono " + userService.listAll().size() + " elementi.");

			// E TUTTI I TEST VANNO FATTI COSI'
			testCercaTuttiQuelliCheUsernameIniziaCon(userService);
			testCercaTuttiQuelliCreatiPrimaDi(userService);
			testCercaPerCognomeENomeCheInziaCon(userService);
			testAccedi(userService);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void testInserimentoNuovoUser(UserService userService) throws Exception {
		System.out.println(".......testInserimentoNuovoUser inizio.............");
		User newUserInstance = new User("mauro", "rossi", "avavv", "bobobo", LocalDate.now());
		if (userService.inserisciNuovo(newUserInstance) != 1)
			throw new RuntimeException("testInserimentoNuovoUser FAILED ");

		System.out.println(".......testInserimentoNuovoUser PASSED.............");
	}

	private static void testRimozioneUser(UserService userService) throws Exception {
		System.out.println(".......testRimozioneUser inizio.............");
		// recupero tutti gli user
		List<User> interoContenutoTabella = userService.listAll();
		if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
			throw new Exception("Non ho nulla da rimuovere");

		Long idDelPrimo = interoContenutoTabella.get(0).getId();
		// ricarico per sicurezza con l'id individuato
		User toBeRemoved = userService.findById(idDelPrimo);
		if (userService.rimuovi(toBeRemoved.getId()) != 1)
			throw new RuntimeException("testRimozioneUser FAILED ");

		System.out.println(".......testRimozioneUser PASSED.............");
	}

	private static void testFindByExample(UserService userService) throws Exception {
		System.out.println(".......testFindByExample inizio.............");
		// inserisco i dati che poi mi aspetto di ritrovare
		userService.inserisciNuovo(new User("Asallo", "Bianchi", "pier", "pwd@1", LocalDate.now()));
		userService.inserisciNuovo(new User("Astolfo", "Verdi", "ast", "pwd@2", LocalDate.now()));

		// preparo un example che ha come nome 'as' e ricerco
		List<User> risultatifindByExample = userService.findByExample(new User("as"));
		if (risultatifindByExample.size() != 2)
			throw new RuntimeException("testFindByExample FAILED ");

		// se sono qui il test è ok quindi ripulisco i dati che ho inserito altrimenti
		// la prossima volta non sarebbero 2 ma 4, ecc.
		for (User userItem : risultatifindByExample) {
			userService.rimuovi(userItem.getId());
		}

		System.out.println(".......testFindByExample PASSED.............");
	}

	private static void testUpdateUser(UserService userService) throws Exception {
		System.out.println(".......testUpdateUser inizio.............");

		// inserisco i dati che poi modifico
		if (userService.inserisciNuovo(new User("Giovanna", "Sastre", "gio", "pwd@3", LocalDate.now())) != 1)
			throw new RuntimeException("testUpdateUser: inserimento preliminare FAILED ");

		// recupero col findbyexample e mi aspetto di trovarla
		List<User> risultatifindByExample = userService.findByExample(new User("Giovanna", "Sastre"));
		if (risultatifindByExample.size() != 1)
			throw new RuntimeException("testUpdateUser: testFindByExample FAILED ");

		// mi metto da parte l'id su cui lavorare per il test
		Long idGiovanna = risultatifindByExample.get(0).getId();

		// ricarico per sicurezza con l'id individuato e gli modifico un campo
		String nuovoCognome = "Perastra";
		User toBeUpdated = userService.findById(idGiovanna);
		toBeUpdated.setCognome(nuovoCognome);
		if (userService.aggiorna(toBeUpdated) != 1)
			throw new RuntimeException("testUpdateUser FAILED ");

		System.out.println(".......testUpdateUser PASSED.............");
	}

	//public List<User> cercaTuttiQuelliCheUsernameIniziaCon(String iniziale) throws Exception;
	//
	//	public List<User> cercaTuttiQuelliCreatiPrimaDi(LocalDate dataConfronto) throws Exception;
	//
	//	public List<User> cercaPerCognomeENomeCheInziaCon(String cognomeInput, String inizialeNomeInput) throws Exception;
	//
	//	public User accedi(String loginInput, String passwordInput) throws Exception;

	private static void testCercaTuttiQuelliCheUsernameIniziaCon(UserService userService) throws Exception {
		System.out.println(".......testCercaTuttiQuelliCheUsernameIniziaCon inizio.............");

		List<User> risultatifindByExample = userService.cercaTuttiQuelliCheUsernameIniziaCon("gi");

		System.out.println(risultatifindByExample);

		System.out.println(".......testCercaTuttiQuelliCheUsernameIniziaCon PASSED.............");
	}

	private static void testCercaTuttiQuelliCreatiPrimaDi(UserService userService) throws Exception {
		System.out.println(".......testCercaTuttiQuelliCreatiPrimaDi inizio.............");

		List<User> risultatifindByExample = userService.cercaTuttiQuelliCreatiPrimaDi(LocalDate.now());

		System.out.println(risultatifindByExample);

		System.out.println(".......testCercaTuttiQuelliCreatiPrimaDi PASSED.............");
	}

	private static void testCercaPerCognomeENomeCheInziaCon(UserService userService) throws Exception {
		System.out.println(".......testCercaPerCognomeENomeCheInziaCon inizio.............");

		List<User> risultatifindByExample = userService.cercaPerCognomeENomeCheInziaCon("Sastre", "Gio");
		System.out.println(risultatifindByExample);

		System.out.println(".......testCercaPerCognomeENomeCheInziaCon PASSED.............");
	}
	private static void testAccedi(UserService userService) throws Exception {
		System.out.println(".......testAccedi inizio.............");
		// inserisco i dati che poi modifico

		User result = userService.accedi("gio", "pwd@3");
		if (result == null)
			throw new RuntimeException("testAccedi FAILED ");

		System.out.println(".......testAccedi PASSED.............");
	}
}
