package it.prova.model.hotel;

public class Turista extends Cliente{

    public Turista(String nome, String cognome, Stanza stanza) {
        super(nome, cognome, stanza);
        super.sconto = 1f;
    }

    @Override
    public float sommaDaPagare() {
        return sconto * getStanza().getQuantoAPersona();
    }
}
