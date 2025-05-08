package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Progetto;

import java.util.List;

public interface ProgettoService {

    void add(Progetto p);

    void linkProgettoToDipendenti(Long ProgettoId, List<Long> idDipendenti) throws Exception;

    List<Progetto> listaProgettiInCuiLavoraAlmenoUnDipendenteConUnaRALAPartireDa30000();

    List<Progetto> listaProgettiAnomali();
}
