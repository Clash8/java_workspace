package it.prova.gestioneimpiegati.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestioneimpiegati.model.Satellite;
import it.prova.gestioneimpiegati.repository.SatelliteRepository;

@Service
public class SatelliteServiceImpl implements SatelliteService {

	@Autowired
	private SatelliteRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Satellite> listAllElements() {
		return (List<Satellite>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Satellite caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Satellite satelliteInstance) {
		repository.save(satelliteInstance);
	}

	@Override
	@Transactional
	public void inserisciNuovo(Satellite satelliteInstance) {
		repository.save(satelliteInstance);

	}

	@Override
	@Transactional
	public void rimuovi(Long idSatellite) {
		repository.deleteById(idSatellite);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Satellite> findByExample(Satellite example) {
		Specification<Satellite> specificationCriteria = (root, query, cb) -> {

			List<Predicate> predicates = new ArrayList<Predicate>();

			if (StringUtils.isNotEmpty(example.getDenominazione()))
				predicates.add(cb.like(cb.upper(root.get("denominazione")), "%" + example.getDenominazione().toUpperCase() + "%"));

			if (StringUtils.isNotEmpty(example.getCodice()))
				predicates.add(cb.like(cb.upper(root.get("codice")), "%" + example.getCodice().toUpperCase() + "%"));

			if (example.getStato() != null)
				predicates.add(cb.equal(root.get("stato"), example.getStato()));

			if (example.getDataLancio() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataLancio"), example.getDataLancio()));

			if (example.getDataRientro() != null)
				predicates.add(cb.greaterThanOrEqualTo(root.get("dataRientro"), example.getDataRientro()));

			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};

		return repository.findAll(specificationCriteria);
	}
	@Override
	public List<Satellite> findLanciatiDaPiuDiDueAnni() {
		LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
		List<Satellite> result = repository.findLanciatiDaPiuDiDueAnni(twoYearsAgo);
		return result;
	}
	@Override
	public List<Satellite> findDisattivatiMaNonRientrati() {
		List<Satellite> result = repository.findDisattivatiMaNonRientrati();
		return result;
	}
	@Override
	public List<Satellite> findFissiOraInOrbita10Anni() {
		LocalDate tenYearsAgo = LocalDate.now().minusYears(10);
		List<Satellite> result = repository.findFissiOraInOrbita10Anni(tenYearsAgo);
		return result;
	}

}
