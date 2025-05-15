package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Pizza;

import java.util.List;

public interface PizzaService {
	List<Pizza> listAllElements();

	Pizza caricaSingoloElemento(Long id);

	void aggiorna(Pizza pizzaInstance);

	void inserisciNuovo(Pizza pizzaInstance);

	void rimuovi(Long idPizzaToDelete);

	List<Pizza> findByExample(Pizza example);

	List<Pizza> cercaByEverything(String term);

}
