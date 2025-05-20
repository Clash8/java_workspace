package it.prova.pokeronline.service.implementation;

import it.prova.pokeronline.exception.TavoloNonTrovatoException;
import it.prova.pokeronline.exception.TavoloNonVuotoException;
import it.prova.pokeronline.exception.UtenteNonAutorizzatoException;
import it.prova.pokeronline.exception.UtenteNonTrovatoException;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.TavoloRepository;
import it.prova.pokeronline.repository.UtenteRepository;
import it.prova.pokeronline.service.abstraction.TavoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TavoloServiceImpl implements TavoloService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private TavoloRepository tavoloRepository;

    @Override
    @Transactional
    public Tavolo creaTavolo(Tavolo tavolo) {

        //Questa prima parte, che si occupa di effettuare i controlli,
        // per evitare duplicazione inutile di codice all'interno dei vari metodi,
        //  è stato implementato in un metodo privato alla fine del service


//        Authentication userLoggato = SecurityContextHolder.getContext().getAuthentication();
//        String username = userLoggato.getName();
//
//        Utente utente = utenteRepository.findByUsername(username).orElse(null);
//
//        if (utente != null && !(utente.getRuolo().getCodice().equals("ADMIN") || utente.getRuolo().getCodice().equals("SPECIAL_PLAYER"))) {
//            throw new UtenteNonAutorizzatoException("Non hai i permessi per creare un tavolo");
//        }

        Utente utente = getUtenteAutenticatoConRuoloAdminOSpecialPlayer();
        tavolo.setUtenteCreazione(utente);
        return tavoloRepository.save(tavolo);
    }

    @Override
    @Transactional
    public Tavolo aggiornaTavolo(Tavolo tavolo) {
        boolean tavoloModificabile = checkIfTavoloModificabileOEliminabile(tavolo.getId());
        if (!tavoloModificabile) {
            throw new TavoloNonVuotoException("Il tavolo non può essere modificato perchè ha giocatori al suo interno!");
        }
        return tavoloRepository.save(tavolo);
    }

    @Override
    @Transactional
    public void disabilitaTavolo(Long idTavolo) {

        boolean tavoloEliminabile = checkIfTavoloModificabileOEliminabile(idTavolo);

        if (!tavoloEliminabile) {
            throw new TavoloNonVuotoException("Il tavolo non può essere cancellato perchè ha giocatori al suo interno!");
        }

        tavoloRepository.deleteById(idTavolo);
    }

    @Override
    @Transactional(readOnly = true)
    public Tavolo cercaPerId(Long idTavolo) {
        Utente utente = getUtenteAutenticatoConRuoloAdminOSpecialPlayer();

        Tavolo tavolo = tavoloRepository.findById(idTavolo).orElse(null);

        if (tavolo == null) {
            throw new TavoloNonTrovatoException("Tavolo non trovato");
        }
        return tavolo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tavolo> listAll() {
        Utente utente = getUtenteAutenticatoConRuoloAdminOSpecialPlayer();

        if(utente.getRuolo().getCodice().equals("ADMIN")){
            return tavoloRepository.findAll();
        }else if(utente.getRuolo().getCodice().equals("SPECIAL_PLAYER")){
            return tavoloRepository.findAllByUtenteCreazioneId(utente.getId());
        }
        throw new UtenteNonAutorizzatoException("Non hai i permessi per visualizzare i tavoli");
    }

    private Utente getUtenteAutenticatoConRuoloAdminOSpecialPlayer() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Utente utente = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UtenteNonTrovatoException("Utente non trovato"));

        String ruolo = utente.getRuolo().getCodice();

        if (!ruolo.equals("ADMIN") && !ruolo.equals("SPECIAL_PLAYER")) {
            throw new UtenteNonAutorizzatoException("Non hai i permessi per questa operazione");
        }

        return utente;
    }

    private boolean checkIfTavoloModificabileOEliminabile(Long idTavolo){

        boolean checkTavolo = false;
        //Controllo che l'utente sia un ADMIN o SPECIAL_PLAYER
        Utente utente = getUtenteAutenticatoConRuoloAdminOSpecialPlayer();

        Tavolo tavolo = tavoloRepository.findById(idTavolo).orElseThrow(() ->
                new TavoloNonTrovatoException("Tavolo non trovato"));


        //Controllo a parte per vedere se il tavolo è stato creato dall'utente che sta provando
        //a disabilitarlo, rispetto al controllo di prima, qui è necessario fare un ulteriore controllo
        //poichè non voglio che un qualsiasi SPECIAL_PLAYER possa disabilitare un tavolo non suo
        if(!(utente.getId().equals(tavolo.getUtenteCreazione().getId()))){
            throw new UtenteNonAutorizzatoException("Non sei il creatore di questo tavolo");
        }

        //Controllo che il tavolo non abbia giocatori al suo interno
        //La query viene eseguita da utente, perchè è il tavolo a essere mappato lato utente con una colonna
        if(utenteRepository.countAllGiocatoriByTavoloId(idTavolo) > 0){
            throw new TavoloNonVuotoException("Il tavolo non può essere cancellato perchè ha giocatori al suo interno!");
        }
        return checkTavolo = true;
    }
}
