package it.prova.gestionearticoli.service;

import java.util.List;

import it.prova.gestionearticoli.dao.articolo.ArticoloDAO;
import it.prova.gestionearticoli.dao.categoria.CategoriaDAO;
import it.prova.gestionearticoli.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Long idCategoria) throws Exception;

	public void rimuoviCategoriaCollegata(Long idCategoria) throws Exception;

	// per injection
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
