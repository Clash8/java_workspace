package it.prova.model;

public class Lavoratore {
    protected String nome;
    protected String cognome;

    public Lavoratore(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
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

    public String percepisco() {
        return "N.D.";
    }

    public static int contaQuantiPadri(Lavoratore[] input) {
        int count = 0;
        for (Lavoratore lavoratore : input)
            if (!(lavoratore instanceof Operaio)
                    && !(lavoratore instanceof Volontario))
                count++;
        return count;
    }
}
