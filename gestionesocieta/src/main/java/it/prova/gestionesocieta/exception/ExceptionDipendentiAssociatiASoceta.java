package it.prova.gestionesocieta.exception;

public class ExceptionDipendentiAssociatiASoceta extends Exception{

    public ExceptionDipendentiAssociatiASoceta() {
        super("impossibile eliminare la società perchè ha dei dipendenti associati");
    }
}
