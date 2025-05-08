package it.prova.gestionesocieta.exception;

public class ExceptionRagioneSocialeGiaPresente extends Exception{

    public ExceptionRagioneSocialeGiaPresente() {
        super("La ragione sociale è già presente");
    }
}
