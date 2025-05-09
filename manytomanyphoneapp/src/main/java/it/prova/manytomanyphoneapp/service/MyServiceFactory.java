package it.prova.manytomanyphoneapp.service;

import it.prova.manytomanyphoneapp.dao.MyDaoFactory;

public class MyServiceFactory {

	private static SmartphoneService smartphoneServiceInstance = null;
	private static AppService appServiceInstance = null;

	public static SmartphoneService getSmartphoneServiceInstance() {
		if (smartphoneServiceInstance == null)
			smartphoneServiceInstance = new SmartphoneServiceImpl();

		smartphoneServiceInstance.setSmartphoneDAO(MyDaoFactory.getSmartphoneDAOInstance());
		smartphoneServiceInstance.setAppDAO(MyDaoFactory.getAppDAOInstance());

		return smartphoneServiceInstance;
	}

	public static AppService getAppServiceInstance() {
		if (appServiceInstance == null)
			appServiceInstance = new AppServiceImpl();

		appServiceInstance.setAppDAO(MyDaoFactory.getAppDAOInstance());

		return appServiceInstance;
	}

}
