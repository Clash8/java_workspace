package it.prova.model;

public class Aquilone implements Volante {
    private String colore;

    public Aquilone(String colore) {
        this.colore = colore;
    }

    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }

    @Override
    public void decolla() {
        System.out.println("L'aquilone prende il volo con il vento.");
    }

    @Override
    public void vola() {
        System.out.println("L'aquilone ondeggia leggero nel cielo.");
    }

    @Override
    public void atterra() {
        System.out.println("L'aquilone scende lentamente al suolo.");
    }

    @Override
    public String details() {
        return getClass().getSimpleName() + ": " + colore;
    }

    @Override
    public boolean sonoSimili(Volante altroVolante) {
        if (altroVolante instanceof Aquilone) {
            Aquilone aquilone = (Aquilone) altroVolante;
            return aquilone.getColore().equalsIgnoreCase(this.colore);
        }
        return false;
    }

}