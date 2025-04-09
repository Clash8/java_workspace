package it.prova.utility;

public class ArrayUtility {

    public static int prodottoElementiPosizionePari(int[] arr) {
        int prodotto = 1;
        for (int i = 0; i < arr.length; i+= 2)
            prodotto *= arr[i];
        return prodotto;
    }

    public static String trovaParolaPiuLunga(String[] input) {
        String max = input[0];
        for (String s : input)
            if (s.length() > max.length())
                max = s;
        return max;
    }

    public static boolean trovaOccorrenza(String[] heyStack, String needle) {
        for (String s : heyStack)
            if (s.equals(needle))
                return true;
        return false;
    }

    public static boolean sumEqualsZero(int[] arr) {
        int sum = 0;
        for (int num : arr)
            sum += num;
        return sum == 0;
    }


    public static int controlloLunghezzaNomi(String[] input) {
        int contatore = 0;
        for (String s : input) {
            if (s.length()%2 != 0)
                contatore++;
        }
        return contatore;
    }

    public static String invertiStringa(String input) {
        String risultato = "";
        for (int i = input.length() - 1; i >= 0; i--)
            risultato += input.charAt(i);
        return risultato;
    }

    public static boolean tutteLunghezzeUguali(String[] input) {
        int lunghezza = input[0].length();
        for (String parola : input)
            if (parola.length() != lunghezza)
                return false;
        return true;
    }
    public static boolean tutteFinisconoCon(String[] parole, char carattere) {
        for (String parola : parole)
            if (parola.charAt(parola.length() - 1) != carattere)
                return false;
        return true;
    }
    public static int sommaLunghezza(String[] input) {
        int sum = 0;
        for (String parola : input)
            sum += parola.length();
        return sum;
    }
}
