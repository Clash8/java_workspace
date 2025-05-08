package it.prova.gestionearticoli.service;

import java.util.List;

import it.prova.gestionearticoli.dao.categoria.CategoriaDAO;
import it.prova.gestionearticoli.dao.articolo.ArticoloDAO;
import it.prova.gestionearticoli.model.Articolo;

public interface ArticoloService {

	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Long idArticolo) throws Exception;

	public void aggiungiCategoriaAdArticolo(Long idArticolo, Long idCategoria) throws Exception;

	public void rimuoviArticoloCollegato(Long idArticolo) throws Exception;

	float calcolaPrezzoTotaleCategoria(Long idCategoria) throws Exception;

	List<Articolo> ottieniArticoliConErrori() throws Exception;

	// per injection
	public void setArticoloDAO(ArticoloDAO articoloDAO);
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);



}
