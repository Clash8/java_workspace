package it.manytomanyjpamaven.service;

import it.manytomanyjpamaven.dao.AtletaDAO;
import it.manytomanyjpamaven.dao.SportDAO;
import it.manytomanyjpamaven.model.Atleta;
import it.manytomanyjpamaven.model.Sport;

import java.util.List;

public interface AtletaService {
	public List<Atleta> listAll() throws Exception;

	public Atleta caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Atleta atletaInstance) throws Exception;

	public void inserisciNuovo(Atleta atletaInstance) throws Exception;

	public void rimuovi(Long idAtletaToRemove) throws Exception;

	// per injection
	public void setAtletaDAO(AtletaDAO atletaDAO);
	public void setSportDAO(SportDAO sportDAO);
}
