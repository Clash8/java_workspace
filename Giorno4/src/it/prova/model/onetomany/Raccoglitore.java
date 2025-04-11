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
        sb.append("Raccoglitore [colore=").append(colore).append(", spessore=").append(spessore).append(", fogli=\n");
        for (Foglio f : fogli) {
            sb.append(f).append(", \n");
        }
        sb.append("]");
        return sb.toString();
    }
    public void addToFogli(Foglio foglio) {
        Foglio[] arrayCopy = new Foglio[this.fogli.length + 1];
        for (int i = 0; i < this.fogli.length; i++) {
            arrayCopy[i] = this.fogli[i];
        }
        arrayCopy[this.fogli.length] = foglio;

        this.setFogli(arrayCopy);
    }

    public boolean removeFromFogli(int index) {
        if (index < 0 || index >= this.fogli.length) return false;

        Foglio[] arrayCopy = new Foglio[this.fogli.length - 1];

        int count = 0;
        for (int i = 0; i < this.fogli.length; i++)
            if (i != index)
                arrayCopy[count++] = this.fogli[i];

        this.setFogli(arrayCopy);
        return true;
    }

    public boolean esisteAlmenoUnFoglioAQuadretti() {
        for (Foglio f : fogli)
            if (f.getTipologia().equalsIgnoreCase("quadretti"))
                return true;
        return false;
    }

    public int quantiFogliDiAltaQualita() {
        int count = 0;
        for (Foglio f : fogli)
            if (f.getQualita().equalsIgnoreCase("alta"))
                count++;
        return count;
    }

    public boolean stessoColoreENumeroFogliDi(Raccoglitore altroRaccoglitore) {
        return altroRaccoglitore.getFogli().length == this.fogli.length && altroRaccoglitore.getFogli().length == this.fogli.length;
    }

}
