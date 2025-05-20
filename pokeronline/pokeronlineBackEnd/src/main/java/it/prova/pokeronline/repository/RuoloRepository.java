package it.prova.pokeronline.repository;

import it.prova.pokeronline.model.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {

    @Query(value = "Select r from Ruolo r where r.codice = ?1")
    Ruolo findRuoloByCodice(String codice);
}
