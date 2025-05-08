package it.prova.gestionesocieta.service;

import it.prova.gestionesocieta.model.Dipendente;

import java.util.List;

public interface DipendenteService {

    void add(Dipendente dipendente) throws Exception;

    void linkDipendenteToProgetti(Long dipendenteId, List<Long> idProgetti) throws Exception;

    Dipendente dipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();

}
