package it.prova.gestionetratte.service;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;
import it.prova.gestionetratte.web.api.exception.AirbusNotFoundException;
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
public class AirbusServiceImpl implements AirbusService {

	@Autowired
	private AirbusRepository repository;

	@Override
	public List<Airbus> listAllElements() {
		return repository.findAll();
	}

	@Override
	public List<Airbus> listAllElementsEager() {
		return repository.findAllEager();
	}

	@Override
	public Airbus caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Airbus caricaSingoloElementoEager(Long id) {
		return repository.findSingleAirbusEager(id);
	}

	@Transactional
	public Airbus aggiorna(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Transactional
	public Airbus inserisciNuovo(Airbus airbusInstance) {
		return repository.save(airbusInstance);
	}

	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.findById(idToRemove)
				.orElseThrow(() -> new AirbusNotFoundException("Airbus not found con id: " + idToRemove));
		repository.deleteById(idToRemove);
	}

	@Override
	public List<Airbus> findByExample(Airbus example) {
		return repository.findByExample(example);
	}

	@Override
	public Page<Airbus> findByExampleWithPagination(Airbus example, Integer pageNo, Integer pageSize, String sortBy) {
		Specification<Airbus> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotEmpty(example.getCodice()))
				predicates.add(cb.like(cb.upper(root.get("codice")), "%" + example.getCodice().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getDescrizione()))
				predicates.add(cb.like(cb.upper(root.get("descrizione")), "%" + example.getDescrizione().toUpperCase() + "%"));

			if (example.getNumeroPasseggeri() != null)
				predicates.add(cb.equal(root.get("numeroPasseggeri"), example.getNumeroPasseggeri()));

			if (example.getDataInizioServizio() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataInizioServizio"), example.getDataInizioServizio()));

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
	public Page<Airbus> findByExampleNativeWithPagination(Airbus example, Integer pageNo, Integer pageSize,
			String sortBy) {
		return repository.findByExampleNativeWithPagination(
				example.getCodice(),
				example.getDescrizione(),
				example.getDataInizioServizio(),
				example.getNumeroPasseggeri(),
				PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
	}

	@Override
	public List<Airbus> findByCodiceEDescrizione(String term) {
		return repository.findByCodiceIgnoreCaseContainingOrDescrizioneIgnoreCaseContainingOrderByIdAsc(term, term);
	}

	@Override
	public Airbus findByCodiceEDescrizione(String codice, String descrizione) {
		return repository.findByCodiceAndDescrizione(codice, descrizione);
	}

}
