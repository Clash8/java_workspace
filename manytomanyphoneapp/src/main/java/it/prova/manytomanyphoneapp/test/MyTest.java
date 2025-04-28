package it.prova.manytomanyphoneapp.test;

import it.prova.manytomanyphoneapp.dao.EntityManagerUtil;
import it.prova.manytomanyphoneapp.model.App;
import it.prova.manytomanyphoneapp.model.Smartphone;
import it.prova.manytomanyphoneapp.service.SmartphoneService;
import it.prova.manytomanyphoneapp.service.AppService;
import it.prova.manytomanyphoneapp.service.MyServiceFactory;

import java.util.Date;

public class MyTest {

	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);

		SmartphoneService smartphoneServiceInstance = MyServiceFactory.getSmartphoneServiceInstance();
		AppService appServiceInstance = MyServiceFactory.getAppServiceInstance();

		try {

			System.out.println("In tabella smartphone ci sono " + smartphoneServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella app ci sono " + appServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"**************************** inizio batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");


			testInserimentoNuovoSmartphone(smartphoneServiceInstance);
			testAggionamentoSmartphone(smartphoneServiceInstance);
			testInserimentoNuovaApp(appServiceInstance);
			testAggionamentoApp(appServiceInstance);
			testInstallazioneAppSuSmartphone(smartphoneServiceInstance, appServiceInstance);
			testDisinstallazioneAppDaSmartphone(smartphoneServiceInstance, appServiceInstance);
			testRimozioneSmartphone(smartphoneServiceInstance);


			System.out.println(
					"****************************** fine batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");


			System.out.println("In tabella smartphone ci sono " + smartphoneServiceInstance.listAll().size() + " elementi.");
			System.out.println("In tabella app ci sono " + appServiceInstance.listAll().size() + " elementi.");


		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}
	}


	private static void testInserimentoNuovoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoSmartphone inizio.............");

		Smartphone smartphoneInstance = new Smartphone("marca1", "modello1", 100.0, "versioneOS1");
		smartphoneServiceInstance.inserisciNuovo(smartphoneInstance);
		if (smartphoneInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoSmartphone fallito ");

		System.out.println(".......testInserimentoNuovoSmartphone fine: PASSED.............");
	}

	private static void testAggionamentoSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testAggionamentoSmartphone inizio.............");

		Smartphone smartphoneInstance = smartphoneServiceInstance.caricaSingoloElemento(1L);
		smartphoneInstance.setVersioneOS("versioneOS2");
		smartphoneServiceInstance.aggiorna(smartphoneInstance);
		if (!smartphoneInstance.getVersioneOS().equals("versioneOS2"))
			throw new RuntimeException("testAggionamentoSmartphone fallito ");

		System.out.println(".......testAggionamentoSmartphone fine: PASSED.............");
	}

	private static void testInserimentoNuovaApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovaApp inizio.............");

		App appInstance = new App("nomeApp1", java.time.LocalDate.now(), java.time.LocalDate.now(), "versione1");
		appServiceInstance.inserisciNuovo(appInstance);
		if (appInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovaApp fallito ");

		System.out.println(".......testInserimentoNuovaApp fine: PASSED.............");
	}

	//Aggiornamento versione APP con relativa data
	private static void testAggionamentoApp(AppService appServiceInstance) throws Exception {
		System.out.println(".......testAggionamentoApp inizio.............");

		App appInstance = appServiceInstance.caricaSingoloElemento(1L);
		appInstance.setVersione("versione2");
		appServiceInstance.aggiorna(appInstance);
		if (!appInstance.getVersione().equals("versione2"))
			throw new RuntimeException("testAggionamentoApp fallito ");

		System.out.println(".......testAggionamentoApp fine: PASSED.............");
	}

	private static void testInstallazioneAppSuSmartphone(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance) throws Exception {
		System.out.println(".......testInstallazioneAppSuSmartphone inizio.............");

		Smartphone smartphoneInstance = smartphoneServiceInstance.caricaSingoloElemento(1L);
		App appInstance = appServiceInstance.caricaSingoloElemento(1L);
		smartphoneInstance.getApp().add(appInstance);
		smartphoneServiceInstance.aggiorna(smartphoneInstance);
		if (!smartphoneInstance.getApp().contains(appInstance))
			throw new RuntimeException("testInstallazioneAppSuSmartphone fallito ");

		System.out.println(".......testInstallazioneAppSuSmartphone fine: PASSED.............");
	}
	private static void testDisinstallazioneAppDaSmartphone(SmartphoneService smartphoneServiceInstance, AppService appServiceInstance) throws Exception {
		System.out.println(".......testDisinstallazioneAppDaSmartphone inizio.............");

		Smartphone smartphoneInstance = smartphoneServiceInstance.caricaSingoloElemento(1L);
		App appInstance = appServiceInstance.caricaSingoloElemento(1L);
		smartphoneInstance.getApp().remove(appInstance);
		smartphoneServiceInstance.aggiorna(smartphoneInstance);
		if (smartphoneInstance.getApp().contains(appInstance))
			throw new RuntimeException("testDisinstallazioneAppDaSmartphone fallito ");

		System.out.println(".......testDisinstallazioneAppDaSmartphone fine: PASSED.............");
	}

	private static void testRimozioneSmartphone(SmartphoneService smartphoneServiceInstance) throws Exception {
		System.out.println(".......testRimozioneSmartphone inizio.............");

		Smartphone smartphoneInstance = smartphoneServiceInstance.caricaSingoloElemento(1L);
		smartphoneServiceInstance.rimuovi(smartphoneInstance.getId());
		if (smartphoneServiceInstance.caricaSingoloElemento(smartphoneInstance.getId()) != null)
			throw new RuntimeException("testRimozioneSmartphone fallito ");

		System.out.println(".......testRimozioneSmartphone fine: PASSED.............");
	}

}
