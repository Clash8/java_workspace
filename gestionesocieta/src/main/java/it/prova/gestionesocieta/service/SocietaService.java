package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Societa;

import java.util.List;

public interface SocietaService {

    List<Societa> listAll();

    void add(Societa s) throws Exception;

    List<Societa> findByExample(Societa example);

    void rem(Long id) throws Exception;

    List<String> listaClientiDataSocieta(Long idSocieta);

    List<String> listaNomiSocietaConProgettiConDurataMaggioreDiUnAnno();

    List<Societa> listaSocietaAnomale();
}
