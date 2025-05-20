package it.prova.pokeronline.service.implementation;

import it.prova.pokeronline.exception.*;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.StatoUtente;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.RuoloRepository;
import it.prova.pokeronline.repository.TavoloRepository;
import it.prova.pokeronline.repository.UtenteRepository;
import it.prova.pokeronline.service.abstraction.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private TavoloRepository tavoloRepository;

    @Autowired
    private RuoloRepository ruoloRepository;

    @Override
    public Utente inserisciUtente(Utente utente) {
        if(utente == null) {
            throw new UtenteNotNullException("L'utente non può essere nullo.");
        }
        //Assegno all'utente degli attributi iniziali che voglio che abbia appena si registra
        utente.setStato(StatoUtente.CREATO);
        utente.setEsperienzaAccumulata(0);
        Ruolo ruolo = ruoloRepository.findRuoloByCodice("PLAYER");
        utente.setRuolo(ruolo);
        utente.setDataRegistrazione(LocalDate.now());
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return utenteRepository.save(utente);
    }

    @Override
    public Utente aggiornaUtente(Utente utente) {
        if(utente == null) {
            throw new IllegalArgumentException("L'utente non può essere nullo.");
        }
        Utente utenteLoggato = recuperaUtenteLoggato();

        if(utenteLoggato.getRuolo().getCodice().equals("ADMIN") || utenteLoggato.getId().equals(utente.getId())) {
            return utenteRepository.save(utente);
        }else{
            throw new UtenteNonAutorizzatoException("Utente non autorizzato a modificare questo utente.");
        }
    }

    @Override
    public void disabilitaUtente(Long idUtente) {
        if(idUtente == null) {
            throw new IllegalArgumentException("ID utente non può essere nullo.");
        }
        Utente utente = recuperaUtenteLoggato();
        if(utente.getRuolo().getCodice().equals("ADMIN")) {
            Utente utenteDaDisabilitare = utenteRepository.findById(idUtente).orElseThrow(() ->
                    new UtenteNonTrovatoException("Nessun utente trovato con ID: " + idUtente));
            utenteDaDisabilitare.setStato(StatoUtente.DISABILITATO);
        }else{
            throw new UtenteNonAutorizzatoException("Non sei autorizzato a disabilitare questo utente.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Utente caricaSingoloUtente(Long idUtente) {
        if(idUtente == null) {
            throw new IllegalArgumentException("ID utente non può essere nullo.");
        }
        Utente utente = recuperaUtenteLoggato();
        if(utente.getRuolo().getCodice().equals("ADMIN") || utente.getId().equals(idUtente)) {
            return utenteRepository.findById(idUtente).orElseThrow(() ->
                    new UtenteNonTrovatoException("Nessun utente trovato con ID: " + idUtente));
        }
        throw new UtenteNonAutorizzatoException("Utente non autorizzato a cercare questo utente.");
    }

    @Transactional
    public void compraCredito(Integer credito) {
        if (credito == null || credito <= 0) {
            throw new IllegalArgumentException("Il credito deve essere un valore positivo.");
        }
        Utente utente = recuperaUtenteLoggato();

        utente.setCreditoAccumulato(credito + utente.getCreditoAccumulato());
        utenteRepository.save(utente);
    }

    @Override
    public Tavolo restituisciUltimoTavolo() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare il tavolo.");
        }

        Tavolo tavolo = utenteRepository.findLastGameByUtenteId(utente.getId()).get();

        if(tavolo == null) {
            throw new UtenteNonAutorizzatoException("Non appartieni a nessun tavolo.");
        }
        return tavolo;

    }

    @Override
    public void abbandonaPartita() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare il tavolo.");
        }
        if(utente.getTavolo() == null) {
            throw new UtenteNonAutorizzatoException("Non appartieni a nessun tavolo.");
        }
        utente.setTavolo(null);
        utenteRepository.save(utente);
    }

    @Override
    public List<Tavolo> trovaTavoloCompatibileConUtente() {
        Utente utente = recuperaUtenteLoggato();
        if(utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per visualizzare un tavolo compatibile.");
        }
        List<Tavolo> tavoli = utenteRepository.findTavoliCompatibilePerUtente(utente.getId());
        if(tavoli.isEmpty()){
            throw new TavoloNonTrovatoException("Nessun tavolo trovato compatibile con l'utente.");
        }
        return tavoli;
    }

    @Override
    public String giocaPartita(Long idTavolo) {
        Utente utente = recuperaUtenteLoggato();

        Tavolo tavolo = tavoloRepository.findById(idTavolo).orElseThrow(() ->
                new TavoloNonTrovatoException("Nessun tavolo trovato con ID: " + idTavolo));

        if (utente == null) {
            throw new UtenteNonAutorizzatoException("Effettua il login per giocare una partita.");
        }

        if (utente.getEsperienzaAccumulata() < tavolo.getEsperienzaMin()) {
            throw new EsperienzaInsufficienteException("Esperienza insufficiente per accedere al tavolo.");
        }

        if (utente.getCreditoAccumulato() < tavolo.getCifraMinima()) {
            throw new CreditoInsufficienteException("Credito insufficiente per giocare a questo tavolo.");
        }

        // Simulazione partita (50% di possibilità)
        boolean vinto = Math.random() < 0.5;
        String messaggio;

        if (vinto) {
            utente.setEsperienzaAccumulata(utente.getEsperienzaAccumulata() + 50);
            utente.setCreditoAccumulato(utente.getCreditoAccumulato() + 100);
            messaggio = "Hai vinto! +50 XP, +100 credito.";
        } else {
            utente.setCreditoAccumulato(utente.getCreditoAccumulato() - tavolo.getCifraMinima());
            messaggio = "Hai perso! -" + tavolo.getCifraMinima() + " credito.";
        }

        if(utente.getStato().equals(StatoUtente.CREATO)){
            utente.setStato(StatoUtente.ATTIVO);
        }
        utente.setTavolo(tavolo);

        utenteRepository.save(utente);
        return messaggio;
    }

    @Override
    public Utente findByUsername(String username) {
        if(username == null) {
            throw new IllegalArgumentException("Username utente non può essere nullo.");
        }
        return utenteRepository.findByUsername(username).orElseThrow(() -> new UtenteNonTrovatoException("Utente non esistente!"));
    }


    private Utente recuperaUtenteLoggato() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken) {
            throw new UtenteNonTrovatoException("Non sei autenticato");
        }

        String username = authentication.getName();
        return utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UtenteNonTrovatoException("Utente non esistente"));
    }

}
