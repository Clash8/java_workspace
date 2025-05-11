package it.prova.pizzastorespringmvc.repository.film;

import it.prova.pizzastorespringmvc.model.Film;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomFilmRepositoryImpl implements CustomFilmRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Film> findByExample(Film example) {
		Map<String, Object> paramaterMap = new HashMap<String, Object>();
		List<String> whereClauses = new ArrayList<String>();

		StringBuilder queryBuilder = new StringBuilder("select r from Film r where r.id = r.id ");
		// id, titolo, genere, dataPubblicazione, minutiDurata, regista
		if (StringUtils.isNotEmpty(example.getTitolo())) {
			whereClauses.add(" r.titolo  like :titolo ");
			paramaterMap.put("titolo", "%" + example.getTitolo() + "%");
		}
		if (StringUtils.isNotEmpty(example.getGenere())) {
			whereClauses.add(" r.genere like :genere ");
			paramaterMap.put("genere", "%" + example.getGenere() + "%");
		}
		if (example.getMinutiDurata() != null) {
			whereClauses.add(" r.minutiDurata =:minutiDurata ");
			paramaterMap.put("minutiDurata", example.getMinutiDurata());
		}
		if (example.getDataPubblicazione() != null) {
			whereClauses.add("r.dataPubblicazione >= :ataPubblicazione ");
			paramaterMap.put("ataPubblicazione", example.getDataPubblicazione());
		}

		if (example.getRegista() != null && example.getRegista().getId() != null) {
			whereClauses.add(" r.regista.id = :registaId ");
			paramaterMap.put("registaId", example.getRegista().getId());
		}

		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Film> typedQuery = entityManager.createQuery(queryBuilder.toString(), Film.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
