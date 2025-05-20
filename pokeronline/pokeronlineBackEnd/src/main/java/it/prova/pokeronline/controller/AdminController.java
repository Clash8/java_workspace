package it.prova.pokeronline.controller;

import it.prova.pokeronline.dto.UtenteDTO;
import it.prova.pokeronline.dto.securitydto.UtenteInfoJWTResponseDTO;
import it.prova.pokeronline.exception.UtenteNonAutorizzatoException;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.service.abstraction.UtenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UtenteService utenteService;

    public AdminController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/testSoloAdmin")
    public String test() {
        return "OK";
    }

    @GetMapping(value = "/userInfo")
    public ResponseEntity<UtenteInfoJWTResponseDTO> getUserInfo() {

        // se sono qui significa che sono autenticato quindi devo estrarre le info dal
        // contesto
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // estraggo le info dal principal
        Utente utenteLoggato = utenteService.findByUsername(username);

        // uso direttamente il ruolo già presente
        Ruolo ruolo = utenteLoggato.getRuolo();

        return ResponseEntity.ok(new UtenteInfoJWTResponseDTO(
                utenteLoggato.getNome(),
                utenteLoggato.getCognome(),
                utenteLoggato.getUsername(),
                ruolo
        ));
    }

    //Sarebbe la delete di un utente
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void disabilitaUtente(@PathVariable Long id) {
        utenteService.disabilitaUtente(id);
    }

    @PutMapping("/{id}")
    public UtenteDTO update(@Valid @RequestBody UtenteDTO utenteInput, @PathVariable(required = true) Long id) {
        Utente utente = utenteService.caricaSingoloUtente(id);

        if (utente == null)
            throw new UtenteNonAutorizzatoException("Utente non trovato con id: " + id);

        utenteInput.setId(id);
        Utente utenteAggiornato = utenteService.aggiornaUtente(utenteInput.buildUtenteModel());
        return UtenteDTO.buildUtenteDTOFromModel(utenteAggiornato);
    }
    @GetMapping("/{id}")
    public UtenteDTO findById(@PathVariable(value = "id", required = true) long id) {
        Utente utente = utenteService.caricaSingoloUtente(id);

        if (utente == null)
            throw new UtenteNonAutorizzatoException("Utente non trovato con id: " + id);

        return UtenteDTO.buildUtenteDTOFromModel(utente);
    }
}
