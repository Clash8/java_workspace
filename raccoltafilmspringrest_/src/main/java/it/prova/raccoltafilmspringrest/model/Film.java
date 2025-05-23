package it.prova.raccoltafilmspringrest.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "titolo")
	private String titolo;

	@Column(name = "genere")
	private String genere;

	@Column(name = "datapubblicazione")
	private LocalDate dataPubblicazione;

	@Column(name = "minutidurata")
	private Integer minutiDurata;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regista_id", nullable = false)
	private Regista regista;

	public Film() {
	}

	public Film(String titolo, String genere) {
		this.titolo = titolo;
		this.genere = genere;
	}

	public Film(Long id, String titolo, String genere, LocalDate dataPubblicazione, Integer minutiDurata) {
		this(titolo, genere);
		this.id = id;
		this.dataPubblicazione = dataPubblicazione;
		this.minutiDurata = minutiDurata;
	}

	public Film(Long id, String titolo, String genere, LocalDate dataPubblicazione, Integer minutiDurata,
			Regista regista) {
		this(id, titolo, genere, dataPubblicazione, minutiDurata);
		this.regista = regista;
	}

	public Film(String titolo, String genere, LocalDate dataPubblicazione, Integer minutiDurata, Regista regista) {
		this(titolo, genere);
		this.dataPubblicazione = dataPubblicazione;
		this.minutiDurata = minutiDurata;
		this.regista = regista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public LocalDate getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(LocalDate dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Integer getMinutiDurata() {
		return minutiDurata;
	}

	public void setMinutiDurata(Integer minutiDurata) {
		this.minutiDurata = minutiDurata;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

}
