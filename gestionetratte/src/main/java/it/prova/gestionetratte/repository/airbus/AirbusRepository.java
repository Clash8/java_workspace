package it.prova.gestionetratte.repository.airbus;

import it.prova.gestionetratte.model.Airbus;
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

public interface AirbusRepository extends CrudRepository<Airbus, Long>, JpaRepository<Airbus,Long>, PagingAndSortingRepository<Airbus, Long>, JpaSpecificationExecutor<Airbus>, CustomAirbusRepository {
	@Query("from Airbus a join fetch a.tratte where a.id = ?1")
	Airbus findSingleAirbusEager(Long id);

	List<Airbus> findByCodiceIgnoreCaseContainingOrDescrizioneIgnoreCaseContainingOrderByIdAsc(String codice, String descrizione);

	Airbus findByCodiceAndDescrizione(String codice, String descrizione);

	@Query("select a from Airbus a join fetch a.tratte")
	List<Airbus> findAllEager();

	@Query(value = "SELECT a.* " + "FROM airbus a " + "WHERE ((:codice IS NULL OR LOWER(a.codice) LIKE CONCAT('%', :codice, '%')) "
			+ "AND (:descrizione IS NULL OR LOWER(a.descrizione) LIKE CONCAT('%', :descrizione, '%'))) "
			+ "AND (:datainizioservizio IS NULL OR a.datainizioservizio > :datainizioservizio) "
			+ "AND (:numeropasseggeri IS NULL OR a.numeropasseggeri = :numeropasseggeri) ", countQuery = "SELECT a.* "
			+ "FROM airbus a " + "WHERE ((:codice IS NULL OR LOWER(a.codice) LIKE CONCAT('%', :codice, '%')) "
			+ "AND (:descrizione IS NULL OR LOWER(a.descrizione) LIKE CONCAT('%', :descrizione, '%'))) "
			+ "AND (:datainizioservizio IS NULL OR a.datainizioservizio > :datainizioservizio) "
			+ "AND (:numeropasseggeri IS NULL OR a.numeropasseggeri = :numeropasseggeri)", nativeQuery = true)
	Page<Airbus> findByExampleNativeWithPagination(
			@Param("codice") String codice,
			@Param("descrizione") String descrizione,
			@Param("datainizioservizio") LocalDate datainizioservizio,
			@Param("numeropasseggeri") Integer numeropasseggeri,
			Pageable pageable);
}
