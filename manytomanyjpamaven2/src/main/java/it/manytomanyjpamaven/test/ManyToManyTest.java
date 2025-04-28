package it.manytomanyjpamaven.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Atleta;
import it.manytomanyjpamaven.model.SportAtleta;
import it.manytomanyjpamaven.model.Sport;
import it.manytomanyjpamaven.service.*;

public class ManyToManyTest {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		AtletaService atletaServiceInstance = MyServiceFactory.getAtletaServiceInstance();
		SportService sportServiceInstance = MyServiceFactory.getSportServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// aggiungo un atleta
			Atleta atleta1 = new Atleta("Mario", "Rossi", LocalDate.of(1990, 1, 1), "1234567890", 5);
			atleta1.setSport(SportAtleta.CALCIO);
			atletaServiceInstance.inserisciNuovo(atleta1);

			// aggiungo un altro atleta
			Atleta atleta2 = new Atleta("Luigi", "Verdi", LocalDate.of(1992, 2, 2), "0987654321", 3);
			atleta2.setSport(SportAtleta.CALCIO);
			atletaServiceInstance.inserisciNuovo(atleta2);

			// aggiungo uno sport
			Sport sport1 = new Sport("CALCIO A 5", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
			sportServiceInstance.inserisciNuovo(sport1);
			// aggiungo un altro sport
			Sport sport2 = new Sport("CALCIO A 7", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
			sportServiceInstance.inserisciNuovo(sport2);

			// carico un atleta
			Atleta atletaCaricato = atletaServiceInstance.caricaSingoloElemento(atleta1.getId());
			System.out.println("Atleta caricato: " + atletaCaricato);
			// carico uno sport
			Sport sportCaricato = sportServiceInstance.caricaSingoloElemento(sport1.getId());
			System.out.println("Sport caricato: " + sportCaricato);
			Sport sportCaricato2 = sportServiceInstance.caricaSingoloElemento(sport2.getId());
			System.out.println("Sport caricato: " + sportCaricato2);


			// aggiungo lo sport all'atleta
//			System.out.println("aggiungo lo sport all'atleta");
//
//			sportServiceInstance.aggiungiAtletaASport(atleta1.getId(), sport1.getId());
//			System.out.println(atleta1);

			// aggiorno l'atleta
			atleta1.setCognome("BALOTELLI");
			atletaServiceInstance.aggiorna(atleta1);
			System.out.println("quante medaglie ha vinto: \n" + atleta1.getCognome() + "\n" + atleta1.getNumeroMaglieVinte());

			System.out.println("conto quante medaglie hanno vinto in totale");
			System.out.println("medaglie vinte: " + sportServiceInstance.countMedals());

			System.out.println("errori count" + sportServiceInstance.listAllErrors());




		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}
}
