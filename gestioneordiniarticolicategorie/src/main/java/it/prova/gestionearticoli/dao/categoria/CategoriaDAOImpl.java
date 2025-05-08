package it.prova.gestionearticoli.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionearticoli.model.Articolo;
import it.prova.gestionearticoli.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;

	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Categoria input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public List<Articolo> listAllArticoli(Long idCategoria) throws Exception {
		if (idCategoria == null) {
			throw new Exception("Problema valore in input");
		}
		return entityManager.createQuery("select a from Articolo a join a.categorie c where c.id = ?1", Articolo.class).setParameter(1, idCategoria).getResultList();
	}


	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
