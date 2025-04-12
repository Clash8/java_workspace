package it.prova.model;

public class Volontario extends Lavoratore{
    private String nomeAssociazione;

    public Volontario(String nome, String cognome, String nomeAssociazione) {
        super(nome, cognome);
        this.nomeAssociazione = nomeAssociazione;
    }

    @Override
    public String percepisco() {
        return this.nomeAssociazione+ " E’ NO PROFIT";
    }

}
