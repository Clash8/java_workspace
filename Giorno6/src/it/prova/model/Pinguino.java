package it.prova.model;

public class Pinguino implements Volatile {
    private String continenteAppartenenza;

    public Pinguino(String continenteAppartenenza) {
        this.continenteAppartenenza = continenteAppartenenza;
    }

    public String getContinenteAppartenenza() {
        return continenteAppartenenza;
    }
    public void setContinenteAppartenenza(String continenteAppartenenza) {
        this.continenteAppartenenza = continenteAppartenenza;
    }

    @Override
    public String fly() {
        return "Il pinguino non fly";
    }

    @Override
    public String stampaProprieta() {
        return continenteAppartenenza;
    }
    @Override
    public boolean ugualeA(Volatile altroVolatile) {
        return (altroVolatile instanceof Pinguino && continenteAppartenenza.equals(((Pinguino) altroVolatile).getContinenteAppartenenza()));
    }
}
