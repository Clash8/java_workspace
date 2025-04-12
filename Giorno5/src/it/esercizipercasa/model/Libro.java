package it.esercizipercasa.model;

public class Libro extends MaterialeBiblioteca{
    private int numeroPagine;
    private String genere;

    public Libro(String titolo, String autore, String codiceIdentificativo, int numeroPagine, String genere) {
        super(titolo, autore, codiceIdentificativo);
        this.numeroPagine = numeroPagine;
        this.genere = genere;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
    public String getGenere() {
        return genere;
    }
    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 30;
    }

}
