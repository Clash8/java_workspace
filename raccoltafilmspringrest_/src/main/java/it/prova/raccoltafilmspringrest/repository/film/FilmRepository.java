package it.prova.raccoltafilmspringrest.repository.film;

import java.time.LocalDate;
import java.util.List;

import it.prova.raccoltafilmspringrest.model.Regista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.raccoltafilmspringrest.model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface FilmRepository extends CrudRepository<Film, Long>, JpaRepository<Film,Long>, PagingAndSortingRepository<Film, Long>, JpaSpecificationExecutor<Film>, CustomFilmRepository {
	@Query("from Film f join fetch f.regista where f.id = ?1")
	Film findSingleFilmEager(Long id);
	
	List<Film> findByTitoloAndGenere(String titolo, String genere);
	
	@Query("select f from Film f join fetch f.regista")
	List<Film> findAllFilmEager();

	@Query(value = "SELECT f.* " + "FROM film f " + "WHERE ((:titolo IS NULL OR LOWER(f.titolo) LIKE CONCAT('%', :titolo, '%'))  "
			+ "AND (:genere IS NULL OR LOWER(f.genere) LIKE CONCAT('%', :genere, '%'))) "
			+ "AND (:datapubblicazione IS NULL OR f.datapubblicazione > :datapubblicazione) "
			+ "AND (:minutiDurata IS NULL OR f.minutiDurata = :minutiDurata) ", countQuery = "SELECT f.* "
			+ "FROM film f " + "WHERE ((:titolo IS NULL OR LOWER(f.titolo) LIKE CONCAT('%', :titolo, '%'))  "
			+ "AND (:genere IS NULL OR LOWER(f.genere) LIKE CONCAT('%', :genere, '%'))) "
			+ "AND (:datapubblicazione IS NULL OR f.datapubblicazione > :datapubblicazione) "
			+ "AND (:minutidurata IS NULL OR f.minutidurata = :minutidurata)", nativeQuery = true)
	Page<Film> findByExampleNativeWithPagination(
			@Param("titolo") String titolo,
			@Param("genere") String genere,
			@Param("datapubblicazione") LocalDate datapubblicazione,
			@Param("minutiDurata") Integer minutidurata,
			Pageable pageable);
}
