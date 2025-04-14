package it.prova.model.centrocommerciale;

public class Boss extends Lavoratore {

    public Boss(String nome, String cognome) {
        super(nome, cognome);
    }

    public boolean handleItemAdd(Item item) {
        return false;
    }
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
