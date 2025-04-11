package it.prova.model;

public class Lavoratore {
    protected String nome;
    protected String cognome;

    public Lavoratore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String percepisco() {
        return "N.D.";
    }
}
