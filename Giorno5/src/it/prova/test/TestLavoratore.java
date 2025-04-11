package it.prova.test;
import it.prova.model.*;

public class TestLavoratore {
    public static void main(String[] args) {
        Lavoratore l1 = new it.prova.model.Operaio("Mario", "Rossi", 1500);
        Lavoratore l2 = new it.prova.model.Volontario("Giovanni", "Verdi", "Associazione Volontari");

        System.out.println(l1.percepisco());
        System.out.println(l2.percepisco());
    }
}
