package it.prova.utility;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListUtility {

    public static ArrayList<Integer> incrementaOgniElemento(ArrayList<Integer> valori, int incremento) {
        ArrayList<Integer> risultato = new ArrayList<>();
        for (int i = 0; i < valori.size(); i++) {
            int valore = valori.get(i);
            if ((valore + incremento) % incremento == 0) {
                risultato.add(valore + incremento);
            } else {
                risultato.add(0);
            }
        }
        return risultato;
    }

    public static boolean verficaSeMultipliTraLoro(ArrayList<Integer> valori, ArrayList<Integer> multipli) {
        if (valori.size() != multipli.size()) return false;
        for (int i = 0; i < valori.size(); i++)
            if (multipli.get(i) % valori.get(i) != 0)
                return false;
        return true;
    }
    public static ArrayList<Integer> prodottoVettoriale (ArrayList<Integer> input1, ArrayList<Integer> input2) {
        if (input1.size() != 3 || input2.size() != 3)
            return new ArrayList<Integer> (Arrays.asList(0,0,0));
        ArrayList<Integer> risultato = new ArrayList<>();
        risultato.add(input1.get(1) * input2.get(2) - input1.get(2) * input2.get(1));
        risultato.add(input1.get(2) * input2.get(0) - input1.get(0) * input2.get(2));
        risultato.add(input1.get(0) * input2.get(1) - input1.get(1) * input2.get(0));
        return risultato;
    }

    public static boolean calcolaSeTantiDispariQuantiPari(ArrayList<Integer> input) {
        int pari = 0;
        int dispari = 0;
        for (int i : input)
            if (i != 0)
                if (i % 2 == 0) pari++;
                else dispari++;
        return pari == dispari;
    }

    public static boolean verificaSeDifferenzaPosizioniPariConDispariRisultaPositivo(int [] input) {
        int posPari = 0;
        int posDispari = 0;
        for (int i = 0; i < input.length; i++)
            if (i % 2 == 0)
                posPari += input[i];
            else
                posDispari += input[i];
        return posPari - posDispari > 0;
    }
    public static int quantiSonoDivisibiliPer(int[] valori, int divisore) {
        int count = 0;
        for (int i : valori)
            if (i % divisore == 0)
                count++;
        return count;
    }

    public static int[] unioneDueArray(int[] array1, int[] array2) {
        int[] risultato = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++)
            risultato[i] = array1[i];
        for (int i = 0; i < array2.length; i++)
            risultato[array1.length + i] = array2[i];
        return risultato;
    }
    public static String creaStringaAlContrarioConIndice(String input, int tipoIndice) {
        String result = "";
        for (int i = input.length() - 1; i >= 0; i--)
            if (i % 2 == tipoIndice % 2)
                result += input.charAt(i);
        return result;
    }
}
