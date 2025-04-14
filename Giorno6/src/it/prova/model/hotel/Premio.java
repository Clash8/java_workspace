package it.prova.model.hotel;

public class Premio extends Cliente {

    public Premio(String nome, String cognome, Stanza stanza) {
        super(nome, cognome, stanza);
        super.sconto = 0.0f;
    }
    @Override
    public float sommaDaPagare() {
        return sconto * getStanza().getQuantoAPersona();
    }
}
