package it.prova.model;

public class Televisore {

    private String marca;
    private String modello;
    private int prezzo;
    private int pollici;

    public Televisore() {}

    public Televisore(String marca, String modello, int prezzo, int pollici) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.pollici = pollici;
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getPollici() {
        return pollici;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public void setPollici(int pollici) {
        this.pollici = pollici;
    }

    // Metodo 1: controllo se il prezzo è inferiore al budget
    public boolean costaMenoDelBudgetDisponibile(int budgetDisponibile) {
        return this.prezzo < budgetDisponibile;
    }

    // Metodo 2: confronto tra le marche
    public boolean stessaMarcaDi(Televisore that) {
        return this.marca.equalsIgnoreCase(that.getMarca());
    }

    // Metodo 2: confronto tra i pollici
    public boolean piuGrandeDi(Televisore that) {
        return this.pollici > that.pollici;
    }

    // Metodo che confronta il rapporto qualità/prezzo (prezzo per pollice)
    public boolean miglioreQualitaPrezzoDi(Televisore that) {
        float costoThis = (float) this.prezzo / this.pollici;
        float costoThat = (float) that.getPrezzo() / that.getPollici();
        return costoThis < costoThat;
    }

    public boolean esisteAlmenoUnoPiuEconomico(Televisore[] catalogo) {
        for (Televisore t : catalogo)
            if (t.getPrezzo() < this.prezzo)
                return true;
        return false;
    }
    public int quantiSonoPiuGrandi(Televisore[] catalogo) {
        int count = 0;
        for (Televisore t : catalogo)
            if (t.getPollici() > this.pollici)
                count++;
        return count;
    }
    public int quantiSonoPiuCariAvendoStessaMarca (Televisore[] catalogo) {
        int count = 0;
        for (Televisore t : catalogo)
            if (this.marca.equalsIgnoreCase(t.getMarca()) && t.getPrezzo() > this.prezzo)
                count++;
        return count;
    }
    public boolean ePiuCaroDellaMedia(Televisore[] input) {
        int sum = 0;
        for (Televisore t : input)
            sum += t.getPrezzo();
        double media = (double) sum / (double) input.length;
        return media < this.prezzo;
    }

}
