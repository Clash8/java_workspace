package it.prova.pokeronline.dto.securitydto;

import it.prova.pokeronline.model.Ruolo;


public class UtenteAuthJWTResponseDTO {

    private String token;
    private String type = "Bearer";
    private String username;
    private String email;
    private Ruolo ruolo;

    public UtenteAuthJWTResponseDTO(String accessToken, String username, String email, Ruolo ruolo) {
        this.token = accessToken;
        this.username = username;
        this.email = email;
        this.ruolo = ruolo;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
