package it.prova.pizzastorespringmvc.repository.film;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.pizzastorespringmvc.model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmRepository extends CrudRepository<Film, Long>, PagingAndSortingRepository<Film, Long>, JpaSpecificationExecutor<Film>, CustomFilmRepository {
	@Query("from Film f join fetch f.regista where f.id = ?1")
	Film findSingleFilmEager(Long id);
}
