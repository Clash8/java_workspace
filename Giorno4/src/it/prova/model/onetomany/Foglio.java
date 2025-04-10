package it.prova.model.onetomany;

public class Foglio {
    private String qualita;
    private String tipologia;

    public Foglio(String qualita, String tipologia) {
        this.qualita = qualita;
        this.tipologia = tipologia;
    }
    public String getQualita() {
        return qualita;
    }
    public void setQualita(String qualita) {
        this.qualita = qualita;
    }
    public String getTipologia() {
        return tipologia;
    }
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    @Override
    public String toString() {
        return "Foglio [qualita=" + qualita + ", tipologia=" + tipologia + "]";
    }
}
