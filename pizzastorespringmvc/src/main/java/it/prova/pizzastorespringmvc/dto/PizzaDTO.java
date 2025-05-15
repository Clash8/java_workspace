package it.prova.pizzastorespringmvc.dto;

import it.prova.pizzastorespringmvc.model.Pizza;

import java.util.List;
import java.util.stream.Collectors;

public class PizzaDTO {

//id, descrizione, ingredienti, prezzo base [che è un prezzo fisso della pizza dato dal costo della farina, luce, costi vari], attivo=true/false),
	private Long id;

	private String descrizione;

	private String ingredienti;

	private Double prezzoBase = 0.0;

	private Boolean attivo;

	public PizzaDTO() {}

	public PizzaDTO(Long id, String descrizione, String ingredienti, Double prezzoBase, Boolean attivo) {
		this.id = id;
		this.descrizione = descrizione;
		this.ingredienti = ingredienti;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
	}

	public PizzaDTO(String descrizione, String ingredienti, Double prezzoBase, Boolean attivo) {
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

	public Pizza buildPizzaModel() {
		return new Pizza(this.id, this.descrizione, this.ingredienti, this.prezzoBase, this.attivo);
	}

	public static PizzaDTO buildPizzaDTOFromModel(Pizza pizzaModel) {
		PizzaDTO result = new PizzaDTO(pizzaModel.getId(), pizzaModel.getDescrizione(), pizzaModel.getIngredienti(), pizzaModel.getPrezzoBase(), pizzaModel.getAttivo());

		return result;
	}

	public static List<PizzaDTO> createPizzaDTOListFromModelList(List<Pizza> modelListInput) {
		return modelListInput.stream().map(PizzaDTO::buildPizzaDTOFromModel).collect(Collectors.toList());
	}

}
