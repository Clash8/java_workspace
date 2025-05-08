package it.prova.gestionearticoli.test;

import it.prova.gestionearticoli.dao.EntityManagerUtil;
import it.prova.gestionearticoli.model.Articolo;
import it.prova.gestionearticoli.model.Categoria;
import it.prova.gestionearticoli.model.Ordine;
import it.prova.gestionearticoli.service.ArticoloService;
import it.prova.gestionearticoli.service.CategoriaService;
import it.prova.gestionearticoli.service.OrdineService;
import it.prova.gestionearticoli.service.MyServiceFactory;

import java.util.List;

public class MyTest {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

		try {

			System.out.println("In tabella articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");

            System.out.println(
					"**************************** inizio batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");

			testInserimentoNuovoOrdine(ordineServiceInstance);
			testAggiornamentoOrdine(ordineServiceInstance);
			testInserimentoNuovoArticolo(articoloServiceInstance);
			testAggiornamentoArticolo(articoloServiceInstance);
			testInserimentoNuovaCategoria(categoriaServiceInstance);
			testAggiornamentoCategoria(categoriaServiceInstance);
			testRimuoviArticoloLegatoAUnOrdine(articoloServiceInstance, ordineServiceInstance);
			testAggiungiCategoriaAUnArticolo(articoloServiceInstance, categoriaServiceInstance);

			testRimuoviArticoloPrevioScollegamentoDelleCategorie(articoloServiceInstance, categoriaServiceInstance);
			testRimozioneCategoriaPrevioScollegamentoDegliArticoli(articoloServiceInstance, categoriaServiceInstance);
			testRimozioneCheDaErroreNelCasoInCuiSiaCollegatoAUnArticolo(ordineServiceInstance, articoloServiceInstance);


			System.out.println(
					"****************************** fine batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");



            System.out.println("In tabella articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
            System.out.println("In tabella categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
            System.out.println("In tabella ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");

        } catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}

	//Inserimento nuovo ordine
	private static void testInserimentoNuovoOrdine(OrdineService ordineServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Ordine ordineInstance = new Ordine();
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		if (ordineInstance.getId() == null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}
	//Aggiornamento ordine esistente
	private static void testAggiornamentoOrdine(OrdineService ordineServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Ordine ordineInstance = new Ordine();
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		Ordine ordindeDaModificare = ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId());
		ordindeDaModificare.setNomeDestinatario("Giuseppe");
		ordineServiceInstance.aggiorna(ordindeDaModificare);

		Ordine ordindeDaControllare = ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId());
		if (!ordindeDaControllare.getNomeDestinatario().equals("Giuseppe"))
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}
	//Inserimento nuovo articolo
	private static void testInserimentoNuovoArticolo(ArticoloService articoloServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		articoloServiceInstance.inserisciNuovo(articoloInstance);

		if (articoloInstance.getId() == null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}
	
	//Aggiornamento articolo esistente
	private static void testAggiornamentoArticolo(ArticoloService articoloServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		articoloServiceInstance.inserisciNuovo(articoloInstance);

		Articolo articoloDaModificare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());
		articoloDaModificare.setDescrizione("Descrizione bella");
		articoloServiceInstance.aggiorna(articoloDaModificare);
		Articolo ordindeDaControllare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());

		if (!ordindeDaControllare.getDescrizione().equals("Descrizione bella"))
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}
	
	//Rimozione di un articolo legato ad un ordine (non a delle categorie)
	private static void testRimuoviArticoloLegatoAUnOrdine(ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		articoloServiceInstance.inserisciNuovo(articoloInstance);

		Ordine ordineInstance = new Ordine();
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		Articolo articoloDaModificare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());
		Ordine ordineDaInserire = ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId());

		articoloDaModificare.setOrdine(ordineDaInserire);
		articoloServiceInstance.aggiorna(articoloDaModificare);

		articoloServiceInstance.rimuovi(articoloDaModificare.getId());

		Articolo articoloDaControllare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());

		if (articoloDaControllare != null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	//Inserimento nuova categoria
	private static void testInserimentoNuovaCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Categoria categoriaInstance = new Categoria();
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);

		if (categoriaInstance.getId() == null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	//Aggiornamento categoria esistente
	private static void testAggiornamentoCategoria(CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Categoria categoriaInstance = new Categoria();
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);

		Categoria ordindeDaModificare = categoriaServiceInstance.caricaSingoloElemento(categoriaInstance.getId());
		ordindeDaModificare.setDescrizione("Descrizione Bellissima");
		categoriaServiceInstance.aggiorna(ordindeDaModificare);

		Categoria ordindeDaControllare = categoriaServiceInstance.caricaSingoloElemento(categoriaInstance.getId());
		if (!ordindeDaControllare.getDescrizione().equals("Descrizione Bellissima"))
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}


	//Aggiungi categoria ad un articolo
	private static void testAggiungiCategoriaAUnArticolo(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		Categoria categoriaInstance = new Categoria();

		articoloServiceInstance.inserisciNuovo(articoloInstance);
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);

		articoloServiceInstance.aggiungiCategoriaAdArticolo(articoloInstance.getId(), categoriaInstance.getId());

		Articolo articoloDaControllare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());

		boolean presente = articoloDaControllare.getCategorie()
				.stream()
				.map(Categoria::getId)
				.anyMatch(categoriaInstance.getId()::equals);

		if (!presente)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	//Rimozione articolo (previo scollegamento dalle categorie)
	private static void testRimuoviArticoloPrevioScollegamentoDelleCategorie(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		Categoria categoriaInstance = new Categoria();

		articoloServiceInstance.inserisciNuovo(articoloInstance);
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);

		articoloServiceInstance.aggiungiCategoriaAdArticolo(articoloInstance.getId(), categoriaInstance.getId());

		articoloServiceInstance.rimuoviArticoloCollegato(articoloInstance.getId());

		Articolo articoloDaControllare = articoloServiceInstance.caricaSingoloElemento(articoloInstance.getId());

		if (articoloDaControllare != null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	//Rimozione categoria (previo scollegamento dagli articoli)
	private static void testRimozioneCategoriaPrevioScollegamentoDegliArticoli(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		Categoria categoriaInstance = new Categoria();

		articoloServiceInstance.inserisciNuovo(articoloInstance);
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);

		articoloServiceInstance.aggiungiCategoriaAdArticolo(articoloInstance.getId(), categoriaInstance.getId());

		categoriaServiceInstance.rimuoviCategoriaCollegata(categoriaInstance.getId());

		Categoria categoriaDaControllare = categoriaServiceInstance.caricaSingoloElemento(categoriaInstance.getId());

		if (categoriaDaControllare != null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	//Rimozione ordine (nel caso in cui sia collegato ad almeno un articolo lanciare eccezione custom)
	private static void testRimozioneCheDaErroreNelCasoInCuiSiaCollegatoAUnArticolo(OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Ordine ordineInstance = new Ordine();
		Articolo articoloInstance = new Articolo();

		ordineServiceInstance.inserisciNuovo(ordineInstance);

//		articoloInstance.setOrdine(ordineInstance);

		articoloServiceInstance.inserisciNuovo(articoloInstance);

		ordineServiceInstance.rimuoviOrdineCollegato(ordineInstance.getId());

		Ordine ordineDaControllare = ordineServiceInstance.caricaSingoloElemento(ordineInstance.getId());

		if (ordineDaControllare != null)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

	private static void testSommaArticoliLegatiAUnaCategoria(ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");

		Articolo articoloInstance = new Articolo();
		Articolo articoloInstance2 = new Articolo();
		Categoria categoriaInstance = new Categoria();

		articoloInstance.setPrezzoSingolo(12.5f);
		articoloInstance2.setPrezzoSingolo(17.5f);
		articoloServiceInstance.inserisciNuovo(articoloInstance);
		articoloServiceInstance.inserisciNuovo(articoloInstance2);
		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloServiceInstance.aggiungiCategoriaAdArticolo(articoloInstance.getId(), categoriaInstance.getId());
		articoloServiceInstance.aggiungiCategoriaAdArticolo(articoloInstance2.getId(), categoriaInstance.getId());
		
		float somma = articoloServiceInstance.calcolaPrezzoTotaleCategoria(categoriaInstance.getId());

		if (somma != 30.0f)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}
	private static void testGetListaIndirizziBySerialNumber(OrdineService ordineServiceInstance, ArticoloService articoloServiceInstance) throws Exception {
		String metodo = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println("......." + metodo + " inizio.............");


		Ordine ordineInstance = new Ordine();
		Ordine ordineInstance2 = new Ordine();

		ordineInstance.setIndirizzoSpedizione("via castro del pincio 2");
		ordineInstance2.setIndirizzoSpedizione("via fornie 22");

		ordineServiceInstance.inserisciNuovo(ordineInstance);
		ordineServiceInstance.inserisciNuovo(ordineInstance2);

		Articolo articoloInstance = new Articolo();
		articoloInstance.setNumeroSeriale("37645");
		articoloInstance.setOrdine(ordineInstance);

		articoloServiceInstance.inserisciNuovo(articoloInstance);



		List<String> lista = ordineServiceInstance.trovaIndirizziDalSerialeArticolo("645");




		if (lista.size() != 1)
			throw new RuntimeException(metodo + " fallito");

		System.out.println("......." + metodo + " fine: PASSED.............");
	}

}
