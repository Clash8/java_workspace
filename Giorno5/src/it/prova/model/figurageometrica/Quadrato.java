package it.prova.model.figurageometrica;

public class Quadrato extends FiguraGeometrica{

    public Quadrato(float lato) {
        super(lato);
    }

    @Override
    public float calcolaArea() {
        return lato*lato;
    }

    @Override
    public float calcolaPerimetro() {
        return 4 * lato;
    }
}
