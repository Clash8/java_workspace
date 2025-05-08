package it.prova.gestionearticoli.dao.categoria;

import it.prova.gestionearticoli.dao.IBaseDAO;
import it.prova.gestionearticoli.model.Articolo;
import it.prova.gestionearticoli.model.Categoria;

import java.util.List;

public interface CategoriaDAO extends IBaseDAO<Categoria>{

    List<Articolo> listAllArticoli(Long idCategoria) throws Exception;
}
