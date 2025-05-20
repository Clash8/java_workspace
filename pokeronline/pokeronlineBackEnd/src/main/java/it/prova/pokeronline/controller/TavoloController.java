package it.prova.pokeronline.controller;


import it.prova.pokeronline.dto.TavoloDTO;
import it.prova.pokeronline.exception.IdNotNullForInsertException;
import it.prova.pokeronline.exception.TavoloNonTrovatoException;
import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.service.abstraction.TavoloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tavolo")
public class TavoloController {

    @Autowired
    private TavoloService tavoloService;

    @GetMapping
    public List<TavoloDTO> getAll() {
        return TavoloDTO.createTavoloDTOListFromModelList(tavoloService.listAll());
    }

    @PostMapping
    public TavoloDTO createNew(@Valid @RequestBody TavoloDTO tavoloInput) {
        if (tavoloInput.getId() != null)
            throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

        Tavolo tavoloInserito = tavoloService.creaTavolo(tavoloInput.buildTavoloModel());
        return TavoloDTO.buildTavoloDTOFromModel(tavoloInserito);
    }

    @GetMapping("/{id}")
    public TavoloDTO findById(@PathVariable(value = "id", required = true) long id) {
        Tavolo tavolo = tavoloService.cercaPerId(id);

        if (tavolo == null)
            throw new TavoloNonTrovatoException("Tavolo non trovato con id: " + id);

        return TavoloDTO.buildTavoloDTOFromModel(tavolo);
    }
    @PutMapping("/{id}")
    public TavoloDTO update(@Valid @RequestBody TavoloDTO tavoloInput, @PathVariable(required = true) Long id) {
        Tavolo tavolo = tavoloService.cercaPerId(id);

        if (tavolo == null)
            throw new TavoloNonTrovatoException("Tavolo non trovato con id: " + id);

        tavoloInput.setId(id);
        Tavolo registaAggiornato = tavoloService.aggiornaTavolo(tavoloInput.buildTavoloModel());
        return TavoloDTO.buildTavoloDTOFromModel(registaAggiornato);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(required = true) Long id) {
        tavoloService.disabilitaTavolo(id);
    }
}
