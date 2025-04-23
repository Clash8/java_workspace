package it.prova.proprietarioautomobile.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
//Proprietario (id, nome, cognome, cf, dataDiNascita) e Automobile (id, marca, modello, targa, annoImmatricolazione, proprietario)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cogmone")
	private String cogmone;
	@Column(name = "cf")
	private String cf;
	@Column(name = "datadinascita")
	private String dataDiNascita;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "proprietario")
	private Set<Automobile> automobile = new HashSet<>();

	public Proprietario() {}

	public Proprietario(String nome, String cognome, String cf, String dataDiNascita) {
		super();
		this.nome = nome;
		this.cogmone = cognome;
		this.cf = cf;
		this.dataDiNascita = dataDiNascita;
	}
	public Proprietario(String nome, String cognome, String cf) {
		super();
		this.nome = nome;
		this.cogmone = cognome;
		this.cf = cf;
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
		return cogmone;
	}
	public void setCognome(String cognome) {
		this.cogmone = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public Set<Automobile> getAutomobile() {
		return automobile;
	}
	public void setAutomobile(Set<Automobile> automobile) {
		this.automobile = automobile;
	}

	@Override
	public String toString() {
		return "Proprietario [id=" + id + ", nome=" + nome + ", cognome=" + cogmone + ", cf=" + cf + ", dataDiNascita="
				+ dataDiNascita + "]";
	}

	
}
