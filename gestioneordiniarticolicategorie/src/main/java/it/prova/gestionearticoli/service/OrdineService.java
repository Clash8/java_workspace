package it.prova.gestionearticoli.service;

import it.prova.gestionearticoli.dao.articolo.ArticoloDAO;
import it.prova.gestionearticoli.dao.ordine.OrdineDAO;
import it.prova.gestionearticoli.model.Ordine;

import java.util.List;

public interface OrdineService {

	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Long idOrdine) throws Exception;

	void rimuoviOrdineCollegato(Long idOrdine) throws Exception;


	Ordine trovaOrdineRecenteDaIdCategoria(Long idCategoria) throws Exception;

	List<String> trovaIndirizziDalSerialeArticolo(String serialeArticolo) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);
	public void setArticoloDAO(ArticoloDAO articoloDAO);



}
