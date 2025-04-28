package it.manytomanyjpamaven.service;

import it.manytomanyjpamaven.dao.AtletaDAO;
import it.manytomanyjpamaven.dao.SportDAO;
import it.manytomanyjpamaven.model.Atleta;
import it.manytomanyjpamaven.model.Sport;

import java.util.List;

public interface SportService {
	public List<Sport> listAll() throws Exception;

	public Sport caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Sport sportInstance) throws Exception;

	public void inserisciNuovo(Sport sportInstance) throws Exception;

	public void rimuovi(Long idSportToRemove) throws Exception;

	public void aggiungiAtletaASport(Long idSport, Long idAtleta) throws Exception;

	public void rimuoviAtletaDaSport(Long idSport, Long idAtleta) throws Exception;

	public List<Atleta> listAllAtleta(Long idSport) throws Exception;

	public List<Sport> listAllErrors() throws Exception;

	public long countMedals() throws Exception;

	// per injection
	public void setSportDAO(SportDAO sportDAO);
	public void setAtletaDAO(AtletaDAO atletaDAO);
}
