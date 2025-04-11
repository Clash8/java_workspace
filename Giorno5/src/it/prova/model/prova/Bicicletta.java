package it.prova.model.prova;

public class Bicicletta extends Veicolo {


    public Bicicletta(String marca) {
        super(marca);
    }
    @Override
    public void suono() {
        System.out.println("driin driin!");
    }
}
