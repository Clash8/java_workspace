package it.prova.model.figurageometrica;

public class FiguraGeometrica {
    protected float lato;

    public FiguraGeometrica(float lato) {
        this.lato = lato;
    }
    public float getLato() {
        return lato;
    }
    public void setLato(float lato) {
        this.lato = lato;
    }

    public float calcolaArea() {
        return -1;
    }
    public float calcolaPerimetro() {
        return -1;
    }

}
