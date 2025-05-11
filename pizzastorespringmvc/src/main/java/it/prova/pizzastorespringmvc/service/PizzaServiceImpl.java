package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Pizza;
import it.prova.pizzastorespringmvc.repository.pizza.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaRepository repository;

	@Transactional(readOnly = true)
	public List<Pizza> listAllElements() {
		return (List<Pizza>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Pizza caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Pizza pizzaInstance) {
		repository.save(pizzaInstance);
	}

	@Transactional
	public void inserisciNuovo(Pizza pizzaInstance) {
		repository.save(pizzaInstance);
	}

	@Transactional
	public void rimuovi(Long idPizzaToDelete) {
		repository.deleteById(idPizzaToDelete);
	}

	@Transactional(readOnly = true)
	public List<Pizza> findByExample(Pizza example) {
		// da implementare V
		return repository.findByExample(example);
//		return null;
	}


}
