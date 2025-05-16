package it.prova.gestionetratte.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tratta")
public class Tratta {
//	Tratta (id, codice, descrizione, data, oraDecollo, oraAtterraggio, stato=ATTIVA, CONCLUSA, ANNULLATA, airbus)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "codice")
	private String codice;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "data")
	private LocalDate data;

	@Column(name = "oradecollo")
	private LocalTime oraDecollo;

	@Column(name = "oraatterraggio")
	private LocalTime oraAtterraggio;

	@Column(name = "stato")
	@Enumerated(EnumType.STRING)
	private StatoTratta stato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airbus_id", nullable = false)
	private Airbus airbus;

	public Tratta() {}

	public Tratta(Long id, String codice, String descrizione, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio, StatoTratta stato, Airbus airbus) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
		this.airbus = airbus;
	}
	public Tratta(Long id, String codice, String descrizione, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio, StatoTratta stato) {
		this.id = id;
		this.codice = codice;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
	}
	public Tratta(String codice, String descrizione, LocalDate data, LocalTime oraDecollo, LocalTime oraAtterraggio, StatoTratta stato) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.data = data;
		this.oraDecollo = oraDecollo;
		this.oraAtterraggio = oraAtterraggio;
		this.stato = stato;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOraDecollo() {
		return oraDecollo;
	}

	public void setOraDecollo(LocalTime oraDecollo) {
		this.oraDecollo = oraDecollo;
	}

	public LocalTime getOraAtterraggio() {
		return oraAtterraggio;
	}

	public void setOraAtterraggio(LocalTime oraAtterraggio) {
		this.oraAtterraggio = oraAtterraggio;
	}

	public StatoTratta getStato() {
		return stato;
	}

	public void setStato(StatoTratta stato) {
		this.stato = stato;
	}

	public Airbus getAirbus() {
		return airbus;
	}

	public void setAirbus(Airbus airbus) {
		this.airbus = airbus;
	}

	@Override
	public String toString() {
		return "Tratta{" +
				"id=" + id +
				", codice='" + codice + '\'' +
				", descrizione='" + descrizione + '\'' +
				", data=" + data +
				", oraDecollo='" + oraDecollo + '\'' +
				", oraAtterraggio='" + oraAtterraggio + '\'' +
				", stato=" + stato +
				", airbus=" + airbus +
				'}';
	}
}

