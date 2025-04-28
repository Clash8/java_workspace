package it.manytomanyjpamaven.service;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.dao.SportDAO;
import it.manytomanyjpamaven.dao.AtletaDAO;
import it.manytomanyjpamaven.model.Sport;
import it.manytomanyjpamaven.model.Atleta;

import javax.persistence.EntityManager;
import java.util.List;

public class SportServiceImpl implements SportService {

	private SportDAO sportDAO;
	private AtletaDAO atletaDAO;

	@Override
	public void setAtletaDAO(AtletaDAO atletaDAO) {
		this.atletaDAO = atletaDAO;
	}

	@Override
	public void setSportDAO(SportDAO sportDAO) {
		this.sportDAO = sportDAO;
	}

	@Override
	public List<Sport> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return sportDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Sport caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return sportDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Sport sportInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			sportDAO.update(sportInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Sport sportInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			sportDAO.insert(sportInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Long idSportToRemove) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			sportDAO.setEntityManager(entityManager);
			atletaDAO.setEntityManager(entityManager);

			Sport sportInstance = sportDAO.get(idSportToRemove);

			List<Atleta> atleti = sportDAO.listAllAtleti(idSportToRemove);

			for (Atleta atleta : atleti) {
				atleta.getSports().remove(sportInstance);
			}
			sportDAO.delete(sportInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiungiAtletaASport(Long idSport, Long idAtleta) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			sportDAO.setEntityManager(entityManager);
			atletaDAO.setEntityManager(entityManager);

			Sport sportInstance = sportDAO.get(idSport);
			Atleta atletaInstance = atletaDAO.get(idAtleta);

			atletaInstance.getSports().add(sportInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuoviAtletaDaSport(Long idSport, Long idAtleta) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();

			sportDAO.setEntityManager(entityManager);
			atletaDAO.setEntityManager(entityManager);

			Sport sportInstance = sportDAO.get(idSport);
			Atleta atletaInstance = atletaDAO.get(idAtleta);

			atletaInstance.getSports().remove(sportInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}
	@Override
	public List<Atleta> listAllAtleta(Long idSport) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			sportDAO.setEntityManager(entityManager);
			atletaDAO.setEntityManager(entityManager);

			Sport sportInstance = sportDAO.get(idSport);

            return sportDAO.listAllAtleti(sportInstance.getId());


		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Sport> listAllErrors() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			sportDAO.setEntityManager(entityManager);
			return sportDAO.listAllErrors();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public long countMedals() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			sportDAO.setEntityManager(entityManager);
			return sportDAO.countMedals();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
}
