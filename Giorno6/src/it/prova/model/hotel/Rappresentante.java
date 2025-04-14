package it.prova.model.hotel;

public class Rappresentante extends Cliente {

    public Rappresentante(String nome, String cognome, Stanza stanza) {
        super(nome, cognome, stanza);
        super.sconto = 0.8f;
    }

    public float sommaDaPagare() {
        return sconto * getStanza().getQuantoAPersona();
    }
}
