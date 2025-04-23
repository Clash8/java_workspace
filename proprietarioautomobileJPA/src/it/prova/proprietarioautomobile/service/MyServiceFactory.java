package it.prova.proprietarioautomobile.service;

import it.prova.proprietarioautomobile.dao.MyDaoFactory;
import it.prova.proprietarioautomobile.service.automobile.AutomobileService;
import it.prova.proprietarioautomobile.service.automobile.AutomobileServiceImpl;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioService;
import it.prova.proprietarioautomobile.service.proprietario.ProprietarioServiceImpl;

public class MyServiceFactory {

	// rendiamo le istanze restituite SINGLETON
	private static AutomobileService automobileServiceInstance = null;
	private static ProprietarioService proprietarioServiceInstance = null;

	public static AutomobileService getAutomobileServiceInstance() {
		if (automobileServiceInstance == null) {
			automobileServiceInstance = new AutomobileServiceImpl();
			automobileServiceInstance.setAutomobileDAO(MyDaoFactory.getAutomobileDAOInstance());
		}
		return automobileServiceInstance;
	}

	public static ProprietarioService getProprietarioServiceInstance() {
		if (proprietarioServiceInstance == null) {
			proprietarioServiceInstance = new ProprietarioServiceImpl();
			proprietarioServiceInstance.setProprietarioDAO(MyDaoFactory.getProprietarioDAOInstance());
		}
		return proprietarioServiceInstance;
	}

}
