package it.prova.model;

public interface Volante {
    void decolla();
    void vola();
    void atterra();
    String details();
    boolean sonoSimili(Volante altroVolante);
}