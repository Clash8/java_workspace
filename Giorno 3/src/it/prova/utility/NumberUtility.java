package it.prova.utility;

public class NumberUtility {


    //Metodo 1: progettare un metodo che verifica se un array di interi è disposto in ordine decrescente
    public static boolean eDecrescente(int[] valori) {
        for (int i = 1; i < valori.length; i++)
            if (valori[i] >= valori[i - 1])
                return false;
        return true;
    }

    //Metodo 2:

    public static int[] creaProgressioneNumerica(int quanti, int moltiplicando) {
        int[] valori = new int[quanti];
        int currentValue = 1;
        for (int i = 0; i < quanti; i++) {
            valori[i] = currentValue * moltiplicando;
            currentValue = valori[i];
        }
        return valori;
    }
}
