package it.prova.model.prova;

public class Veicolo {
    protected String marca;


    public Veicolo() {
        this.marca = "N.D.";
    }

    public Veicolo(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void suono() {
        System.out.println("deafult sound");
    }

}
