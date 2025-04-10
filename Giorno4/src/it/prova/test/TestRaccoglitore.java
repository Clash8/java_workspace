package it.prova.test;
import it.prova.model.onetomany.*;

public class TestRaccoglitore {
    public static void main(String[] args) {

        Foglio foglio1 = new Foglio("Alta", "A4");
        Foglio foglio2 = new Foglio("Media", "A3");
        Foglio foglio3 = new Foglio("Bassa", "A5");


        Foglio[] fogli = {foglio1, foglio2, foglio3};

        Raccoglitore raccoglitore = new Raccoglitore("Blu", 5, fogli);

        System.out.println(raccoglitore);
    }
}
