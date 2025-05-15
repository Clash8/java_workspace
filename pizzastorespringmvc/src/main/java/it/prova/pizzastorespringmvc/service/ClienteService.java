package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Cliente;

import java.util.List;

public interface ClienteService {
	List<Cliente> listAllElements();

	Cliente caricaSingoloElemento(Long id);

	Cliente caricaSingoloElementoConOrdini(Long id);

	void aggiorna(Cliente clienteInstance);

	void inserisciNuovo(Cliente clienteInstance);

	void rimuovi(Long idClienteToDelete);

	List<Cliente> findByExample(Cliente example);

}
