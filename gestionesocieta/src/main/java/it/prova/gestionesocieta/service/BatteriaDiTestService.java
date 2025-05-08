package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;
import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import it.prova.gestionesocieta.repository.SocietaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class BatteriaDiTestService {

	@Autowired
	private DipendenteService dipendenteService;
	@Autowired
	private SocietaService societaService;
	@Autowired
	private ProgettoService progettoService;


	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED   = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";

	public void testInserimentoSocieta() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa  = new Societa("Smart s.p.a.", "via delle nainaianinifeywb");
		try {
			societaService.add(societa);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}

		Societa societa2 = new Societa("Smart s.p.a.", "via del tutto eccezionale");
		try {
			societaService.add(societa2);

			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Duplicate insert did NOT fail");
		} catch (Exception expected) {
			System.out.println("ragione sociale già esistente");
		}

		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}

	public void testfindSocietaByExample() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa  = new Societa("TechCorp s.p.a.", "via delle Innovazioni 1");
		Societa societa1 = new Societa("GreenEnergy s.p.a.", "via delle Energie 2");
		Societa societa2 = new Societa("EduLearn s.p.a.", "via dell'Istruzione 3");
		Societa societa3 = new Societa("TechCare s.p.a.", "via della Salute 4");
		Societa societa4 = new Societa("Tech s.p.a.", "via delle Automobili 5");
		Societa societa5 = new Societa("Foodies s.p.a.", "via del Gusto 6");

		try {
			societaService.add(societa);
			societaService.add(societa1);
			societaService.add(societa2);
			societaService.add(societa3);
			societaService.add(societa4);
			societaService.add(societa5);
		} catch (Exception e) {
			// Unexpected : the very first insert must work
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Societa example = new Societa("tech", "via");
		try {
			List<Societa> societatrovate = societaService.findByExample(example);
			if (societatrovate.size() != 3) {
				System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
				throw new RuntimeException("testfindSocietaByExample...failed: expected 3 results, got " + societatrovate.size());
			}
			System.out.println(societatrovate);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}


	public void testRemoveSocieta() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa1  = new Societa("Societa' con tanti dipendenti s.p.a.", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());


		try {
			societaService.add(societa1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}

		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 2000, societa1);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 3000, societa1);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Societa societa2  = new Societa("Societa' con 0 dipendenti s.p.a.", "via delle Innovazioni 1");


		try {
			societaService.add(societa2);
		} catch (Exception e) {
			// Unexpected : the very first insert must work
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		// provo a rimuovere la soceta1
		try {
			societaService.rem(societa1.getId());
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);

		} catch (Exception e) {

			System.out.println(ANSI_GREEN + e + ANSI_RESET);
		}
		// provo a rimuovere la soceta2

		try {
			societaService.rem(societa2.getId());
			System.out.println(ANSI_GREEN + "societa' senza dipendenti puo' essere rimossa senza problemi" + ANSI_RESET);

		} catch (Exception e) {

			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
		}
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}


	public void testInserimentoDipendenteConThrowException() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa1  = new Societa("Societa' con un dipendente s.r.l.", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());


		try {
			societaService.add(societa1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}

		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);

		try {
			dipendenteService.add(d1);
			System.out.println(ANSI_GREEN + "Ho inserito un dipendente!" + ANSI_RESET);

		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now().minusDays(1), 2000, societa1);

		try {
			dipendenteService.add(d2);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed");
		} catch (Exception e) {
			System.out.println(ANSI_GREEN + e + ANSI_RESET);
		}

		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}

	public void testInserimentoProgetto() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Progetto progetto = new Progetto("Progetto 1", "Cliente 1", 12);

		try {
			progettoService.add(progetto);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}
	public void testCollegaDipendenteConThrowsException() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa1  = new Societa("A.S ROMA", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());
		societa1.setDataChiusura(LocalDate.now().plusMonths(12L));


		try {
			societaService.add(societa1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}

		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 2000, societa1);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 3000, societa1);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto progetto = new Progetto("Progetto 1", "Cliente 1", 11);
		try {
			progettoService.add(progetto);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> dipendentiId = List.of(d1.getId(), d2.getId(), d3.getId());
		try {
			progettoService.linkProgettoToDipendenti(progetto.getId(), dipendentiId);
			System.out.println(ANSI_GREEN + "Ho inserito linkato il progetto con id: " + progetto.getId() +" ai dipendenti con id: "+ dipendentiId + ANSI_RESET);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		Progetto progetto2 = new Progetto("Progetto 1", "Cliente 1", 14);

		try {
			progettoService.add(progetto2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #5 failed", e);
		}

		try {
			progettoService.linkProgettoToDipendenti(progetto2.getId(), List.of(d1.getId(), d2.getId(), d3.getId()));
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #6 failed");
		} catch (Exception e) {
			System.out.println(ANSI_GREEN + e + ANSI_RESET);
		}

		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}



	public void testCollegaProgettoConThrowsException() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);


		Societa societa1  = new Societa("S.S. LAZIO", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());
		societa1.setDataChiusura(LocalDate.now().plusMonths(12L));


		try {
			societaService.add(societa1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}

		Dipendente d1 = new Dipendente("Mario", "Balotelli", LocalDate.now(), 1000, societa1);


		try {
			dipendenteService.add(d1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 11);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);
		Progetto p3 = new Progetto("Progetto 3", "Cliente 3", 11);
		try {
			progettoService.add(p1);
			progettoService.add(p2);
			progettoService.add(p3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId(), p2.getId(), p3.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
			System.out.println(ANSI_GREEN + "Ho inserito linkato il dipendente con id: " + d1.getId() +" ai progetti con id: "+ progettiId + ANSI_RESET);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		Progetto p4 = new Progetto("Progetto 1", "Cliente 1", 11);
		Progetto p5 = new Progetto("Progetto 2", "Cliente 2", 11);
		Progetto p6 = new Progetto("Progetto 3", "Cliente 3", 14);

		try {
			progettoService.add(p4);
			progettoService.add(p5);
			progettoService.add(p6);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #5 failed", e);
		}
		List<Long> progetti2Id = List.of(p4.getId(), p5.getId(), p6.getId());

		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progetti2Id);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #6 failed");
		} catch (Exception e) {
			System.out.println(ANSI_GREEN + e + ANSI_RESET);
		}

		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}


	public void testListaClientiDataSocietaInInput() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);
		Societa societa1  = new Societa("CocaCola Company", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());
		societa1.setDataChiusura(LocalDate.now().plusMonths(12L));

		try {
			societaService.add(societa1);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 2000, societa1);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 3000, societa1);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 11);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);

		try {
			progettoService.add(p1);
			progettoService.add(p2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId(), p2.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		List<String> clienti = societaService.listaClientiDataSocieta(societa1.getId());

		if (clienti.size() != 2) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException( testN + "................................FAILED: dovevano essere 2!! e sono " + clienti.size());
		}

		System.out.println(ANSI_GREEN + "trovati: " + clienti + ANSI_RESET);
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}





	public void testListaNomiProgettiDelleSocietaConDuratMaggioreDiUnAnno() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);
		Societa societa1  = new Societa("RAI srl", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());
		societa1.setDataChiusura(LocalDate.now().plusMonths(25L));

		Societa societa2 = new Societa("Mediaset srl", "via delle Innovazioni 1");
		societa2.setDataFondazione(LocalDate.now());
		societa2.setDataChiusura(LocalDate.now().plusMonths(25L));

		try {
			societaService.add(societa1);
			societaService.add(societa2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 2000, societa2);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 3000, societa2);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 14);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);

		try {
			progettoService.add(p1);
			progettoService.add(p2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}
		List<Long> progetti2Id = List.of(p2.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d2.getId(),progetti2Id);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		List<String> societaName = societaService.listaNomiSocietaConProgettiConDurataMaggioreDiUnAnno();


		if (societaName.size() != 1) {
			System.out.println(ANSI_RED + "trovati: " + societaName + ANSI_RESET);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException( testN + "................................FAILED: dovevano essere 1!! e sono " + societaName.size());
		}
		System.out.println(ANSI_GREEN + "trovati: " + societaName + ANSI_RESET);
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}

	public void testListaProgettiInCuiLavoraAlmenoUnDipendenteRicco() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);
		Societa societa1  = new Societa("GUCCI SPA", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now());
		societa1.setDataChiusura(LocalDate.now().plusMonths(25L));

		Societa societa2 = new Societa("FENDI srl", "via delle Innovazioni 1");
		societa2.setDataFondazione(LocalDate.now());
		societa2.setDataChiusura(LocalDate.now().plusMonths(25L));


		try {
			societaService.add(societa1);
			societaService.add(societa2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 30000, societa2);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 20000, societa2);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 14);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);

		try {
			progettoService.add(p1);
			progettoService.add(p2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}
		List<Long> progetti2Id = List.of(p2.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d2.getId(),progetti2Id);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		List<Progetto> progettiRicchi = progettoService.listaProgettiInCuiLavoraAlmenoUnDipendenteConUnaRALAPartireDa30000();


		if (progettiRicchi.size() != 1) {
			System.out.println(ANSI_RED + "trovati: " + progettiRicchi + ANSI_RESET);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException( testN + "................................FAILED: dovevano essere 1!! e sono " + progettiRicchi.size());
		}
		System.out.println(ANSI_GREEN + "trovati: " + progettiRicchi + ANSI_RESET);
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}









	public void testDipendentePiuAnziano() {

		final String testN = currentMethodName();

		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);
		Societa societa1  = new Societa("Ferrari SPA", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now().minusYears(40));
		societa1.setDataChiusura(LocalDate.now().plusMonths(25L));

		Societa societa2 = new Societa("Maserati srl", "via delle Innovazioni 2");
		societa2.setDataFondazione(LocalDate.now());
		societa2.setDataChiusura(LocalDate.now().plusMonths(25L));


		try {
			societaService.add(societa1);
			societaService.add(societa2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 30000, societa2);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 20000, societa2);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 14);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);

		try {
			progettoService.add(p1);
			progettoService.add(p2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}
		List<Long> progetti2Id = List.of(p2.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d2.getId(),progetti2Id);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		Dipendente dipendentePiuAnziano = dipendenteService.dipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();


		if (!Objects.equals(dipendentePiuAnziano.getId(), d1.getId())) {
			System.out.println(ANSI_RED + "trovato: " + dipendentePiuAnziano + ANSI_RESET);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException( testN + "................................FAILED");
		}
		System.out.println(ANSI_GREEN + "trovato: " + dipendentePiuAnziano + ANSI_RESET);
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}






















	public static String currentMethodName() {
		try {
			return StackWalker.getInstance()
					.walk(stream -> stream
							.skip(1)           // 0 = this method, 1 = caller
							.findFirst()
							.map(StackWalker.StackFrame::getMethodName)
							.orElse("unknown"));
		} catch (NoClassDefFoundError | UnsupportedOperationException e) {
			StackTraceElement[] st = Thread.currentThread().getStackTrace();
			return (st.length > 2) ? st[2].getMethodName() : "unknown";
		}
	}


	/*

	public void test() {
		final String testN = currentMethodName();
		System.out.println(ANSI_GREEN + testN + "................................START" + ANSI_RESET);

		Societa societa1 = new Societa("Ferrari SPA", "via delle Innovazioni 1");
		societa1.setDataFondazione(LocalDate.now().minusYears(40));
		societa1.setDataChiusura(LocalDate.now().plusMonths(25L));

		Societa societa2 = new Societa("Maserati srl", "via delle Innovazioni 2");
		societa2.setDataFondazione(LocalDate.now());
		societa2.setDataChiusura(LocalDate.now().plusMonths(25L));


		try {
			societaService.add(societa1);
			societaService.add(societa2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #1 failed", e);
		}
		Dipendente d1 = new Dipendente("Mario", "Rossi", LocalDate.now(), 1000, societa1);
		Dipendente d2 = new Dipendente("Luigi", "Verdi", LocalDate.now(), 30000, societa2);
		Dipendente d3 = new Dipendente("Giovanni", "Bianchi", LocalDate.now(), 20000, societa2);

		try {
			dipendenteService.add(d1);
			dipendenteService.add(d2);
			dipendenteService.add(d3);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #2 failed", e);
		}

		Progetto p1 = new Progetto("Progetto 1", "Cliente 1", 14);
		Progetto p2 = new Progetto("Progetto 2", "Cliente 2", 11);

		try {
			progettoService.add(p1);
			progettoService.add(p2);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #3 failed", e);
		}

		List<Long> progettiId = List.of(p1.getId());
		try {
			dipendenteService.linkDipendenteToProgetti(d1.getId(),progettiId);
		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}
		List<Long> progetti2Id = List.of(p2.getId());
		try {

		} catch (Exception e) {
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException("Insert #4 failed", e);
		}

		Dipendente dipendentePiuAnziano = dipendenteService.dipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();


		if (!Objects.equals(dipendentePiuAnziano.getId(), d1.getId())) {
			System.out.println(ANSI_RED + "trovato: " + dipendentePiuAnziano + ANSI_RESET);
			System.err.println(ANSI_RED + testN + "................................FAILED" + ANSI_RESET);
			throw new RuntimeException( testN + "................................FAILED");
		}
		System.out.println(ANSI_GREEN + "trovato: " + dipendentePiuAnziano + ANSI_RESET);
		System.out.println(ANSI_GREEN + testN + "................................PASSED" + ANSI_RESET);
	}



	 */
}
