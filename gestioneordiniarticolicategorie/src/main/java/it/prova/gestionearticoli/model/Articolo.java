package it.prova.gestionearticoli.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "numero_seriale")
	private String numeroSeriale;

	@Column(name = "prezzo_singolo")
	private Float prezzoSingolo;

	@Column(name = "data_inserimento")
	private LocalDate dataInserimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(
			name = "articolo_categoria",
			joinColumns = @JoinColumn(name = "articolo_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private Set<Categoria> categorie = new HashSet<>();

	@CreationTimestamp
	@Column(name = "createdatetime", updatable = false)
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@Column(name = "updatedatetime")
	private LocalDateTime updateDateTime;

	public Articolo() { }

	public Articolo(String descrizione,
					String numeroSeriale,
					Float prezzoSingolo,
					LocalDate dataInserimento,
					Ordine ordine) {
		this.descrizione    = descrizione;
		this.numeroSeriale  = numeroSeriale;
		this.prezzoSingolo  = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.ordine         = ordine;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getDescrizione() { return descrizione; }
	public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

	public String getNumeroSeriale() { return numeroSeriale; }
	public void setNumeroSeriale(String numeroSeriale) { this.numeroSeriale = numeroSeriale; }

	public Float getPrezzoSingolo() { return prezzoSingolo; }
	public void setPrezzoSingolo(Float prezzoSingolo) { this.prezzoSingolo = prezzoSingolo; }

	public LocalDate getDataInserimento() { return dataInserimento; }
	public void setDataInserimento(LocalDate dataInserimento) { this.dataInserimento = dataInserimento; }

	public Ordine getOrdine() { return ordine; }
	public void setOrdine(Ordine ordine) { this.ordine = ordine; }

	public Set<Categoria> getCategorie() { return categorie; }
	public void setCategorie(Set<Categoria> categorie) { this.categorie = categorie; }

	public LocalDateTime getCreateDateTime() { return createDateTime; }
	public LocalDateTime getUpdateDateTime() { return updateDateTime; }

	// -------------------- UTILITY ------------------------
	@Override
	public String toString() {
		return "Articolo{id=" + id +
				", descrizione='" + descrizione + '\'' +
				", numeroSeriale='" + numeroSeriale + '\'' +
				", prezzoSingolo=" + prezzoSingolo +
				", dataInserimento=" + dataInserimento +
				'}';
	}

}
