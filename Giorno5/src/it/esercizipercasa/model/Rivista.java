package it.esercizipercasa.model;

public class Rivista extends MaterialeBiblioteca{
    private int numeroEdizione;
    private int annoPubblicazione;

    public Rivista(String titolo, String autore, String codiceIdentificativo, int numeroEdizione, int annoPubblicazione) {
        super(titolo, autore, codiceIdentificativo);
        this.numeroEdizione = numeroEdizione;
        this.annoPubblicazione = annoPubblicazione;
    }
    public Rivista() {}

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 14;
    }
}
