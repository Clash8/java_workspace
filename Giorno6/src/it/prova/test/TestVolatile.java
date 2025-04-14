package it.prova.test;

import it.prova.model.*;

public class TestVolatile {
    public static void main(String[] args) {
        Volatile v;

        v = new Aquila("Alpina");
        System.out.println(v.fly());
        System.out.println(v.stampaProprieta());

        v = new Gallina("Liscio");
        System.out.println(v.fly());
        System.out.println(v.stampaProprieta());


        v = new Pinguino("Antartide");
        System.out.println(v.fly());
        System.out.println(v.stampaProprieta());

        Volatile v2 = new Pinguino("Antartide");
        System.out.println(v.ugualeA(new Pinguino("Antartide")));



    }
}
