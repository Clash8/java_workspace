package it.prova.gestionesocieta.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "progetto")
public class Progetto {
// (id, nome, cliente, durataInMesi)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cliente")
	private String cliente;
	@Column(name = "durata_in_mesi")
	private Integer durataInMesi;

	@ManyToMany(mappedBy = "progetti")
	private Set<Dipendente> dipendenti = new HashSet<>();


	public Progetto() {}

	public Progetto(String nome, String cliente, Integer durataInMesi) {
		this.nome = nome;
		this.cliente = cliente;
		this.durataInMesi = durataInMesi;
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(Integer durataInMesi) {
		this.durataInMesi = durataInMesi;
	}

	public Set<Dipendente> getDipendenti() {
		return dipendenti;
	}
	public void setDipendenti(Set<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	@Override
	public String toString() {
		return "Progetto{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", cliente='" + cliente + '\'' +
				", durataInMesi=" + durataInMesi +
				'}';
	}
}
