package it.prova.test;
import it.prova.utility.NumberUtility;

public class TestNumberUtility {
    public static void main(String[] args) {
        int[] numeri = new int[100];
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = i-20;
        }


        System.out.printf("TEST sonoTuttiPari.................................................Start%n");
        boolean risultato = NumberUtility.sonoTuttiPari(numeri);
        System.out.printf("%s tutti pari%n", risultato ? "Sono" : "Non sono");   // Atteso: true
        System.out.printf("TEST sonoTuttiPari.................................................End%n%n");


        System.out.printf("TEST esisteNegativoPari............................................Start%n");
        boolean esisteNegativo = NumberUtility.esisteNegativoPari(numeri);
        System.out.printf("Nell'array %sesiste almeno un negativo pari%n", esisteNegativo ? "" : "non ");
        System.out.printf("TEST esisteNegativoPari............................................End%n%n");


        System.out.printf("TEST sumReverse........................................................Start%n");
        int[] numeri2 = {3,6,9,4,5,9};
        int risultato2 = NumberUtility.sumReverse(numeri2);
        System.out.printf("La somma degli elementi in posizione dispari (da destra) è: %d%n", risultato2);
        System.out.printf("TEST sumReverse........................................................End%n%n");
    }
}
