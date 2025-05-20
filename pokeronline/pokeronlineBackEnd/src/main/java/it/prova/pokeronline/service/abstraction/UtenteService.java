package it.prova.pokeronline.service.abstraction;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

import java.util.List;

public interface UtenteService {

    Utente inserisciUtente(Utente utente);

    Utente aggiornaUtente(Utente utente);

    void disabilitaUtente(Long idUtente);

    Utente caricaSingoloUtente(Long idUtente);

    void compraCredito(Integer credito);

    Tavolo restituisciUltimoTavolo();

    void abbandonaPartita();

    List<Tavolo> trovaTavoloCompatibileConUtente();

    String giocaPartita(Long idTavolo);

    Utente findByUsername(String username);


}
