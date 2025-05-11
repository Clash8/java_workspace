package it.prova.pizzastorespringmvc.repository.film;

import it.prova.pizzastorespringmvc.model.Film;

import java.util.List;

public interface CustomFilmRepository {
	List<Film> findByExample(Film example);
}
