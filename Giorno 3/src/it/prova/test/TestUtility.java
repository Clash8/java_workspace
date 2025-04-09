package it.prova.test;

import it.prova.utility.NumberUtility;

public class TestUtility {
    public static void main(String[] args) {


        int[] valori = {11,9,8,7,6,5,3,2};

        System.out.printf("TEST eDecrescente.........................Start%n");
        boolean eDecrescente = NumberUtility.eDecrescente(valori);
        System.out.printf("l'array è decrescente? %b%n", eDecrescente);
        System.out.printf("TEST eDecrescente.........................End%n%n");


        System.out.printf("TEST creaProgressioneNumerica.............................Start%n");
        int quanti = 4;
        int moltiplicando = 3;
        int[] progressione = NumberUtility.creaProgressioneNumerica(quanti, moltiplicando);
        System.out.printf("Progressione numerica (quanti=%d, moltiplicando=%d):%n", quanti, moltiplicando);
        for (int valore : progressione) {
            System.out.printf("%d ", valore);
        }
        System.out.println();
        System.out.printf("TEST creaProgressioneNumerica.............................End%n%n");

    }
}
