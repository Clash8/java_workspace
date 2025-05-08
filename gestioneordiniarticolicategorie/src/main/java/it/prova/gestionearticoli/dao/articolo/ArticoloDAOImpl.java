package it.prova.gestionearticoli.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionearticoli.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;

	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Articolo input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public List<Articolo> listAllByOrdine(Long idOrdine) throws Exception {
		return entityManager.createQuery("from Articolo a where a.ordine.id = ?1", Articolo.class).setParameter(1, idOrdine).getResultList();
	}

	public float calcolaPrezzoTotaleCategoria(Long idCategoria) throws Exception {
		return entityManager.createQuery(
				"select coalesce(sum(a.prezzoSingolo), 0) from Articolo a join a.categorie c where c.id = ?1", Float.class)
				.setParameter(1, idCategoria)
				.getSingleResult();
	}

	@Override
	public List<Articolo> getArticoliWithErrors() throws Exception {
		return entityManager.createQuery("from Articolo a join a.ordine o where o.dataSpedizione > o.dataScadenza", Articolo.class).getResultList();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
