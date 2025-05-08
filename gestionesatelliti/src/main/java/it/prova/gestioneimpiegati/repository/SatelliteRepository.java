package it.prova.gestioneimpiegati.repository;

import it.prova.gestioneimpiegati.model.Satellite;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface SatelliteRepository extends CrudRepository<Satellite, Long>,JpaSpecificationExecutor<Satellite> {


    @Query("SELECT s FROM Satellite s WHERE s.dataLancio <= :twoYearsAgo AND s.stato <> 'DISATTIVATO'")
    List<Satellite> findLanciatiDaPiuDiDueAnni(@Param("twoYearsAgo") LocalDate twoYearsAgo);

    @Query("SELECT s FROM Satellite s WHERE s.stato = 'DISATTIVATO' AND s.dataRientro IS NULL")
    List<Satellite> findDisattivatiMaNonRientrati();

    @Query("SELECT s FROM Satellite s WHERE s.stato = 'FISSO' AND s.dataLancio <= :tenYearsAgo")
    List<Satellite> findFissiOraInOrbita10Anni(@Param("tenYearsAgo") LocalDate tenYearsAgo);
}
