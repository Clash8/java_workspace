package it.prova.gestionesocieta.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionesocieta.model.Dipendente;
//
//    void linkDipendenteToProgetti(Long dipendenteId, List<Long> idProgetti);
//
//    Dipendente dipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();

public interface DipendenteRepository extends CrudRepository<Dipendente, Long>,QueryByExampleExecutor <Dipendente> {

    @Query("""
            select distinct d
            from Dipendente d
            join d.progetti p
            join d.societa s
            where p.durataInMesi >= 6
            and s.dataFondazione < {d '1990-01-01'}

""")
    Dipendente findDipendentePiuAnzianoDelleSocietaFondatePrimaDel1990EProgettiAlmeno6Mesi();



}
