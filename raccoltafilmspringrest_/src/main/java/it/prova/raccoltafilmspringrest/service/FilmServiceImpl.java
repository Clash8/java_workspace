package it.prova.raccoltafilmspringrest.service;

import java.util.ArrayList;
import java.util.List;

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

import it.prova.raccoltafilmspringrest.model.Film;
import it.prova.raccoltafilmspringrest.repository.film.FilmRepository;
import it.prova.raccoltafilmspringrest.web.api.exception.FilmNotFoundException;

@Service
@Transactional(readOnly = true)
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository repository;

	public List<Film> listAllElements(boolean eager) {
		if (eager)
			return (List<Film>) repository.findAllFilmEager();

		return (List<Film>) repository.findAll();
	}

	public Film caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Film caricaSingoloElementoEager(Long id) {
		return repository.findSingleFilmEager(id);
	}

	@Transactional
	public Film aggiorna(Film filmInstance) {
		return repository.save(filmInstance);
	}

	@Transactional
	public Film inserisciNuovo(Film filmInstance) {
		return repository.save(filmInstance);
	}

	@Transactional
	public void rimuovi(Long idToRemove) {
		repository.findById(idToRemove)
				.orElseThrow(() -> new FilmNotFoundException("Film not found con id: " + idToRemove));
		repository.deleteById(idToRemove);
	}

	public List<Film> findByExample(Film example) {
		// da implementare
		return this.listAllElements(false);
	}

	public List<Film> findByTitoloAndGenere(String titolo, String genere) {
		return repository.findByTitoloAndGenere(titolo, genere);
	}
	@Override
	public Page<Film> findByExampleNativeWithPagination(Film example, Integer pageNo, Integer pageSize, String sortBy) {
		return repository.findByExampleNativeWithPagination(example.getTitolo(), example.getGenere(),
				example.getDataPubblicazione(), example.getMinutiDurata(),
				PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
	}

	@Override
	public Page<Film> findByExampleWithPagination(Film example, Integer pageNo, Integer pageSize, String sortBy) {
		Specification<Film> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotEmpty(example.getTitolo()))
				predicates.add(cb.like(cb.lower(root.get("titolo")), "%" + example.getTitolo().toLowerCase() + "%"));

			if (StringUtils.isNotEmpty(example.getGenere()))
				predicates.add(cb.like(cb.lower(root.get("genere")), "%" + example.getGenere().toLowerCase() + "%"));

			if (example.getMinutiDurata() != null)
				predicates.add(cb.equal(root.get("minutiDurata"), example.getMinutiDurata()));

			if (example.getDataPubblicazione() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataPubblicazione"), example.getDataPubblicazione()));

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


}
