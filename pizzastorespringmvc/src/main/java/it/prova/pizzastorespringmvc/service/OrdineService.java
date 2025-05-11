package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Ordine;

import java.util.List;

public interface OrdineService {
	List<Ordine> listAllElements();

	Ordine caricaSingoloElemento(Long id);

	void aggiorna(Ordine ordineInstance);

	void inserisciNuovo(Ordine ordineInstance);

	void rimuovi(Long idOrdineToDelete);

	List<Ordine> findByExample(Ordine example);

}
