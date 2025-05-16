package it.prova.gestionetratte.repository.tratta;

import it.prova.gestionetratte.model.StatoTratta;
import it.prova.gestionetratte.model.Tratta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TrattaRepository extends CrudRepository<Tratta, Long>, JpaRepository<Tratta,Long>, PagingAndSortingRepository<Tratta, Long>, JpaSpecificationExecutor<Tratta>, CustomTrattaRepository {
	@Query("from Tratta t join fetch t.airbus where t.id = ?1")
	Tratta findSingleTrattaEager(Long id);

	List<Tratta> findByCodiceIgnoreCaseContainingOrDescrizioneIgnoreCaseContainingOrderByIdAsc(String codice, String descrizione);

	Tratta findByCodiceAndDescrizione(String codice, String descrizione);

	@Query("select t from Tratta t join fetch t.airbus")
	List<Tratta> findAllEager();

	@Query(value = "SELECT t.* " + "FROM tratta t " + "WHERE ((:codice IS NULL OR LOWER(t.codice) LIKE CONCAT('%', :codice, '%'))  "
			+ "AND (:descrizione IS NULL OR LOWER(t.descrizione) LIKE CONCAT('%', :descrizione, '%'))) "
			+ "AND (:data IS NULL OR t.data > :data) "
			+ "AND (:stato IS NULL OR t.stato = :stato) ", countQuery = "SELECT t.* "
			+ "FROM tratta t " + "WHERE ((:codice IS NULL OR LOWER(t.codice) LIKE CONCAT('%', :codice, '%'))  "
			+ "AND (:descrizione IS NULL OR LOWER(t.descrizione) LIKE CONCAT('%', :descrizione, '%'))) "
			+ "AND (:data IS NULL OR t.data > :data) "
			+ "AND (:stato IS NULL OR t.stato = :stato)", nativeQuery = true)
	Page<Tratta> findByExampleNativeWithPagination(
			@Param("codice") String codice,
			@Param("descrizione") String descrizione,
			@Param("data") LocalDate data,
			@Param("stato") StatoTratta stato,
			Pageable pageable);
}
