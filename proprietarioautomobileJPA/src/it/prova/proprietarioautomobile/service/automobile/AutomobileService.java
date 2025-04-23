package it.prova.proprietarioautomobile.service.automobile;

import java.util.List;

import it.prova.proprietarioautomobile.dao.automobile.AutomobileDAO;
import it.prova.proprietarioautomobile.model.Automobile;

public interface AutomobileService {
	
	public List<Automobile> listAllAutomobili() throws Exception;

	public Automobile caricaSingoloAutomobile(Long id) throws Exception;

	public void aggiorna(Automobile automobileInstance) throws Exception;

	public void inserisciNuovo(Automobile automobileInstance) throws Exception;

	public void rimuovi(Long idAutomobileInstance) throws Exception;

	public void setAutomobileDAO(AutomobileDAO automobileDAO);


}
