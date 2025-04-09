package it.prova.test;
import it.prova.utility.Exercise1;


public class TestExercise1 {
    public static void main(String[] args) {
        // Metodo 1
        int[] numeri = {3, 7, 1, 9, 2, 6};
        int soglia = 5;

        System.out.printf("TEST dimmiQuantiElementiStrettamenteMinoriDi................Start%n");
        int countMinori = Exercise1.dimmiQuantiElementiStrettamenteMinoriDi(numeri, soglia);
        System.out.printf("Ci sono %d numeri strettamente minori di %d%n", countMinori, soglia);
        System.out.printf("TEST dimmiQuantiElementiStrettamenteMinoriDi................End%n%n");

        // Metodo 2
        int[] valori = {10, 15, 12, 14, 13};
        int sogliaMin = 10;
        int sogliaMax = 15;

        System.out.printf("TEST sonoTuttiDentroUnIntervallo............................Start%n");
        boolean tuttiDentro = Exercise1.sonoTuttiDentroUnIntervallo(valori, sogliaMin, sogliaMax);
        System.out.printf("Tutti i valori sono dentro l'intervallo [%d, %d]? %b%n", sogliaMin, sogliaMax, tuttiDentro);
        System.out.printf("TEST sonoTuttiDentroUnIntervallo............................End%n%n");

        // Metodo 3
        String[] nomi = {"Mario", "mArio", "mario", "luigi", "mario"};
        int nPosizioni = 3;

        System.out.printf("TEST nomiUgualiNellePrimeNPosizioni.........................Start%n");
        boolean ugualiPrime = Exercise1.nomiUgualiNellePrimeNPosizioni(nomi, nPosizioni);
        System.out.printf("I primi %d nomi sono uguali? %b%n", nPosizioni, ugualiPrime);
        System.out.printf("TEST nomiUgualiNellePrimeNPosizioni.........................End%n%n");

        // Metodo 4
        String[] elenco = {"Anna", "luigi", "Mario", "anna", "giorgio"};
        String nomeDaCercare = "mario";

        System.out.printf("TEST ePresenteSoloUnaVolta.................................Start%n");
        boolean presenteUnaVolta = Exercise1.ePresenteSoloUnaVolta(elenco, nomeDaCercare);
        System.out.printf("Il nome \"%s\" è presente una sola volta? %b%n", nomeDaCercare, presenteUnaVolta);
        System.out.printf("TEST ePresenteSoloUnaVolta.................................End%n%n");

        System.out.printf("TEST sommaPosParieDispari.................................Start%n");
        int[] valori2 = {4, 7, 2, 9, 6, 1};
        boolean risultato = Exercise1.sommaPosDisparieDispari(valori2);
        System.out.printf("La somma delle posizioni dispari è dispari? %b%n", risultato);
        System.out.printf("TEST sommaPosParieDispari.................................End%n%n");

        System.out.printf("TEST arrayUguali..........................................Start%n");
        int[] valori3 = {1, 2, 3, 4};
        int[] valori4 = {1, 2, 3, 4};
        boolean sonoUguali = Exercise1.arrayUguali(valori3, valori4);
        System.out.printf("I due array sono uguali? %b%n", sonoUguali);
        System.out.printf("TEST arrayUguali..........................................End%n%n");

    }
}
