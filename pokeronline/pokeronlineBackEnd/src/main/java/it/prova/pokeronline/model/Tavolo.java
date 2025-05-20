package it.prova.pokeronline.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tavolo")
public class Tavolo {

    ///Tavolo (sarebbe la partita) coi campi esperienzaMin
    ///(cioè il minimo dell’esperienzaAccumulata che gli utenti devono possedere per poter giocare a quel tavolo)
    ///, cifraMinima  (il minimo valore di denaro che si deve possedere per giocare a quel tavolo),
    ///denominazione …., data creazione…..
    /// Set di Utente (i giocatori) ed un Utente utenteCreazione che è colui che ha creato il tavolo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer esperienzaMin;
    private Double cifraMinima;
    private String denominazione;
    private LocalDate dataCreazione;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tavolo")
    private Set<Utente> utenti = new HashSet<>(0);

    @OneToOne
    @JoinColumn(name = "utente_creazione_id")
    private Utente utenteCreazione;


    public Tavolo() {
    }

    public Tavolo(Integer esperienzaMin, Double cifraMinima, String denominazione, LocalDate dataCreazione) {
        this.esperienzaMin = esperienzaMin;
        this.cifraMinima = cifraMinima;
        this.denominazione = denominazione;
        this.dataCreazione = dataCreazione;
    }

    public Tavolo(Long id,Integer esperienzaMin, Double cifraMinima, String denominazione, LocalDate dataCreazione) {
        this.id = id;
        this.esperienzaMin = esperienzaMin;
        this.cifraMinima = cifraMinima;
        this.denominazione = denominazione;
        this.dataCreazione = dataCreazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEsperienzaMin() {
        return esperienzaMin;
    }

    public void setEsperienzaMin(Integer esperienzaMin) {
        this.esperienzaMin = esperienzaMin;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public Double getCifraMinima() {
        return cifraMinima;
    }

    public void setCifraMinima(Double cifraMinima) {
        this.cifraMinima = cifraMinima;
    }

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }

    public Utente getUtenteCreazione() {
        return utenteCreazione;
    }

    public void setUtenteCreazione(Utente utenteCreazione) {
        this.utenteCreazione = utenteCreazione;
    }
}
