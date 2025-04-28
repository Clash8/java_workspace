package it.prova.manytomanyphoneapp.service;

import java.time.LocalDate;
import java.util.List;

import it.prova.manytomanyphoneapp.dao.app.AppDAO;
import it.prova.manytomanyphoneapp.model.Smartphone;
import it.prova.manytomanyphoneapp.model.App;

public interface AppService {

	public List<App> listAll() throws Exception;

	public App caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(App appInstance) throws Exception;

	public void inserisciNuovo(App appInstance) throws Exception;

	public void rimuovi(Long idApp) throws Exception;

	// per injection
	public void setAppDAO(AppDAO appDAO);

}
