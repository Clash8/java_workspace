package it.prova.manytomanyphoneapp.service;

import java.util.List;

import it.prova.manytomanyphoneapp.dao.app.AppDAO;
import it.prova.manytomanyphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.manytomanyphoneapp.model.Smartphone;

public interface SmartphoneService {

	public List<Smartphone> listAll() throws Exception;

	public Smartphone caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Smartphone smartphoneInstance) throws Exception;

	public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;

	public void rimuovi(Long idSmartphone) throws Exception;

	public void scollegaERimuoviSmartphone(Long idSmartphone) throws Exception;

	void aggionaSmartphone(Long idSmartphone, String versioneOS) throws Exception;

	void installaAppSuSmartphone(Long idSmartphone, Long idApp) throws Exception;

	public void disinstallaAppDaSmartphone(Long idSmartphone, Long idApp) throws Exception;

	// per injection
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);
	public void setAppDAO(AppDAO appDAO);



}
