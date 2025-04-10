package it.prova.model;

public class Persona {
    //create a class with following attributes:
    // nome, cognome, eta, Indirizzo
    private String nome;
    private String cognome;
    private int eta;
    private Indirizzo indirizzo;

    //create a constructor empty
    public Persona() {}

    public Persona(String nome, String cognome, int eta, Indirizzo indirizzo) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.indirizzo = indirizzo;
    }

    //create a constructor with only nome, cognome and eta
    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
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
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", indirizzo=" + indirizzo + "]";
    }


    public boolean abitaA(String cittaInput) {
        return (cittaInput.equalsIgnoreCase(this.indirizzo.getCitta()));
    }
    public boolean haAlmenoUnConcittadino(Persona[] elenco) {
        for (Persona persona : elenco)
            if (persona.getIndirizzo().getCitta().equals(this.indirizzo.getCitta()))
                return true;
        return false;
    }
    public boolean sonoTuttiPiuAnziani(Persona[] elenco) {
        for (Persona persona : elenco)
            if (persona.getEta() <= this.eta)
                return false;
        return true;
    }

    public int quantiCoabitanoNelMioStessoPalazzo(Persona[] elencoInput) {
        int count = 0;
        for (Persona p : elencoInput)
            if (p.getIndirizzo().getCitta().equalsIgnoreCase(this.indirizzo.getCitta()) &&
                    p.getIndirizzo().getVia().equalsIgnoreCase(this.indirizzo.getVia()) &&
                    p.getIndirizzo().getNumeroCivico().equalsIgnoreCase(this.indirizzo.getNumeroCivico()))
                count++;
        return count;
    }

    public void nuovoCoinquilino(Persona nuovoC) {
        nuovoC.setIndirizzo(this.indirizzo);
    }
}
