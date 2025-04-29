package it.prova.manytomanyphoneapp.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.manytomanyphoneapp.dao.EntityManagerUtil;
import it.prova.manytomanyphoneapp.dao.app.AppDAO;
import it.prova.manytomanyphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.manytomanyphoneapp.model.Smartphone;
import it.prova.manytomanyphoneapp.model.App;

public class SmartphoneServiceImpl implements SmartphoneService {

	private SmartphoneDAO smartphoneDAO;
	private AppDAO appDAO;

	@Override
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO) {
		this.smartphoneDAO = smartphoneDAO;
	}
	@Override
	public void setAppDAO(AppDAO appDAO) {
		this.appDAO = appDAO;
	}

	@Override
	public List<Smartphone> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return smartphoneDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Smartphone caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return smartphoneDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void aggiorna(Smartphone smartphoneInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			smartphoneDAO.update(smartphoneInstance);

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
	public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			smartphoneDAO.insert(smartphoneInstance);

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
	public void rimuovi(Long idSmartphone) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			smartphoneDAO.delete(smartphoneDAO.get(idSmartphone));

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	public void scollegaERimuoviSmartphone(Long idSmartphone) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			Smartphone smartphoneInstance = smartphoneDAO.get(idSmartphone);
			smartphoneDAO.unlinkAppsFromSmartphone(smartphoneInstance);
			smartphoneDAO.delete(smartphoneInstance);

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
	public void aggionaSmartphone(Long idSmartphone, String versioneOS) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			Smartphone smartphoneInstance = smartphoneDAO.get(idSmartphone);
			smartphoneInstance.setVersioneOS(versioneOS);
			smartphoneDAO.update(smartphoneInstance); // superfluo??

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
	public void installaAppSuSmartphone(Long idSmartphone, Long idApp) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			Smartphone smartphoneInstance = smartphoneDAO.get(idSmartphone);
			App appInstance = appDAO.get(idApp);
			smartphoneInstance.getApp().add(appInstance);
			smartphoneDAO.update(smartphoneInstance); // superfluo??

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
	public void disinstallaAppDaSmartphone(Long idSmartphone, Long idApp) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			smartphoneDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			Smartphone smartphoneInstance = smartphoneDAO.get(idSmartphone);
			App appInstance = appDAO.get(idApp);
			smartphoneInstance.getApp().remove(appInstance);
			smartphoneDAO.update(smartphoneInstance); // superfluo??

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}
}
