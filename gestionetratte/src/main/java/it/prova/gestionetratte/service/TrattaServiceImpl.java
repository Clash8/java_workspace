package it.prova.gestionetratte.service;

import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.repository.tratta.TrattaRepository;
import it.prova.gestionetratte.web.api.exception.TrattaNotFoundException;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TrattaServiceImpl implements TrattaService {

	@Autowired
	private TrattaRepository repository;

	public List<Tratta> listAllElements() {
		return repository.findAll();
	}

	public Tratta caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Tratta caricaSingoloElementoEager(Long id) {
		return repository.findSingleTrattaEager(id);
	}

	@Transactional
	public Tratta aggiorna(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Transactional
	public Tratta inserisciNuovo(Tratta trattaInstance) {
		return repository.save(trattaInstance);
	}

	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.findById(idToRemove)
				.orElseThrow(() -> new TrattaNotFoundException("Tratta not found con id: " + idToRemove));
		repository.deleteById(idToRemove);
	}

	public List<Tratta> findByExample(Tratta example) {
		return repository.findByExample(example);
	}

	@Override
	public Page<Tratta> findByExampleWithPagination(Tratta example, Integer pageNo, Integer pageSize, String sortBy) {
		Specification<Tratta> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<Predicate>();

			if (StringUtils.isNotEmpty(example.getCodice()))
				predicates.add(cb.like(cb.upper(root.get("codice")), "%" + example.getCodice().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getDescrizione()))
				predicates.add(cb.like(cb.upper(root.get("descrizione")), "%" + example.getDescrizione().toUpperCase() + "%"));

			if (example.getStato() != null)
				predicates.add(cb.equal(root.get("stato"), example.getStato()));

			if (example.getData() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("data"), example.getData()));

			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};

		Pageable paging = null;
		// se non passo parametri di paginazione non ne tengo conto
		if (pageSize == null || pageSize < 10)
			paging = Pageable.unpaged();
		else
			paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		return repository.findAll(specificationCriteria, paging);
	}

	@Override
	public Page<Tratta> findByExampleNativeWithPagination(Tratta example, Integer pageNo, Integer pageSize,
			String sortBy) {
		return repository.findByExampleNativeWithPagination(
				example.getCodice(),
				example.getDescrizione(),
				example.getData(),
				example.getStato(),
				PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
	}

	public List<Tratta> findByCodiceEDescrizione(String term) {
		return repository.findByCodiceIgnoreCaseContainingOrDescrizioneIgnoreCaseContainingOrderByIdAsc(term, term);
	}

	public Tratta findByCodiceEDescrizione(String codice, String descrizione) {
		return repository.findByCodiceAndDescrizione(codice, descrizione);
	}

	@Override
	public List<Tratta> listAllElementsEager() {
		return (List<Tratta>) repository.findAllEager();
	}

}
