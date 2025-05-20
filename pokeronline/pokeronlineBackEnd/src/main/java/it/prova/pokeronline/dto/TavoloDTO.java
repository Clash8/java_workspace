package it.prova.pokeronline.dto;

import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.Tavolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TavoloDTO {

    private Long id;

    private Integer esperienzaMin;

    @NotNull(message = "{cifraMinima.notnull}")
    private Double cifraMinima;

    @NotBlank(message = "{denominazione.notblank}")
    private String denominazione;

    @NotNull(message = "{dataCreazione.notnull}")
    private LocalDate dataCreazione;

    public TavoloDTO() {
    }

    public TavoloDTO(Long id, LocalDate dataCreazione, String denominazione, Double cifraMinima, Integer esperienzaMin) {
        this.id = id;
        this.dataCreazione = dataCreazione;
        this.denominazione = denominazione;
        this.cifraMinima = cifraMinima;
        this.esperienzaMin = esperienzaMin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEsperienzaMin() {
        return esperienzaMin;
    }

    public void setEsperienzaMin(Integer esperienzaMin) {
        this.esperienzaMin = esperienzaMin;
    }

    public Double getCifraMinima() {
        return cifraMinima;
    }

    public void setCifraMinima(Double cifraMinima) {
        this.cifraMinima = cifraMinima;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public LocalDate getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(LocalDate dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    //this.dataCreazione = dataCreazione;
    //        this.denominazione = denominazione;
    //        this.cifraMinima = cifraMinima;
    //        this.esperienzaMin = esperienzaMin;
    public Tavolo buildTavoloModel() {
        return new Tavolo(this.id, this.esperienzaMin, this.cifraMinima, this.denominazione, this.dataCreazione);
    }
    public static TavoloDTO buildTavoloDTOFromModel(Tavolo tavoloModel) {
        return new TavoloDTO(tavoloModel.getId(),tavoloModel.getDataCreazione(),
                tavoloModel.getDenominazione(), tavoloModel.getCifraMinima(), tavoloModel.getEsperienzaMin());
    }

    public static List<TavoloDTO> createTavoloDTOListFromModelSet(Set<Tavolo> modelListInput) {
        return modelListInput.stream().map(tavoloEntity -> {
            return TavoloDTO.buildTavoloDTOFromModel(tavoloEntity);
        }).collect(Collectors.toList());
    }

    public static List<TavoloDTO> createTavoloDTOListFromModelList(List<Tavolo> modelListInput) {
        return modelListInput.stream().map(tavoloEntity -> {
            return TavoloDTO.buildTavoloDTOFromModel(tavoloEntity);
        }).collect(Collectors.toList());
    }
}
