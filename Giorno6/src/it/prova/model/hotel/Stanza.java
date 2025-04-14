package it.prova.model.hotel;

import java.util.ArrayList;
import java.util.List;

public class Stanza {
    private int numeroStanza;
    private float quantoAPersona;
    private Hotel hotel;
    private List<Cliente> clienti = new ArrayList<>();

    public Stanza(int numeroStanza, float quantoAPersona, Hotel hotel) {
        this.numeroStanza = numeroStanza;
        this.quantoAPersona = quantoAPersona;
        this.hotel = hotel;
    }
    public int getNumeroStanza() {
        return numeroStanza;
    }
    public void setNumeroStanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
    }
    public float getQuantoAPersona() {
        return quantoAPersona;
    }
    public void setQuantoAPersona(int quantoAPersona) {
        this.quantoAPersona = quantoAPersona;
    }
    public Hotel getHotel() {
        return hotel;
    }
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    public List<Cliente> getClienti() {
        return clienti;
    }
    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }

}
