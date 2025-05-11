package it.prova.pizzastorespringmvc.repository.regista;

import java.util.List;

import it.prova.pizzastorespringmvc.model.Regista;

public interface CustomRegistaRepository {
	List<Regista> findByExample(Regista example);
}
