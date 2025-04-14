package it.prova.model;

public class Aquila implements Volatile {
    private String razzaAquila;

    public Aquila(String razzaAquila) {
        this.razzaAquila = razzaAquila;
    }

    public String getRazzaAquila() {
        return razzaAquila;
    }
    public void setRazzaAquila(String razzaAquila) {
        this.razzaAquila = razzaAquila;
    }

    @Override
    public String fly() {
        return "L'aquila fly!";
    }

    @Override
    public String stampaProprieta() {
        return razzaAquila;
    }
    @Override
    public boolean ugualeA(Volatile altroVolatile) {
        return (altroVolatile instanceof Aquila && razzaAquila.equals(((Aquila) altroVolatile).getRazzaAquila()));
    }
}
