package it.prova.test;
import it.prova.utility.*;

public class TestArrayUtility {
    public static void main(String[] args) {
        String[] input = {"ciao", "ciao1", "ciao12", "ciao123"};
        int[] numeri = {3,3,5,4,3};


        System.out.printf("TEST controlloLunghezzaNomi............................Start%n");
        int quantiNomi = ArrayUtility.controlloLunghezzaNomi(input);
        System.out.printf("Ci sono %d nomi con lunghezza dispari%n", quantiNomi);
        System.out.printf("TEST controlloLunghezzaNomi............................End%n%n");


        System.out.printf("TEST prodottoElementiPosizionePari......................Start%n");
        int prodottoElementiPosizionePari = ArrayUtility.prodottoElementiPosizionePari(numeri);
        System.out.printf("Il prodotto degli elementi in posizione pari è: %d%n", prodottoElementiPosizionePari);
        System.out.printf("TEST prodottoElementiPosizionePari......................End%n%n");


        System.out.printf("TEST trovaParolaPiuLunga................................Start%n");
        String parolaPiuLunga = ArrayUtility.trovaParolaPiuLunga(input);
        System.out.printf("La parola più lunga è: %s%n", parolaPiuLunga);
        System.out.printf("TEST trovaParolaPiuLunga................................End%n%n");


        System.out.printf("TEST trovaOccorrenza....................................Start%n");
        boolean trovato = ArrayUtility.trovaOccorrenza(input, "ciao1");
        System.out.printf("La parola 'ciao1' %sè presente nell'array%n", trovato ? "" : "non ");
        System.out.printf("TEST trovaOccorrenza....................................End%n%n");


        System.out.printf("TEST sumEqualsZero......................................Start%n");
        boolean sommaUgualeAZero = ArrayUtility.sumEqualsZero(numeri);
        System.out.printf("La somma degli elementi dell'array %s uguale a zero%n", sommaUgualeAZero ? "è" : "non è");
        System.out.printf("TEST sumEqualsZero......................................End%n%n");


        System.out.printf("TEST invertiStringa......................................Start%n");
        String stringaInvertita = ArrayUtility.invertiStringa("Ciao come va?");
        System.out.printf("l'inverso della stringa \"Ciao come va?\" è  %s%n", stringaInvertita);
        System.out.printf("TEST invertiStringa......................................End%n%n");


        System.out.printf("TEST tutteLunghezzeUguali......................................Start%n");
        boolean tutteLunghezzeUguali = ArrayUtility.tutteLunghezzeUguali(input);
        System.out.printf("L'array di stringhe in input %scontiene tutte lunghezze uguali%n", tutteLunghezzeUguali ? "" : "non ");
        System.out.printf("TEST tutteLunghezzeUguali......................................End%n%n");


        System.out.printf("TEST tutteFinisconoCon............................................Start%n");
        String[] parole = {"ciao", "bravo", "piano"};
        char carattere = 'o';
        boolean tutteFinisconoCon = ArrayUtility.tutteFinisconoCon(parole, carattere);
        System.out.printf("L'array di stringhe in input %sfinisce tutto con il carattere '%c'%n", tutteFinisconoCon ? "" : "non ", carattere);
        System.out.printf("TEST tutteFinisconoCon............................................End%n%n");


        System.out.printf("TEST sommaLunghezza................................................Start%n");
        int somma = ArrayUtility.sommaLunghezza(parole);
        System.out.printf("L'array di stringhe contiene %d caratteri in totale%n", somma);
        System.out.printf("TEST sommaLunghezza................................................End%n%n");


    }
}
