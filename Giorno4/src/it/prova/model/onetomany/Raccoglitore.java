package it.prova.model.onetomany;

public class Raccoglitore {
    private String colore;
    private int spessore;
    private Foglio[] fogli;

    public Raccoglitore(String colore, int spessore, Foglio[] fogli) {
        this.colore = colore;
        this.spessore = spessore;
        this.fogli = fogli;
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public int getSpessore() {
        return spessore;
    }
    public void setSpessore(int spessore) {
        this.spessore = spessore;
    }
    public Foglio[] getFogli() {
        return fogli;
    }
    public void setFogli(Foglio[] fogli) {
        this.fogli = fogli;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raccoglitore [colore=").append(colore).append(", spessore=").append(spessore).append(", fogli=");
        for (Foglio f : fogli) {
            sb.append(f.toString()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
