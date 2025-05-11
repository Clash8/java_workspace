package it.prova.pizzastorespringmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {

//id, descrizione, ingredienti, prezzo base [che è un prezzo fisso della pizza dato dal costo della farina, luce, costi vari], attivo=true/false),
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "ingredienti")
	private String ingredienti;

	@Column(name = "prezzobase")
	private Double prezzoBase;

	@Column(name = "attivo")
	private Boolean attivo;

	public Pizza() {}

	public Pizza(Long id, String descrizione, String ingredienti, Double prezzoBase, Boolean attivo) {
		this.id = id;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
	}

	public Pizza(String descrizione, String ingredienti, Double prezzoBase, Boolean attivo) {
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
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

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public Double getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(Double prezzoBase) {
		this.prezzoBase = prezzoBase;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"id=" + id +
				", descrizione='" + descrizione + '\'' +
				", ingredienti='" + ingredienti + '\'' +
				", prezzoBase=" + prezzoBase +
				", attivo=" + attivo +
				'}';
	}
}
