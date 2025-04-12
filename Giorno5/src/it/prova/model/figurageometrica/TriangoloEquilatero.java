package it.prova.model.figurageometrica;

public class TriangoloEquilatero extends FiguraGeometrica{

    public TriangoloEquilatero(float lato) {
        super(lato);
    }

    @Override
    public float calcolaArea() {
        return (float) (Math.sqrt(3) / 4 * Math.pow(lato, 2));
    }

    @Override
    public float calcolaPerimetro() {
        return 3 * lato;
    }

}
