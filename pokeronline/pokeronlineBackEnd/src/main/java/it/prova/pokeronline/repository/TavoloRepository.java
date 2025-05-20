package it.prova.pokeronline.repository;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TavoloRepository extends JpaRepository<Tavolo, Long> {

    @Query("select t from Tavolo t join fetch t.utenteCreazione where t.utenteCreazione = ?1")
    List<Tavolo> findAllByUtenteCreazioneId(Long id);
}
