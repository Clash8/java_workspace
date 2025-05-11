package it.prova.pizzastorespringmvc.dto;

import it.prova.pizzastorespringmvc.model.Cliente;
import it.prova.pizzastorespringmvc.model.Film;
import it.prova.pizzastorespringmvc.model.Ordine;
import it.prova.pizzastorespringmvc.model.Regista;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ClienteDTO {


	private Long id;

	@NotBlank(message = "{notblank}")
	private String nome;

	@NotBlank(message = "{notblank}")
	private String cognome;

	private String indirizzo;

	private Date dataDiNascita;

	private Boolean attivo;

	private Set<Ordine> ordini = new HashSet<>(0);

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String cognome, String indirizzo, Date dataDiNascita, Boolean attivo) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.dataDiNascita = dataDiNascita;
		this.attivo = attivo;
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

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Boolean getAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", indirizzo='" + indirizzo + '\'' +
				", dataDiNascita=" + dataDiNascita +
				", attivo=" + attivo +
				", ordini=" + ordini +
				'}';
	}

	public Cliente buildClienteModel() {
		return new Cliente(this.id, this.nome, this.cognome, this.indirizzo, this.dataDiNascita, this.attivo);
	}

	public static ClienteDTO buildClienteDTOFromModel(Cliente clienteModel, boolean withOrdini) {

		if (clienteModel == null) {
			return null;
		}

		ClienteDTO result = new ClienteDTO(
				clienteModel.getId(),
				clienteModel.getNome(),
				clienteModel.getCognome(),
				clienteModel.getIndirizzo(),
				clienteModel.getDataDiNascita(),
				clienteModel.getAttivo()
		);

		if (clienteModel.getOrdini() != null) {
			result.setOrdini(clienteModel.getOrdini());
		}

		return result;
	}

	public static List<ClienteDTO> createClienteDTOListFromModelList(List<Cliente> modelListInput, Boolean withOrdini) {
		return modelListInput.stream().map(clienteEntity -> {
			return ClienteDTO.buildClienteDTOFromModel(clienteEntity, withOrdini);
		}).collect(Collectors.toList());
	}
}
