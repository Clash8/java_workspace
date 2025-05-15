package it.prova.pizzastorespringmvc.dto;

import it.prova.pizzastorespringmvc.model.Ordine;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrdineDTO {

	//(id, Cliente, lista di Pizza, dataOrdine, CLOSED=true/false, codice, costo totale ordine).
	private Long id;

	private ClienteDTO cliente;

	private List<PizzaDTO> pizze = new ArrayList<>(0);

	private Date dataOrdine;

	private Boolean chiuso;

	@NotBlank(message = "{notblank}")
	private String codice;

	public OrdineDTO() {}

	public OrdineDTO(Long id, ClienteDTO cliente, Date dataOrdine, Boolean chiuso, String codice) {
		this.id = id;
		this.cliente = cliente;
		this.dataOrdine = dataOrdine;
		this.chiuso = chiuso;
		this.codice = codice;
	}

	public OrdineDTO(Long id, ClienteDTO cliente, List<PizzaDTO> pizze, Date dataOrdine, Boolean chiuso, String codice) {
		this.id = id;
		this.cliente = cliente;
		this.pizze = pizze;
		this.dataOrdine = dataOrdine;
		this.chiuso = chiuso;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<PizzaDTO> getPizze() {
		return pizze;
	}

	public void setPizze(List<PizzaDTO> pizze) {
		this.pizze = pizze;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Boolean getChiuso() {
		return chiuso;
	}

	public void setChiuso(Boolean chiuso) {
		this.chiuso = chiuso;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Double calcolaCosto() {
		Double costo = 0.0;
		for (PizzaDTO pizza : pizze) {
			costo += pizza.getPrezzoBase();
		}
		return costo;
	}

	@Override
	public String toString() {
		return "Ordine{" +
				"id=" + id +
				", cliente=" + cliente +
				", pizze=" + pizze +
				", dataOrdine=" + dataOrdine +
				", costo=" + calcolaCosto() +
				", chiuso=" + chiuso +
				", codice='" + codice + '\'' +
				'}';
	}

	public Ordine buildOrdineModel() {
		return new Ordine(this.id, this.cliente.buildClienteModel(), this.pizze.stream().map(PizzaDTO::buildPizzaModel).collect(Collectors.toList()), this.dataOrdine, this.chiuso, this.codice);
	}

	public static OrdineDTO buildOrdineDTOFromModel(Ordine ordineModel, boolean includePizze) {
		OrdineDTO result = new OrdineDTO(
				ordineModel.getId(),
				ClienteDTO.buildClienteDTOFromModel(ordineModel.getCliente(), false),
				ordineModel.getDataOrdine(),
				ordineModel.getChiuso(),
				ordineModel.getCodice()
		);

		if (includePizze)
			result.setPizze(PizzaDTO.createPizzaDTOListFromModelList(ordineModel.getPizze()));

		return result;
	}

	public static List<OrdineDTO> createOrdineDTOListFromModelList(List<Ordine> modelListInput, boolean includePizze) {
		return modelListInput.stream().map(ordineEntity -> {
			return OrdineDTO.buildOrdineDTOFromModel(ordineEntity, includePizze);
		}).collect(Collectors.toList());
	}
}
