package it.prova.pizzastorespringmvc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cliente")
public class Cliente {
	// list of attributes: id, nome, cognome, indirizzo, attivo=true/false

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "datadinascita")
	private Date dataDiNascita;

	@Column(name = "attivo")
	private Boolean attivo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Ordine> ordini = new HashSet<>(0);

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cognome, String indirizzo, Date dataDiNascita, Boolean attivo) {
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
}
