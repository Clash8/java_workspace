package it.prova.test;

import it.prova.model.figurageometrica.*;

public class TestFiguraGeometrica {
    public static void main(String[] args) {

        FiguraGeometrica figuraGenerica = new FiguraGeometrica(5);
        FiguraGeometrica triangolo = new TriangoloEquilatero(5);
        FiguraGeometrica quadrato = new Quadrato(5);

        System.out.println("Area figura generica: " + figuraGenerica.calcolaArea());
        System.out.println("Perimetro figura generica: " + figuraGenerica.calcolaPerimetro());
        System.out.println("Area triangolo: " + triangolo.calcolaArea());
        System.out.println("Perimetro triangolo: " + triangolo.calcolaPerimetro());
        System.out.println("Area quadrato: " + quadrato.calcolaArea());
        System.out.println("Perimetro quadrato: " + quadrato.calcolaPerimetro());

    }
}
