package it.prova.pizzastorespringmvc.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.prova.pizzastorespringmvc.model.Regista;
import it.prova.pizzastorespringmvc.model.Sesso;

public class RegistaDTO {
	
	private Long id;
	
	@NotBlank(message = "{regista.nome.notblank}")
	private String nome;
	
	@NotBlank(message = "{regista.cognome.notblank}")
	private String cognome;
	
	@NotBlank(message = "{regista.nickName.notblank}")
	@Size(min = 3, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	private String nickName;
	
	@NotNull(message = "{regista.dataDiNascita.notnull}")
	private Date dataDiNascita;

	// la proprieta uno a molti e cioe 'films' non serve al momento nelle view
	// e quindi non la mettiamo anche perche in genere risulta di difficile gestione

	public RegistaDTO() {
	}

	public RegistaDTO(Long id) {
		this.id = id;
	}

	public RegistaDTO(Long id, String nome, String cognome, String nickName, Date dataDiNascita) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
		this.dataDiNascita = dataDiNascita;
	}

	public RegistaDTO(String nome, String cognome, String nickName) {
		this.nome = nome;
		this.cognome = cognome;
		this.nickName = nickName;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Regista buildRegistaModel() {
		return new Regista(this.id, this.nome, this.cognome, this.nickName, this.dataDiNascita);
	}

	public static RegistaDTO buildRegistaDTOFromModel(Regista registaModel) {
		return new RegistaDTO(registaModel.getId(), registaModel.getNome(), registaModel.getCognome(),
				registaModel.getNickName(), registaModel.getDataDiNascita(), registaModel.getSesso());
	}

	public static List<RegistaDTO> createRegistaDTOListFromModelList(List<Regista> modelListInput) {
		return modelListInput.stream().map(registaEntity -> {
			return RegistaDTO.buildRegistaDTOFromModel(registaEntity);
		}).collect(Collectors.toList());
	}

}
