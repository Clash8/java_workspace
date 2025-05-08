package it.prova.gestionesocieta.exception;

public class ExceptionDataAssunzioneSuperioreAllaDataFondazione extends Exception{

    public ExceptionDataAssunzioneSuperioreAllaDataFondazione() {
        super("Il Dipendente non può essere inserito perchè la data di assunzione è superiore alla data di fondazione della società");
    }
}
