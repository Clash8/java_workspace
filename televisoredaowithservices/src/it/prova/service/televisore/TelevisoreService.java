package it.prova.service.televisore;

import java.time.LocalDate;
import java.util.List;

import it.prova.dao.televisore.TelevisoreDAO;
import it.prova.model.Televisore;

public interface TelevisoreService {

	// questo mi serve per injection
	void setTelevisoreDao(TelevisoreDAO televisoreDao);

	List<Televisore> listAll() throws Exception;

	Televisore findById(Long idInput) throws Exception;

	int aggiorna(Televisore input) throws Exception;

	int inserisciNuovo(Televisore input) throws Exception;

	int rimuovi(Long idDaRimuovere) throws Exception;

	List<Televisore> findByExample(Televisore input) throws Exception;

	Televisore getBigger() throws Exception;

	int quantiTelTraDate(LocalDate from, LocalDate to) throws Exception;

	List<String> list30anni() throws Exception;

	//##########################################################################################
}
