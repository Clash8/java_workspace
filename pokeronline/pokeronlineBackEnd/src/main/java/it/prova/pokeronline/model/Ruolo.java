package it.prova.pokeronline.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ruolo")
public class Ruolo {


    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_PLAYER = "ROLE_PLAYER";
    public static final String ROLE_SPECIAL_PLAYER = "ROLE_SPECIAL_PLAYER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descrizione;
    private String codice;

    public Ruolo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
