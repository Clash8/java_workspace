package it.prova.manytomanyphoneapp.dao;

import it.prova.manytomanyphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.manytomanyphoneapp.dao.smartphone.SmartphoneDAOImpl;
import it.prova.manytomanyphoneapp.dao.app.AppDAO;
import it.prova.manytomanyphoneapp.dao.app.AppDAOImpl;

public class MyDaoFactory {

	private static SmartphoneDAO smartphoneDaoInstance = null;
	private static AppDAO appDaoInstance = null;

	public static SmartphoneDAO getSmartphoneDAOInstance() {
		if (smartphoneDaoInstance == null)
			smartphoneDaoInstance = new SmartphoneDAOImpl();

		return smartphoneDaoInstance;
	}

	public static AppDAO getAppDAOInstance() {
		if (appDaoInstance == null)
			appDaoInstance = new AppDAOImpl();

		return appDaoInstance;
	}

}
