package it.prova.utility;

public class NumberUtility {

    public static boolean sonoTuttiPari(int[] numeri){
        for (int numero : numeri)
            if (numero % 2 != 0)
                return false;
        return true;
    }

    public static boolean esisteNegativoPari(int[] numeri) {
        for (int numero : numeri)
            if (numero < 0 && numero % 2 == 0)
                return true;
        return false;
    }

    public static int sumReverse(int[] numeri) {
        int sum = 0;
        for (int i = numeri.length - 1; i >= 0; i--)
            if (i % 2 != 0)
                sum += numeri[i];
        return sum;
    }
    public static boolean trovaOccorrenza(int[] numeri, int needle) {
        for (int numero : numeri)
            if (numero == needle)
                return true;
        return false;
    }
}
