package it.esercizipercasa.model;

public class DVD extends MaterialeBiblioteca{
    private int durata;



    public DVD() {};

    public DVD(String titolo, String autore, String codiceIdentificativo, int durata) {
        super(titolo, autore, codiceIdentificativo);
        this.durata = durata;
    }
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    @Override
    public int calcolaTempoPrestitoMassimo() {
        return 7;
    }

}
