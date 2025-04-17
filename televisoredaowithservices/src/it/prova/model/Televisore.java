package it.prova.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Televisore {
	//id, marca, modello,pollici, dataproduzione
	private Long id;
	private String marca;
	private String modello;
	private Integer pollici;
	private LocalDate dataProduzione;

	public Televisore() {
		super();
	}
	public Televisore(String marca, String modello, int pollici, LocalDate dataProduzione) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.pollici = pollici;
		this.dataProduzione = dataProduzione;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public Integer getPollici() {
		return pollici;
	}
	public void setPollici(Integer pollici) {
		this.pollici = pollici;
	}
	public LocalDate getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(LocalDate dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Televisore [id=" + id + ", marca=" + marca + ", modello=" + modello + ", pollici=" + pollici
				+ ", dataProduzione=" + dataProduzione.format(formatter) + "]";
	}

}
