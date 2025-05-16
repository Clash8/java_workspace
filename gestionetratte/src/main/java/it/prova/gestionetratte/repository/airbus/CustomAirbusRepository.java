package it.prova.gestionetratte.repository.airbus;

import it.prova.gestionetratte.model.Airbus;

import java.util.List;

public interface CustomAirbusRepository {
	List<Airbus> findByExample(Airbus example);
}
