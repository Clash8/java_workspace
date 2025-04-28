package it.manytomanyjpamaven.dao;

import it.manytomanyjpamaven.model.Atleta;
import it.manytomanyjpamaven.model.Sport;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SportDAOImpl implements SportDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Sport> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Sport",Sport.class).getResultList();
	}

	@Override
	public Sport get(Long id) throws Exception {
		return entityManager.find(Sport.class, id);
	}

	@Override
	public void update(Sport sportInstance) throws Exception {
		if (sportInstance == null) {
			throw new Exception("Problema valore in input");
		}
		sportInstance = entityManager.merge(sportInstance);
	}

	@Override
	public void insert(Sport sportInstance) throws Exception {
		if (sportInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(sportInstance);
	}

	@Override
	public void delete(Sport sportInstance) throws Exception {
		if (sportInstance == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(sportInstance));
	}

	@Override
	public List<Atleta> listAllAtleti(Long idSport) throws Exception {
		if (idSport == null) {
			throw new Exception("Problema valore in input");
		}
		TypedQuery<Atleta> query = entityManager.createQuery("SELECT DISTINCT a  FROM Atleta a  JOIN a.sports s WHERE s.id = ?1", Atleta.class);
		query.setParameter(1, idSport);
		return query.getResultList();
	}

	@Override
	public List<Sport> listAllErrors() throws Exception {
		TypedQuery<Sport> query = entityManager.createQuery("SELECT s FROM Sport s WHERE s.dataInizio > s.dataFine", Sport.class);
		return query.getResultList();
	}

	@Override
	public long countMedals() throws Exception {
		TypedQuery<Long> query = entityManager.createQuery(
				"SELECT SUM(a.numeroMaglieVinte) FROM Atleta a JOIN a.sports s WHERE s.dataFine < CURRENT_DATE",
				Long.class);
		return query.getSingleResult();
	}
}
