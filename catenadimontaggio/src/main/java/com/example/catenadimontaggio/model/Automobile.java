package com.example.catenadimontaggio.model;

import java.time.LocalDate;

public class Automobile {
//(modello, telaio, dataProduzione)

    private Long id;
    private String modello;
    private String telaio;
    private LocalDate dataProduzione;

    public Automobile() {
    }
    public Automobile(String modello, String telaio, LocalDate dataProduzione) {
        this.modello = modello;
        this.telaio = telaio;
        this.dataProduzione = dataProduzione;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getTelaio() {
        return telaio;
    }
    public void setTelaio(String telaio) {
        this.telaio = telaio;
    }
    public LocalDate getDataProduzione() {
        return dataProduzione;
    }
    public void setDataProduzione(LocalDate dataProduzione) {
        this.dataProduzione = dataProduzione;
    }
    @Override
    public String toString() {
        return "Automobile [modello=" + modello + ", telaio=" + telaio + ", dataProduzione=" + dataProduzione + "]";
    }
}
