package it.prova.gestionearticoli.dao.articolo;

import it.prova.gestionearticoli.dao.IBaseDAO;
import it.prova.gestionearticoli.model.Articolo;

import java.util.List;

public interface ArticoloDAO extends IBaseDAO<Articolo> {


    List<Articolo> listAllByOrdine(Long idOrdine) throws Exception;

    float calcolaPrezzoTotaleCategoria(Long idCategoria) throws Exception;

    List<Articolo> getArticoliWithErrors() throws Exception;
}
