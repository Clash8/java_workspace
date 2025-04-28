package it.prova.manytomanyphoneapp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app")
public class App {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datainstallazione")
	private LocalDate dataInstallazione;
	@Column(name = "dataultimoaggiornamento")
	private LocalDate dataUltimoAggiornamento;
	@Column(name = "versione")
	private String versione;

	// campi per le time info del record
	@CreationTimestamp
	@Column(name = "createdatetime")
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	@Column(name = "updatedatetime")
	private LocalDateTime updateDateTime;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "app")
	private Set<Smartphone> smartphones = new HashSet<>();

	public App() {
	}
	public App(String nome, LocalDate dataInstallazione, LocalDate dataUltimoAggiornamento, String versione) {
		this.nome = nome;
		this.dataInstallazione = dataInstallazione;
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
		this.versione = versione;
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
	public LocalDate getDataInstallazione() {
		return dataInstallazione;
	}
	public void setDataInstallazione(LocalDate dataInstallazione) {
		this.dataInstallazione = dataInstallazione;
	}
	public LocalDate getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}
	public void setDataUltimoAggiornamento(LocalDate dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}
	public String getVersione() {
		return versione;
	}
	public void setVersione(String versione) {
		this.versione = versione;
	}
	@Override
	public String toString() {
		return "App [id=" + id + ", nome=" + nome + ", dataInstallazione=" + dataInstallazione
				+ ", dataUltimoAggiornamento=" + dataUltimoAggiornamento + ", versione=" + versione + "]";
	}

}
