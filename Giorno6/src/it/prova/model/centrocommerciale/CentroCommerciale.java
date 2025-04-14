package it.prova.model.centrocommerciale;

import java.util.List;

public class CentroCommerciale {
    private String ragioneSociale;
    private String indirizzo;
    private List<Negozio> negozi;

    public CentroCommerciale(String ragioneSociale, String indirizzo, List<Negozio> negozi) {
        this.ragioneSociale = ragioneSociale;
        this.indirizzo = indirizzo;
        this.negozi = negozi;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public List<Negozio> getNegozi() {
        return negozi;
    }
    public void setNegozi(List<Negozio> negozi) {
        this.negozi = negozi;
    }

}
