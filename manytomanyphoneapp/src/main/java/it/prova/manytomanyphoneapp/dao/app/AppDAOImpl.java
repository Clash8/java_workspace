package it.prova.manytomanyphoneapp.dao.app;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.manytomanyphoneapp.model.App;

public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;

	@Override
	public List<App> list() throws Exception {
		return entityManager.createQuery("from App", App.class).getResultList();
	}

	@Override
	public App get(Long id) throws Exception {
		return entityManager.find(App.class, id);
	}

	@Override
	public void update(App input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(App input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(App input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
