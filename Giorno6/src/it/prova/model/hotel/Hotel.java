package it.prova.model.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String ragioneSociale;
    private int stelle;
    private List<Stanza> stanze = new ArrayList<>();

    public Hotel(String ragioneSociale, int stelle) {
        this.ragioneSociale = ragioneSociale;
        this.stelle = stelle;
    }
    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    public int getStelle() {
        return stelle;
    }
    public void setStelle(int stelle) {
        this.stelle = stelle;
    }
    public List<Stanza> getStanze() {
        return stanze;
    }
    public void setStanze(List<Stanza> stanze) {
        this.stanze = stanze;
    }

    public float calcolaConto(Stanza stanza) {
        if (stanza.getHotel().getRagioneSociale().equals(ragioneSociale)) {
            float somma = 0;
            for (Cliente cliente : stanza.getClienti()) {
                somma += cliente.sommaDaPagare();
            }
            return somma;
        }
        return 0;
    }
    public float calcolaContoAndPrint(Stanza stanza) {
        if (stanza.getHotel().getRagioneSociale().equals(ragioneSociale)) {
            float somma = 0;
            for (Cliente cliente : stanza.getClienti()) {
                somma += cliente.sommaDaPagare();
                System.out.println(cliente.getClass().getSimpleName() + " ha lo scondo del " + ((1-cliente.getSconto())*100) +"% e deve pagare: " + cliente.sommaDaPagare());
            }
            return somma;
        }
        return 0;
    }
}
