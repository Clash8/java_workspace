package it.prova.utility;

public class Exercise1 {

    // Metodo 1: conta quanti elementi sono strettamente minori della soglia
    public static int dimmiQuantiElementiStrettamenteMinoriDi(int[] elementi, int soglia) {
        int count = 0;
        for (int val : elementi)
            if (val < soglia)
                count++;
        return count;
    }

    // Metodo 2: verifica che tutti i valori siano nell'intervallo [sogliaMin, sogliaMax]
    public static boolean sonoTuttiDentroUnIntervallo(int[] valori, int sogliaMin, int sogliaMax) {
        for (int val : valori)
            if (val < sogliaMin || val > sogliaMax)
                return false;
        return true;
    }

    // Metodo 3: verifica se i primi n elementi sono tutti uguali
    public static boolean nomiUgualiNellePrimeNPosizioni(String[] elenco, int nPosizioni) {
        String primo = elenco[0];
        for (int i = 1; i < nPosizioni; i++)
            if (!primo.equals(elenco[i]))
                return false;
        return true;
    }

    // Metodo 4: verifica se il nome è presente una sola volta nell'elenco
    public static boolean ePresenteSoloUnaVolta(String[] elenco, String nome) {
        int count = 0;
        for (String s : elenco)
            if (nome.equals(s))
                if (count > 0)
                    return false;
                else
                    count++;
        return count == 1;
    }


    // Metodo: Progettare un metodo che mi dica dica se la somma degli elementi in posizioni dispari risulti un numero dispari
    public static boolean sommaPosDisparieDispari(int[] valori) {
        int sum = 0;
        for (int i = 1; i < valori.length; i += 2) sum += valori[i];
        return sum%2 != 0;
    }

    // Metodo: Progettare un metodo che confronta se due array di interi hanno lo stesso contenuto nelle medesime posizioni
    public static boolean arrayUguali(int[] valori, int[] valori2) {
        for (int i = 0; i < valori.length; i++)
            if (valori[i] != valori2[i])
                return false;
        return valori.length == valori2.length;
    }

}
