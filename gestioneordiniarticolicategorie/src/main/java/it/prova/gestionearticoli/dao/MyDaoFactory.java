package it.prova.gestionearticoli.dao;

import it.prova.gestionearticoli.dao.articolo.ArticoloDAO;
import it.prova.gestionearticoli.dao.articolo.ArticoloDAOImpl;
import it.prova.gestionearticoli.dao.categoria.CategoriaDAO;
import it.prova.gestionearticoli.dao.categoria.CategoriaDAOImpl;
import it.prova.gestionearticoli.dao.ordine.OrdineDAO;
import it.prova.gestionearticoli.dao.ordine.OrdineDAOImpl;

public class MyDaoFactory {

	private static ArticoloDAO articoloDaoInstance = null;
	private static CategoriaDAO categoriaDaoInstance = null;
	private static OrdineDAO ordineDaoInstance = null;

	public static ArticoloDAO getArticoloDAOInstance() {
		if (articoloDaoInstance == null)
			articoloDaoInstance = new ArticoloDAOImpl();

		return articoloDaoInstance;
	}

	public static CategoriaDAO getCategoriaDAOInstance() {
		if (categoriaDaoInstance == null)
			categoriaDaoInstance = new CategoriaDAOImpl();

		return categoriaDaoInstance;
	}

	public static OrdineDAO getOrdineDAOInstance() {
		if (ordineDaoInstance == null)
			ordineDaoInstance = new OrdineDAOImpl();

		return ordineDaoInstance;
	}

}
