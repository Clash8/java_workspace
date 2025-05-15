package it.prova.pizzastorespringmvc.repository.pizza;

import it.prova.pizzastorespringmvc.model.Pizza;
import it.prova.pizzastorespringmvc.repository.pizza.CustomPizzaRepository;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomPizzaRepositoryImpl implements CustomPizzaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pizza> findByExample(Pizza example) {
		Map<String, Object> paramaterMap = new HashMap<>();
		List<String> whereClauses = new ArrayList<>();

		StringBuilder queryBuilder = new StringBuilder("select p from Pizza p where p.id = p.id ");
		// id, descrizione, ingredienti, prezzo base [che è un prezzo fisso della pizza dato dal costo della farina, luce, costi vari], attivo=true/false),
		if (StringUtils.isNotEmpty(example.getDescrizione())) {
			whereClauses.add(" p.descrizione like :descrizione ");
			paramaterMap.put("descrizione", "%" + example.getDescrizione() + "%");
		}
		if (StringUtils.isNotEmpty(example.getIngredienti())) {
			whereClauses.add(" p.ingredienti like :ingredienti ");
			paramaterMap.put("ingredienti", "%" + example.getIngredienti() + "%");
		}
		if (example.getPrezzoBase() != null) {
			whereClauses.add(" p.prezzoBase = :prezzoBase ");
			paramaterMap.put("prezzoBase", example.getPrezzoBase());
		}
		if (example.getAttivo() != null) {
			whereClauses.add(" p.attivo = :attivo ");
			paramaterMap.put("attivo", example.getAttivo());
        }

		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Pizza> typedQuery = entityManager.createQuery(queryBuilder.toString(), Pizza.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
