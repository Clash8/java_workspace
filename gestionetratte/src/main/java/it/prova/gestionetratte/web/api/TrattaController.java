package it.prova.gestionetratte.web.api;

import it.prova.gestionetratte.dto.TrattaDTO;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.TrattaService;
import it.prova.gestionetratte.web.api.exception.TrattaNotFoundException;
import it.prova.gestionetratte.web.api.exception.IdNotNullForInsertException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tratta")
public class TrattaController {

	@Autowired
	private TrattaService trattaService;

	@GetMapping
	public List<TrattaDTO> getAll() {
		return TrattaDTO.createTrattaDTOListFromModelList(trattaService.listAllElementsEager(), true);
	}

	@GetMapping("/{id}")
	public TrattaDTO findById(@PathVariable(value = "id", required = true) long id) {
		Tratta tratta = trattaService.caricaSingoloElementoEager(id);

		if (tratta == null)
			throw new TrattaNotFoundException("Tratta not found con id: " + id);

		return TrattaDTO.buildTrattaDTOFromModel(tratta, true);
	}
	// gli errori di validazione vengono mostrati con 400 Bad Request ma
	// elencandoli grazie al ControllerAdvice
	@PostMapping
	public TrattaDTO createNew(@Valid @RequestBody TrattaDTO trattaInput) {
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (trattaInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		Tratta trattaInserito = trattaService.inserisciNuovo(trattaInput.buildTrattaModel());
		return TrattaDTO.buildTrattaDTOFromModel(trattaInserito, true);
	}

	@PutMapping("/{id}")
	public TrattaDTO update(@PathVariable(value = "id", required = true) long id, @Valid @RequestBody TrattaDTO trattaInput) {
		Tratta tratta = trattaService.caricaSingoloElemento(id);

		if (tratta == null)
			throw new TrattaNotFoundException("Tratta not found con id: " + id);

		trattaInput.setId(id);
		Tratta trattaAggiornato =  trattaService.aggiorna(trattaInput.buildTrattaModel());
		return TrattaDTO.buildTrattaDTOFromModel(trattaAggiornato, true);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id", required = true) long id) {
		Tratta tratta = trattaService.caricaSingoloElemento(id);

		if (tratta == null)
			throw new TrattaNotFoundException("Tratta not found con id: " + id);

		trattaService.rimuovi(id);
	}

	@PostMapping("/searchWithPagination")
	public ResponseEntity<Page<TrattaDTO>> searchPaginated(
			@RequestBody TrattaDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Tratta> entityPageResults = trattaService.findByExampleWithPagination(example.buildTrattaModel(),
				pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<TrattaDTO>>(TrattaDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	@PostMapping("/searchNativeWithPagination")
	public ResponseEntity<Page<TrattaDTO>> searchNativePaginated(
			@RequestBody TrattaDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Tratta> entityPageResults = trattaService.findByExampleNativeWithPagination(example.buildTrattaModel(), pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<TrattaDTO>>(TrattaDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	
}
