package it.prova.gestionearticoli.service;

import it.prova.gestionearticoli.dao.MyDaoFactory;

public class MyServiceFactory {

	private static ArticoloService articoloServiceInstance = null;
	private static CategoriaService categoriaServiceInstance = null;
	private static OrdineService ordineServiceInstance = null;

	public static ArticoloService getArticoloServiceInstance() {
		if (articoloServiceInstance == null)
			articoloServiceInstance = new ArticoloServiceImpl();

		articoloServiceInstance.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());
		articoloServiceInstance.setCategoriaDAO(MyDaoFactory.getCategoriaDAOInstance());

		return articoloServiceInstance;
	}

	public static CategoriaService getCategoriaServiceInstance() {
		if (categoriaServiceInstance == null)
			categoriaServiceInstance = new CategoriaServiceImpl();

		categoriaServiceInstance.setCategoriaDAO(MyDaoFactory.getCategoriaDAOInstance());
		categoriaServiceInstance.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());

		return categoriaServiceInstance;
	}

	public static OrdineService getOrdineServiceInstance() {
		if (ordineServiceInstance == null)
			ordineServiceInstance = new OrdineServiceImpl();

		ordineServiceInstance.setOrdineDAO(MyDaoFactory.getOrdineDAOInstance());
		ordineServiceInstance.setArticoloDAO(MyDaoFactory.getArticoloDAOInstance());

		return ordineServiceInstance;
	}

}
