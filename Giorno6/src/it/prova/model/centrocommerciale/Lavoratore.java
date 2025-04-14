package it.prova.model.centrocommerciale;

public abstract class Lavoratore {
    protected String nome;
    protected String cognome;
    protected Negozio negozio;

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
    public Negozio getNegozio() {
        return negozio;
    }
    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }

    public abstract boolean handleItemAdd(Item item);
    public abstract boolean handleItemRemove(Item item);
}
