package it.prova.gestionetratte.service;

import it.prova.gestionetratte.model.Airbus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AirbusService {

	List<Airbus> listAllElements();

	List<Airbus> listAllElementsEager();

	Airbus caricaSingoloElemento(Long id);

	Airbus caricaSingoloElementoEager(Long id);

	Airbus aggiorna(Airbus airbusInstance);

	Airbus inserisciNuovo(Airbus airbusInstance);

	void rimuovi(Long idToRemove);

	List<Airbus> findByExample(Airbus example);

	Page<Airbus> findByExampleWithPagination(Airbus example, Integer pageNo, Integer pageSize, String sortBy);

	Page<Airbus> findByExampleNativeWithPagination(Airbus example, Integer pageNo, Integer pageSize, String sortBy);

	List<Airbus> findByCodiceEDescrizione(String term);

	Airbus findByCodiceEDescrizione(String codice, String descrizione);

}
