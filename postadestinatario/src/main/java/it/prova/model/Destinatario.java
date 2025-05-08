package it.prova.model;

public class Destinatario {
//(nome, cognome, eta, indirizzo, boolean possessoreDiContoCorrente, postaDiPaese)
    private String nome;
    private String cognome;
    private int eta;
    private String indirizzo;
    private boolean possessoreDiContoCorrente;
    private PostaDiPaese postaDiPaese;

    public Destinatario() {
    }
    public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreDiContoCorrente,
            PostaDiPaese postaDiPaese) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.indirizzo = indirizzo;
        this.possessoreDiContoCorrente = possessoreDiContoCorrente;
        this.postaDiPaese = postaDiPaese;
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
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public boolean isPossessoreDiContoCorrente() {
        return possessoreDiContoCorrente;
    }
    public void setPossessoreDiContoCorrente(boolean possessoreDiContoCorrente) {
        this.possessoreDiContoCorrente = possessoreDiContoCorrente;
    }
    public PostaDiPaese getPostaDiPaese() {
        return postaDiPaese;
    }
    public void setPostaDiPaese(PostaDiPaese postaDiPaese) {
        this.postaDiPaese = postaDiPaese;
    }

    @Override
    public String toString() {
        return "Destinatario [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", indirizzo=" + indirizzo
                + ", possessoreDiContoCorrente=" + possessoreDiContoCorrente + "]";
    }
}
