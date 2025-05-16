package it.prova.gestionetratte.repository.airbus;

import it.prova.gestionetratte.model.Airbus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAirbusRepositoryImpl implements CustomAirbusRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Airbus> findByExample(Airbus example) {
		Map<String, Object> paramaterMap = new HashMap<>();
		List<String> whereClauses = new ArrayList<>();

		StringBuilder queryBuilder = new StringBuilder("select a from Airbus a where a.id = a.id ");

		if (StringUtils.isNotEmpty(example.getCodice())) {
			whereClauses.add(" a.codice  like :codice ");
			paramaterMap.put("codice", "%" + example.getCodice() + "%");
		}
		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" a.descrizione like :descrizione ");
			paramaterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (example.getDataInizioServizio() != null) {
			whereClauses.add(" a.dataInizioServizio = :dataInizioServizio ");
			paramaterMap.put("dataInizioServizio", example.getDataInizioServizio());
		}
		if (example.getNumeroPasseggeri() != null) {
			whereClauses.add("a.numeroPasseggeri = :numeroPasseggeri ");
			paramaterMap.put("numeroPasseggeri", example.getNumeroPasseggeri());
		}
		
		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Airbus> typedQuery = entityManager.createQuery(queryBuilder.toString(), Airbus.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
