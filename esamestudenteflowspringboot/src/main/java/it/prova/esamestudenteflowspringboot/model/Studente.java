package it.prova.esamestudenteflowspringboot.model;

public class Studente {

	private Long id;
	private String nome;
	private String cognome;

	private Esame esame;

	public Studente() {
	}

	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public Studente(String nome, String cognome, Esame esame) {
		this(nome, cognome);
		this.esame = esame;
	}

	public Studente(Long id, String nome, String cognome, Esame esame) {
		this(nome, cognome, esame);
		this.id = id;
	}

	public Studente(Long id, String nome, String cognome) {
		this(nome, cognome);
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

	public Esame getEsame() {
		return esame;
	}

	public void setEsame(Esame esame) {
		this.esame = esame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nome + " " + cognome;
	}

}
