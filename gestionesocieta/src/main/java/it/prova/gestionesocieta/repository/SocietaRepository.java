package it.prova.gestionesocieta.repository;

import java.util.List;
import java.util.Optional;

import it.prova.gestionesocieta.model.Societa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface SocietaRepository extends CrudRepository<Societa, Long>, QueryByExampleExecutor<Societa> {

    @Query("""
           select distinct p.cliente
           from Progetto p
           join p.dipendenti d
           where d.societa.id = :societaId
           """)
    List<String> findDistinctClientiBySocietaId(@Param("societaId") Long societaId);
    //SocietaConProgettiConDurataMaggioreDiUnAnno
    @Query("""
            select distinct s.ragioneSociale
            from Societa s
            join s.dipendenti d
            join d.progetti p
            where p.durataInMesi > 12
            """)
    List<String> findRagioniSocialiConProgettiOltreUnAnno();

    @Query("""
            select distinct s
            from Societa s
            join s.dipendenti d
            where d.dataAssunzione < s.dataFondazione
""")
    List<Societa> findSocietaAnomale();

    Optional<Societa> findFirstByRagioneSociale(String ragioneSociale);
}
