package it.prova.test;

import java.util.ArrayList;
import java.util.List;

public class TestListe {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        lista.add("Aquilone");
        lista.add("Gabbiano");
        lista.add("Aliante");
        lista.add("Peruviano");
        lista.add("Senzatetto");
        lista.add("Senzatetto");

        System.out.println(lista);

        lista.remove("Senzatetto");

        System.out.println(lista);

    }
}
