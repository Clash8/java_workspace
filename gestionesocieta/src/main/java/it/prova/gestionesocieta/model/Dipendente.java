package it.prova.gestionesocieta.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "dipendente")
public class Dipendente {
// (id, nome, cognome, dataAssunzione, reditoAnnuoLordo, società [nullable false])
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "data_assunzione")
	private LocalDate dataAssunzione;
	@Column(name = "redditoAnnuoLordo")
	private int redditoAnnuoLordo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "societa_id",nullable = false)
	private Societa societa;


	@ManyToMany
	@JoinTable(name = "progetto_dipendente",
			joinColumns = @JoinColumn(name = "progetto_id"),
			inverseJoinColumns = @JoinColumn(name = "dipendente_id"))
	private List<Progetto> progetti = new ArrayList<>();

	public Dipendente() {}

	public Dipendente(String nome, String cognome, LocalDate dataAssunzione, int redditoAnnuoLordo, Societa societa) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataAssunzione = dataAssunzione;
		this.redditoAnnuoLordo = redditoAnnuoLordo;
		this.societa = societa;
	}
	public Dipendente(String nome, String cognome, int redditoAnnuoLordo, Societa societa) {
		this.nome = nome;
		this.cognome = cognome;
		this.redditoAnnuoLordo = redditoAnnuoLordo;
		this.societa = societa;
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

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(LocalDate dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public int getRedditoAnnuoLordo() {
		return redditoAnnuoLordo;
	}

	public void setRedditoAnnuoLordo(int redditoAnnuoLordo) {
		this.redditoAnnuoLordo = redditoAnnuoLordo;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Progetto> getProgetti() {
		return progetti;
	}

	public void setProgetti(List<Progetto> progetti) {
		this.progetti = progetti;
	}

	@Override
	public String toString() {
		return "Dipendente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cognome='" + cognome + '\'' +
				", dataAssunzione=" + dataAssunzione +
				", redditoAnnuoLordo=" + redditoAnnuoLordo +
				", societa=" + societa +
				'}';
	}
}
