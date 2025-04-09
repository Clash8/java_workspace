package it.prova.model;

public class Studente {
    private String nome;
    private String cognome;
    private int eta;
    private double mediaScolastica;

    public Studente(String nome, String cognome, int eta, double mediaScolastica) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.mediaScolastica = mediaScolastica;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public double getMediaScolastica() {
        return mediaScolastica;
    }

    public boolean sonoTuttiPiuGiovaniDiMe(Studente [] corso) {
        for (Studente studente : corso)
            if (studente.getEta() >= this.eta)
                return false;
        return true;
    }
    public boolean almenoUnoHaLaMediaMiglioreDellaMia(Studente [] corso) {
        for (Studente studente : corso)
            if (studente.getMediaScolastica() > this.mediaScolastica)
                return true;
        return false;
    }

    public int contaOmonimiMinorenni(Studente[] corso) {
        int count = 0;
        for (Studente studente : corso)
            if (studente.getNome().equals(this.nome) && studente.getEta() < 18)
                count++;
        return count;
    }
    public static int contaStudentiConMediaSufficiente(Studente[] corso) {
        int count = 0;
        for (Studente studente : corso)
            if (studente.getMediaScolastica() >= 6)
                count++;
        return count;
    }
}