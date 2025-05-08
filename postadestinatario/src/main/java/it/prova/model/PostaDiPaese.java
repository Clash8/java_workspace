package it.prova.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostaDiPaese {
    private String denominazione;
    private String indirizzoSede;
    private LocalDate dataApertura;
    private int numeroDipendenti;
    private List<Destinatario> destinatari = new ArrayList<>();


    public PostaDiPaese(){}

    public PostaDiPaese(String denominazione, String indirizzoSede, LocalDate dataApertura, int numeroDipendenti) {
        this.denominazione = denominazione;
        this.indirizzoSede = indirizzoSede;
        this.dataApertura = dataApertura;
        this.numeroDipendenti = numeroDipendenti;
    }

    public String getDenominazione() {
        return denominazione;
    }
    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }
    public String getIndirizzoSede() {
        return indirizzoSede;
    }
    public void setIndirizzoSede(String indirizzoSede) {
        this.indirizzoSede = indirizzoSede;
    }
    public LocalDate getDataApertura() {
        return dataApertura;
    }
    public void setDataApertura(LocalDate dataApertura) {
        this.dataApertura = dataApertura;
    }
    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }
    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }
    public List<Destinatario> getDestinatari() {
        return destinatari;
    }
    public void setDestinatari(List<Destinatario> destinatari) {
        this.destinatari = destinatari;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(denominazione + "\n");

        destinatari.forEach(destinatario -> {
            sb.append("\t").append(destinatario.getNome()).append("\n");
        });
        return sb.toString();
    }

}
