package it.prova.gestionetratte.repository.tratta;

import it.prova.gestionetratte.model.Tratta;

import java.util.List;

public interface CustomTrattaRepository {
	List<Tratta> findByExample(Tratta example);
}
