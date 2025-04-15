package it.prova.lavoratorejdbc.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

public class TestInsert {

	public static void main(String[] args) throws ParseException {
		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao
		LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();
		int quantiSonoAttualmentePresenti = -1;
		List<Lavoratore> attualmentePresentiSullaBaseDati = lavoratoreDaoInstance
				.elencaTuttiQuelliAttualmenteSullaBaseDati();
		quantiSonoAttualmentePresenti = attualmentePresentiSullaBaseDati.size();

		System.out.println("############### test qualche insert ###########################");
		Lavoratore voceDaInserire = new Lavoratore("peppe", "rossi",
				new SimpleDateFormat("dd/MM/yyyy").parse("20/10/1990"), 18000);
		lavoratoreDaoInstance.insert(voceDaInserire);
		Lavoratore altraVoceDaInserire = new Lavoratore("mario", "bianchi",
				new SimpleDateFormat("dd/MM/yyyy").parse("11/10/1989"), 18500);
		lavoratoreDaoInstance.insert(altraVoceDaInserire);
		// faccio il test per verificare che siano state inserite altre due voci
		if (quantiSonoAttualmentePresenti + 2 != lavoratoreDaoInstance.elencaTuttiQuelliAttualmenteSullaBaseDati()
				.size())
			throw new AssertionError("qualche insert: FAILED");
		else
			System.out.println("Sono presenti due elementi in più");

		System.out.println("################### test qualche insert: FINE ###################################");
		System.out.println("#####################################################################");

	}

}
