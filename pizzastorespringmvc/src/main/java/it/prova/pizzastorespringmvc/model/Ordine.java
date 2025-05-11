package it.prova.pizzastorespringmvc.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ordine")
public class Ordine {

	//(id, Cliente, lista di Pizza, dataOrdine, CLOSED=true/false, codice, costo totale ordine).
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ordine_pizza", joinColumns = @JoinColumn(name = "ordine_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	private List<Pizza> pizze = new ArrayList<>(0);

	@Column(name = "dataordine")
	private LocalDate dataOrdine;

	@Column(name = "chiuso")
	private Boolean chiuso;

	@Column(name = "codice")
	private String codice;

	public Ordine() {}

	public Ordine(Cliente cliente, List<Pizza> pizze, LocalDate dataOrdine, Boolean chiuso, String codice) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}

	public LocalDate getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(LocalDate dataOrdine) {
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




	@Override
	public String toString() {
		return "Ordine{" +
				"id=" + id +
				", cliente=" + cliente +
				", pizze=" + pizze +
				", dataOrdine=" + dataOrdine +
				", chiuso=" + chiuso +
				", codice='" + codice + '\'' +
				'}';
	}
}
