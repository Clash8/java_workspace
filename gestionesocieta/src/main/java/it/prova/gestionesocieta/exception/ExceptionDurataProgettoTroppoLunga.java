package it.prova.gestionesocieta.exception;

public class ExceptionDurataProgettoTroppoLunga extends Exception{

    public ExceptionDurataProgettoTroppoLunga() {
        super("La durata del progetto non può superare la chiusura della società");
    }
}
