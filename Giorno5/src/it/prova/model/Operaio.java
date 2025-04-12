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

    public static int contaQuantiFigli(Lavoratore[] input) {
        int count = 0;
        for (Lavoratore lavoratore : input)
            if (lavoratore instanceof Operaio)
                count++;
        return count;
    }
}
