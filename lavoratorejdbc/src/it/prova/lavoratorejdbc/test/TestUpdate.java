package it.prova.lavoratorejdbc.test;

import java.util.List;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

public class TestUpdate {

	public static void main(String[] args) {
		System.out.println("Inizio....");

		// questo risulta l'oggetto incaricato di operazioni dao
		LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();

		System.out.println("################ test se esiste almeno uno ne sfrutto l'id #######");
		List<Lavoratore> attualmentePresentiSullaBaseDati = lavoratoreDaoInstance
				.elencaTuttiQuelliAttualmenteSullaBaseDati();

		if (!attualmentePresentiSullaBaseDati.isEmpty()) {
			Lavoratore elementoCheVoglioModificare = attualmentePresentiSullaBaseDati.get(0);
			String nuovoValoreDaAssegnareANome = "maurizio";
			System.out.println("...before update: " + elementoCheVoglioModificare);
			elementoCheVoglioModificare.setNome(nuovoValoreDaAssegnareANome);
			// eseguo update vero e proprio
			lavoratoreDaoInstance.update(elementoCheVoglioModificare);

			// ora lo ricarico e verifico se il nome è stato effettivamente modificato
			Long idElementoRicaricataDaDbPerTestUpdate = elementoCheVoglioModificare.getId();
			Lavoratore elementoRicaricataDaDbPerTestUpdate = lavoratoreDaoInstance
					.findById(idElementoRicaricataDaDbPerTestUpdate);
			System.out.println("...after update: " + elementoRicaricataDaDbPerTestUpdate);
			System.out.println("carico studente con id: " + idElementoRicaricataDaDbPerTestUpdate);
			if (elementoRicaricataDaDbPerTestUpdate == null
					|| !elementoRicaricataDaDbPerTestUpdate.getNome().equals(nuovoValoreDaAssegnareANome))
				throw new AssertionError("se ne esiste almeno uno: FAILED");
		}
		System.out.println("################### test se ne esiste almeno uno provo a modificarlo :FINE #######");

	}

}
