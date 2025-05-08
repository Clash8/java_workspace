package it.prova.gestionesocieta.repository;

import it.prova.gestionesocieta.model.Progetto;
import it.prova.gestionesocieta.model.Societa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface ProgettoRepository extends CrudRepository<Progetto, Long>, QueryByExampleExecutor<Progetto> {

    @Query("""
            select distinct p
            from Progetto p
            join p.dipendenti d
            join d.societa s
            where  s.dataChiusura is not null
            and  s.dataChiusura < CURRENT_DATE
           """)
    List<Progetto> findProgettiAnomali();

    @Query("""
           select distinct p
           from Progetto p
           join p.dipendenti d
           where d.redditoAnnuoLordo >= 30000
           """)
    List<Progetto> findProgettiInCuiLavoraAlmenoUnDipendenteConUnaRALAPartireDa30000();
}
