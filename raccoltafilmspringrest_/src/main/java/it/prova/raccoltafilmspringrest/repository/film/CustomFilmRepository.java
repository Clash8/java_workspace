package it.prova.raccoltafilmspringrest.repository.film;

import it.prova.raccoltafilmspringrest.model.Film;

import java.util.List;

public interface CustomFilmRepository {
	List<Film> findByExample(Film example);
}
