package it.prova.model.centrocommerciale;

public class PersonaleAmministrativo extends Lavoratore {
    public PersonaleAmministrativo(String nome, String cognome) {
        super(nome, cognome);
    }

    public boolean handleItemAdd(Item item) {
        return getNegozio().getItems().add(item);
    }
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
