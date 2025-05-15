package it.prova.pizzastorespringmvc.service;

import it.prova.pizzastorespringmvc.model.Ordine;
import it.prova.pizzastorespringmvc.repository.ordine.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	private OrdineRepository repository;

	@Transactional(readOnly = true)
	public List<Ordine> listAllElements() {
		return (List<Ordine>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Ordine caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Ordine caricaSingoloElementoEager(Long id) {
		return repository.findSingleOrdineEager(id);
	}

	@Transactional
	public void aggiorna(Ordine ordineInstance) {
		repository.save(ordineInstance);
	}

	@Transactional
	public void inserisciNuovo(Ordine ordineInstance) {
		repository.save(ordineInstance);
	}

	@Transactional
	public void rimuovi(Long idOrdineToDelete) {
		repository.deleteById(idOrdineToDelete);;
	}

	@Transactional(readOnly = true)
	public List<Ordine> findByExample(Ordine example) {
		// da implementare V
		return repository.findByExample(example);
//		return null;
	}


}
