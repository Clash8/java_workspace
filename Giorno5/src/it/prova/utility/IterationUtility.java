package it.prova.utility;

public class IterationUtility {


    public static int[]  incrementaOgniElemento(int[] valori, int incremento) {
        int[] risultato = new int[valori.length];
        for (int i = 0; i < valori.length; i++)
            risultato[i] = ((valori[i] + incremento) % incremento == 0) ? valori[i] + incremento : 0;
        return risultato;
    }

    public static boolean verficaSeMultipliTraLoro(int[] valori, int[] multipli) {
        if (valori.length != multipli.length) return false;
        for (int i = 0; i < valori.length; i++)
            if (multipli[i] % valori[i] != 0)
                return false;
        return true;
    }
    public static int[] prodottoVettoriale (int[] input1, int[] input2) {
        if (input1.length != 3 || input2.length != 3)
            return new int[] {0, 0, 0};
        int[] risultato = new int[3];
        risultato[0] = input1[1] * input2[2] - input1[2] * input2[1];
        risultato[1] = input1[2] * input2[0] - input1[0] * input2[2];
        risultato[2] = input1[0] * input2[1] - input1[1] * input2[0];
        return risultato;
    }

    public static boolean calcolaSeTantiDispariQuantiPari(int[] input) {
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
