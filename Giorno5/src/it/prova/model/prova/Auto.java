package it.prova.model.prova;

public class Auto extends Veicolo {

    public Auto(String marca) {
        super(marca);
    }

    @Override
    public void suono() {
        System.out.println("biip biip!");
    }
}
