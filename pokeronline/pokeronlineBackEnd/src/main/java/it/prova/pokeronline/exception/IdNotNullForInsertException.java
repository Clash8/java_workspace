package it.prova.pokeronline.exception;

public class IdNotNullForInsertException extends RuntimeException {
    public IdNotNullForInsertException(String message) {
        super(message);
    }
}
