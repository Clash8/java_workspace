package it.prova.model;

public class Aereo implements Volante {

    private String compagnia;

    public Aereo(String compagnia) {
        this.compagnia = compagnia;
    }

    public String getCompagnia() {
        return compagnia;
    }
    public void setCompagnia(String compagnia) {
        this.compagnia = compagnia;
    }

    @Override
    public void decolla() {
        System.out.println("L'aereo accelera sulla pista e decolla.");
    }

    @Override
    public void vola() {
        System.out.println("L'aereo sta volando ad alta quota.");
    }

    @Override
    public void atterra() {
        System.out.println("L'aereo atterra dolcemente sull'asfalto.");
    }

    @Override
    public String details() {
        return getClass().getSimpleName() + ": " + compagnia;
    }
    @Override
    public boolean sonoSimili(Volante altroVolante) {
        if (altroVolante instanceof Aereo) {
            Aereo aereo = (Aereo) altroVolante;
            return aereo.getCompagnia().equalsIgnoreCase(this.compagnia);
        }
        return false;
    }
}