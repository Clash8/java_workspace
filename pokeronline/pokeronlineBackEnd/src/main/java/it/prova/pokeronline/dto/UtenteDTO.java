package it.prova.pokeronline.dto;

import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.StatoUtente;
import it.prova.pokeronline.model.Utente;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class UtenteDTO {

    private Long id;

    @NotBlank(message = "{nome.notblank}")
    private String nome;
    @NotBlank(message = "{cognome.notblank}")
    private String cognome;
    @NotBlank(message = "{username.notblank}")
    private String username;
    @NotBlank(message = "{password.notblank}")
    private String password;

    private LocalDate dataRegistrazione;

    private Integer esperienzaAccumulata;

    private Double creditoAccumulato;

    private StatoUtente statoUtente;

    private Ruolo ruolo;

    public UtenteDTO() {
    }

    public UtenteDTO(Long id, String nome,
                     String cognome, String username,
                     Integer esperienzaAccumulata, Double creditoAccumulato) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.creditoAccumulato = creditoAccumulato;
        this.esperienzaAccumulata = esperienzaAccumulata;
    }

    public UtenteDTO(Long id, String nome, String cognome, String username, String password, Double creditoAccumulato){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.creditoAccumulato = creditoAccumulato;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(LocalDate dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public Integer getEsperienzaAccumulata() {
        return esperienzaAccumulata;
    }

    public void setEsperienzaAccumulata(Integer esperienzaAccumulata) {
        this.esperienzaAccumulata = esperienzaAccumulata;
    }

    public Double getCreditoAccumulato() {
        return creditoAccumulato;
    }

    public void setCreditoAccumulato(Double creditoAccumulato) {
        this.creditoAccumulato = creditoAccumulato;
    }

    public StatoUtente getStato() {
        return statoUtente;
    }

    public void setStato(StatoUtente statoUtente) {
        this.statoUtente = statoUtente;
    }

    public Utente buildUtenteModel() {
        return new Utente(
                this.nome,
                this.cognome,
                this.username,
                this.password,
                this.dataRegistrazione,
                this.esperienzaAccumulata,
                this.creditoAccumulato,
                this.statoUtente,
                this.ruolo
        );
    }
    //this.nome = nome;
    //        this.cognome = cognome;
    //        this.username = username;
    //        this.creditoAccumulato = creditoAccumulato;
    //        this.esperienzaAccumulata = esperienzaAccumulata;
    public static UtenteDTO buildUtenteDTOFromModel(Utente utenteModel) {
        return new UtenteDTO(utenteModel.getId(), utenteModel.getUsername(), utenteModel.getNome(),
                utenteModel.getCognome(),utenteModel.getEsperienzaAccumulata(),
                utenteModel.getCreditoAccumulato());
    }

    public Utente buildUtenteModelInsert(){
        return new Utente(this.id, this.nome, this.cognome, this.username,this.password,this.creditoAccumulato);
    }
    public static UtenteDTO buildUtenteDTOFromModelInsert(Utente utenteModel){
        return new UtenteDTO(utenteModel.getId(), utenteModel.getNome(), utenteModel.getCognome(),
                utenteModel.getUsername(),utenteModel.getPassword(),utenteModel.getCreditoAccumulato());
    }

}

