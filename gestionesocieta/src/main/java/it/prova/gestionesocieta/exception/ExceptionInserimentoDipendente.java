package it.prova.gestionesocieta.exception;

public class ExceptionInserimentoDipendente extends Exception{

    public ExceptionInserimentoDipendente() {
        super("Il Dipendente non può essere inserito perchè la società non è presente");
    }
}
