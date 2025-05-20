package it.prova.pokeronline.controller;

import it.prova.pokeronline.dto.securitydto.UtenteAuthDTO;
import it.prova.pokeronline.dto.securitydto.UtenteInfoJWTResponseDTO;
import it.prova.pokeronline.exception.AccessoNegatoException;
import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.security.JWTUtil;
import it.prova.pokeronline.service.abstraction.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UtenteService utenteService;

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authManager;

    public AuthController(JWTUtil jwtUtil, AuthenticationManager authManager) {
        this.jwtUtil = jwtUtil;
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody UtenteAuthDTO body) {
        try {

            //Qui recupero l'utente che sta provando a loggare dal db
            //poi recupero il suo stato e controllo attraverso isAttivo(metodo nel model)
            //se è attivo o meno, se è disabilitato non può fare l'accesso
            Utente utente = utenteService.findByUsername(body.getUsername());
            if (!utente.isAttivo()) {
                throw new AccessoNegatoException("Utente non attivo. Accesso negato.");
            }

            UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
                    body.getUsername(), body.getPassword());

            // Authenticating the Login Credentials
            authManager.authenticate(authInputToken);

            // Se siamo qui posso tranquillamente generare il JWT Token
            String token = jwtUtil.generateToken(body.getUsername());

            // Respond with the JWT
            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException authExc) {
            // Auhentication Failed
            throw new RuntimeException("Invalid Login Credentials");
        }
    }

}
