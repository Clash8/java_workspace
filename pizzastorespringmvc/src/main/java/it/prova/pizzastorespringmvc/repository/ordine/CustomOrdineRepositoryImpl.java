package it.prova.pizzastorespringmvc.repository.ordine;

import it.prova.pizzastorespringmvc.model.Ordine;
import it.prova.pizzastorespringmvc.repository.ordine.CustomOrdineRepository;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomOrdineRepositoryImpl implements CustomOrdineRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ordine> findByExample(Ordine example) {
		Map<String, Object> paramaterMap = new HashMap<>();
		List<String> whereClauses = new ArrayList<>();

		StringBuilder queryBuilder = new StringBuilder("select o from Ordine o where o.id = o.id ");
		//(id, Cliente, lista di Pizza, dataOrdine, CLOSED=true/false, codice, costo totale ordine).
		if (example.getCliente() != null && example.getCliente().getId() != null) {
			whereClauses.add(" o.cliente.id = :clienteId ");
			paramaterMap.put("clienteId", example.getCliente().getId());
		}
		if (example.getDataOrdine() != null) {
			whereClauses.add(" o.dataOrdine = :dataOrdine ");
			paramaterMap.put("dataOrdine", example.getDataOrdine());
		}
		if (example.getChiuso() != null) {
			whereClauses.add(" o.chiuso =:chiuso ");
			paramaterMap.put("chiuso", example.getChiuso());
		}
		if (StringUtils.isNotEmpty(example.getCodice())) {
			whereClauses.add(" o.codice like :codice ");
			paramaterMap.put("codice", "%" + example.getCodice() + "%");
        }

		queryBuilder.append(!whereClauses.isEmpty()?" and ":"");
		queryBuilder.append(StringUtils.join(whereClauses, " and "));
		TypedQuery<Ordine> typedQuery = entityManager.createQuery(queryBuilder.toString(), Ordine.class);

		for (String key : paramaterMap.keySet()) {
			typedQuery.setParameter(key, paramaterMap.get(key));
		}

		return typedQuery.getResultList();
	}

}
