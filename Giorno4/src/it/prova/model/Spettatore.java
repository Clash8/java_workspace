package it.prova.model;

public class Spettatore {
    private String nome;
    private String cognome;
    private String numeroCartaDiCredito;
    private Biglietto biglietto;

    public Spettatore() {}

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito, Biglietto biglietto) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
        this.biglietto = biglietto;
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

    public String getNumeroCartaDiCredito() {
        return numeroCartaDiCredito;
    }

    public void setNumeroCartaDiCredito(String numeroCartaDiCredito) {
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    @Override
    public String toString() {
        return "Spettatore [nome=" + nome + ", cognome=" + cognome + ", numeroCartaDiCredito=" + numeroCartaDiCredito
                + ", biglietto=" + biglietto + "]";
    }

    public float incassoDeiPagantiNellaMiaFila(Spettatore[] elencoPagantiTotali) {
        float sum = this.biglietto.getPrezzo();
        for (Spettatore sp : elencoPagantiTotali)
            if (sp.getBiglietto().getLetteraFila() == this.biglietto.getLetteraFila())
                sum += sp.getBiglietto().getPrezzo();
        return sum;
    }

    public int numeroSpettatoriDelMioStessoSpettacolo(Spettatore[] elencoPagantiTotali) {
        int count = 1;
        for (Spettatore sp : elencoPagantiTotali)
            if (sp.getBiglietto().getNomeSpettacolo().equals(this.biglietto.getNomeSpettacolo()))
                count++;
        return count;
    }

    public boolean numeroSpettatoriMioSpettacoloSuperaAspettativa(Spettatore[] paganti, int aspettativa) {
        return numeroSpettatoriDelMioStessoSpettacolo(paganti) > aspettativa;
    }


    public static int contaQuantiSenzaBiglietto(Spettatore[] elencoSpettatori) {
        int count = 0;
        for (Spettatore sp : elencoSpettatori)
            if (sp.getBiglietto() == null)
                count++;
        return count;
    }
    public int contaQuantiNellaMiaStessaFila(Spettatore[] elencoSpettatori) {
        int count = 0;
        for (Spettatore sp : elencoSpettatori)
            if (sp.getBiglietto().getLetteraFila() == this.biglietto.getLetteraFila())
                count++;
        return count;
    }
    public boolean eIlPiuCaroTraIBigliettiDeiPaganti(Spettatore[] elencoSpettatoriPaganti) {
        for (Spettatore sp : elencoSpettatoriPaganti)
            if (sp.getBiglietto().getPrezzo() > this.biglietto.getPrezzo())
                return false;
        return true;
    }

}