package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Cliente;
import it.prova.pizzastorespringmvc.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<Cliente> listAllElements() {
		return (List<Cliente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Cliente caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Transactional
	public void inserisciNuovo(Cliente clienteInstance) {
		repository.save(clienteInstance);
	}

	@Transactional
	public void rimuovi(Long idClienteToDelete) {
		repository.deleteById(idClienteToDelete);;
	}

	@Transactional(readOnly = true)
	public List<Cliente> findByExample(Cliente example) {
		// da implementare V
		return repository.findByExample(example);
	}

}
