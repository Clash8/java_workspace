package it.prova.gestionetratte.service;

import it.prova.gestionetratte.model.Tratta;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TrattaService {

	List<Tratta> listAllElements();

	List<Tratta> listAllElementsEager();

	Tratta caricaSingoloElemento(Long id);

	Tratta caricaSingoloElementoEager(Long id);

	Tratta aggiorna(Tratta trattaInstance);

	Tratta inserisciNuovo(Tratta trattaInstance);

	void rimuovi(Long idToRemove);

	List<Tratta> findByExample(Tratta example);

	List<Tratta> findByCodiceEDescrizione(String term);

	Tratta findByCodiceEDescrizione(String codice, String descrizione);

	Page<Tratta> findByExampleNativeWithPagination(Tratta example, Integer pageNo, Integer pageSize, String sortBy);

	Page<Tratta> findByExampleWithPagination(Tratta example, Integer pageNo, Integer pageSize, String sortBy);


}
