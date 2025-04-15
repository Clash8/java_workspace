package it.prova.lavoratorejdbc.model;

import java.util.Date;

public class Lavoratore {
	private Long id;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private Integer ral;

	public Lavoratore() {
	}

	public Lavoratore(String nome, String cognome, Date dataDiNascita, Integer ral) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.ral = ral;
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

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Integer getRal() {
		return ral;
	}

	public void setRal(Integer ral) {
		this.ral = ral;
	}

	@Override
	public String toString() {
		return "Lavoratore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", ral=" + ral + "]";
	}
	
	

}
