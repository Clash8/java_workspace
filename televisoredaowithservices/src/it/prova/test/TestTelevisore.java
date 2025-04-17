package it.prova.test;

import java.time.LocalDate;
import java.util.List;

import it.prova.model.Televisore;
import it.prova.service.MyServiceFactory;
import it.prova.service.televisore.TelevisoreService;

public class TestTelevisore {

	public static void main(String[] args) {

		// parlo direttamente con il service
		TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();

		try {
			listAll(televisoreService);
			System.out.println("ottengo il televisore con id 1:");
			Televisore primoTelevisore = televisoreService.findById(1L);
			System.out.println(primoTelevisore);
			System.out.println("inserisco un nuovo televisore:");
			Televisore newTelevisore = new Televisore("Samsung", "QLED", 1200, LocalDate.now());
			System.out.println(newTelevisore);
			if (televisoreService.inserisciNuovo(newTelevisore) == 1)
				System.out.println("inserito correttamente");
			else
				System.out.println("inserimento fallito");
			listAll(televisoreService);
			System.out.println("cancello lultimo televisore inserito:");
			if (televisoreService.rimuovi(getLastId(televisoreService)) == 1)
				System.out.println("cancellato correttamente");
			else
				System.out.println("cancellazione fallita");
			listAll(televisoreService);
			System.out.println("modifico il televisore con id 2:");
			Televisore teleDaAggiornare = televisoreService.findById(2L);
			teleDaAggiornare.setMarca("LG");
			teleDaAggiornare.setModello("OLED");
			if (televisoreService.aggiorna(teleDaAggiornare) == 1)
				System.out.println("modificato correttamente");
			else
				System.out.println("modifica fallita");
			listAll(televisoreService);
			System.out.println("ottengo il televisore più grande:");
			Televisore piuGrande = televisoreService.getBigger();
			System.out.println(piuGrande);
			System.out.println("ottengo il numero di televisori prodotti tra due date:");
			int quantiTele = televisoreService.quantiTelTraDate(LocalDate.of(2020, 1, 1), LocalDate.of(2023, 1, 1));
			System.out.println("Ci sono " + quantiTele + " televisori prodotti tra le due date.");
			System.out.println("ottengo le marche dei recenti di 30 anni");
			List<String> listaRecenti = televisoreService.list30anni();
			System.out.println(listaRecenti);



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void listAll(TelevisoreService televisoreService) throws Exception {
		System.out.println("In tabella ci sono " + televisoreService.listAll().size() + " elementi.");

		System.out.println("QESTI SONO I TELEVISORI PRESENTI NEL DB");
		List<Televisore> listaTelevisori = televisoreService.listAll();
		for (Televisore tele : listaTelevisori) {
			System.out.println(tele);
		}
	}

	private static Long getLastId(TelevisoreService televisoreService) throws Exception {
		List<Televisore> listaTelevisori = televisoreService.listAll();
		return listaTelevisori.get(listaTelevisori.size() - 1).getId();
	}

}
