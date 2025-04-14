package it.prova.model.centrocommerciale;

public class Commesso extends Lavoratore {

    public Commesso(String nome, String cognome) {
        super(nome, cognome);
    }

    public boolean handleItemAdd(Item item) {
        return getNegozio().getItems().add(item);
    }
    public boolean handleItemRemove(Item item) {
        return getNegozio().getItems().remove(item);
    }
}
