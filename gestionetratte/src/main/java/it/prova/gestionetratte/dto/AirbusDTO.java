package it.prova.gestionetratte.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import it.prova.gestionetratte.model.Airbus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirbusDTO {
	//Airbus (id, codice, descrizione, dataInizioServizio, numeroPasseggeri, tratte)

	private Long id;

	@NotBlank(message = "{codice.notblank}")
	@Size(min = 4, max = 15, message = "Il valore inserito '${validatedValue}' deve essere lungo tra {min} e {max} caratteri")
	private String codice;

	@NotBlank(message = "{descrizione.notblank}")
	private String descrizione;

	@NotNull(message = "{dataInizioServizio.notnull}")
	private LocalDate dataInizioServizio;

	@NotNull(message = "{numeroPasseggeri.notnull}")
	@Min(1)
	private Integer numeroPasseggeri;

	@JsonIgnoreProperties(value = { "airbus" })
	private Set<TrattaDTO> tratte = new HashSet<>(0);

	public AirbusDTO() {}

	public AirbusDTO(Long id, String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPasseggeri,
			Set<TrattaDTO> tratte) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPasseggeri = numeroPasseggeri;
		this.tratte = tratte;
	}
	public AirbusDTO(Long id, String codice, String descrizione, LocalDate dataInizioServizio, Integer numeroPasseggeri) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.dataInizioServizio = dataInizioServizio;
		this.numeroPasseggeri = numeroPasseggeri;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataInizioServizio() {
		return dataInizioServizio;
	}

	public void setDataInizioServizio(LocalDate dataInizioServizio) {
		this.dataInizioServizio = dataInizioServizio;
	}

	public Integer getNumeroPasseggeri() {
		return numeroPasseggeri;
	}

	public void setNumeroPasseggeri(Integer numeroPasseggeri) {
		this.numeroPasseggeri = numeroPasseggeri;
	}

	public Set<TrattaDTO> getTratte() {
		return tratte;
	}

	public void setTratte(Set<TrattaDTO> tratte) {
		this.tratte = tratte;
	}

	@Override
	public String toString() {
		return "AirbusDTO{" +
				"id=" + id +
				", codice='" + codice + '\'' +
				", descrizione='" + descrizione + '\'' +
				", dataInizioServizio=" + dataInizioServizio +
				", numeroPasseggeri=" + numeroPasseggeri +
				", tratte=" + tratte +
				'}';
	}

	public Airbus buildAirbusModel() {
		return new Airbus(this.id, this.getCodice(), this.getDescrizione(), this.getDataInizioServizio(), this.getNumeroPasseggeri());
	}

	public static AirbusDTO buildAirbusDTOFromModel(Airbus airbusModel, boolean includeTratte) {
		AirbusDTO result = new AirbusDTO(airbusModel.getId(), airbusModel.getCodice(), airbusModel.getDescrizione(),
				airbusModel.getDataInizioServizio(), airbusModel.getNumeroPasseggeri());
		if (includeTratte)
			result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusModel.getTratte(), false));
		return result;
	}

	public static List<AirbusDTO> createAirbusDTOListFromModelList(List<Airbus> modelListInput, boolean includeTratte) {
		return modelListInput.stream().map(airbusEntity -> {
			AirbusDTO result = AirbusDTO.buildAirbusDTOFromModel(airbusEntity, includeTratte);
			if (includeTratte)
				result.setTratte(TrattaDTO.createTrattaDTOSetFromModelSet(airbusEntity.getTratte(), false));
			return result;

		}).collect(Collectors.toList());
	}

	public static Page<AirbusDTO> fromModelPageToDTOPage(Page<Airbus> input) {
		return new PageImpl<>(createAirbusDTOListFromModelList(input.getContent(), false),
				PageRequest.of(input.getPageable().getPageNumber(), input.getPageable().getPageSize(),
						input.getPageable().getSort()),
				input.getTotalElements());
	}

}
