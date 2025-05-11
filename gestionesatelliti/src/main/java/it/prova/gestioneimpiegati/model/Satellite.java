package it.prova.gestioneimpiegati.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "impiegato")
public class Satellite {
	//id, denominazione*, codice*, dataLancio, dataRientro, stato [IN_MOVIMENTO, FISSO, DISATTIVATO])
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{satellite.denominazione.notblank}")
	@Column(name = "denominazione")
	private String denominazione;

	@NotBlank(message = "{satellite.codice.notblank}")
	@Column(name = "codice")
	private String codice;

	@Column(name = "data_lancio")
	private LocalDate dataLancio;

	@Column(name = "data_rientro")
	private LocalDate dataRientro;

	@Column(name = "stato")
	@Enumerated(EnumType.STRING)
	private StatoSatellite stato;

	public Satellite() {
	}
	public Satellite(Long id, String denominazione, String codice, LocalDate dataLancio, LocalDate dataRientro,
			StatoSatellite stato) {
		this.id = id;
		this.denominazione = denominazione;
		this.codice = codice;
		this.dataLancio = dataLancio;
		this.dataRientro = dataRientro;
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public LocalDate getDataLancio() {
		return dataLancio;
	}

	public void setDataLancio(LocalDate dataLancio) {
		this.dataLancio = dataLancio;
	}

	public LocalDate getDataRientro() {
		return dataRientro;
	}

	public void setDataRientro(LocalDate dataRientro) {
		this.dataRientro = dataRientro;
	}

	public StatoSatellite getStato() {
		return stato;
	}

	public void setStato(StatoSatellite stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Satellite{" +
				"id=" + id +
				", denominazione='" + denominazione + '\'' +
				", codice='" + codice + '\'' +
				", dataLancio=" + dataLancio +
				", dataRientro=" + dataRientro +
				", stato=" + stato +
				'}';
	}



	public String ottieniIncongruenze() {
		if (getDataRientro() != null)
			if (getDataRientro().isBefore(getDataLancio()))
				return "La data di rientro non può essere prima della data di lancio";
		if (getStato() != null) {
			if (getDataLancio() == null)
				return "La data di lancio deve essere inserita se si sta inserendo uno stato";
			if (getDataLancio().isAfter(java.time.LocalDate.now()))
				return "La data di lancio non può essere successiva alla data odierna se si sta inserendo uno stato";
			if ((getStato().equals(StatoSatellite.IN_MOVIMENTO) || getStato().equals(StatoSatellite.FISSO)) && getDataRientro() != null && getDataRientro().isBefore(java.time.LocalDate.now()))
				return "La data di rientro non puo essere antecedente alla data odierna se si sta inserendo uno stato IN_MOVIMENTO o FISSO";
			if (getStato().equals(StatoSatellite.DISATTIVATO)) {
				if (getDataRientro() == null)
					return "La data di rientro deve essere inserita se si sta inserendo uno stato DISATTIVATO";
				if (getDataRientro().isAfter(java.time.LocalDate.now()))
					return "La data di rientro non può essere successiva alla data odierna se si sta inserendo uno stato DISATTIVATO";
			}
		}
		return null;
	}
}
