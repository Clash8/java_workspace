package it.prova.model;

public class Biglietto {
    private String nomeSpettacolo;
    private char letteraFila;
    private int numeroPosto;
    private float prezzo;

    public Biglietto() {}
    public Biglietto(String nomeSpettacolo, char letteraFila, int numeroPosto, float prezzo) {
        this.nomeSpettacolo = nomeSpettacolo;
        this.letteraFila = letteraFila;
        this.numeroPosto = numeroPosto;
        this.prezzo = prezzo;
    }

    public String getNomeSpettacolo() {
        return nomeSpettacolo;
    }

    public void setNomeSpettacolo(String nomeSpettacolo) {
        this.nomeSpettacolo = nomeSpettacolo;
    }
    public char getLetteraFila() {
        return letteraFila;
    }
    public void setLetteraFila(char letteraFila) {
        this.letteraFila = letteraFila;
    }
    public int getNumeroPosto() {
        return numeroPosto;
    }
    public void setNumeroPosto(int numeroPosto) {
        this.numeroPosto = numeroPosto;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Biglietto [nomeSpettacolo=" + nomeSpettacolo + ", letteraFila=" + letteraFila + ", numeroPosto="
                + numeroPosto + ", prezzo=" + prezzo + "]";
    }

    public static Biglietto trovaIlPiuEconomico(Biglietto[] elencoBiglietti) {
        Biglietto piuEconomico = elencoBiglietti[0];
        for (Biglietto b : elencoBiglietti)
            if (b.getPrezzo() < piuEconomico.getPrezzo())
                piuEconomico = b;
        return piuEconomico;
    }

    public boolean bigliettoAncoraInvenduto(Biglietto[] elencoBigliettiInvenduti) {
        for (Biglietto b : elencoBigliettiInvenduti)
            if (
                b.getNomeSpettacolo().equalsIgnoreCase(this.nomeSpettacolo) &&
                b.getLetteraFila() == this.letteraFila &&
                b.getNumeroPosto() == this.numeroPosto
            )
                return false;
        return true;
    }

    public static boolean sonoTuttiBigliettiPerLoSpettacoloIntitolato(Biglietto[] elencoBiglietti, String titoloSpettacoloDaRicercare) {
        for (Biglietto b : elencoBiglietti)
            if (!b.getNomeSpettacolo().equalsIgnoreCase(titoloSpettacoloDaRicercare))
                return false;
        return true;
    }


}
