package it.prova.model;

import java.util.ArrayList;
import java.util.List;

public class Assicurato {
    //nome,cognome,codiceFiscale,rataPremioAssicurativo
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private float rataPremioAssicurativo;

    public Assicurato(String nome, String cognome, String codiceFiscale, float rataPremioAssicurativo) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.rataPremioAssicurativo = rataPremioAssicurativo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public float getRataPremioAssicurativo() {
        return rataPremioAssicurativo;
    }
    public void setRataPremioAssicurativo(int rataPremio) {
        this.rataPremioAssicurativo = rataPremio;
    }


    @Override
    public String toString() {
        return String.format("%-15s %-15s %-20s %-10.2f\n",
                getNome(),
                getCognome(),
                getCodiceFiscale(),
                getRataPremioAssicurativo());
    }
    public boolean presenteInElenco(List<Assicurato> assicurati) {
        for (Assicurato assicurato : assicurati)
            if (assicurato.getCodiceFiscale().equals(this.codiceFiscale))
                return true;
        return false;
    }

    public static int quantiConInizialeNelCognome(List<Assicurato> assicurati, char iniziale) {
        int cont = 0;
        for (Assicurato assicurato : assicurati)
            if (assicurato.getCognome().charAt(0) == iniziale)
                cont++;
        return cont;
    }
    public static List<String> estraiSoloICognomi(List<Assicurato> assicurati) {
        List<String> cognomi = new ArrayList<>();
        for (Assicurato assicurato : assicurati)
            cognomi.add(assicurato.getCognome());
        return cognomi;
    }
    public static List<Assicurato> estraiQuelliConRataMaggioreDi(List<Assicurato> assicurati, int sogliaRata) {
        List<Assicurato> sogliaMaggiore = new ArrayList<>();
        for (Assicurato assicurato : assicurati)
            if (assicurato.getRataPremioAssicurativo() > (float) sogliaRata)
                sogliaMaggiore.add(assicurato);
        return sogliaMaggiore;
    }


//    static List<Assicurato> estraiSoloMaggiorenni(List<Assicurato> assicurati) {
//        List<Assicurato> maggiorenni = new ArrayList<>();
//        for (Assicurato assicurato : assicurati)
//            if (assicurato.getEta() >= 18)
//                maggiorenni.add(assicurato);
//        return maggiorenni;
//    }
}
