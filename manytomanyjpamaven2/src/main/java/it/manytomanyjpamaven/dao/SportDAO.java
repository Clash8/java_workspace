package it.manytomanyjpamaven.dao;

import it.manytomanyjpamaven.model.Atleta;
import it.manytomanyjpamaven.model.Sport;

import java.util.List;

public interface SportDAO extends IBaseDAO<Sport> {

    List<Atleta> listAllAtleti(Long idSport) throws Exception;

    List<Sport> listAllErrors() throws Exception;

    long countMedals() throws Exception;
}
