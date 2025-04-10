package it.prova.model;

public class Indirizzo {
    private String via;
    private String numeroCivico;
    private String citta;

    //complete the constructor
    public Indirizzo(String via, String numeroCivico, String citta) {
        this.via = via;
        this.numeroCivico = numeroCivico;
        this.citta = citta;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getNumeroCivico() {
        return numeroCivico;
    }
    public void setNumeroCivico(String numeroCivico) {
        this.numeroCivico = numeroCivico;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    @Override
    public String toString() {
        return "Indirizzo [via=" + via + ", numeroCivico=" + numeroCivico + ", citta=" + citta + "]";
    }

    public boolean equals(Indirizzo indirizzo) {
        return (this.via.equalsIgnoreCase(indirizzo.getVia()) &&
                this.numeroCivico.equalsIgnoreCase(indirizzo.getNumeroCivico()) &&
                this.citta.equalsIgnoreCase(indirizzo.getCitta()));
    }

}
