package it.prova.model;

public class Nazione {
    private String denominazione;
    private double superficieKmQ;
    private int abitanti;

    public Nazione() {}

    public Nazione(String denominazione, double superficieKmQ, int abitanti) {
        this.denominazione = denominazione;
        this.superficieKmQ = superficieKmQ;
        this.abitanti = abitanti;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public double getSuperficieKmQ() {
        return superficieKmQ;
    }

    public void setSuperficieKmQ(double superficieKmQ) {
        this.superficieKmQ = superficieKmQ;
    }

    public int getAbitanti() {
        return abitanti;
    }

    public void setAbitanti(int abitanti) {
        this.abitanti = abitanti;
    }
}