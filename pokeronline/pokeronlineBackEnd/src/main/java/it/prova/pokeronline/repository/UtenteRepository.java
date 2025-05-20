package it.prova.pokeronline.repository;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    @Query("select u.tavolo from Utente u where u.id = ?1 and u.tavolo is not null")
    Optional<Tavolo> findLastGameByUtenteId(Long idUtente);

    @Query("SELECT t FROM Tavolo t WHERE t.esperienzaMin <= (SELECT u.esperienzaAccumulata FROM Utente u WHERE u.id = ?1)")
    List<Tavolo> findTavoliCompatibilePerUtente(Long idUtente);

    @Query("select u from Utente u where u.username = ?1")
    Optional<Utente> findByUsername(String username);

    @Query("select count (u) from Utente u where u.tavolo = ?1")
    Long countAllGiocatoriByTavoloId(Long id);



}
