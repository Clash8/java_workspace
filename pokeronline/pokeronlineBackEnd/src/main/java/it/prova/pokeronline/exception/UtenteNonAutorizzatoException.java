package it.prova.pokeronline.exception;

import org.springframework.security.access.AccessDeniedException;

public class UtenteNonAutorizzatoException extends AccessDeniedException {
    public UtenteNonAutorizzatoException(String message) {
        super(message);
    }
}
