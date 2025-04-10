package it.prova.model;

public class Sim {
    private String gestore;
    private int numero;
    private String IMEI;

    public Sim(String gestore, int numero, String IMEI) {
        this.gestore = gestore;
        this.numero = numero;
        this.IMEI = IMEI;
    }
    public String getGestore() {
        return gestore;
    }
    public int getNumero() {
        return numero;
    }
    public String getIMEI() {
        return IMEI;
    }

    public void setGestore(String gestore) {
        this.gestore = gestore;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    @Override
    public String toString() {
        return "Sim [gestore=" + gestore + ", numero=" + numero + ", IMEI=" + IMEI + "]";
    }

    public static int quanteSimConGestore(Sim [] elencoSim, String gestoreInput) {
        int count = 0;
        for (Sim s : elencoSim)
            if (s.getGestore().equalsIgnoreCase(gestoreInput))
                count++;
        return count;
    }

    public int quanteSimStessoGestore(Sim [] elencoSim) {
        return quanteSimConGestore(elencoSim, this.gestore);
    }

    public static int contaSimConNumeroDispari(Sim[] sims){
        int count = 0;
        for (Sim s : sims)
            if (s.getNumero() % 2 != 0)
                count++;
        return count;
    }

    public static void cambiaGestore(Sim[] sims, String vecchioGestore, String nuovoGestore) {
        for (Sim s : sims)
            if (s.getGestore().equalsIgnoreCase(vecchioGestore))
                s.setGestore(nuovoGestore);
    }

}
