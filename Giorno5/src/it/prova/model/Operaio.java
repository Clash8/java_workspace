package it.prova.model;

public class Operaio extends Lavoratore{
    private int Salario;


    public Operaio(String nome, String cognome, int Salario) {
        super(nome, cognome);
        this.Salario = Salario;
    }

    @Override
    public String percepisco() {
        return "io percepisco " + Salario + " euro";
    }
}
