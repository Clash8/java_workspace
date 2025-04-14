package it.prova.model;

public class Gallina implements Volatile {
    private String piumaggio;

    public Gallina(String piumaggio) {
        this.piumaggio = piumaggio;
    }

    public String getPiumaggio() {
        return piumaggio;
    }
    public void setPiumaggio(String piumaggio) {
        this.piumaggio = piumaggio;
    }

    @Override
    public String fly() {
        return "La gallina svolazza";
    }
    @Override
    public String stampaProprieta() {
        return piumaggio;
    }
    @Override
    public boolean ugualeA(Volatile altroVolatile) {
        return (altroVolatile instanceof Gallina && piumaggio.equals(((Gallina) altroVolatile).getPiumaggio()));
    }
}
