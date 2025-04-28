package it.manytomanyjpamaven.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "atleta")
public class Atleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "datadinascita")
	private LocalDate dataDiNascita;
	@Column(name = "codice")
	private String codice;
	@Column(name = "numeromaglievinte")
	private Integer numeroMaglieVinte;

	// se non uso questa annotation viene gestito come un intero
	@Enumerated(EnumType.STRING)
	private SportAtleta sport = SportAtleta.NON_IMPOSTATO;

	@ManyToMany
	@JoinTable(name = "atleta_sport", joinColumns = @JoinColumn(name = "atleta_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "ID"))
	private Set<Sport> sports = new HashSet<>(0);

	public Atleta() {
	}
	public Atleta(String nome, String cognome, LocalDate dataDiNascita, String codice, Integer numeroMaglieVinte) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.codice = codice;
		this.numeroMaglieVinte = numeroMaglieVinte;
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
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Integer getNumeroMaglieVinte() {
		return numeroMaglieVinte;
	}
	public void setNumeroMaglieVinte(Integer numeroMaglieVinte) {
		this.numeroMaglieVinte = numeroMaglieVinte;
	}
	public SportAtleta getSport() {
		return sport;
	}
	public void setSport(SportAtleta sport) {
		this.sport = sport;
	}
	public Set<Sport> getSports() {
		return sports;
	}
	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "Atleta [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", codice=" + codice + ", numeroMaglieVinte=" + numeroMaglieVinte + ", sport=" + sport + ", sports=" + sports + "]";
	}

}
