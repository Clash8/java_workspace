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


    public boolean piuEstesaDi(Nazione input) {
        return input.getSuperficieKmQ() < this.getSuperficieKmQ();
    }
    public boolean piuPopolosaDi(Nazione input) {
        return input.getAbitanti() < this.getAbitanti();
    }
    public boolean esisteAlmenoUnaPiuEstesa(Nazione[] nazioni) {
        for (Nazione n : nazioni)
            if (n.getAbitanti() > this.abitanti)
                return true;
        return false;
    }
    public int dimmiQuanteSonoPiuPopolose(Nazione[] nazioni) {
        int count = 0;
        for (Nazione n : nazioni)
            if (n.getSuperficieKmQ() >= this.superficieKmQ)
                count++;
        return count;
    }
    public boolean haPiuAbitantiDiTutteLeAltre(Nazione[] nazioni) {
        for (Nazione n : nazioni)
            if (n.getAbitanti() < this.abitanti)
                return false;
        return true;
    }
    public boolean hannoTutteLaMiaStessaIniziale(Nazione[] nazioni) {
        for (Nazione n : nazioni)
            if (n.getDenominazione().charAt(0) != this.denominazione.charAt(0))
                return false;
        return true;
    }
    public boolean eAlDiSopraDellaMediaComeSuperficie(Nazione[] nazioni) {
        float media = 0;
        for (Nazione n : nazioni)
            media += (float) n.getSuperficieKmQ();
        media /= nazioni.length;
        return media >= this.superficieKmQ;
    }
}