package it.prova.gestionearticoli.dao.ordine;

import it.prova.gestionearticoli.dao.IBaseDAO;
import it.prova.gestionearticoli.model.Ordine;

import java.util.List;

public interface OrdineDAO extends IBaseDAO<Ordine> {

    Ordine findMostRecentOrderByCategoria(Long idCategoria) throws Exception;

    List<String> findAddressByArticoliSerial(String serialeArticolo) throws Exception;
}
