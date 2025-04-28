package it.prova.manytomanyphoneapp.service;

import java.util.List;

import it.prova.manytomanyphoneapp.dao.smartphone.SmartphoneDAO;
import it.prova.manytomanyphoneapp.model.Smartphone;
import it.prova.manytomanyphoneapp.model.App;

public interface SmartphoneService {

	public List<Smartphone> listAll() throws Exception;

	public Smartphone caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Smartphone smartphoneInstance) throws Exception;

	public void inserisciNuovo(Smartphone smartphoneInstance) throws Exception;

	public void rimuovi(Long idSmartphone) throws Exception;

	public void scollegaERimuoviSmartphone(Long idSmartphone) throws Exception;
	// per injection
	public void setSmartphoneDAO(SmartphoneDAO smartphoneDAO);

}
