package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.exception.ExceptionDipendentiAssociatiASoceta;
import it.prova.gestionesocieta.exception.ExceptionRagioneSocialeGiaPresente;
import it.prova.gestionesocieta.model.Societa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionesocieta.repository.SocietaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class SocietaServiceImpl implements SocietaService {

	@Autowired
	private SocietaRepository societaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Societa> listAll() {return (List<Societa>) societaRepository.findAll();}

	@Transactional
	public void add(Societa s) throws Exception {
		if (societaRepository.findFirstByRagioneSociale(s.getRagioneSociale()).isEmpty())
			s = societaRepository.save(s);
		else
			throw new ExceptionRagioneSocialeGiaPresente();
	}

	public List<Societa> findByExample(Societa example) {

		Map<String, Object> paramaterMap = new HashMap<>();
		List<String> whereClauses = new ArrayList<>();

		StringBuilder queryBuilder = new StringBuilder("select a from Societa a where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getRagioneSociale())) {
			whereClauses.add(" a.ragioneSociale  like :ragioneSociale ");
			paramaterMap.put("ragioneSociale", "%" + example.getRagioneSociale() + "%");
		}
		if (StringUtils.isNotEmpty(example.getIndirizzo())) {
			whereClauses.add(" a.indirizzo like :indirizzo ");
			paramaterMap.put("indirizzo", "%" + example.getIndirizzo() + "%");
		}
		if (example.getDataFondazione() != null) {
			whereClauses.add(" a.dataFondazione >= :dataFondazione ");
			paramaterMap.put("dataFondazione", example.getDataFondazione());
		}
		if (example.getDataChiusura() != null) {
			whereClauses.add(" a.dataChiusura >= :dataChiusura ");
			paramaterMap.put("dataChiusura", example.getDataChiusura());
		}

		queryBuilder.append(!whereClauses.isEmpty() ? " and " : "");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Societa> typedQuery = entityManager.createQuery(queryBuilder.toString(), Societa.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

	@Transactional
	public void rem(Long id) throws Exception{
		Societa societa = societaRepository.findById(id).orElse(null);
		if (societa != null && societa.getDipendenti() != null && societa.getDipendenti().isEmpty()) {
			societaRepository.deleteById(id);
		} else {
			throw new ExceptionDipendentiAssociatiASoceta();
		}

	}

	public List<String> listaClientiDataSocieta(Long idSocieta) {return societaRepository.findDistinctClientiBySocietaId(idSocieta);}

	public List<String> listaNomiSocietaConProgettiConDurataMaggioreDiUnAnno() {return societaRepository.findRagioniSocialiConProgettiOltreUnAnno();}

	public List<Societa> listaSocietaAnomale() {return societaRepository.findSocietaAnomale();}
}
