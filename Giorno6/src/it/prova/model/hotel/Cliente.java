package it.prova.model.hotel;

public abstract class Cliente {
    protected String nome;
    protected String cognome;
    protected Stanza stanza;
    protected Float sconto;


    public Cliente(String nome, String cognome, Stanza stanza) {
        this.nome = nome;
        this.cognome = cognome;
        this.stanza = stanza;
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

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    public Float getSconto() {
        return sconto;
    }

    public abstract float sommaDaPagare();
}
