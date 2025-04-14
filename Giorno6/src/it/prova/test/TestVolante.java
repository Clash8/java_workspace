package it.prova.test;

import it.prova.model.*;

public class TestVolante {
    public static void main(String[] args) {
        Aereo v1 = new Aereo("Alitalia");
        Aquilone v2 = new Aquilone("blu");
        Volante v3 = new Aereo("Alitalia");
        Volante v4 = new Aquilone("rosso");

        System.out.println(v1.details() + " e' simile a " + v2.details() + "\n\t\t\t" + v1.sonoSimili(v2));
        System.out.println(v3.details() + " e' simile a " + v1.details() + "\n\t\t\t" + v3.sonoSimili(v1));



    }
}
