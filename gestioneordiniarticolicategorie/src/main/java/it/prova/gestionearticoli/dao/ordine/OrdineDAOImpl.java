package it.prova.gestionearticoli.dao.ordine;

import it.prova.gestionearticoli.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public Ordine findMostRecentOrderByCategoria(Long idCategoria) throws Exception {
		//snis
		return null;
	}

	public List<String> findAddressByArticoliSerial(String serialeArticolo) throws Exception {
		if (serialeArticolo == null || serialeArticolo.isEmpty()) {
			throw new Exception("Problema valore in input");
		}
		return entityManager.createQuery("select distinct o.indirizzoSpedizione from Ordine o join o.articoli a where a.numeroSeriale = ?1", String.class)
				.setParameter(1, serialeArticolo)
				.getResultList();
	}




	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
