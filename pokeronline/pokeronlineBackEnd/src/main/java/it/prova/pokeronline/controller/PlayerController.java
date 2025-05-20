package it.prova.pokeronline.controller;

import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.exception.IdNotNullForInsertException;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.abstraction.RuoloService;
import it.prova.pokeronline.service.abstraction.UtenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private RuoloService ruoloService;

    public PlayerController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UtenteDTO createPlayer(@Valid @RequestBody UtenteDTO utenteInput) {
        if (utenteInput.getId() != null)
            throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");


        Utente utenteInserito = utenteService.inserisciUtente(utenteInput.buildUtenteModelInsert());
        return UtenteDTO.buildUtenteDTOFromModelInsert(utenteInserito);
    }
    @GetMapping("/{id}")
    public UtenteDTO findById(@PathVariable(value = "id", required = true) long id) {
        Utente utente = utenteService.caricaSingoloUtente(id);

        if (utente == null)
            throw new IdNotNullForInsertException("Utente non trovato con id: " + id);

        return UtenteDTO.buildUtenteDTOFromModel(utente);
    }

    @PutMapping("/compraCredito")
    public ResponseEntity<String> compraCredito(@RequestParam Integer credito) {
        utenteService.compraCredito(credito);
        return ResponseEntity.ok("Credito aggiunto con successo!");
    }

    @GetMapping("/ultimoTavolo")
    public TavoloDTO restituisciUltimoTavolo() {
        Tavolo tavolo = utenteService.restituisciUltimoTavolo();
        return TavoloDTO.buildTavoloDTOFromModel(tavolo);
    }

    @PutMapping("/abbandona")
    public ResponseEntity<String> abbandonaPartita() {
        utenteService.abbandonaPartita();
        return ResponseEntity.ok("Hai abbandonato la partita con successo.");
    }

    @GetMapping("/tavoliCompatibili")
    public List<TavoloDTO> trovaTavoliCompatibili() {
        return utenteService.trovaTavoloCompatibileConUtente()
                .stream()
                .map(TavoloDTO::buildTavoloDTOFromModel)
                .collect(Collectors.toList());
    }

    @PostMapping("/gioca/{idTavolo}")
    public ResponseEntity<String> giocaPartita(@PathVariable Long idTavolo) {
        String esito = utenteService.giocaPartita(idTavolo);
        return ResponseEntity.ok(esito);
    }

}
