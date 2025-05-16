package it.prova.gestionetratte.web.api;

import it.prova.gestionetratte.dto.AirbusDTO;
import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.service.AirbusService;
import it.prova.gestionetratte.web.api.exception.IdNotNullForInsertException;
import it.prova.gestionetratte.web.api.exception.AirbusNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/airbus")
public class AirbusController {

	@Autowired
	private AirbusService airbusService;

	@GetMapping
	public List<AirbusDTO> getAll() {
		return AirbusDTO.createAirbusDTOListFromModelList(airbusService.listAllElementsEager(), true);
	}

	@GetMapping("/{id}")
	public AirbusDTO findById(@PathVariable(value = "id", required = true) long id) {
		Airbus airbus = airbusService.caricaSingoloElementoEager(id);

		if (airbus == null)
			throw new AirbusNotFoundException("Airbus not found con id: " + id);

		return AirbusDTO.buildAirbusDTOFromModel(airbus, true);
	}
	// gli errori di validazione vengono mostrati con 400 Bad Request ma
	// elencandoli grazie al ControllerAdvice
	@PostMapping
	public AirbusDTO createNew(@Valid @RequestBody AirbusDTO airbusInput) {
		// se mi viene inviato un id jpa lo interpreta come update ed a me (producer)
		// non sta bene
		if (airbusInput.getId() != null)
			throw new IdNotNullForInsertException("Non è ammesso fornire un id per la creazione");

		Airbus airbusInserito = airbusService.inserisciNuovo(airbusInput.buildAirbusModel());
		return AirbusDTO.buildAirbusDTOFromModel(airbusInserito, true);
	}

	@PutMapping("/{id}")
	public AirbusDTO update(@PathVariable(value = "id", required = true) long id, @Valid @RequestBody AirbusDTO airbusInput) {
		Airbus airbus = airbusService.caricaSingoloElemento(id);

		if (airbus == null)
			throw new AirbusNotFoundException("Airbus not found con id: " + id);

		airbusInput.setId(id);
		Airbus airbusAggiornato =  airbusService.aggiorna(airbusInput.buildAirbusModel());
		return AirbusDTO.buildAirbusDTOFromModel(airbusAggiornato, true);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id", required = true) long id) {
		Airbus airbus = airbusService.caricaSingoloElemento(id);

		if (airbus == null)
			throw new AirbusNotFoundException("Airbus not found con id: " + id);

		airbusService.rimuovi(id);
	}

	@PostMapping("/searchWithPagination")
	public ResponseEntity<Page<AirbusDTO>> searchPaginated(
			@RequestBody AirbusDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Airbus> entityPageResults = airbusService.findByExampleWithPagination(example.buildAirbusModel(),
				pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<AirbusDTO>>(AirbusDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	@PostMapping("/searchNativeWithPagination")
	public ResponseEntity<Page<AirbusDTO>> searchNativePaginated(
			@RequestBody AirbusDTO example,
			@RequestParam(required = true) Integer pageNo,
			@RequestParam(required = true) Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy) {

		Page<Airbus> entityPageResults = airbusService.findByExampleNativeWithPagination(example.buildAirbusModel(), pageNo, pageSize, sortBy);

		return new ResponseEntity<Page<AirbusDTO>>(AirbusDTO.fromModelPageToDTOPage(entityPageResults),
				HttpStatus.OK);
	}


	
}
