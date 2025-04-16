package gestionenegoziojdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

import java.util.List;

public class TestSelectAll {

	public static void main(String[] args) {
		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao 
		LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();
		int quantiSonoAttualmentePresenti = -1;

		// #####################################################################
		System.out.println("############### test per verifica esistenza dati ###########################");
		List<Lavoratore> attualmentePresentiSullaBaseDati = lavoratoreDaoInstance
				.elencaTuttiQuelliAttualmenteSullaBaseDati();
		quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();
		System.out.println("Sono attualmente presenti " + quantiSonoAttualmentePresenti + " records");
		for (Lavoratore lavoratoreItem : attualmentePresentiSullaBaseDati) {
			System.out.println(lavoratoreItem);
		}

		System.out.println(
				"####################### test per verifica esistenza dati: FINE     ##################################");
		System.out.println("#####################################################################");

	}

}
