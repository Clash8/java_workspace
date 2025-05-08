package it.prova.gestionearticoli.service;

import it.prova.gestionearticoli.dao.EntityManagerUtil;
import it.prova.gestionearticoli.dao.articolo.ArticoloDAO;
import it.prova.gestionearticoli.dao.ordine.OrdineDAO;
import it.prova.gestionearticoli.model.Articolo;
import it.prova.gestionearticoli.model.Ordine;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;
	private ArticoloDAO articoloDAO;

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
	}

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

	@Override
	public List<Ordine> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.update(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.insert(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void rimuovi(Long idOrdine) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.delete(ordineDAO.get(idOrdine));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public void rimuoviOrdineCollegato(Long idOrdine) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);
			articoloDAO.setEntityManager(entityManager);


			List<Articolo> articoliAssociati = articoloDAO.listAllByOrdine(idOrdine);

			if (articoliAssociati != null && articoliAssociati.size() > 0) {
				throw new RuntimeException("Non puoi eliminare un ordine con articoli");
			} else {
				ordineDAO.delete(ordineDAO.get(idOrdine));
			}

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public Ordine trovaOrdineRecenteDaIdCategoria(Long idCategoria) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.findMostRecentOrderByCategoria(idCategoria);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public List<String> trovaIndirizziDalSerialeArticolo(String serialeArticolo) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.findAddressByArticoliSerial(serialeArticolo);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}

	}

}
