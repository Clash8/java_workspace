package it.prova.test;
import it.prova.model.*;

public class TestLavoratore {
    public static void main(String[] args) {

        Lavoratore totti = new Operaio("Enrico", "Brignano", 1500);
        System.out.println(totti.getNome() + " " + totti.getCognome() + ": " + totti.percepisco());

        Lavoratore fiorello = new Volontario("Rosario", "Fiorello", "Croce Rossa");
        System.out.println(fiorello.getNome() + " " + fiorello.getCognome() + ": " + fiorello.percepisco());

        Lavoratore boldi = new Lavoratore("Massimo", "Boldi");
        System.out.println(boldi.getNome() + " " + boldi.getCognome() + ": " + boldi.percepisco());
    }
}
