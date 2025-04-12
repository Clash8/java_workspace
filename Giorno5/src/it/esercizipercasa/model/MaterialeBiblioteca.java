package it.esercizipercasa.model;

public class MaterialeBiblioteca {
    //Attributi: titolo, autore, codiceIdentificativo, disponibile
    protected String titolo;
    protected String autore;
    protected String codiceIdentificativo;
    protected boolean disponibile;


    public MaterialeBiblioteca() {}
    public MaterialeBiblioteca(String titolo, String autore, String codiceIdentificativo) {
        this.titolo = titolo;
        this.autore = autore;
        this.codiceIdentificativo = codiceIdentificativo;
        this.disponibile = true; // Inizialmente disponibile
    }
    //Metodi
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }
    public boolean isDisponibile() {
        return disponibile;
    }
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }


    public void prestito() {
        disponibile = false;
    }
    public void restituzione() {
        disponibile = true;
    }
    public int calcolaTempoPrestitoMassimo() {
        return 14;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + titolo + " di " + autore + "\n";
    }
}
